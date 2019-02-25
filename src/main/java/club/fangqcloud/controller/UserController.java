package club.fangqcloud.controller;

import club.fangqcloud.pojo.Teacher;
import club.fangqcloud.pojo.User;
import club.fangqcloud.service.StudentService;
import club.fangqcloud.service.TeacherService;
import club.fangqcloud.service.UserService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @RequestMapping("/register.do")
    @ResponseBody
    public Boolean register(User userInfo){
//        取名文密码进行BASE64加密
        BASE64Encoder encoder = new BASE64Encoder();
        String password = encoder.encode(userInfo.getPassword().getBytes());

        userInfo.setPassword(password);
        List<User> userList = userService.selectByCondition(userInfo);
        if(userList.size() != 0){
            return false;
        }else{
            userInfo.setUserId(String.valueOf(System.currentTimeMillis()));
            return userService.insert(userInfo);
        }
    }


    @RequestMapping("/login.do")
    @ResponseBody
    public Boolean login(User userInfo, HttpServletRequest request){
        BASE64Encoder encoder = new BASE64Encoder();
        String password = encoder.encode(userInfo.getPassword().getBytes());


        userInfo.setPassword(password);
        List<User> userList = userService.selectByCondition(userInfo);
        if(userList.size()==0){
            return false;
        }
        else{
            String userId = userList.get(0).getUserId();
            HttpSession session = request.getSession();
            session.setAttribute("userId",userId);
            return true;
        }
    }


    @RequestMapping("/export.do")
    public void export_excel(HttpServletResponse response) throws Exception{
        String[] tableHeaders = {"id", "用户名", "密码","人员类型","邮箱"};

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

        Font font = workbook.createFont();
        font.setBold(true);
        cellStyle.setFont(font);

        // 将第一行的三个单元格给合并
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));
        HSSFRow row = sheet.createRow(0);
        HSSFCell beginCell = row.createCell(0);
        beginCell.setCellValue("用户信息");
        beginCell.setCellStyle(cellStyle);

        row = sheet.createRow(1);
        // 创建表头
        for (int i = 0; i < tableHeaders.length; i++) {
            HSSFCell cell = row.createCell(i);
            cell.setCellValue(tableHeaders[i]);
            cell.setCellStyle(cellStyle);
        }

        List<User> users = userService.selectByCondition(new User());

        for (int i = 0; i < users.size(); i++) {
            row = sheet.createRow(i + 2);

            User user = users.get(i);
            row.createCell(0).setCellValue(user.getUserId());
            row.createCell(1).setCellValue(user.getUserName());
            row.createCell(2).setCellValue(user.getPassword());
            row.createCell(3).setCellValue(user.getType());
            row.createCell(4).setCellValue(user.getEmail());


        }

        OutputStream outputStream = response.getOutputStream();
        response.reset();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=user.xls");

        workbook.write(outputStream);
        outputStream.flush();
        outputStream.close();
    }


    @RequestMapping("/import.do")
    public void import_excel(@RequestParam("file") MultipartFile file) throws Exception{
        InputStream inputStream = file.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        POIFSFileSystem fileSystem = new POIFSFileSystem(bufferedInputStream);
        HSSFWorkbook workbook = new HSSFWorkbook(fileSystem);
        HSSFSheet sheet = workbook.getSheetAt(0);

        int lastRowNum = sheet.getLastRowNum();
        for (int i = 2; i <= lastRowNum; i++) {
            HSSFRow row = sheet.getRow(i);

            User user = new User();
            user.setUserId(row.getCell(0).getStringCellValue());
            user.setUserName(row.getCell(1).getStringCellValue());
            user.setPassword(row.getCell(2).getStringCellValue());
            user.setType((int) row.getCell(3).getNumericCellValue());
            user.setEmail(row.getCell(4).getStringCellValue());
            userService.insert(user);
        }
    }

    @RequestMapping("/getUserInfo.do")
    @ResponseBody
    public List<Map> getUserInfo(String userId) {
        User user = new User();
        user.setUserId(userId);

        List<User> userList = userService.selectByCondition(user);
        if(userList.size() != 0){
            if(userList.get(0).getType()==1){
                return userService.selectTeacherInfo(userId);
            }else{
                return userService.selectStudentInfo(userId);
            }
        }
        else{
            return null;
        }
    }


    @RequestMapping("/modify.do")
    @ResponseBody
    public Boolean modify(Map userInfo){
        System.out.println(userInfo);
        int type = (int)userInfo.get("type");
//        if(type==1){
//            return teacherService.insert(userInfo);
//        }else{
//            return studentService.add(userInfo);
//        }
        return null;
    }
}

package club.fangqcloud.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter",urlPatterns = "/a.html")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;
        HttpSession session = servletRequest.getSession();

        // 获得用户请求的URI
        String path = servletRequest.getRequestURI();
        //System.out.println(path);

        // 从session里取用户编号信息
        String userId = (String) session.getAttribute("userId");
//        System.out.println(userId);
        /*创建类Constants.java，里面写的是无需过滤的页面
        for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {
            if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }
        }*/

        // 登陆页面无需过滤
        if(path.indexOf("/login.html") > -1 || path.indexOf("/register.html") > -1) {
            chain.doFilter(servletRequest, servletResponse);
            return;
        }

         // 判断如果没有取到员工信息,就跳转到登陆页面
        if (userId == null || "".equals(userId)) {
            // 跳转到登陆页面
            servletResponse.sendRedirect("/login.html");
        } else {
            // 已经登陆,继续此次请求
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

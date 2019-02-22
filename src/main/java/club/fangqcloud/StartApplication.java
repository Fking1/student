package club.fangqcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"club.fangqcloud.controller","club.fangqcloud.impl","club.fangqcloud.pojo"})
@MapperScan(basePackages = {"club.fangqcloud.mapper"})
public class StartApplication extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(StartApplication.class,args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StartApplication.class);
    }
}

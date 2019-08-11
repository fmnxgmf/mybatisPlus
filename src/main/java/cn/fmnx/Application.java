package cn.fmnx;

import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: mybatisPlus
 * @description: springboot的启动类
 * @author: guojing
 * @create: 2019-08-09 18:07
 **/
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        System.out.println("springboot项目启动");
    }

}

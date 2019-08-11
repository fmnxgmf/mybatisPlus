package cn.fmnx.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: mybatisPlus
 * @description: mybatisPlus配置
 * @author: guojing
 * @create: 2019-08-10 17:01
 **/
@Configuration
public class MybatisPlusConfig {
    /**
     * 分页
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){return new PaginationInterceptor();}
}

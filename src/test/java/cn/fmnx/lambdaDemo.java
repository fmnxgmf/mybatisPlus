package cn.fmnx;

import cn.fmnx.mapper.UserMapper;
import cn.fmnx.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @program: mybatisPlus
 * @description: mybatisPlus lambda测试
 * @author: guojing
 * @create: 2019-08-10 19:05
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class lambdaDemo {
    @Resource
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @Test
    public void lambdaDemo1(){


    }


}

package cn.fmnx;

import cn.fmnx.entity.User;
import cn.fmnx.mapper.UserMapper;
import cn.fmnx.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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
        /**
         * lambda表达式的三种方式
         */
        LambdaQueryWrapper<User> queryWrapper =new QueryWrapper<User>().lambda();
        LambdaQueryWrapper<User> lambda = new LambdaQueryWrapper<User>();
        LambdaQueryWrapper<User> lambdaQueryWrapper = Wrappers.<User>lambdaQuery();
        queryWrapper.ge(User::getId,3);
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);

    }

    @Test
    public void lambdaDemo2(){
        LambdaQueryWrapper<User> queryWrapper = Wrappers.<User>lambdaQuery();
        queryWrapper.likeRight(User::getName,"王")
                .and(wq->wq.gt(User::getAge,22))
                .or().isNotNull(User::getEmail);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
    @Test
    public void lambdaDemo3(){
        List<User> list = new LambdaQueryChainWrapper<User>(userMapper)
                .like(User::getName, "王").ge(User::getAge, 20).list();
        list.forEach(System.out::println);
    }
}

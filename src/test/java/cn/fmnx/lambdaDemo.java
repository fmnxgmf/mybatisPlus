package cn.fmnx;

import cn.fmnx.entity.User;
import cn.fmnx.mapper.UserMapper;
import cn.fmnx.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.LambdaQueryChainWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    public void selectList(){
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
    @Test
    //批量插入
    public void saveBatch(){
        User user1 = new User();
        user1.setAge(12);
        user1.setEmail("894697547@qq.com");
        user1.setName("陈智超");
        user1.setVersion("1");

        User user2 = User.builder()
                .age(55)
                .email("15378621793")
                .version("1")
                .name("陈王磊")
                .build();

        User user3 = User.builder()
                .age(30)
                .email("142578@qq.com")
                .name("和伪军")
                .version("1")
                .build();
        List<User> users = Arrays.asList(user1, user2,user3);
        userService.saveBatch(users);

    }
    @Test
    //批量插入或者修改
    public void saveOrUpdateBatch(){
        User user1 = new User();
        user1.setAge(12);
        user1.setId(9);
        user1.setEmail("894644547@qq.com");
        user1.setName("陈咸鱼");
        user1.setVersion("1");

        User user2 = User.builder()
                .age(55)
                .id(10)
                .email("15378621793")
                .version("1")
                .name("陈王磊")
                .build();

        User user3 = User.builder()
                .age(30)
                .id(11)
                .email("142578@qq.com")
                .name("和伪军")
                .version("1")
                .build();
        List<User> users = Arrays.asList(user1, user2,user3);
        userService.saveOrUpdateBatch(users);

    }
    //获得一个
    @Test
    public void getOne(){
        User one = new LambdaQueryChainWrapper<User>(userMapper).eq(User::getId,3).one();
        System.out.println(one);
    }

    @Test
    public void getOne1(){

        LambdaQueryWrapper<User> eq = new LambdaQueryWrapper<User>().ge(User::getAge, 22);
        //User one = userService.getOne(eq);
        Map<String, Object> map = userService.getMap(eq);
        List<User> list = userService.list(eq);
        System.out.println(list);
        list.forEach(System.out::println);
    }
}


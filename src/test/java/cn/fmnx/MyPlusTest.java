package cn.fmnx;

import cn.fmnx.mapper.UserMapper;
import cn.fmnx.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatisPlus
 * @description: mybatisplus测试
 * @author: guojing
 * @create: 2019-08-10 14:19
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyPlusTest {

    @Resource
    private UserMapper userMapper;

    @Test
    //查询所有的值
    public void selectAll(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
    @Test
    //按id查询
    public void selectId(){
        User user = userMapper.selectById(6);
        System.out.println(user);
    }
    @Test
    //按多个id查询
    public void selectIds(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        List user = userMapper.selectBatchIds(list);
        user.forEach(System.out::println);
    }
    @Test
    //插入一条数据
    public void add(){
        User user = new User();
        user.setAge(12);
        user.setEmail("894697547@qq.com");
        user.setName("陈智超");
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
    @Test
    public void update(){
        User user = new User();
        user.setId(6);
        user.setEmail("czclikewa@qq.com");
        int i = userMapper.updateById(user);
    }

    @Test
    public void selectMap(){
        User user = new User();
        List<Map<String, Object>> maps = userMapper.selectMaps(null);
        System.out.println(maps);
    }
    @Test
    public void page(){
        QueryWrapper<User> query = new QueryWrapper<User>();
        query.gt("age",5);
        Page<User> page = new Page<User>(2,2);
        IPage<User> userIPage = userMapper.selectPage(page, query);
        System.out.println("当前页"+userIPage.getCurrent());
        System.out.println("总条数"+userIPage.getTotal());
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void page1(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>();
        queryWrapper.gt("id",1);
        //不查询总条数
        Page<User> page = new Page<User>(1,2,false);
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, queryWrapper);
        System.out.println("当前页"+mapIPage.getCurrent());
        System.out.println("总条数"+mapIPage.getTotal());
        System.out.println("得到的条数"+mapIPage.getSize());
        List<Map<String, Object>> records = mapIPage.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void insert(){
        User user = new User();
        user.setId(1);
//        user.setName("王王王");
//        user.setVersion("1");
//        user.setEmail("www@qq.com");
//        user.setAge(223);
//        user.setUpdateTime(new Date());
        int insert = userMapper.updateById(user);
        if(insert>0){
            userMapper.selectList(null).forEach(System.out::println);
        }
    }
}

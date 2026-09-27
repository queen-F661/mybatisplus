package com.example.mybatisplus;

import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    // 继承了BaseMapper 所有的方法都来自自己的父类
    // 我们也可以编写自己的扩展方法
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        // 参数是一个wrapper,条件构造器 这里我们先不用null(相当于类的构造器)
        // 查询所有的用户
        List<User> users = userMapper.selectList(null);
        // 这个的作用相当于循环打印数据
        users.forEach(System.out::println);
    }

}

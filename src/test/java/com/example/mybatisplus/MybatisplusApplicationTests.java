package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

    @Test
    void Insert(){
        // 插入一条数据
        // 他可以自动的生成id
        User user = new User();
        user.setName("狂神说java");
        user.setAge(3);
        user.setEmail("122222@qq.com");

        int result = userMapper.insert(user);
        System.out.println(result); // 受影响的行数
        System.out.println(user); // 发现id会自动回填
    }


    @Test
    public void testUpdate(){

        User user = new User();
        // 通过条件来动态拼接sql
        user.setId(5L);
        user.setName("关注公众号:狂神说");
        user.setAge(18);

        // 注意:UpdateById 但是参数是一个对象!
        int i = userMapper.updateById(user);

    }

    /**
     * 测试乐观锁成功!
     * */
    @Test
    public void testmybatisPlus01(){
        // 1.查询用户信息
        User user = userMapper.selectById(1L);
        // 2.修改用户信息
        user.setName("kuansheng");
        user.setEmail("24736743@qq.com");
        // 3.执行更新操作
        int i = userMapper.updateById(user);
    }

    /**
     * 测试乐观锁失败！ 多线程下
     * */
    @Test
    public void testmybatisPlus02(){
        // 线程1
        User user01 = userMapper.selectById(1L);
        user01.setName("kuansheng111");
        user01.setEmail("24736743@qq.com");
        // 模拟另外一个线程执行了插队操作
        User user02 = userMapper.selectById(1L);
        user02.setName("kuansheng222");
        user02.setEmail("24736743@qq.com");
        userMapper.updateById(user02);

        // 直选锁来多次尝试提交!
        userMapper.updateById(user01);
    }
}

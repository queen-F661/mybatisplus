package com.example.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mybatisplus.mapper.UserMapper;
import com.example.mybatisplus.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
        // 查询name不为空的用户,并且邮箱不为空的用户,年纪大于等于12
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 给他设置当前的api
        userQueryWrapper
                .isNotNull("name")
                .isNotNull("email")
                .ge("age", 12)
        ;
        userMapper.selectList(userQueryWrapper).forEach(System.out::println);
    }

    @Test
    void test02() {
        // 查询名称 查询相关的数据
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", "关注公众号:狂神说");
        // 查询一个数据,出现多个结果使用List或者map
        userMapper.selectOne(userQueryWrapper);
    }

    /**
     * 查询年纪在20~30岁之间的用户
     *
     */
    @Test
    void test03() {
        // 查询年纪在20~30岁之间的用户
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 区间 between
        userQueryWrapper.between("age", 20, 30);
        // 查询结果数量
        Long count = userMapper.selectCount(userQueryWrapper);
        System.out.println(count);
    }

    /**
     * 模糊查询
     *
     */
    @Test
    void test04() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 左和有右
        userQueryWrapper
                .likeRight("name", "k")
                .notLike("name", "e")
        ;

        // 查询结果数量
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);
    }


    /**
     * 子查询
     */
    @Test
    void test05() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        // id在子查询中查询出来的
        userQueryWrapper.inSql("id","select id from user where id > 3");

        List<Object> objects = userMapper.selectObjs(userQueryWrapper);
        objects.forEach(System.out::println);
    }

    /**
     * 测试六
     * */
    @Test
    void test06() {
        // 根据id来进行排序
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.orderByAsc("id");

        userMapper.selectList(userQueryWrapper);
    }
}
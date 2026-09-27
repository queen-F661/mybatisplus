package com.example.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

// 在对应的mapper上面实现基本的接口 baseMapper
// 你要操作哪个类 就传递哪个实体类进去
@Repository  // 代表持久层
public interface UserMapper extends BaseMapper<User> {
    // 所有的crud操作都已经编写完成了
    // 你不需要像以前的配置类

}

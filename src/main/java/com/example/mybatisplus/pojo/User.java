package com.example.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    // 对应数据库中的主键(uuid,自增id,雪花算法,redis,zookeeper！)
    @TableId(type = IdType.AUTO)  // 一旦手动输入id之后,就需要自己配置id了!
    private Long id;

    private String name;

    private Integer age;

    private String email;

    // 乐观锁注解
    @Version
    private int version;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}

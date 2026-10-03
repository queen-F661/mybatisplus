package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.pojo.Employee;
import com.example.mybatisplus.mapper.EmployeeMapper;
import com.example.mybatisplus.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 员工表 服务实现类
 * </p>
 *
 * @author ithema
 * @since 2026-09-28
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

}

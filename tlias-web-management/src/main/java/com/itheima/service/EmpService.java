package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
public interface EmpService {
    //分页查询
    PageBean page(Integer page,Integer pageSize,String name, Short gender,
                  LocalDate begin, LocalDate end);

    //删除职工
    void delete(List<Integer> ids);

    //新增员工
    void save(Emp emp);

    //查询员工
    Emp getById(Integer id);

    //修改员工信息-->动态SQL
    void update(Emp emp);

    //员工登录
    Emp login(Emp emp);
}

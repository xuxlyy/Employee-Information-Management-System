package com.itheima.service.impl;

import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageBean page(Integer page, Integer pageSize,String name, Short gender,
                         LocalDate begin, LocalDate end) {
        //获取总记录数
        Long total = empMapper.count();
        //获取分页查询结果列表
        Integer start = (page -1)*pageSize;
        List<Emp> rows = empMapper.page(start,pageSize,name,gender, begin,end);
        //封装为PageBean对象
        PageBean pageBean = new PageBean(total,rows);
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids){
        empMapper.delete(ids);
    }

    @Override
    public void save(Emp emp){
        //补全属性
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id){
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp){
        //补全数据
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPassword(emp);
    }

}

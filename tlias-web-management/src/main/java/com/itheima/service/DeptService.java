package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 */
public interface DeptService {
    //声明对应的list方法 -- 查询全部部门数据
    List<Dept> list();

    //根据ID删除部门
    void delete(Integer id);

    //新增部门
    void add(Dept dept);

    //根据ID查找部门
    Dept get(Integer id);

    //修改部门
    void edit(Dept dept);
}

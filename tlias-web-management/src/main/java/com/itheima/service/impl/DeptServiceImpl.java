package com.itheima.service.impl;

import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Dept;
import com.itheima.pojo.DeptLog;
import com.itheima.service.DeptLogService;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    /*对list（）方法的实现
     * */
    //Service类不可以对数据库进行直接的操作，因此引入Mapper的依赖
    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private DeptLogService deptLogService;

    @Override
    public List<Dept> list() {
        //调用Mapper中的方法 查询全部部门信息
        return deptMapper.list();
    }

    @Override
    @Transactional //由Spring进行事务管理
    public void delete(Integer id){
        try {
            deptMapper.deleteById(id);
            //删除部门下的员工信息
            empMapper.deleteByDeptId(id);
        } finally {
            //记录日志
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("执行解散部门操作，此次解散的是"+id+"部门");
            deptLogService.insert(deptLog);
        }
    }

    @Override
    public void add(Dept dept){
        //补全属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public Dept get(Integer id){
        return deptMapper.getById(id);
    }

    @Override
    public void edit(Dept dept){
        //补全属性 修改更新时间
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
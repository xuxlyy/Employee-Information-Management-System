package com.itheima.controller;

import com.itheima.anno.Log;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理Controller
 */
//自动添加日志的注解
@Slf4j
@RestController//返回的结果为json 是Result转Json后的结果
//因为此注解为组合注解 里面包含了@ResponseBody注解
//此注解会将返回值中的对象转换为Json 再进行响应

//Controller调用Service类
@RequestMapping("/depts")
public class DeptController {
    /*查询部门信息的方法
    * */
    //注入部门管理的Service接口 以供Controller方法调用Service接口的list方法获取全部部门的数据
    @Autowired
    private DeptService deptService;

    //添加注解 指定当前接口的访问路径
    @GetMapping
    public Result list(){
        //记录日志
        log.info("查询全部部门数据");
        //调用Service的list方法 查询所有部门的信息 使用List集合接收
        List<Dept> deptList = deptService.list();
        //返回结果
        return Result.success(deptList);
    }


    //删除部门信息的方法
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        //@PathVariable注解 使方法的参数的id绑定到 路径中参数的id
        deptService.delete(id);
        log.info("根据ID删除部门:{}",id);
        return Result.success();
    }

    //新增部门的方法
    @Log
    @PostMapping
    //接收传进来的json格式的数据 @RequestBody 封装成dept类的对象中
    public Result add(@RequestBody Dept dept){
        log.info("添加新的部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据部门ID查询获取对应部门-->页面回显
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("根据Id查询对应部门");
        return Result.success(deptService.get(id));
    }

    //修改部门
    @Log
    @PutMapping//利用注解进行封装
    public Result edit(@RequestBody Dept dept){
        log.info("修改部门");
        deptService.edit(dept);
        return Result.success();
    }
}

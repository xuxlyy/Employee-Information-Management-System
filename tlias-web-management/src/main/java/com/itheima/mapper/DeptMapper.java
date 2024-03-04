package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 部门管理
 */
@Mapper
public interface DeptMapper {
    //实现 查询所有部门的方法--->通过对数据库的直接操作
    @Select("select * from dept")
    List<Dept> list();

    //根据ID删除部门
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    //插入新的部门
    @Insert("insert into dept(name,create_time,update_time) values (#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    //根据ID获取对应部门
    @Select("select * from dept where id = #{id}")
    Dept getById(Integer id);

    //修改部门信息
    @Update("update dept set name=#{name},update_time = #{updateTime} where id=#{id};")
    void update(Dept dept);
//    @Update("update dept set name = #{name},update_time = #{updateTime} where id = #{id}")
//    void update(Dept dept);
}

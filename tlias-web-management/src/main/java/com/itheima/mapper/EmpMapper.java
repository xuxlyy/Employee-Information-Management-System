package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 员工管理
 */
@Mapper
public interface EmpMapper {
    //返回分页查询数据
    //@Select("select * from emp limit #{start},#{pageSize}")
    List<Emp> page(Integer start, Integer pageSize, String name, Short gender,
                          LocalDate begin, LocalDate end);

    //查询总记录数
    @Select("select count(*) from emp")
    Long count();

    void delete(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    //根据ID查询员工信息
    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);

    //修改员工信息
    void update(Emp emp);

    //根据ID 密码查找员工信息
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getByUsernameAndPassword(Emp emp);

    //根据部门ID删除部门下员工信息
    @Delete("delete from emp where dept_id = #{deptId}")
    void deleteByDeptId(Integer deptId);
}

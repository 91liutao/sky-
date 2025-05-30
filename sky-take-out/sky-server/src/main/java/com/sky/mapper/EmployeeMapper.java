package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;

import com.sky.enumeration.OperationType;
import com.sky.result.PageResult;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);
    //新增员工数据
    @Insert("insert into employee (name,username,password,phone,sex,id_number,status,create_time,update_time,create_user,update_user) " +
            "values (#{name},#{username},#{password},#{phone},#{sex},#{idNumber},#{status},#{createTime},#{updateTime},#{createUser},#{updateUser})")
    @AutoFill(value = OperationType.INSERT)
    void insert(Employee employee);
    //分页查询员工数据

    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
    /*
    * 根据主键动态修改属性*/
    @AutoFill(OperationType.UPDATE)
    void update(Employee employee);
//根据id查询员工
    Employee getById(Long id);
    //根据id修改员工

}

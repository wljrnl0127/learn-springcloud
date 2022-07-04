package com.cfz.mapper;

import com.cfz.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentMapper {

    /**
     * 查询所有部门信息
     */
    List<Department> getDeptList();

    /**
     * 根据id查询部门信息
     */
    Department getDeptById(@Param("deptId") Integer deptId);

    /**
     * 添加部门信息
     */
    boolean addDept(Department department);

    /**
     * 更新部门信息
     */
    boolean updateDept(Department department);

    /**
     * 删除部门信息
     */
    boolean deleteDept(Integer deptId);

}

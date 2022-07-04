package com.cfz.server.impl;

import com.cfz.mapper.DepartmentMapper;
import com.cfz.pojo.Department;
import com.cfz.server.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询所有部门信息
     */
    @Override
    public List<Department> getDeptList() {
        return departmentMapper.getDeptList();
    }

    /**
     * 根据id查询部门信息
     *
     * @param deptId
     */
    @Override
    public Department getDeptById(Integer deptId) {
        return departmentMapper.getDeptById(deptId);
    }

    /**
     * 添加部门信息
     *
     * @param department
     */
    @Override
    public boolean addDept(Department department) {
        return departmentMapper.addDept(department);
    }

    /**
     * 更新部门信息
     *
     * @param department
     */
    @Override
    public boolean updateDept(Department department) {
        return departmentMapper.updateDept(department);
    }

    /**
     * 删除部门信息
     *
     * @param deptId
     */
    @Override
    public boolean deleteDept(Integer deptId) {
        return departmentMapper.deleteDept(deptId);
    }

}

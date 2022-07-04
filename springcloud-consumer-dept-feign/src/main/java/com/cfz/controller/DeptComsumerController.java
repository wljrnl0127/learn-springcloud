package com.cfz.controller;

import com.cfz.pojo.Department;
import com.cfz.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptComsumerController {

    @Autowired
    private DeptClientService deptClientService;

    /**
     * 根据id查询部门信息
     */
    @GetMapping("/consumer/dept/get/{deptId}")
    public Department getDeptById(@PathVariable("deptId") int deptId) {
        return deptClientService.getDeptById(deptId);
    }

    /**
     * 查询所有部门信息
     */
    @GetMapping("/consumer/dept/list")
    public List<Department> list() {
        return deptClientService.getDeptList();
    }

    /**
     * 添加部门信息
     */
    @GetMapping("/consumer/dept/add")
    public Boolean addDept(Department department) {
        return deptClientService.addDept(department);
    }

    /**
     * 更新部门信息
     */
    @GetMapping("/consumer/dept/update")
    public Boolean updateDept(Department department) {
        return deptClientService.updateDept(department);
    }

    /**
     * 删除部门信息
     */
    @GetMapping("/consumer/dept/delete/{deptId}")
    public Boolean deleteDept(@PathVariable("deptId") Integer deptId) {
        return deptClientService.deleteDept(deptId);
    }
}

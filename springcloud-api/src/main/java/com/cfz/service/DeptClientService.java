package com.cfz.service;

import com.cfz.pojo.Department;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT")
public interface DeptClientService {

    /**
     * 查询所有部门信息
     */
    @GetMapping("/dept/list")
    List<Department> getDeptList();

    /**
     * 根据id查询部门信息
     */
    @GetMapping("/dept/get/{deptId}")
    Department getDeptById(@Param("deptId") Integer deptId);

    /**
     * 添加部门信息
     */
    @GetMapping("/dept/add")
    boolean addDept(Department department);

    /**
     * 更新部门信息
     */
    @GetMapping("/dept/update")
    boolean updateDept(Department department);

    /**
     * 删除部门信息
     */
    @GetMapping("/dept/delete/{deptId}")
    boolean deleteDept(@Param("deptId") Integer deptId);
}

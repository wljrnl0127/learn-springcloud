package com.cfz.controller;

import com.cfz.pojo.Department;
import com.cfz.server.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * DiscoveryClient 可以用来获取一些配置的信息，得到具体的微服务！
     */
    @Autowired
    private DiscoveryClient client;

    /**
     * 获取一些注册进来的微服务的信息~，
     *
     * @return
     */
    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);
        // 得到一个具体的微服务信息,通过具体的微服务id，applicaioinName；
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t" + // 主机名称
                            instance.getPort() + "\t" + // 端口号
                            instance.getUri() + "\t" + // uri
                            instance.getServiceId() // 服务id
            );
        }
        return this.client;
    }

    /**
     * 查询所有部门信息
     */
    @GetMapping("/dept/list")
    public List<Department> getDeptList() {
        return departmentService.getDeptList();
    }

    /**
     * 根据id查询部门信息
     */
    @GetMapping("/dept/get/{deptId}")
    public Department getDeptById(@PathVariable("deptId") Integer deptId) {
        return departmentService.getDeptById(deptId);
    }

    /**
     * 添加部门信息
     */
    @GetMapping("/dept/add")
    public boolean addDept(Department department) {
        return departmentService.addDept(department);
    }

    /**
     * 更新部门信息
     */
    @GetMapping("/dept/update")
    public boolean updateDept(Department department) {
        return departmentService.updateDept(department);
    }

    /**
     * 删除部门信息
     */
    @GetMapping("/dept/delete/{deptId}")
    public boolean deleteDept(@PathVariable("deptId") Integer deptId) {
        return departmentService.deleteDept(deptId);
    }

}

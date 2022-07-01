package com.cfz.controller;

import com.cfz.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptComsumerController {

    /**
     * 服务提供方地址前缀
     * <p>
     * Ribbon:我们这里的地址，应该是一个变量，通过服务名来访问
     */
//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    /**
     * 理解：消费者，不应该有service层~
     * RestTemplate .... 供我们直接调用就可以了！ 注册到Spring中
     * (地址：url, 实体：Map ,Class<T> responseType)
     * <p>
     * 提供多种便捷访问远程http服务的方法，简单的Restful服务模板~
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据id查询部门信息
     */
    @RequestMapping("/consumer/dept/get/{deptId}")
    public Department getDeptById(@PathVariable("deptId") int deptId) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + deptId, Department.class);
    }

    /**
     * 查询所有部门信息
     */
    @RequestMapping("/consumer/dept/list")
    public List<Department> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    /**
     * 添加部门信息
     */
    @RequestMapping("/consumer/dept/add")
    public Boolean addDept(Department department) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", department, Boolean.class);
    }

    /**
     * 更新部门信息
     */
    @RequestMapping("/consumer/dept/update")
    public Boolean updateDept(Department department) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/update", department, Boolean.class);
    }

    /**
     * 删除部门信息
     */
    @RequestMapping("/consumer/dept/delete/{deptId}")
    public Boolean deleteDept(@PathVariable("deptId") Integer deptId) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/delete/" + deptId, Boolean.class);
    }

}

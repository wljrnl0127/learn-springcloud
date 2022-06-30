package com.cfz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //链式写法
public class Department implements Serializable {

    //部门id
    private Integer deptId;
    //部门名称
    private String deptName;
    //数据源名称
    private String dbSource;

}

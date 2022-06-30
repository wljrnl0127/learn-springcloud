package com.cfz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 启动之后访问http://localhost:7001
 *
 * @author cfz的ThinkPad
 */
@SpringBootApplication
@EnableEurekaServer // 启动eureka服务器，可以接收注册中心的请求
public class EurekaServer_7002 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7002.class, args);
    }
}

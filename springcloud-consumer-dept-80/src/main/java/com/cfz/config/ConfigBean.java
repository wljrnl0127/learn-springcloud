package com.cfz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author cfz
 * @Configuration 告诉SpringBoot，这是一个配置类 ，相当于spring的 applicationContext.xml  配置文件
 * @date 2022/6/27
 */
@Configuration
public class ConfigBean {

    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }

}

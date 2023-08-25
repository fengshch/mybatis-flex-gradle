package com.github.fengshch.mybatis.config;

import lombok.Data;

@Data
public class DataSourceConfigBuilder {
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}

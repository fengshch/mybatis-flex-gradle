package com.github.fengshch.mybatis.config;

import lombok.Data;

/**
 * Builder class for configuring database data source settings.
 *
 * This class holds the configuration for database connections including URL, credentials,
 * and driver information. It is used during code generation to establish connections to
 * the database for introspection and model generation.
 *
 * @see GlobalConfigBuilder
 */
@Data
public class DataSourceConfigBuilder {
    /**
     * Constructs a new {@code DataSourceConfigBuilder} with default settings.
     */
    public DataSourceConfigBuilder() {
    }
    private String url;
    private String username;
    private String password;
    private String driverClassName;
}

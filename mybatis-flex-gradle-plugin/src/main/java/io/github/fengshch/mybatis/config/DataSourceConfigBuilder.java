package io.github.fengshch.mybatis.config;

/**
 * Builder class for configuring database data source settings.
 *
 * This class holds the configuration for database connections including URL, credentials,
 * and driver information. It is used during code generation to establish connections to
 * the database for introspection and model generation.
 *
 * @see GlobalConfigBuilder
 */
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
}

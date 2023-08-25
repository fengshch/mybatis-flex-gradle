package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.ServiceConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class ServiceConfigBuilder {
    /**
     * Service 类的前缀。
     */
    private String classPrefix = "";

    /**
     * Service 类的后缀。
     */
//    private String classSuffix = "Service";
    private String classSuffix = "Repo";

    /**
     * 自定义 Service 的父类。
     */
    private String superClass;

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = false;

    public void build(GlobalConfig globalConfig) {
        ServiceConfig serviceConfig = globalConfig.getServiceConfig();
        if (StringUtils.isNotBlank(classPrefix)) {
            serviceConfig.setClassPrefix(classPrefix);
        }
        if (StringUtils.isNotBlank(classSuffix)) {
            serviceConfig.setClassSuffix(classSuffix);
        }
        if (StringUtils.isNotBlank(superClass)) {
            try {
                Class<?> aClass = Class.forName(superClass);
                serviceConfig.setSuperClass(aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        serviceConfig.setOverwriteEnable(overwriteEnable);
    }
}

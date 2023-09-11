package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.ControllerConfig;
import com.mybatisflex.codegen.config.GlobalConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class ControllerConfigBuilder {
    /**
     * Controller 类的前缀。
     */
    private String classPrefix = "";

    /**
     * Controller 类的后缀。
     */
    private String classSuffix = "Controller";

    /**
     * 自定义 Controller 的父类。
     */
    private String superClass;

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = false;

    /**
     * 生成 REST 风格的 Controller。
     */
    private boolean restStyle = true;

    public void build(GlobalConfig globalConfig) {
        ControllerConfig controllerConfig = globalConfig.getControllerConfig();
        if (StringUtils.isNotBlank(classPrefix)) {
            controllerConfig.setClassPrefix(classPrefix);
        }
        if (StringUtils.isNotBlank(classSuffix)) {
            controllerConfig.setClassSuffix(classSuffix);
        }
        if (StringUtils.isNotBlank(superClass)) {
            try {
                Class<?> aClass = Class.forName(superClass);
                controllerConfig.setSuperClass(aClass);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("superClass not found: " + superClass);
            }
        }
        controllerConfig.setOverwriteEnable(overwriteEnable);
        controllerConfig.setRestStyle(restStyle);
    }
}

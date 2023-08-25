package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.ServiceImplConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class ServiceImplConfigBuilder {
    /**
     * ServiceImpl 类的前缀。
     */
    private String classPrefix = "";

    /**
     * ServiceImpl 类的后缀。
     */
    private String classSuffix = "RepoImpl";

    /**
     * 自定义 ServiceImpl 的父类。
     */
    private String superClass;

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = false;

    /**
     * 是否生成缓存样例代码。
     */
    private boolean cacheExample = false;

    public void build(GlobalConfig globalConfig){
        ServiceImplConfig serviceImplConfig = globalConfig.getServiceImplConfig();
        if(StringUtils.isNotBlank(classPrefix)){
            serviceImplConfig.setClassPrefix(classPrefix);
        }
        if(StringUtils.isNotBlank(classSuffix)){
            serviceImplConfig.setClassSuffix(classSuffix);
        }
        if(StringUtils.isNotBlank(superClass)){
            try {
                Class<?> aClass = Class.forName(superClass);
                serviceImplConfig.setSuperClass(aClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        serviceImplConfig.setOverwriteEnable(overwriteEnable);
        serviceImplConfig.setCacheExample(cacheExample);
    }
}

package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.PackageConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.gradle.api.Project;

@Data
public class PackageConfigBuilder {

    /**
     * 代码生成目录。
     */
    private String sourceDir = "src/batis/java";

    /**
     * 根包。
     */
    private String basePackage = "com.mybatisflex";

    /**
     * Entity 所在包。
     */
    private String entityPackage = "po";

    /**
     * Mapper 所在包。
     */
    private String mapperPackage;

    /**
     * Service 所在包。
     */
    private String servicePackage = "repo";

    /**
     * ServiceImpl 所在包。
     */
    private String serviceImplPackage = "repo.impl";

    /**
     * Controller 所在包。
     */
    private String controllerPackage;

    /**
     * TableDef 所在包。
     */
    private String tableDefPackage;

    /**
     * MapperXml 文件所在位置。
     */
    private String mapperXmlPath;// = "src/batis/resources/mapper";

    public void build(Project project, GlobalConfig globalConfig) {
        PackageConfig packageConfig = globalConfig.getPackageConfig();
        if (StringUtils.isNotBlank(sourceDir)){
            String projectDir = project.getProjectDir().getAbsolutePath();
            String path = projectDir +"/" + sourceDir;
            packageConfig.setSourceDir(path);
        }
        if (StringUtils.isNotBlank(basePackage))
            packageConfig.setBasePackage(basePackage);
        if (StringUtils.isNotBlank(entityPackage))
            packageConfig.setEntityPackage(basePackage + "." + entityPackage);
        if (StringUtils.isNotBlank(mapperPackage))
            packageConfig.setMapperPackage(basePackage + "." + mapperPackage);
        if (StringUtils.isNotBlank(servicePackage))
            packageConfig.setServicePackage(basePackage + "." + servicePackage);
        if (StringUtils.isNotBlank(serviceImplPackage))
            packageConfig.setServiceImplPackage(basePackage + "." +serviceImplPackage);
        if (StringUtils.isNotBlank(controllerPackage))
            packageConfig.setControllerPackage(basePackage + "." + controllerPackage);
        if (StringUtils.isNotBlank(tableDefPackage))
            packageConfig.setTableDefPackage(basePackage + "." + tableDefPackage);
        if (StringUtils.isNotBlank(mapperXmlPath)){
            String path = project.getProjectDir().getAbsolutePath() + "/" + mapperXmlPath;
            packageConfig.setMapperXmlPath(path);
        }else{
            if(StringUtils.isBlank(mapperPackage )){
                mapperPackage = "mapper";
            }
            String path = project.getProjectDir().getAbsolutePath() + "/"+ sourceDir +  "/" + basePackage.replace(".", "/") + "/" + mapperPackage + "/xml";
            packageConfig.setMapperXmlPath(path);
        }
    }
}

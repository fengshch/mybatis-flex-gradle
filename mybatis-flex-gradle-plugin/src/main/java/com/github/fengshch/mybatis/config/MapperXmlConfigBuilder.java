package com.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.MapperXmlConfig;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class MapperXmlConfigBuilder {
    /**
     * MapperXml 文件的前缀。
     */
    private String filePrefix = "";

    /**
     * MapperXml 文件的后缀。
     */
    private String fileSuffix = "Mapper";

    /**
     * 是否覆盖之前生成的文件。
     */
    private boolean overwriteEnable = true;

    public void build(GlobalConfig globalConfig){
        MapperXmlConfig mapperXmlConfig = globalConfig.getMapperXmlConfig();
        if(StringUtils.isNotBlank(filePrefix)){
            mapperXmlConfig.setFilePrefix(filePrefix);
        }
        if(StringUtils.isNotBlank(fileSuffix)){
            mapperXmlConfig.setFileSuffix(fileSuffix);
        }
        mapperXmlConfig.setOverwriteEnable(overwriteEnable);
    }
}

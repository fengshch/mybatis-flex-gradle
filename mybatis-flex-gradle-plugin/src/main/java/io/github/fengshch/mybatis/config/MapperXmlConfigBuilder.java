package io.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import com.mybatisflex.codegen.config.MapperXmlConfig;
import org.apache.commons.lang3.StringUtils;

/**
 * Builder class for configuring Mapper XML file code generation settings.
 *
 * This class configures the generation of MyBatis Mapper XML files that contain SQL statements
 * and their mappings to the mapper interface methods.
 *
 * @see GlobalConfigBuilder
 * @see MapperXmlConfig
 */
public class MapperXmlConfigBuilder {
    /**
     * Constructs a new {@code MapperXmlConfigBuilder} with default settings.
     */
    public MapperXmlConfigBuilder() {
    }

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

    public String getFilePrefix() {
        return filePrefix;
    }

    public void setFilePrefix(String filePrefix) {
        this.filePrefix = filePrefix;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }

    public boolean isOverwriteEnable() {
        return overwriteEnable;
    }

    public void setOverwriteEnable(boolean overwriteEnable) {
        this.overwriteEnable = overwriteEnable;
    }

    /**
     * Builds and applies the mapper XML configuration to the global config.
     *
     * @param globalConfig the {@link GlobalConfig} to update with mapper XML settings
     */
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

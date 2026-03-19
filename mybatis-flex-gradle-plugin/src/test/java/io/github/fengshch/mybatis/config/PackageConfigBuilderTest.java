package io.github.fengshch.mybatis.config;

import com.mybatisflex.codegen.config.GlobalConfig;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PackageConfigBuilderTest {

    @Test
    void testBuildResolvesPathsFromCapturedProjectDir() {
        PackageConfigBuilder builder = new PackageConfigBuilder();
        builder.setProjectDir("/tmp/project");
        builder.setSourceDir("src/batis/java");
        builder.setBasePackage("com.example");
        builder.setMapperPackage("mapper");

        GlobalConfig globalConfig = new GlobalConfig();
        builder.build(globalConfig);

        assertEquals("/tmp/project/src/batis/java", globalConfig.getPackageConfig().getSourceDir());
        assertEquals("/tmp/project/src/batis/java/com/example/mapper/xml", globalConfig.getPackageConfig().getMapperXmlPath());
        assertEquals("/tmp/project/src/batis/java", builder.getResolvedSourceDir());
    }
}

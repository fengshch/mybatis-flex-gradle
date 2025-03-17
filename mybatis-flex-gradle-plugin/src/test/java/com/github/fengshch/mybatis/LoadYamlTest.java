package com.github.fengshch.mybatis;

import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;

public class LoadYamlTest {

    @SuppressWarnings("unchecked")
    private Map<String, Object> readDataSourceConfig(InputStream yamlStream) {
        Yaml yaml = new Yaml();
        try {
            Iterable<Object> documents = yaml.loadAll(yamlStream);
            for (Object document : documents) {
                if (document instanceof Map) {
                    Map<String, Object> props = (Map<String, Object>) document;
                    if (props.get("spring") instanceof Map) {
                        Map<String, Object> spring = (Map<String, Object>) props.get("spring");
                        if (spring != null && spring.get("datasource") instanceof Map) {
                            Map<String, Object> datasource = (Map<String, Object>) spring.get("datasource");
                            if (datasource != null) {
                                return datasource;
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read YAML file", e);
        }
        return null;
    }

    @Test
    public void testLoadMultipleYaml() {
        try (InputStream yamlStream = getClass().getClassLoader().getResourceAsStream("application.yml")) {
            if (yamlStream == null) {
                System.out.println("application.yml not found");
                return;
            }
            Map<String, Object> dataSourceConfig = readDataSourceConfig(yamlStream);
            if (dataSourceConfig != null) {
                System.out.println("Datasource Config: " + dataSourceConfig);
            } else {
                System.out.println("Datasource Config not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
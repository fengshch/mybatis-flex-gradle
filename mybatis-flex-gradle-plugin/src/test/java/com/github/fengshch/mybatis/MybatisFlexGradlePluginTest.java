/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.fengshch.mybatis;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * A simple unit test for the 'com.github.fengshch.mybatis.greeting' plugin.
 */
class MybatisFlexGradlePluginTest {
    @TempDir
    public File testProjectDir;

    private File buildFile;

    @BeforeEach
    public void setup() {
        buildFile = new File(testProjectDir, "build.gradle");
    }

    @Test
    public void pluginRegistersATask() throws IOException {
        // Write the contents of the build file
        String content = """
                        plugins {
                            id 'com.github.fengshch.mybatis-flex-gradle-plugin'
                        }
                   
                        mybatis{
                            configurations{
                                main {
                                    dataSourceConfig{
                                        driverClassName = 'org.postgresql.Driver'
                                        url = 'jdbc:postgresql://localhost:5432/postgres'
                                        username = 'postgres'
                                        password = '123456'
                                     }
                                    packageConfig{
                                        sourceDir ="src/main/java"
                                        basePackage = "com.example"
                                    }
                                }
                            }
                        }
                """;
        // Write the contents of the build file
        Files.write(buildFile.toPath(), content.getBytes());

        BuildResult tasks = GradleRunner.create()
                .withProjectDir(testProjectDir)
                .withPluginClasspath()
                .withArguments("tasks")
                .build();
        System.out.println("tasks:" + tasks.getOutput());
        // Verify the result
        assertNotNull(tasks);
    }
}

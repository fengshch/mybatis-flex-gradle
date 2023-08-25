package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayCleanTask;

import javax.inject.Inject;

public class CustomFlywayCleanTask extends FlywayCleanTask {

    @Inject
    public CustomFlywayCleanTask(FlywayExtension flywayExtension) {
        super();
        this.extension = flywayExtension;
    }
}

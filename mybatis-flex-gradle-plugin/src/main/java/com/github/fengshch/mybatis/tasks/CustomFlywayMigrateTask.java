package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayMigrateTask;

import javax.inject.Inject;

public class CustomFlywayMigrateTask extends FlywayMigrateTask {
    @Inject
    public CustomFlywayMigrateTask(FlywayExtension flywayExtension) {
        super();
        this.extension = flywayExtension;
    }
}

package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayInfoTask;

import javax.inject.Inject;

public class CustomFlywayInfoTask extends FlywayInfoTask {
    @Inject
    public CustomFlywayInfoTask(FlywayExtension flywayExtension) {
        super();
        this.extension = flywayExtension;
    }
}

package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayBaselineTask;

import javax.inject.Inject;

public class CustomFlywayBaselineTask extends FlywayBaselineTask {
    @Inject
    public CustomFlywayBaselineTask(FlywayExtension flywayExtension) {
        super();
        this.extension = flywayExtension;
    }
}

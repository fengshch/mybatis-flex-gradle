package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayRepairTask;

import javax.inject.Inject;

public class CustomFlywayRepairTask extends FlywayRepairTask {
    @Inject
    public CustomFlywayRepairTask(FlywayExtension flywayExtension){
        super();
        this.extension = flywayExtension;
    }
}

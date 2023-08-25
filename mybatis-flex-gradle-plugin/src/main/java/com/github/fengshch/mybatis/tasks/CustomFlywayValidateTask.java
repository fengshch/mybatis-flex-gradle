package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayValidateTask;

import javax.inject.Inject;

public class CustomFlywayValidateTask extends FlywayValidateTask {
    @Inject
   public CustomFlywayValidateTask(FlywayExtension flywayExtension){
        super();
        this.extension = flywayExtension;
    }
}

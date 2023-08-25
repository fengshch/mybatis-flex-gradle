package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayUndoTask;

import javax.inject.Inject;

public class CustomFlywayUndoTask extends FlywayUndoTask {
    @Inject
   public CustomFlywayUndoTask(FlywayExtension flywayExtension){
       super();
       this.extension = flywayExtension;
   }
}

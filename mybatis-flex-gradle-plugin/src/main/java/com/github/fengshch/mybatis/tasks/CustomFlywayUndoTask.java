package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayUndoTask;

import javax.inject.Inject;

/**
 * Custom Flyway undo task that extends the standard {@link FlywayUndoTask}.
 *
 * This task undoes the most recently applied migration by executing the corresponding undo migration script.
 * It requires undo migration scripts to be present for the migrations that need to be undone.
 *
 * The {@code FlywayExtension} is injected via Gradle's dependency injection mechanism to provide
 * the Flyway configuration needed for the undo operation.
 *
 * @see FlywayUndoTask
 * @see FlywayExtension
 */
public class CustomFlywayUndoTask extends FlywayUndoTask {
    /**
     * Constructs a new {@code CustomFlywayUndoTask} with the specified Flyway extension.
     *
     * @param flywayExtension the {@link FlywayExtension} containing Flyway configuration
     *                        for database connection and migration settings
     */
    @Inject
   public CustomFlywayUndoTask(FlywayExtension flywayExtension){
       super();
       this.extension = flywayExtension;
   }
}

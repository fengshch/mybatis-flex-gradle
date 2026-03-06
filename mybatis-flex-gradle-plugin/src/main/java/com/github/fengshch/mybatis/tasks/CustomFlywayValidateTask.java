package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayValidateTask;

import javax.inject.Inject;

/**
 * Custom Flyway validate task that extends the standard {@link FlywayValidateTask}.
 *
 * This task validates the database migrations by checking the integrity of the migration scripts
 * and comparing them against the migration history in the database. It ensures that all applied
 * migrations are still present and unchanged.
 *
 * The {@code FlywayExtension} is injected via Gradle's dependency injection mechanism to provide
 * the Flyway configuration needed for the validation operation.
 *
 * @see FlywayValidateTask
 * @see FlywayExtension
 */
public class CustomFlywayValidateTask extends FlywayValidateTask {
    /**
     * Constructs a new {@code CustomFlywayValidateTask} with the specified Flyway extension.
     *
     * @param flywayExtension the {@link FlywayExtension} containing Flyway configuration
     *                        for database connection and migration settings
     */
    @Inject
   public CustomFlywayValidateTask(FlywayExtension flywayExtension){
        super();
        this.extension = flywayExtension;
    }
}

package com.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayMigrateTask;

import javax.inject.Inject;

/**
 * Custom Flyway migrate task that extends the standard {@link FlywayMigrateTask}.
 *
 * This task executes all pending database migrations in order. It compares the migration
 * files with the database to determine which migrations have already been applied and which
 * ones are pending, then applies only the pending migrations.
 *
 * The {@code FlywayExtension} is injected via Gradle's dependency injection mechanism to provide
 * the Flyway configuration needed for the migration operation.
 *
 * @see FlywayMigrateTask
 * @see FlywayExtension
 */
public class CustomFlywayMigrateTask extends FlywayMigrateTask {
    /**
     * Constructs a new {@code CustomFlywayMigrateTask} with the specified Flyway extension.
     *
     * @param flywayExtension the {@link FlywayExtension} containing Flyway configuration
     *                        for database connection and migration settings
     */
    @Inject
    public CustomFlywayMigrateTask(FlywayExtension flywayExtension) {
        super();
        this.extension = flywayExtension;
    }
}

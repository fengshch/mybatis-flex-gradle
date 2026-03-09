package io.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayCleanTask;

import javax.inject.Inject;

/**
 * Custom Flyway clean task that extends the standard {@link FlywayCleanTask}.
 *
 * This task is used to clean (drop) all objects in a database, including tables, views, etc.
 * It allows developers to reset their database schema to a clean state.
 *
 * The {@code FlywayExtension} is injected via Gradle's dependency injection mechanism to provide
 * the Flyway configuration needed for the clean operation.
 *
 * @see FlywayCleanTask
 * @see FlywayExtension
 */
public class CustomFlywayCleanTask extends FlywayCleanTask {

    /**
     * Constructs a new {@code CustomFlywayCleanTask} with the specified Flyway extension.
     *
     * @param flywayExtension the {@link FlywayExtension} containing Flyway configuration
     *                        for database connection and migration settings
     */
    @Inject
    public CustomFlywayCleanTask(FlywayExtension flywayExtension) {
        super();
        this.extension = flywayExtension;
    }
}

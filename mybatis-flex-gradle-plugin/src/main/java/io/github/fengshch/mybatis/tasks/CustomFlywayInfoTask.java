package io.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayInfoTask;

import javax.inject.Inject;

/**
 * Custom Flyway info task that extends the standard {@link FlywayInfoTask}.
 *
 * This task provides information about pending and applied migrations in the database.
 * It displays the current state of the database schema and the history of applied migrations.
 *
 * The {@code FlywayExtension} is injected via Gradle's dependency injection mechanism to provide
 * the Flyway configuration needed for retrieving migration information.
 *
 * @see FlywayInfoTask
 * @see FlywayExtension
 */
public class CustomFlywayInfoTask extends FlywayInfoTask {
    /**
     * Constructs a new {@code CustomFlywayInfoTask} with the specified Flyway extension.
     *
     * @param flywayExtension the {@link FlywayExtension} containing Flyway configuration
     *                        for database connection and migration settings
     */
    @Inject
    public CustomFlywayInfoTask(FlywayExtension flywayExtension) {
        super();
        this.extension = flywayExtension;
    }
}

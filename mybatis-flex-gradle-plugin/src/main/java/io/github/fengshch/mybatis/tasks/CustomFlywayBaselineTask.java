package io.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayBaselineTask;

import javax.inject.Inject;

/**
 * Custom Flyway baseline task that extends the standard {@link FlywayBaselineTask}.
 * <p>
 * This task is used to mark an existing database schema as the baseline for Flyway migration tracking.
 * It allows initializing Flyway on a database that already has existing schema without having to
 * re-run all past migrations.
 * <p>
 * The {@code FlywayExtension} is injected via Gradle's dependency injection mechanism to provide
 * the Flyway configuration needed for the baseline operation.
 *
 * @see FlywayBaselineTask
 * @see FlywayExtension
 */
public class CustomFlywayBaselineTask extends FlywayBaselineTask {
    /**
     * Constructs a new {@code CustomFlywayBaselineTask} with the specified Flyway extension.
     *
     * @param flywayExtension the {@link FlywayExtension} containing Flyway configuration
     *                        for database connection and migration settings
     */
    @Inject
    public CustomFlywayBaselineTask(FlywayExtension flywayExtension) {
        super();
        this.extension = flywayExtension;
    }
}

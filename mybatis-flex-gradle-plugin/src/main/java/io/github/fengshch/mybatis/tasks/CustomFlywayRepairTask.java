package io.github.fengshch.mybatis.tasks;

import org.flywaydb.gradle.FlywayExtension;
import org.flywaydb.gradle.task.FlywayRepairTask;

import javax.inject.Inject;

/**
 * Custom Flyway repair task that extends the standard {@link FlywayRepairTask}.
 *
 * This task repairs the database metadata (the migrations table) by reconciling it with
 * the actual migration files. It can be useful for fixing inconsistencies between the
 * database and the migration history.
 *
 * The {@code FlywayExtension} is injected via Gradle's dependency injection mechanism to provide
 * the Flyway configuration needed for the repair operation.
 *
 * @see FlywayRepairTask
 * @see FlywayExtension
 */
public class CustomFlywayRepairTask extends FlywayRepairTask {
    /**
     * Constructs a new {@code CustomFlywayRepairTask} with the specified Flyway extension.
     *
     * @param flywayExtension the {@link FlywayExtension} containing Flyway configuration
     *                        for database connection and migration settings
     */
    @Inject
    public CustomFlywayRepairTask(FlywayExtension flywayExtension){
        super();
        this.extension = flywayExtension;
    }
}

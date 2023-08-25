package com.github.fengshch.mybatis.config;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.flywaydb.gradle.FlywayExtension;
import org.gradle.api.Project;

@Data
public class FlywayConfigBuilder {
    private final String name;

    public FlywayConfigBuilder(String name) {
        this.name = name;
    }

    private String driver;
    private String url;
    private String user;
    private String password;
    private int connectRetries;
    private int connectRetriesInterval;
    private String initSql;
    private String table;
    private String tablespace;
    private String defaultSchema;
    private String schemas;
    private String baselineVersion;
    private String baselineDescription;
    private String locations;
    private String resolvers;
    private Boolean skipDefaultResolvers;
    private String sqlMigrationPrefix;
    private String undoSqlMigrationPrefix;
    private String repeatableSqlMigrationPrefix;
    private String sqlMigrationSeparator;
    private String sqlMigrationSuffixes;
    private String encoding;
    private Boolean detectEncoding;
    private Integer lockRetryCount;
    //    private Map<Object, Object> placeholders;
//    private Map<Object, Object> jdbcProperties;
    private Boolean placeholderReplacement;
    private String placeholderPrefix;
    private String placeholderSuffix;
    private String placeholderSeparator;
    private String scriptPlaceholderPrefix;
    private String scriptPlaceholderSuffix;
    private String target;
    private String cherryPick;
    private String loggers;
    private String callbacks;
    private Boolean skipDefaultCallbacks;
    private Boolean outOfOrder;
    private Boolean skipExecutingMigrations;
    private Boolean outputQueryResults;
    private Boolean validateOnMigrate = false;
    private Boolean cleanOnValidationError;
    private String ignoreMigrationPatterns;
    private Boolean validateMigrationNaming;
    private Boolean cleanDisabled = false;
    private Boolean baselineOnMigrate = true;
    private Boolean mixed;
    private Boolean group;
    private String installedBy;
    private String configurations;
    private String errorOverrides;
    private String dryRunOutput;
    private Boolean stream;
    private Boolean batch;
    private Boolean oracleSqlplus;
    private Boolean oracleSqlplusWarn;
    private String oracleWalletLocation;
    private String kerberosConfigFile;
    private String licenseKey;
    private String configFileEncoding;
    private String configFiles;
    private String workingDirectory;
    private Boolean createSchemas;
    private Boolean failOnMissingLocations;
//    private Map<String, String> pluginConfiguration;

    public FlywayExtension build(Project project) {
        FlywayExtension flywayExtension = project.getExtensions().create(name + "Flyway", FlywayExtension.class);
        flywayExtension.driver = driver;
        flywayExtension.url = url;
        flywayExtension.user = user;
        flywayExtension.password = password;

        flywayExtension.connectRetries = connectRetries;
        flywayExtension.connectRetriesInterval = connectRetriesInterval;
        flywayExtension.initSql = initSql;
        flywayExtension.table = table;
        flywayExtension.tablespace = tablespace;
        flywayExtension.defaultSchema = defaultSchema;
        if (StringUtils.isNotBlank(schemas))
            flywayExtension.schemas = schemas.split(",");
        flywayExtension.baselineVersion = baselineVersion;
        flywayExtension.baselineDescription = baselineDescription;
        if (StringUtils.isBlank(locations)) {
            String locationsName = name.equals("main") ? "flyway" : name;
            String[] defaultLocations = {"filesystem:src/main/resources/db/" + locationsName};
            flywayExtension.locations = defaultLocations;
        } else {
            flywayExtension.locations = locations.split(",");
        }
        if (StringUtils.isNotBlank(resolvers))
            flywayExtension.resolvers = resolvers.split(",");
        flywayExtension.skipDefaultResolvers = skipDefaultResolvers;
        flywayExtension.sqlMigrationPrefix = sqlMigrationPrefix;
        flywayExtension.undoSqlMigrationPrefix = undoSqlMigrationPrefix;
        flywayExtension.repeatableSqlMigrationPrefix = repeatableSqlMigrationPrefix;
        flywayExtension.sqlMigrationSeparator = sqlMigrationSeparator;
        if (StringUtils.isNotBlank(sqlMigrationSuffixes))
            flywayExtension.sqlMigrationSuffixes = sqlMigrationSuffixes.split(",");
        flywayExtension.encoding = encoding;
        flywayExtension.detectEncoding = detectEncoding;
        flywayExtension.lockRetryCount = lockRetryCount;
//    t,flywayExtension. Object> placeholders;
//    t,flywayExtension. Object> jdbcProperties;
        flywayExtension.placeholderReplacement = placeholderReplacement;
        flywayExtension.placeholderPrefix = placeholderPrefix;
        flywayExtension.placeholderSuffix = placeholderSuffix;
        flywayExtension.placeholderSeparator = placeholderSeparator;
        flywayExtension.scriptPlaceholderPrefix = scriptPlaceholderPrefix;
        flywayExtension.scriptPlaceholderSuffix = scriptPlaceholderSuffix;
        flywayExtension.target = target;
        if (StringUtils.isNotBlank(cherryPick))
            flywayExtension.cherryPick = cherryPick.split(",");
        if (StringUtils.isNotBlank(loggers))
            flywayExtension.loggers = loggers.split(",");
        if (StringUtils.isNotBlank(callbacks))
            flywayExtension.callbacks = callbacks.split(",");
        flywayExtension.skipDefaultCallbacks = skipDefaultCallbacks;
        flywayExtension.outOfOrder = outOfOrder;
        flywayExtension.skipExecutingMigrations = skipExecutingMigrations;
        flywayExtension.outputQueryResults = outputQueryResults;
        flywayExtension.validateOnMigrate = validateOnMigrate;
        flywayExtension.cleanOnValidationError = cleanOnValidationError;
        if (StringUtils.isNotBlank(ignoreMigrationPatterns))
            flywayExtension.ignoreMigrationPatterns = ignoreMigrationPatterns.split(",");
        flywayExtension.validateMigrationNaming = validateMigrationNaming;
        flywayExtension.cleanDisabled = cleanDisabled;
        flywayExtension.baselineOnMigrate = baselineOnMigrate;
        flywayExtension.mixed = mixed;
        flywayExtension.group = group;
        flywayExtension.installedBy = installedBy;
        if (StringUtils.isNotBlank(configurations))
            flywayExtension.configurations = configurations.split(",");
        if (StringUtils.isNotBlank(errorOverrides))
            flywayExtension.errorOverrides = errorOverrides.split(",");
        flywayExtension.dryRunOutput = dryRunOutput;
        flywayExtension.stream = stream;
        flywayExtension.batch = batch;
        flywayExtension.oracleSqlplus = oracleSqlplus;
        flywayExtension.oracleSqlplusWarn = oracleSqlplusWarn;
        flywayExtension.oracleWalletLocation = oracleWalletLocation;
        flywayExtension.kerberosConfigFile = kerberosConfigFile;
        flywayExtension.licenseKey = licenseKey;
        flywayExtension.configFileEncoding = configFileEncoding;
        if (StringUtils.isNotBlank(configFiles))
            flywayExtension.configFiles = configFiles.split(",");
        flywayExtension.workingDirectory = workingDirectory;
        flywayExtension.createSchemas = createSchemas;
        flywayExtension.failOnMissingLocations = failOnMissingLocations;
        return flywayExtension;
    }
}

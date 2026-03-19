package io.github.fengshch.mybatis.config;
import org.apache.commons.lang3.StringUtils;
import org.flywaydb.gradle.FlywayExtension;
import org.gradle.api.Project;

/**
 * Builder class for configuring Flyway database migration settings.
 *
 * This class builds and configures a {@link FlywayExtension} with database connection details,
 * migration paths, naming conventions, and execution parameters for automated database schema
 * versioning and migration management.
 *
 * @see GlobalConfigBuilder
 * @see FlywayExtension
 */
public class FlywayConfigBuilder {
    private final String name;

    /**
     * Constructs a new {@code FlywayConfigBuilder} with the specified configuration name.
     *
     * @param name the name of this Flyway configuration
     */
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

    public String getName() {
        return name;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getConnectRetries() {
        return connectRetries;
    }

    public void setConnectRetries(int connectRetries) {
        this.connectRetries = connectRetries;
    }

    public int getConnectRetriesInterval() {
        return connectRetriesInterval;
    }

    public void setConnectRetriesInterval(int connectRetriesInterval) {
        this.connectRetriesInterval = connectRetriesInterval;
    }

    public String getInitSql() {
        return initSql;
    }

    public void setInitSql(String initSql) {
        this.initSql = initSql;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getTablespace() {
        return tablespace;
    }

    public void setTablespace(String tablespace) {
        this.tablespace = tablespace;
    }

    public String getDefaultSchema() {
        return defaultSchema;
    }

    public void setDefaultSchema(String defaultSchema) {
        this.defaultSchema = defaultSchema;
    }

    public String getSchemas() {
        return schemas;
    }

    public void setSchemas(String schemas) {
        this.schemas = schemas;
    }

    public String getBaselineVersion() {
        return baselineVersion;
    }

    public void setBaselineVersion(String baselineVersion) {
        this.baselineVersion = baselineVersion;
    }

    public String getBaselineDescription() {
        return baselineDescription;
    }

    public void setBaselineDescription(String baselineDescription) {
        this.baselineDescription = baselineDescription;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getResolvers() {
        return resolvers;
    }

    public void setResolvers(String resolvers) {
        this.resolvers = resolvers;
    }

    public Boolean getSkipDefaultResolvers() {
        return skipDefaultResolvers;
    }

    public void setSkipDefaultResolvers(Boolean skipDefaultResolvers) {
        this.skipDefaultResolvers = skipDefaultResolvers;
    }

    public String getSqlMigrationPrefix() {
        return sqlMigrationPrefix;
    }

    public void setSqlMigrationPrefix(String sqlMigrationPrefix) {
        this.sqlMigrationPrefix = sqlMigrationPrefix;
    }

    public String getUndoSqlMigrationPrefix() {
        return undoSqlMigrationPrefix;
    }

    public void setUndoSqlMigrationPrefix(String undoSqlMigrationPrefix) {
        this.undoSqlMigrationPrefix = undoSqlMigrationPrefix;
    }

    public String getRepeatableSqlMigrationPrefix() {
        return repeatableSqlMigrationPrefix;
    }

    public void setRepeatableSqlMigrationPrefix(String repeatableSqlMigrationPrefix) {
        this.repeatableSqlMigrationPrefix = repeatableSqlMigrationPrefix;
    }

    public String getSqlMigrationSeparator() {
        return sqlMigrationSeparator;
    }

    public void setSqlMigrationSeparator(String sqlMigrationSeparator) {
        this.sqlMigrationSeparator = sqlMigrationSeparator;
    }

    public String getSqlMigrationSuffixes() {
        return sqlMigrationSuffixes;
    }

    public void setSqlMigrationSuffixes(String sqlMigrationSuffixes) {
        this.sqlMigrationSuffixes = sqlMigrationSuffixes;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public Boolean getDetectEncoding() {
        return detectEncoding;
    }

    public void setDetectEncoding(Boolean detectEncoding) {
        this.detectEncoding = detectEncoding;
    }

    public Integer getLockRetryCount() {
        return lockRetryCount;
    }

    public void setLockRetryCount(Integer lockRetryCount) {
        this.lockRetryCount = lockRetryCount;
    }

    public Boolean getPlaceholderReplacement() {
        return placeholderReplacement;
    }

    public void setPlaceholderReplacement(Boolean placeholderReplacement) {
        this.placeholderReplacement = placeholderReplacement;
    }

    public String getPlaceholderPrefix() {
        return placeholderPrefix;
    }

    public void setPlaceholderPrefix(String placeholderPrefix) {
        this.placeholderPrefix = placeholderPrefix;
    }

    public String getPlaceholderSuffix() {
        return placeholderSuffix;
    }

    public void setPlaceholderSuffix(String placeholderSuffix) {
        this.placeholderSuffix = placeholderSuffix;
    }

    public String getPlaceholderSeparator() {
        return placeholderSeparator;
    }

    public void setPlaceholderSeparator(String placeholderSeparator) {
        this.placeholderSeparator = placeholderSeparator;
    }

    public String getScriptPlaceholderPrefix() {
        return scriptPlaceholderPrefix;
    }

    public void setScriptPlaceholderPrefix(String scriptPlaceholderPrefix) {
        this.scriptPlaceholderPrefix = scriptPlaceholderPrefix;
    }

    public String getScriptPlaceholderSuffix() {
        return scriptPlaceholderSuffix;
    }

    public void setScriptPlaceholderSuffix(String scriptPlaceholderSuffix) {
        this.scriptPlaceholderSuffix = scriptPlaceholderSuffix;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCherryPick() {
        return cherryPick;
    }

    public void setCherryPick(String cherryPick) {
        this.cherryPick = cherryPick;
    }

    public String getLoggers() {
        return loggers;
    }

    public void setLoggers(String loggers) {
        this.loggers = loggers;
    }

    public String getCallbacks() {
        return callbacks;
    }

    public void setCallbacks(String callbacks) {
        this.callbacks = callbacks;
    }

    public Boolean getSkipDefaultCallbacks() {
        return skipDefaultCallbacks;
    }

    public void setSkipDefaultCallbacks(Boolean skipDefaultCallbacks) {
        this.skipDefaultCallbacks = skipDefaultCallbacks;
    }

    public Boolean getOutOfOrder() {
        return outOfOrder;
    }

    public void setOutOfOrder(Boolean outOfOrder) {
        this.outOfOrder = outOfOrder;
    }

    public Boolean getSkipExecutingMigrations() {
        return skipExecutingMigrations;
    }

    public void setSkipExecutingMigrations(Boolean skipExecutingMigrations) {
        this.skipExecutingMigrations = skipExecutingMigrations;
    }

    public Boolean getOutputQueryResults() {
        return outputQueryResults;
    }

    public void setOutputQueryResults(Boolean outputQueryResults) {
        this.outputQueryResults = outputQueryResults;
    }

    public Boolean getValidateOnMigrate() {
        return validateOnMigrate;
    }

    public void setValidateOnMigrate(Boolean validateOnMigrate) {
        this.validateOnMigrate = validateOnMigrate;
    }

    public Boolean getCleanOnValidationError() {
        return cleanOnValidationError;
    }

    public void setCleanOnValidationError(Boolean cleanOnValidationError) {
        this.cleanOnValidationError = cleanOnValidationError;
    }

    public String getIgnoreMigrationPatterns() {
        return ignoreMigrationPatterns;
    }

    public void setIgnoreMigrationPatterns(String ignoreMigrationPatterns) {
        this.ignoreMigrationPatterns = ignoreMigrationPatterns;
    }

    public Boolean getValidateMigrationNaming() {
        return validateMigrationNaming;
    }

    public void setValidateMigrationNaming(Boolean validateMigrationNaming) {
        this.validateMigrationNaming = validateMigrationNaming;
    }

    public Boolean getCleanDisabled() {
        return cleanDisabled;
    }

    public void setCleanDisabled(Boolean cleanDisabled) {
        this.cleanDisabled = cleanDisabled;
    }

    public Boolean getBaselineOnMigrate() {
        return baselineOnMigrate;
    }

    public void setBaselineOnMigrate(Boolean baselineOnMigrate) {
        this.baselineOnMigrate = baselineOnMigrate;
    }

    public Boolean getMixed() {
        return mixed;
    }

    public void setMixed(Boolean mixed) {
        this.mixed = mixed;
    }

    public Boolean getGroup() {
        return group;
    }

    public void setGroup(Boolean group) {
        this.group = group;
    }

    public String getInstalledBy() {
        return installedBy;
    }

    public void setInstalledBy(String installedBy) {
        this.installedBy = installedBy;
    }

    public String getConfigurations() {
        return configurations;
    }

    public void setConfigurations(String configurations) {
        this.configurations = configurations;
    }

    public String getErrorOverrides() {
        return errorOverrides;
    }

    public void setErrorOverrides(String errorOverrides) {
        this.errorOverrides = errorOverrides;
    }

    public String getDryRunOutput() {
        return dryRunOutput;
    }

    public void setDryRunOutput(String dryRunOutput) {
        this.dryRunOutput = dryRunOutput;
    }

    public Boolean getStream() {
        return stream;
    }

    public void setStream(Boolean stream) {
        this.stream = stream;
    }

    public Boolean getBatch() {
        return batch;
    }

    public void setBatch(Boolean batch) {
        this.batch = batch;
    }

    public Boolean getOracleSqlplus() {
        return oracleSqlplus;
    }

    public void setOracleSqlplus(Boolean oracleSqlplus) {
        this.oracleSqlplus = oracleSqlplus;
    }

    public Boolean getOracleSqlplusWarn() {
        return oracleSqlplusWarn;
    }

    public void setOracleSqlplusWarn(Boolean oracleSqlplusWarn) {
        this.oracleSqlplusWarn = oracleSqlplusWarn;
    }

    public String getOracleWalletLocation() {
        return oracleWalletLocation;
    }

    public void setOracleWalletLocation(String oracleWalletLocation) {
        this.oracleWalletLocation = oracleWalletLocation;
    }

    public String getKerberosConfigFile() {
        return kerberosConfigFile;
    }

    public void setKerberosConfigFile(String kerberosConfigFile) {
        this.kerberosConfigFile = kerberosConfigFile;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public String getConfigFileEncoding() {
        return configFileEncoding;
    }

    public void setConfigFileEncoding(String configFileEncoding) {
        this.configFileEncoding = configFileEncoding;
    }

    public String getConfigFiles() {
        return configFiles;
    }

    public void setConfigFiles(String configFiles) {
        this.configFiles = configFiles;
    }

    public String getWorkingDirectory() {
        return workingDirectory;
    }

    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    public Boolean getCreateSchemas() {
        return createSchemas;
    }

    public void setCreateSchemas(Boolean createSchemas) {
        this.createSchemas = createSchemas;
    }

    public Boolean getFailOnMissingLocations() {
        return failOnMissingLocations;
    }

    public void setFailOnMissingLocations(Boolean failOnMissingLocations) {
        this.failOnMissingLocations = failOnMissingLocations;
    }

    /**
     * Builds a {@link FlywayExtension} from the current configuration and registers it with the project.
     *
     * @param project the Gradle {@link Project} where the extension will be registered
     * @return the configured {@link FlywayExtension}
     */
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
//        flywayExtension.cleanOnValidationError = cleanOnValidationError;
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

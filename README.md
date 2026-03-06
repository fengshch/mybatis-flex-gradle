# MyBatis Flex Gradle Plugin

A Gradle plugin for [MyBatis Flex](https://mybatis-flex.com/) code generation with integrated Flyway database migration support.

[![License](https://img.shields.io/badge/license-Apache%202-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)
[![Gradle Plugin](https://img.shields.io/badge/gradle-plugin-green.svg)](https://plugins.gradle.org/)

## Features

- 🚀 **Automated Code Generation** - Generate Entity, Mapper, Service, ServiceImpl, Controller, and TableDef classes from database schema
- 📝 **YAML Configuration** - Define configurations in `mybatis-flex.yml` for cleaner project structure
- 🔄 **Flyway Integration** - Built-in database migration support with Flyway tasks
- 🧹 **Clean Generation** - Automatically cleans output directory before generation to prevent stale files
- 🎯 **Multiple Configurations** - Support for multiple database configurations in a single project
- 🔌 **Multi-Database Support** - Works with PostgreSQL, MySQL, Oracle, SQLite, and H2
- ⚙️ **Highly Configurable** - Fine-grained control over code generation behavior

## Quick Start

### 1. Add Plugin to Your Project

**Using plugins DSL (Gradle 5.0+):**

```gradle
plugins {
    id 'com.github.fengshch.mybatis-flex-gradle-plugin' version '+'
}
```

**Using legacy plugin application:**

```gradle
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath 'com.github.fengshch:mybatis-flex-gradle-plugin:+'
    }
}

apply plugin: 'com.github.fengshch.mybatis-flex-gradle-plugin'
```

### 2. Configure Database Connection

Create `src/main/resources/application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: password
    driverClassName: com.mysql.cj.jdbc.Driver
```

### 3. Configure Code Generation

Create `src/main/resources/mybatis-flex.yml`:

```yaml
mybatis-flex:
  configurations:
    main:
      packageConfig:
        sourceDir: src/main/java
        basePackage: com.example.mybatis
```

### 4. Generate Code

```bash
gradle mybatisGenerate
```

Generated code will be in `src/main/java/com/example/mybatis/`.

## Configuration

### YAML Configuration (Recommended)

Define all configurations in `src/main/resources/mybatis-flex.yml`:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/mydb
    username: root
    password: password
    driverClassName: com.mysql.cj.jdbc.Driver

mybatis-flex:
  configurations:
    main:
      # Enable/disable code generation for different components
      entityGenerateEnable: true
      mapperGenerateEnable: true
      serviceGenerateEnable: false
      serviceImplGenerateEnable: false
      controllerGenerateEnable: true
      tableDefGenerateEnable: true
      mapperXmlGenerateEnable: false

      # Package configuration
      packageConfig:
        sourceDir: src/main/java
        basePackage: com.example.mybatis
        entityPackage: entity
        mapperPackage: mapper
        servicePackage: service
        serviceImplPackage: service.impl
        controllerPackage: controller
        tableDefPackage: table
        mapperXmlPath: src/main/resources/mapper

      # Strategy configuration
      strategyConfig:
        tablePrefix: tb_
        logicDeleteColumn: deleted
        versionColumn: version
        generateForView: false
        unGenerateTables:
          - flyway_schema_history
          - system_table

      # Flyway configuration
      flyway:
        cleanDisabled: false
        locations:
          - classpath:db/migration
        baselineVersion: "1.0"
        baselineDescription: Initial baseline
```

### Gradle Configuration (Alternative)

You can also configure in `build.gradle`:

```gradle
mybatis {
    configurations {
        main {
            controllerGenerateEnable = true

            packageConfig {
                sourceDir = 'src/main/java'
                basePackage = 'com.example.mybatis'
            }

            strategyConfig {
                unGenerateTables = ['flyway_schema_history']
            }

            flyway {
                cleanDisabled = false
            }
        }
    }
}
```

**Note:** Gradle configurations override YAML configurations.

## Multiple Database Configurations

Support for multiple databases in a single project:

```yaml
spring:
  datasource:
    main:
      url: jdbc:mysql://localhost:3306/db1
      username: root
      password: password
      driverClassName: com.mysql.cj.jdbc.Driver
    secondary:
      url: jdbc:postgresql://localhost:5432/db2
      username: postgres
      password: password
      driverClassName: org.postgresql.Driver

mybatis-flex:
  configurations:
    main:
      packageConfig:
        basePackage: com.example.db1
    secondary:
      packageConfig:
        basePackage: com.example.db2
```

Generate code for specific configuration:

```bash
gradle mybatisMainGenerate      # For main database
gradle mybatisSecondaryGenerate # For secondary database
```

## Available Tasks

### Code Generation Tasks

- `mybatisGenerate` - Generate code for the main configuration
- `mybatis<Name>Generate` - Generate code for named configuration (e.g., `mybatisSecondaryGenerate`)

### Flyway Tasks

- `flywayMigrate` - Migrate database to latest version
- `flywayClean` - Drop all objects in configured schemas
- `flywayInfo` - Print migration status/history
- `flywayValidate` - Validate applied migrations
- `flywayBaseline` - Baseline an existing database
- `flywayRepair` - Repair metadata table
- `flywayUndo` - Undo last migration

For named configurations, tasks are prefixed: `<name>Migrate`, `<name>Clean`, etc.

## Configuration Options

### Generation Enable Flags

| Option | Default | Description |
|--------|---------|-------------|
| `entityGenerateEnable` | `true` | Generate entity classes |
| `mapperGenerateEnable` | `true` | Generate mapper interfaces |
| `serviceGenerateEnable` | `false` | Generate service interfaces |
| `serviceImplGenerateEnable` | `false` | Generate service implementations |
| `controllerGenerateEnable` | `false` | Generate controller classes |
| `tableDefGenerateEnable` | `true` | Generate table definition classes |
| `mapperXmlGenerateEnable` | `false` | Generate mapper XML files |

### Package Configuration

| Option | Default | Description |
|--------|---------|-------------|
| `sourceDir` | `src/batis/java` | Source code output directory |
| `basePackage` | `com.mybatisflex` | Base package name |
| `entityPackage` | `po` | Entity package (relative to base) |
| `mapperPackage` | `mapper` | Mapper package (relative to base) |
| `servicePackage` | `service` | Service package (relative to base) |
| `serviceImplPackage` | `service.impl` | Service impl package (relative to base) |
| `controllerPackage` | `controller` | Controller package (relative to base) |
| `tableDefPackage` | `table` | TableDef package (relative to base) |
| `mapperXmlPath` | Auto-generated | Mapper XML output path |

### Strategy Configuration

| Option | Default | Description |
|--------|---------|-------------|
| `tablePrefix` | - | Table name prefix to remove |
| `logicDeleteColumn` | `deleted` | Logical delete column name |
| `versionColumn` | `version` | Optimistic lock version column |
| `generateForView` | `false` | Generate code for database views |
| `generateSchema` | - | Schema to generate from |
| `generateTables` | - | Whitelist of tables to generate |
| `unGenerateTables` | - | Blacklist of tables to skip |
| `ignoreColumns` | - | Columns to ignore globally |

### Entity Configuration

| Option | Default | Description |
|--------|---------|-------------|
| `classPrefix` | `""` | Entity class name prefix |
| `classSuffix` | `PO` | Entity class name suffix |
| `superClass` | - | Entity base class |
| `withLombok` | `true` | Use Lombok annotations |
| `withSwagger` | `false` | Use Swagger annotations |
| `withActiveRecord` | `false` | Enable Active Record pattern |
| `overwriteEnable` | `true` | Overwrite existing files |

## Supported Databases

- ✅ MySQL / MariaDB
- ✅ PostgreSQL
- ✅ Oracle
- ✅ SQLite
- ✅ H2 (for testing)

## Spring Profiles Support

The plugin supports Spring profiles for different environments:

```bash
# Use dev profile
gradle mybatisGenerate -Pprofile=dev

# Use test profile
gradle mybatisGenerate -Pprofile=test

# Or set environment variable
export PROFILE=dev
gradle mybatisGenerate
```

Configuration files:
- `application.yml` - Default configuration
- `application-dev.yml` - Development configuration
- `application-test.yml` - Test configuration

## Directory Cleaning

The plugin automatically cleans the output directory before generation to ensure no stale files remain:

```
> Task :mybatisGenerate
Cleaning batis directory: /path/to/project/src/batis/java
Batis directory cleaned successfully
Generating code...
```

This behavior ensures:
- No leftover files from previous generations
- Clean state for each generation run
- Prevents conflicts with renamed or deleted tables

## Examples

### Basic Entity Generation

```yaml
mybatis-flex:
  configurations:
    main:
      entityGenerateEnable: true
      mapperGenerateEnable: true
      packageConfig:
        sourceDir: src/main/java
        basePackage: com.example
```

### Full Stack Generation

```yaml
mybatis-flex:
  configurations:
    main:
      entityGenerateEnable: true
      mapperGenerateEnable: true
      serviceGenerateEnable: true
      serviceImplGenerateEnable: true
      controllerGenerateEnable: true

      packageConfig:
        sourceDir: src/main/java
        basePackage: com.example.mybatis
```

### Custom Table Filtering

```yaml
mybatis-flex:
  configurations:
    main:
      strategyConfig:
        generateSchema: PUBLIC
        unGenerateTables:
          - flyway_schema_history
          - system_log
          - temp_table
```

### Lombok and Swagger Integration

```yaml
mybatis-flex:
  configurations:
    main:
      entityConfig:
        withLombok: true
        withSwagger: true
        classSuffix: DTO
```

## Building the Plugin

```bash
# Clean build
gradle clean

# Build plugin
gradle :mybatis-flex-gradle-plugin:build

# Run tests
gradle :mybatis-flex-gradle-plugin:test

# Publish to local Maven repository
gradle :mybatis-flex-gradle-plugin:publishToMavenLocal
```

## Requirements

- Java 25+
- Gradle 8.3+
- MyBatis Flex 1.11.6+

## Dependencies

- MyBatis Flex Codegen: 1.11.6
- Flyway: 12.0.2
- HikariCP: 7.0.2
- SnakeYAML: 2.5
- FreeMarker: 2.3.34

## License

This project is licensed under the Apache License 2.0 - see the LICENSE file for details.

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## Support

- [MyBatis Flex Documentation](https://mybatis-flex.com/)
- [Issue Tracker](https://github.com/fengshch/mybatis-flex-gradle-plugin/issues)

## Changelog

### Latest Version

- ✨ Add support for YAML-based configuration
- ✨ Add automatic directory cleaning before generation
- 🐛 Fix configuration loading issues
- 📝 Improve documentation and examples
- ⚡ Performance improvements

---

Made with ❤️ by the MyBatis Flex community

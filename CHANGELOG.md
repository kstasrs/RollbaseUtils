# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.3-SNAPSHOT] - 2025-11-11

### Added
- GitHub Actions CI/CD pipeline (builds on Java 17 & 21)
- CONTRIBUTING.md with development guidelines and code of conduct
- Comprehensive JavaDoc documentation for core classes
- Logback XML configurations for both modules
- Comprehensive .gitignore for Maven and IDE artifacts
- Maven Assembly plugin for creating distributable JAR
- Serial version UIDs to exception classes

### Changed
- **BREAKING**: Minimum Java version is now 17 (was 1.7)
- **BREAKING**: Migrated from javax.xml.bind to jakarta.xml.bind namespace
- **BREAKING**: Replaced Log4j 1.x with SLF4J + Logback
- **BREAKING**: RedirectAppender now extends Logback's AppenderBase (was Log4j's AppenderSkeleton)
- Updated commons-lang 2.6 → commons-lang3 3.14.0
- Updated commons-io 2.1 → 2.15.1
- Updated commons-codec 1.8 → 1.16.0
- Updated ASM 4.0 → 9.6
- Updated JUnit 4.11 → 5.10.1 (infrastructure ready, tests need migration)
- Updated Maven Compiler Plugin 3.1 → 3.11.0
- Updated Maven Surefire Plugin → 3.2.2
- Updated Maven Assembly Plugin → 3.6.0
- Modernized Java code syntax (var, switch expressions, arrow operators)
- Improved exception messages and error handling
- Enhanced RedirectAppender with better documentation

### Fixed
- JAXB generation errors on Java 9+ (added Jakarta Activation API)
- Missing JAXB runtime dependencies for Java 17
- Compilation errors from javax to jakarta migration
- Logger initialization (changed from Logger.getLogger to LoggerFactory.getLogger)
- Logging method calls (infof/warnf → info/warn with SLF4J placeholders)

### Security
- Verified all dependencies are free from known CVE vulnerabilities
- Removed vulnerable Log4j 1.2.14 (end of life)
- Updated all transitive dependencies to secure versions

### Deprecated
- None

### Removed
- Log4j 1.x dependencies and configuration
- JBoss Logging dependencies
- Old commons-lang 2.x dependency

## [0.2] - 2014-05-14

### Added
- Initial implementation of Rollbase merge functionality
- XSD schema for Rollbase XML exports
- JAXB classes for working with Rollbase XML
- Load and Save commands
- Version control integration support

### Known Issues (Carried Over)
See https://github.com/gmt-europe/RollbaseUtils/issues for original issues:
1. Cleanup during export explosion needs improvement
2. Conflicting ID's solution needs documentation
3. origId's should be removed from exploded XML
4. Direct import/export from Rollbase not yet implemented
5. Sample VCS automation scripts not yet provided
6. dependentDefs property processing has issues
7. Distribution package not yet available (✅ Now available via Maven Assembly)

---

## Migration Guide: v0.2 to v0.3

### Java Version
Upgrade to Java 17 or higher:
```bash
java -version  # Should show 17 or higher
```

### Dependency Updates
If you're using this as a library, update your POM:
```xml
<!-- Old -->
<dependency>
    <groupId>nl.gmt.rollbase</groupId>
    <artifactId>rollbase-shared</artifactId>
    <version>0.2</version>
</dependency>

<!-- New -->
<dependency>
    <groupId>nl.gmt.rollbase</groupId>
    <artifactId>rollbase-shared</artifactId>
    <version>0.3-SNAPSHOT</version>
</dependency>
```

### Code Changes
1. **JAXB Imports**: Update all `javax.xml.bind.*` to `jakarta.xml.bind.*`
2. **Commons Lang**: Update all `org.apache.commons.lang.*` to `org.apache.commons.lang3.*`
3. **Logging**: If you extended RedirectAppender, update to Logback's AppenderBase
4. **Log4j Config**: Replace log4j.properties with logback.xml

### Building
The build process now requires Maven 3.6+ and Java 17+:
```bash
mvn clean install
```

### Running
The distribution JAR now includes all dependencies:
```bash
java -jar rollbase-merge-0.3-SNAPSHOT-jar-with-dependencies.jar load -p project -t output.xml
```

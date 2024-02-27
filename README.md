# Database Change Management 
Database changes happens along with the application code development and it is important part of 
product/project lifecycle. We can either write custom scripts to carry out database changes during
the lifecycle of the product or use ready-made library to do this activity. We can use liquibase or 
Flyway for such change management.
>[Liquibase vs Flyway Comparison](README-LiquibaseVsFlyway.md)
## Liquibase Introduction
Liquibase is an open-source library for managing database schema changes across various environments. 
It allows developers to define database changes in a declarative manner using XML, YAML, JSON, or SQL 
formats, and then applies these changes in a consistent and automated way. To use Liquibase with a 
Spring Boot application for database management and incremental changes, you can follow these steps:
### Project POM or Gradle changes
Add Liquibase dependency to your Spring Boot project. You can include it in your pom.xml if you're using 
Maven or in your build.gradle if you're using Gradle.
Maven:
```
    <dependency>
        <groupId>org.liquibase</groupId>
        <artifactId>liquibase-core</artifactId>
        <version>{latest_version}</version>
    </dependency>
```

Gradle: groovyCopy code
``` 
    implementation 'org.liquibase:liquibase-core:{latest_version}
```
### Configure Liquibase 
Configure Liquibase properties in your application.yml or application.properties file. You'll need to specify 
the changelog file location, database connection details, etc.
Example application.yml configuration:
```
   spring:
     liquibase:
      change-log: classpath:/db/changelog/db.changelog-master.yaml
      url: jdbc:mysql://localhost:3306/mydatabase
      user: username
      password: password
```
### Create Liquibase changelog files
Create Liquibase changelog files in YAML format. These files define the database changes in a human-readable 
manner. You can organize your changes into multiple files if needed.
      
Example Liquibase changelog YAML file (db.changelog-master.yaml): yamlCopy code
```    
    databaseChangeLog:
      - include:
          file: db.changelog-1.0.yaml
      - include:
          file: db.changelog-2.0.yaml
```

### Define your database changes in the changelog files
Define your database changes in the changelog files. Liquibase supports a wide range of change types, 
including creating tables, altering tables, adding columns, etc. Refer to the Liquibase documentation 
for details on the available change types and syntax.
Example Liquibase changelog YAML file (db.changelog-1.0.yaml): yamlCopy code
```
   databaseChangeLog:
    - changeSet:
        id: 1
        author: John Doe
        changes:
          - createTable:
              tableName: my_table
              columns:
                - column:
                    name: id
                    type: int
                    autoIncrement: true
                    constraints:
                    primaryKey: true
                - column:
                    name: name
                    type: varchar(50)
```
### Enable Liquibase in Spring boot application
Annotate your main Spring Boot application class with @EnableLiquibase to enable Liquibase integration.
Example:
```
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import liquibase.integration.spring.SpringLiquibase;

@SpringBootApplication
@EnableLiquibase
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```
## Liquibase Important Documentation URLs
* [Liquibase Best Practices](https://docs.liquibase.com/concepts/bestpractices.html)
* [Design your Liquibase Project](https://docs.liquibase.com/start/design-liquibase-project.html)
* [Liquibase Changeset](https://docs.liquibase.com/concepts/changelogs/changeset.html)
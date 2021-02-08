# Titanfall 2 Ranked

...

## Getting Started

...


### Project installation guide

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

#### Prerequisites

Following programs are needed:
 
 - JDK 1.8
 - Maven 
 - Wildfly 22.0.0.Final
 - Postgres 12.3 

#### Setup Configuration

##### Wildfly

To connect to the postgres database a JDBC driver is need. You can download the Postgres 42.2.18 driver [here](https://jdbc.postgresql.org/download.html).

Place the driver in **WILDFLY_HOME**\modules\org\postgresql\main create folders if necessary.
Afterwards add a **module.xml** with the following content to the same directory:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<module xmlns="urn:jboss:module:1.3" name="org.postgresql">
    <resources>
        <resource-root path="postgresql-42.2.18.jar"/>
        <!-- Make sure this matches the name of the JAR you are installing -->
    </resources>
    <dependencies>
        <module name="javax.api"/>
        <module name="javax.transaction.api"/>
    </dependencies>
</module>
```
 
Add a new driver and datasource to your standalone.xml at **WILDFLY_HOME**\standalone\configuration
```xml
<datasource jndi-name="java:/JPA-TEST" pool-name="JPA-TEST" enabled="true" use-java-context="true">
    <connection-url>jdbc:postgresql://localhost:5432/M152TESTDB</connection-url>
    <driver>postgresql</driver>
    <security>
        <user-name>DBACC</user-name>
        <password>DBACC</password>
    </security>
</datasource>
```
```xml
<driver name="postgresql" module="org.postgresql">
    <driver-class>org.postgresql.Driver</driver-class>
    <xa-datasource-class>org.postgresql.xa.PGXADataSource</xa-datasource-class>
</driver>
```

##### Postgres

Create a new User with **Username:** DBACC and **Password:** DBACC. 

Add a new Database with the name **M152TESTDB**

**Please Note**
Do not use these users in a production system.

#### Installing Sourcecode

...

To build the sources use: 

```
mvn clean install
```
#### Deployment


## Main Authors

...

## License

No licence specified yet.

## Acknowledgments
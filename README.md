#Feature Toggle example using Spring Boot


##Requirements
- Java 8
- Maven

##Running
1. `mvn clean install` will produce a jar file under the target named `feature-toggle-site-1.0.jar`
2. Execute `java -jar target/feature-toggle-site-1.0.jar --spring.config.location=/tmp/feature-configuration.properties` pointing to a .properties file outside of the codebase.
3. Navigate to http://localhost:8080
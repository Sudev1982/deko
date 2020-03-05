# deko
# Deko Coding Assesment

Build using Java/maven.

## Building the application

Use the maven command below to build the application.

```
mvn clean install
```


The application once built will execute all the unit tests and integration test.
Jupiter api and mockito is used for writing tests. The solution implementation
uses strategy design pattern along with the support of factory pattern.

Running the integration test will create the files under the folder named "output".

Decisions
Strategy pattern is chosen for the given problem solution.
Factory pattern support is used in creating instances.
Jackson mappers chosen for deserialization and serialization.
Simple reusable logic for reading and writing the files.
Single model for data mappings driven by annotations.
Jupiter api and mockito used for tests.
Maven chosen for build tool.

Skipped
ISO 8601 date format conversion did't work for the solution chosen
formatting of the file types discarded
csv file column headers did't match with examples



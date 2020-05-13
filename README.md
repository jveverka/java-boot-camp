[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Build Status](https://travis-ci.org/jveverka/java-boot-camp.svg?branch=master)](https://travis-ci.org/jveverka/java-boot-camp)

# Java Boot Camp

![logo](docs/java-bootcamp.png)

### Environment setup
Please make sure you have installed:
* [Open JDK 11.0.5+10](https://adoptopenjdk.net/releases.html?variant=openjdk11&jvmVariant=hotspot) or higher 11.x version.
* [Apache maven 3.6.3](https://maven.apache.org/download.cgi) or higher.
* [git scm](https://git-scm.com/) source code management.
* Install IDE of your choice or use [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).

### Clone and build this project
```
git clone https://github.com/jveverka/java-boot-camp.git
cd java-boot-camp
mvn clean install
```
Open project in [IntelliJ IDEA](docs/ide-instructions.md).

### Examples and Lessons
1. [__java tips__](docs/JAVA-TIPS.md) - documentation project with basic java tips.
2. [__simple-project__](simple-project) - very simple maven java project.
3. [__lambda expressions__](lambdas) - lambda expression examples.
4. [__mt-demo__](mt-demo) - multi-threading demo.
5. [__annotations-demo__](annotations-demo) - annotation demo.
6. [__java-beans-demo__](java-bean-demo) - JSON serialization and deserialization of java beans.
7. [__service-demo__](service-demo) - simple data store service.
8. [__dependency-injection__](dependency-injection) - simple reflection based DI framework.

### Related Topics
* [__Understanding JVM__](https://dzone.com/articles/understanding-jvm-internals) - Java Virtual Machine Internals explained.
* [__http-details__](docs/http-details.md) - family http related protocols (RFCs). 
* [__Spring Initializr__](https://start.spring.io/) - generate your first spring project __now__ !

### How to fix bugs or contribute
Check [this guide](https://github.com/jveverka/do-not-ask-why/blob/master/github/README.md) if you want to contribute.

# Java Beans Demo
A __JavaBean__ is a Java class that should follow the following conventions:
* It should have a no-arg constructor.
* It should be Serializable.
* It should provide methods to set and get the values of the properties, known as getter and setter methods.
* [JavaBeans(TM) Specification 1.01 Final Release](https://download.oracle.com/otndocs/jcp/7224-javabeans-1.01-fr-spec-oth-JSpec/) 

## Usage
__JavaBeans__ are used mainly as DTOs (Data Transfer Objects)

## Pros
* Many java frameworks and libraries rely on proper java beans. (ORM frameworks, JSON frameworks, ...)
* JSON [FasterXml/Jackson](https://github.com/FasterXML/jackson) framework: seamless JSON <-> Java mappings.

## Cons
* Java beans are mutable - not safe for multi-thread applications.

## Exercise
* Check implementations of various DTOs 
* DTO interface ``com.java.bootcamp.projects.javabean.UserDataMutable`` 
* Example of proper __JavaBean__ DTO ``com.java.bootcamp.projects.javabean.UserDataMutable`` 
* Example of immutable DTO which is NOT a __JavaBean__ ``com.java.bootcamp.projects.javabean.UserDataImmutable``
 
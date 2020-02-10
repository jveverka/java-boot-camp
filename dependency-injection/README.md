# Dependency Injection Demo
This is an example of simple DI system based on [Java reflection APIs](http://tutorials.jenkov.com/java-reflection/index.html).
Notable Classes:
* ``com.java.bootcamp.projects.di.DependencyInjector`` - API representing DI engine.
* ``com.java.bootcamp.projects.di.DependencyInjectorImpl`` - actual implementation of DI engine.
* ``com.java.bootcamp.projects.di.annotations.*`` - annotations used by DI engine.

## Implemented features
* given classpath is scanned (not recursively)
* methods annotated by ``@InjectableFactory`` are used to provide instances.
* classes annotated by ``@ManagedService`` are inspected for injection points.
* only constructor injection is supported.
* instances of classes annotated by ``@ManagedService`` are created using constructors with given parameters.
* error cases are not handled properly since this is just a demo.

## Excercise
* Do NOT us this demo as inspiration of your own DI framework. There are plenty of mature frameworks out there.
* Check ``com.java.bootcamp.projects.annotations.test.DITests`` to verify how system works.

# Guide to effective java programming

* [Google's Java coding guidelines](https://google.github.io/styleguide/javaguide.html)
* [Java Clean Code](https://www.baeldung.com/java-clean-code)
* [Java Anti-Patterns](https://javaantipatterns.wordpress.com/)
* [Java Anti-Patterns](http://www.odi.ch/prog/design/newbies.php)

## Use Static Code analyzer 
Many IDEs have possibility ro use static code analysis to prevent bugs.
[Sonar Lint](https://www.sonarlint.org/) recommended. It is available as plugin for Intellij IDEA and Eclipse.

## Always use java packages
Your project should have proper [java package](https://en.wikipedia.org/wiki/Java_package) structure from day 1.
A Java package organizes Java classes into namespaces providing a unique namespace for each type it contains.

## Always use logger
Always use [logger](https://www.vogella.com/tutorials/Logging/article.html). 
Don't use ``System.out.println("my log statement")`` for logging in yor code !

## Create JUnit tests
From day  1, test your code ! Write code to be testable automatically !
Use [JUnit](https://junit.org/junit5/docs/current/user-guide/) to create automated tests.


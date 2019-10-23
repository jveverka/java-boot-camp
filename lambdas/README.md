# Lambda Expressions
* Lambda expressions basically express instances of functional interfaces by implementing the only abstract function.
* Lambda expression is a function that can be created without belonging to any class.
* A lambda expression can be passed around as if it was an object and executed on demand.
* __lambda operator__ -> __body__
  ```
  // Zero parameters
  () -> System.out.println("Zero parameter lambda");
  // One parameter
  (p) -> System.out.println("One parameter: " + p);
  // Multiple parameters
  (p1, p2) -> System.out.println("Multiple parameters: " + p1 + ", " + p2);
  ```

## Functional Interfaces In Java
A functional interface is an interface that contains only one abstract method (single method interface).
Java 8 onwards, lambda expressions can be used to represent the instance of a functional interface.
* Examples: __Runnable, ActionListener, Comparable__
  
## The difference between Lambda Expression and Anonymous class?  
* The key difference between Anonymous class and Lambda expression is the usage of 'this' keyword. In the anonymous classes, ‘this’ keyword resolves to anonymous class itself, whereas for lambda expression ‘this’ keyword resolves to enclosing class where lambda expression is written.
* Another difference between lambda expression and anonymous class is in the way these two are compiled. Java compiler compiles lambda expressions and convert them into private method of the class. It uses invokedynamic instruction that was added in Java 7 to bind this method dynamically.  

## References
* [Java Lambda Expressions](http://tutorials.jenkov.com/java/lambda-expressions.html)
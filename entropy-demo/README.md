# Entropy demo
This simple demo shows how to calculate entropy value for variable data.

```
E = abs( sum( frequency(char(i)) * log2(frequency(char(i)) ) ) )
```
* __E__ - information entropy
* __abs( )__ - absolute value
* __sum( )__ - sum of all values for index __i__
* __frequency(char(i))__ - frequency of character at position __i__
* __log2( )__ - binary logarithm

## References
* [Shannon entropy calculator](https://www.shannonentropy.netmark.pl/)

## Build and test
```
mvn clean install
```
## Mutation testing
```
mvn clean install org.pitest:pitest-maven:mutationCoverage
```
Mutation test report is in ``target/pit-reports`` 

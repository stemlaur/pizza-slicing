# Pizza slicing
Here my take of an *upgraded* version of Google's Practice Problem from Hash Code 2017.
> Here the slices being cut **MUST** cover the entire pizza.

Here a [description of the problem](./doc/DESCRIPTION.md).

## How to build and run
```bash
mvn clean install && \
    java -jar application/target/application-1.0-SNAPSHOT-jar-with-dependencies.jar
```

The program expects to find the input file `./pizza.in` and write a file `./slices.out` 
or output an error when a problem occured.

## The modules
The modules are splitted into two:

 - a module `domain` agnostic of any infrastructure concerns, exposing:
    - the value objects and entities
    - a domain service performing the search
 - a module `application` where are gathered 
    - the entry point Main.java 
    - infrastructure related classes like the Instrumentation implementation, and services to read and write the files

## Best practices
 - I only wrote the application/infrastructure part when I was confident that the domain was satisfying
 - I first wrote the algorithm on a separate project to grasp the complexity and get familiar with the needed concepts
 - After this part I started again from scratch using TDD
 - In the package `com.stemlaur.pizzaslicing.domain.shared.spec` you can find an implementation of Martin Fowler's
 pattern [Specifications](https://www.martinfowler.com/apsupp/spec.pdf)
 - A lot of the objects are Immutable and check there invariants
 - The coverage of the domain module is 100%, though I do not necessarly mean that the tests are correct
 - `com.stemlaur.pizzaslicing.domain.model.Instrumentation` is an example of [domain probe](https://martinfowler.com/articles/domain-oriented-observability.html)
 

# Java Programming Snippets

Collection of Java methods and examples

### Directories
Each section is divided into its own package:
    
    1. arrys
        Java Array methods and useful classes
    2. data
        Data structures such as HashMap and HashSet
    3. designpatterns
        Examples of design patterns in Java
    4. files
        Working with files in Java
    5. multithreading
        Concurrency in Java
    6. RunTime
        Examples of Big-O complexity
    7. sort
        Sorting algorithm examples
    8. tests
        Tests for a few of the examples - explained below

### Tests
A good portion of the classes/methods that perform some type of work, other then just being an example
have test cases.

Tests can be run by calling TestRunner in the main class:

    import tests.TestRunner;
    
    public class JavaReference {
      public static void main(String[] args) {
        TestRunner.RunAll();
      }
    } 
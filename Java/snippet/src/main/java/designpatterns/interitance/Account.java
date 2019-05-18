package designpatterns.interitance;

/*
Inheritance

Some of the following code or definitions is from:
  https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html

 Inheritance is referred to as an is-a-relationship. This is in contrast to composition which
 is referred to as a has-a-relationship. In general, composition is preferred over inheritance.

 Definition: A class that is derived from another class is called a subclass (also a derived class,
             extended class, or child class). The class from which the subclass is derived is called a superclass
            (also a base class or a parent class).

            A subclass inherits all the members (fields, methods, and nested classes) from its superclass.
            Constructors are not members, so they are not inherited by subclasses, but the constructor of the
            superclass can be invoked from the subclass.

 Every class in Java is derived from the base class Object

 Subclass Rules:
    1. The inherited fields can be used directly, just like any other fields.
    2. You can declare a field in the subclass with the same name as the one in the superclass, thus hiding
    it (not recommended).
    3. You can declare new fields in the subclass that are not in the superclass.
    4. The inherited methods can be used directly as they are.
    5. You can write a new instance method in the subclass that has the same signature as the one in the superclass,
    thus overriding it.
    6. You can write a new static method in the subclass that has the same signature as the one in the superclass,
    thus hiding it.
    7. You can declare new methods in the subclass that are not in the superclass.
    8. You can write a subclass constructor that invokes the constructor of the superclass, either implicitly
    or by using the keyword super.
    9. A subclass does not inherit the private members of its parent class. However, if the superclass has public
    or protected methods for accessing its private fields, these can also be used by the subclass.


Using Interfaces vs. Abstract Classes
    Consider using abstract classes if any of these statements apply to your situation:
        You want to share code among several closely related classes.
        You expect that classes that extend your abstract class have many common methods or fields, or require access modifiers other than public (such as protected and private).
        You want to declare non-static or non-final fields. This enables you to define methods that can access and modify the state of the object to which they belong.
    Consider using interfaces if any of these statements apply to your situation:
        You expect that unrelated classes would implement your interface. For example, the interfaces Comparable and Cloneable are implemented by many unrelated classes.
        You want to specify the behavior of a particular data type, but not concerned about who implements its behavior.
        You want to take advantage of multiple inheritance of type.

 */

// The following shows an generic Account class with a basic constructor for the classes
// private properties and getter/setter methods.

// An abstract class is a class that is declared abstract—it may or may not include abstract methods.
// Abstract classes cannot be instantiated, but they can be subclassed.
public abstract class Account {
  private int accountId;
  private String firstName;
  private String lastName;
  private String email;
  private double balance;

  public Account(int accountId, double startingBalance, String firstName, String lastName, String email) {
    this.accountId = accountId;
    // Round to two decimal places.
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public int getAccountId() {
    return accountId;
  }

  public void setAccountId(int accountId) {
    this.accountId = accountId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void deposit(double amount) {
    if (amount <= 0) {
      throw new ArithmeticException("The amount to deposit must be greater then zero.");
    }
    this.balance += amount;
  }

  public double withdraw(double amount) {
    if (amount > this.balance) {
      throw new ArithmeticException("Cannot withdraw more then the account balance.");
    }
    this.balance -= amount;
    return amount;
  }

  public double getBalance() {
    return this.balance;
  }

  @Override
  public String toString() {
    return "Account{" +
          "accountId=" + accountId +
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", email='" + email + '\'' +
          '}';
  }
}

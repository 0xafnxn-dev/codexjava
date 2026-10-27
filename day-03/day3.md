# Day 03 Java Notes

## 1. Class and Real-World Representation

### What is a class?

A class is a blueprint used to define the structure and behaviour of objects in Java.

**Example from the class:** A banking system may have an `AccountInfo` class representing account-related information.

```
public class AccountInfo {
    public static void main(String[] args) {
        System.out.println("Account Type: Current");
        System.out.println("Address: BTM, Bangalore");
        System.out.println("Bank Name: SBI");
    }
}
```

Output:

```
Account Type: Current
Address: BTM, Bangalore
Bank Name: SBI
```

### Important points

- Use the `class` keyword to declare a class.
- Give the class a meaningful name.
- The class body is enclosed in `{ }`.
- Methods and other class members are declared inside the class.
- A class can contain multiple methods.
- A `.java` file can contain multiple top-level classes, subject to Java's public-class and filename rules.

## 2. Java Naming Conventions

Naming conventions make code easier for developers to read, understand, and maintain.

### A. Class names — PascalCase

Start each word with a capital letter.

Examples:

```
AccountInfo
PaymentDetails
StudentDetails
DeliveryAccount
```

### B. Method names — lower camelCase

Start with a lowercase letter. Capitalize the first letter of each subsequent word.

Examples:

```
main()
createAccount()
displayAccountInfo()
calculateTotal()
```

### C. Variable names — lower camelCase

Examples:

```
int amount;
int maxNumber;
String accountName;
```

### Important distinction

Java's compiler generally does not enforce naming conventions such as PascalCase or camelCase. It checks syntax and language rules.

However, the standard launcher expects a recognized entry-point method. For example, writing `Main()` instead of `main()` does not satisfy the conventional `main` entry point.

**Industry lesson:** Code that compiles is not necessarily code that follows good professional conventions.

## 3. The `main()` Method

The conventional Java entry point is:

```
public static void main(String[] args) {
    System.out.println("Hello Java");
}
```

### Understanding each part

| Part            | Meaning                                                                          |
| --------------- | -------------------------------------------------------------------------------- |
| `public`        | Allows the launcher to access the method.                                        |
| `static`        | Allows the method to be invoked without first creating an instance of the class. |
| `void`          | The method does not return a value.                                              |
| `main`          | The conventional entry-point method name.                                        |
| `String[] args` | An array that receives command-line arguments.                                   |

### Why is `main()` important?

When launching a conventional Java application, the Java launcher locates an appropriate entry point and begins execution there.

Not every class needs a `main()` method. Other classes can provide methods that are called from the application's entry point.

### Why is `main()` static?

A static method belongs to the class rather than to an individual object. This lets the launcher invoke the conventional entry point without requiring an instance of that class first.

### Why is its return type `void`?

The conventional `main()` method does not return a result to its caller.

```
public static void main(String[] args) {
    System.out.println("Execution started");
}
```

### Why is `String[] args` used?

It receives command-line arguments as strings.

For example:

```
public class Greeting {
    public static void main(String[] args) {
        System.out.println(args[0]);
    }
}
```

If launched with the argument `Afnan`, the program prints:

```
Afnan
```

The program must be supplied with at least one argument for this example to work safely.

The variable name `args` is not compulsory. You can use another valid name, such as `input`.

## 4. Can a Class Have Two `main()` Methods?

Java allows method overloading, but it does not allow two methods with exactly the same signature in the same class.

### Invalid example

```
public static void main(String[] args) {
}

public static void main(String[] values) {
}
```

This is invalid because both declarations have the same parameter type: `String[]`. Changing the parameter variable name does not create a different signature.

### Valid example

```
public class MainExample {
    public static void main(String[] args) {
        System.out.println("Standard main");
    }

    public static void main(int number) {
        System.out.println(number);
    }
}
```

These methods have different parameter types, so they can coexist.

The Java launcher uses the recognized entry point; it does not automatically choose the overloaded `main(int)` method.

## 5. Compilation and Execution

The Java development process demonstrated in class follows this sequence:

**Understand the requirement → Develop → Compile → Execute and test → Deliver**

If testing reveals a problem, return to development, correct the code, and test again.

### Step 1: Write source code

Save the program in `AccountInfo.java`.

### Step 2: Compile

```
javac AccountInfo.java
```

The Java compiler translates the source code into JVM bytecode and normally generates `AccountInfo.class`.

### Step 3: Execute

```
java AccountInfo
```

Use the class name without `.java` or `.class` for this conventional launch command.

### What happens internally?

1. `javac` compiles the source code.
2. The compiler generates bytecode in `.class` files.
3. The Java launcher starts the JVM.
4. The JVM loads and executes the program.
5. The program produces output.

The JVM can interpret bytecode and use its Just-In-Time (JIT) compiler to compile frequently executed code into native machine code.

## 6. One Java File Can Produce Multiple Class Files

A source file can contain multiple top-level classes, provided the Java declaration and filename rules are followed.

For example:

```
public class Student {
    public static void main(String[] args) {
        System.out.println("Student");
    }
}

class Address {
}

class Marks {
}
```

Compile it:

```
javac Student.java
```

The compiler normally generates:

```
Student.class
Address.class
Marks.class
```

Each class gets its own class file. Nested classes generate their own class files as well, with names such as `Student$Details.class`.

## 7. JVM, Interpreter and JIT

### JVM — Java Virtual Machine

The JVM loads and executes Java bytecode. It also manages runtime services, including memory management.

### Interpreter

The interpreter executes bytecode instructions.

### JIT — Just-In-Time compiler

The JIT compiler can compile frequently executed code into native machine code to improve performance.

### Remember this distinction

| Component    | Main responsibility                                        |
| ------------ | ---------------------------------------------------------- |
| `javac`      | Java source code → bytecode                                |
| JVM          | Loads and executes bytecode                                |
| Interpreter  | Interprets bytecode instructions                           |
| JIT compiler | Compiles frequently executed code into native machine code |

The JIT does not simply compile every loop exactly once. Its optimizations depend on runtime profiling and other factors.

## 8. Access Modifiers and `public`

Java has four access levels commonly taught as:

- `public`
- `protected`
- package-private (no modifier)
- `private`

Access modifiers control where classes, methods, and fields can be accessed.

For the conventional entry point, `public` allows the launcher to access the method.

A method's access level may affect whether it is usable from another class. Removing `public` from the conventional `main()` declaration can prevent the standard launcher from recognizing it as a valid entry point.

## 9. Static vs. Non-Static

### Static

Static members belong to the class.

```
class Calculator {
    static int add(int a, int b) {
        return a + b;
    }
}
```

Call it using the class name:

```
int result = Calculator.add(10, 20);
```

### Non-static

An instance method is associated with an object.

```
class Calculator {
    int multiply(int a, int b) {
        return a * b;
    }
}
```

Call it through an instance:

```
Calculator calculator = new Calculator();
int result = calculator.multiply(10, 20);
```

The conventional `main()` method is static so it can be invoked without creating an instance first.

## 10. Return Types and `void`

A method's return type specifies the type of value it returns to its caller.

### Method that returns an integer

```
public static int add(int a, int b) {
    return a + b;
}
```

Usage:

```
int result = add(10, 20);
System.out.println(result);
```

Output:

```
30
```

### Method that returns nothing

```
public static void displayMessage() {
    System.out.println("Welcome to Java");
}
```

A `void` method does not return a value, although it can perform actions such as printing output.

## 11. Runtime Errors

A program can compile successfully and still fail during execution.

For example:

```
public class DivisionExample {
    public static void main(String[] args) {
        int result = 10 / 0;
        System.out.println(result);
    }
}
```

This compiles, but executing it throws an `ArithmeticException`. The second statement is not executed during that run because the exception is not handled.

**Lesson:** Successful compilation does not guarantee successful execution.

## 12. Day 03 Quick Revision

- A class defines structure and behaviour.
- Class names conventionally use PascalCase.
- Method and variable names conventionally use lower camelCase.
- `main()` is the conventional entry point for a standard Java application.
- Method overloading permits different parameter lists.
- `javac` compiles Java source code into bytecode.
- `java` launches the JVM to execute a class.
- A source file can produce multiple `.class` files.
- The JVM uses interpretation and may use JIT compilation.
- `static` allows a member to be accessed through the class without an instance.
- `void` means a method does not return a value.
- Runtime failures can occur even after successful compilation.
- Professional code should follow consistent naming conventions and be tested.

## 13. Practice Exercises

1. Create an `AccountInfo` class that prints account type, bank name, and branch.
2. Create a `PaymentDetails` class with a method named `displayPaymentDetails()`.
3. Write a program with two overloaded `main()` methods and identify which one the launcher uses.
4. Create one Java file containing one public class and two package-private classes. Compile it and inspect the generated `.class` files.
5. Write an `add()` method that returns the sum of two integers.
6. Write a `displayMessage()` method that returns nothing.
7. Run a program that compiles successfully but throws a runtime exception.
8. Pass your name through the command line and print it using `args`.
9. Rename `main()` to `Main()` and investigate the launch error.
10. Explain the difference between source code, bytecode, and native machine code.

## 14. Interview Questions

### Beginner level

1. What is a class in Java?
2. What is the purpose of the `main()` method?
3. Explain `public static void main(String[] args)`.
4. What is the difference between `javac` and `java`?
5. What is a `.class` file?
6. Can a Java source file contain multiple classes?
7. Can a class have overloaded `main()` methods?
8. What is the difference between `void` and `int` as return types?
9. What is the difference between static and non-static methods?
10. What is the difference between a compile-time error and a runtime exception?

### Experienced-candidate level

1. Explain how Java source code is compiled and executed.
2. How does the JVM use interpretation and JIT compilation?
3. Why does the standard Java launcher expect a recognized entry point?
4. Why does changing `args` to `input` not change the method signature?
5. How are multiple top-level classes compiled from one source file?
6. Why are naming conventions important when the compiler does not enforce them?
7. How can a program compile successfully but fail at runtime?
8. What happens when an exception is thrown and not handled?
9. How would you explain static method invocation without object creation?
10. How would you troubleshoot a `Main method not found` error?

---

**Day 03 learning goal:** Become comfortable writing classes and methods, following naming conventions, and explaining how Java source code becomes executable output.

write Java classes regularly yourself, rather than relying entirely on IDE-generated code. Try implementing the examples in a plain editor first, then use Eclipse to compile, run, and debug them.
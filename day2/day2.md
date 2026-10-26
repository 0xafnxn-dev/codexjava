# KodeWala Java — Day 02 Notes

Topics: Source code, compiler, bytecode, JVM, Java classes, main method, compilation, execution, errors and multiple classes.

These notes are based on your Day 02 class transcript and cross-referenced with your official KodeWala notes. I’ve also added extra examples and interview explanations, clearly marked where useful.

## 1. The complete Java program execution flow

This is the main concept of today's class. Understand it properly because you'll use it throughout Java development.

Developer

Writes Java source code

HelloWorld.java

Compiler — `javac`

Checks the code and reports compilation errors

Bytecode — `HelloWorld.class`

Generated if compilation succeeds

JVM — Java Virtual Machine

Loads and executes the bytecode

Program output

The result appears in the terminal

### Understand the two main stages

Stage 1: Compilation

- You write code in a `.java` source file.
- The Java compiler checks whether the code follows Java's language rules.
- If compilation succeeds, it generates `.class` bytecode files.
- If a compilation error exists, the compiler reports it.

Stage 2: Execution

- You use the `java` command to launch the Java runtime.
- The JVM loads the requested class and looks for a valid `main` method when launching a traditional Java application.
- The JVM executes the bytecode, using interpretation and/or JIT compilation to run instructions on the computer.

Remember: `javac` compiles; `java` launches the program.

## 2. Source code, compiler and bytecode

### Source code

Source code is the human-readable code written by a developer.

Example:

```
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello!");
    }
}
```

The file is saved as `HelloWorld.java`.

### Compiler

The compiler translates Java source code into bytecode after checking the code's validity.

Command:

```
javac HelloWorld.java
```

If successful, this creates:

```
HelloWorld.class
```

### Bytecode

Bytecode is the intermediate instruction format produced by the Java compiler. It is designed to run on a compatible JVM, which helps Java applications work across different operating systems.

Bytecode is not the same as native machine code.

### JVM

JVM stands for Java Virtual Machine. It loads and executes Java bytecode.

Command:

```
java HelloWorld
```

Expected output:

```
Hello!
```

Notice that you use the source filename with `.java` when compiling, but the class name without `.class` when launching.

## 3. Java class and naming rules

A class is a named structure that contains code such as methods, fields and constructors. In today's lesson, the class is the container for our program.

Basic structure:

```
public class Greeting {
    // Class body
}
```

- `public` — an access modifier that makes the class accessible wherever Java's access rules permit.
- `class` — the keyword used to declare a class.
- `Greeting` — the class name.
- `{ }` — define the beginning and end of the class body.

### Java is case-sensitive

These names are different:

```
Greeting
greeting
GREETING
```

Likewise, `class` is a Java keyword and must be written in lowercase. `Class` is not the same keyword.

### Class naming convention

Use PascalCase for class names: start each word with a capital letter.

Examples:

| Good class names | Avoid                            |
| ---------------- | -------------------------------- |
| `Greeting`       | `greeting` as a class convention |
| `StudentDetails` | `studentdetails`                 |
| `PaymentService` | `payment_service`                |

These are conventions, not all compiler-enforced restrictions. A lowercase class name can compile, but following conventions makes code easier to read.

### The important filename rule

The instructor demonstrated a class named `Greeting` inside a file named `welcome.java`.

There is an important distinction:

- If the source file contains a public top-level class, the filename must match that class name, including capitalization.
- A source file can contain multiple top-level classes, but at most one can be `public` in the usual file-based Java compilation model.
- If a top-level class is not `public`, its name does not have to match the filename.

For example, this is valid in `welcome.java`:

```
class Greeting {
    public static void main(String[] args) {
        System.out.println("Welcome!");
    }
}
```

Compile and run:

```
javac welcome.java
java Greeting
```

Output:

```
Welcome!
```

The compiler generates `Greeting.class`, not `welcome.class`, because the generated class file is named after the class. This matches the example demonstrated in your lesson.

## 4. The `main()` method — the entry point

The instructor explained that the JVM needs a starting point for a traditional Java application.

```
public static void main(String[] args) {
    System.out.println("Welcome to KodeWala!");
}
```

Think of `main()` as the main gate of a house. The JVM starts the application there, and the statements inside it execute in order.

| Part            | Meaning                                                            |
| --------------- | ------------------------------------------------------------------ |
| `public`        | Allows the JVM to access the method                                |
| `static`        | Lets the JVM call it without first creating an object of the class |
| `void`          | The method does not return a value                                 |
| `main`          | The conventional entry-point method name                           |
| `String[] args` | An array that receives command-line arguments                      |
| `{ }`           | Enclose the method body                                            |

You do not need to memorize every detail today. Understand the purpose of the method first; the modifiers and arguments can be studied more deeply later.

### Is `main()` compulsory?

This is an important distinction from the class discussion:

- Compilation: A class can compile successfully without a `main()` method.
- Launching a traditional Java application: The selected class normally needs a valid `main()` entry point.

For example:

```
class Payment {
    // No main method
}
```

This can compile successfully:

```
javac Payment.java
```

But attempting to launch it as a traditional application:

```
java Payment
```

will fail because there is no valid `main()` method to start from.

Not every class needs its own `main()` method. A normal application can have many classes and use one designated entry point.

## 5. Java statements and the semicolon

A Java statement is an instruction in your program. Most ordinary Java statements end with a semicolon (`;`).

Correct:

```
System.out.println("Hello");
System.out.println("Welcome");
```

Incorrect:

```
System.out.println("Hello")
System.out.println("Welcome");
```

The first statement is missing its semicolon, so compilation fails.

Practical lesson: If you change your source code, save it and recompile it before running the updated version.

## 6. `print()` vs `println()`

The instructor answered this question during class.

`print()` — stays on the same line

```
System.out.print("Hello");
System.out.print(" Java");
```

Output:

```
Hello Java
```

`println()` — moves to a new line after printing

```
System.out.println("Hello");
System.out.println("Java");
```

Output:

```
Hello
Java
```

`ln` stands for line. `println()` adds a line break after the output; `print()` does not.

### What does `System.out.println()` mean?

- `System` — a predefined Java class.
- `out` — the standard output stream.
- `println()` — a method that prints the supplied value and then adds a line break.

This breakdown is also covered in your official KodeWala notes.&#x20;

All Notes - Kodewala(Core & Advance).pdf



## 7. Multiple classes in one Java file

Your instructor demonstrated that a source file can contain more than one top-level class.

Example — save as `welcome.java`:

```
class Greeting {
    public static void main(String[] args) {
        System.out.println("Greeting started");
    }
}

class Session {
    public static void main(String[] args) {
        System.out.println("Session started");
    }
}
```

Compile:

```
javac welcome.java
```

Generated class files:

```
Greeting.class
Session.class
```

Each top-level class gets its own `.class` file.

Run the first class:

```
java Greeting
```

Output:

```
Greeting started
```

Run the second class:

```
java Session
```

Output:

```
Session started
```

Key point: The class name supplied to the `java` command determines which class the JVM launches. If both classes have a valid `main()` method, either can be launched separately.

You cannot declare both top-level classes as `public` in the same ordinary source file.

## 8. Why must you recompile after changing code?

Suppose your source file originally contains:

```
class Greeting {
    public static void main(String[] args) {
        System.out.println("Old message");
    }
}
```

You compile it:

```
javac Greeting.java
```

Now you change the message in the source file:

```
System.out.println("New message");
```

If you run the program without recompiling, the `.class` file can still contain the old version of the code.

Correct workflow:

1. Edit the `.java` file.
2. Save the file.
3. Compile it again with `javac`.
4. Run it with `java`.

```
javac Greeting.java
java Greeting
```

Output:

```
New message
```

### Build and compilation

Your instructor mentioned that developers often use the word build in industry. A build commonly includes compilation and may also include other steps such as testing, resource processing and packaging.

For a tiny program, compilation may take almost no time. In a large project, builds can take considerably longer.

The instructor also showed checking the modification timestamp of generated `.class` files to confirm whether compilation had happened recently. This can be a useful debugging clue, but timestamps alone do not guarantee that the correct code was built.

## 9. How to read Java compiler errors

One of the most valuable lessons from Day 02 was: read the error message carefully instead of panicking.

Example:

```
class Greeting {
    public static void main(String[] args) {
        System.out.println("Hello")
    }
}
```

The `println` statement is missing `;`.

Compile:

```
javac Greeting.java
```

The compiler reports an error and usually points to the relevant file and line.

When you get an error:

1. Read the complete error message.
2. Identify the filename and line number, if provided.
3. Inspect that line and the nearby code.
4. Correct the issue.
5. Save and recompile.

Common beginner errors:

| Error                                                         | What to check                                          |
| ------------------------------------------------------------- | ------------------------------------------------------ |
| `';' expected`                                                | Missing semicolon or another syntax issue              |
| `';' expected` or related syntax errors near a brace          | Check braces and the preceding statement               |
| `class ... is public, should be declared in a file named ...` | Public class name and filename do not match            |
| `Main method not found`                                       | The selected class lacks a valid entry point           |
| `cannot find symbol`                                          | Check spelling, capitalization, declarations and scope |

The compiler can detect many syntax and type-related errors; it cannot guarantee that your program's logic is correct.

## 10. Full practice program for Day 02

Save this file as `Day02Practice.java`.

```
public class Day02Practice {

    public static void main(String[] args) {

        System.out.println("Welcome to KodeWala!");
        System.out.print("I am learning ");
        System.out.print("Java.");
        System.out.println();

        System.out.println("Day 02 completed.");
    }
}
```

Compile and run:

```
javac Day02Practice.java
java Day02Practice
```

Expected output:

```
Welcome to KodeWala!
I am learning Java.
Day 02 completed.
```

Try changing the messages, deliberately removing a semicolon, and compiling again. Observe the error and then fix it.

# Interview Q&A — Beginner / Fresher

These questions are based on the topics covered in today's class.

Q1. What is source code?

Answer: Source code is the human-readable program written by a developer in a programming language. In Java, it is commonly stored in a `.java` file.

Q2. What is a compiler?

Answer: A compiler checks Java source code and translates it into bytecode when compilation succeeds. The Java compiler is invoked using `javac`.

Q3. What is bytecode?

Answer: Bytecode is the intermediate instruction format generated by the Java compiler. It is stored in `.class` files and executed by a compatible JVM.

Q4. What is the JVM?

Answer: JVM stands for Java Virtual Machine. It loads and executes Java bytecode using interpretation and/or JIT compilation.

Q5. What is the difference between `javac` and `java`?

Answer: `javac` compiles a source file; `java` launches a class. For example, `javac Greeting.java` followed by `java Greeting`.

Q6. Why is the `main()` method important?

Answer: It is the conventional entry point for launching a traditional Java application. Execution begins there, then follows the program's instructions.

Q7. Can a Java class compile without a `main()` method?

Answer: Yes. A class can compile without `main()`. However, it cannot be launched as a traditional standalone Java application unless the selected class has a valid entry point.

Q8. What is the difference between `print()` and `println()`?

Answer: `print()` writes output without adding a line break; `println()` writes output and then adds a line break.

Q9. Can one Java file contain multiple classes?

Answer: Yes. A source file can contain multiple top-level classes. In the usual file-based model, at most one top-level class can be public, and its name must match the filename.

Q10. Why do we recompile after changing Java code?

Answer: Because the `.class` file contains the previously compiled version until it is regenerated. Recompilation ensures the changes are included in the bytecode.

# Interview Q&A — 3-year experienced Java developer

For this level, interviewers often expect you to explain the reasoning behind the behavior and how you would investigate it in practice.

Q1. What happens internally when you run `java Greeting`?

Answer: The Java launcher starts the runtime, loads the requested class, and looks for an appropriate `main()` method. The JVM executes the bytecode, using interpretation and potentially JIT compilation. If the entry point is missing or invalid, launching the class fails.

Q2. A Java source file compiles successfully, but running the class fails. Why?

Answer: Compilation and execution check different things. The source can be syntactically and semantically valid without having a launchable entry point. Runtime failures can also arise from missing dependencies, configuration issues or exceptions during execution.

Q3. Can two classes in the same source file each have a `main()` method?

Answer: Yes. Each class can declare its own valid `main()` method. We choose which class to launch with the `java` command. Launching one class does not automatically launch the other.

Q4. Why can a class compile without a `main()` method?

Answer: The compiler validates the source code; it does not require every class to be a standalone application. Many classes are reusable components that are called by other code. A launchable application needs an appropriate entry point.

Q5. A developer changed the source code, but the old output still appears. How would you investigate?

Answer: I would confirm the correct source file was saved, compile it again, check the compiler's exit status and error messages, verify the generated class file's location and timestamp, and confirm that the command launches the intended class from the intended classpath. I would also check whether another copy of the class is being loaded.

Q6. Why does Java generate separate `.class` files for multiple top-level classes?

Answer: Each top-level class is compiled into its own class representation, normally a separate `.class` file. The JVM loads classes as required, so the source file's name and each generated class name serve different purposes.

Q7. What is the difference between a compilation error and a runtime exception?

Answer: A compilation error prevents the affected source from compiling successfully. A runtime exception occurs while the program is executing. For example, a missing semicolon is a compilation problem, while dividing an integer by zero can cause an `ArithmeticException` during execution.

Q8. What does a successful compilation prove?

Answer: It proves that the compiler accepted the source under the checks it performs. It does not prove that the business logic is correct, that all execution paths work, or that the application will run successfully in its target environment.

Q9. Why should developers read compiler errors instead of immediately searching for a fix?

Answer: Error messages often identify the source file, line and nature of the problem. Reading them helps isolate the root cause, reduces trial-and-error debugging and builds independent troubleshooting skills.

Q10. What is a build in a real Java project?

Answer: A build is the broader process of turning source code and project resources into a deliverable. It may include compilation, dependency resolution, tests, resource processing and packaging. Compilation is one part of a build.

## 11. Practice questions and assignments

Day 02 checklist

0 of 7

Write and compile a class that prints three separate lines.

Use print() twice and println() once. Predict the output before running it.

Create one source file containing two non-public classes, each with a main() method. Compile and run each class separately.

Remove a semicolon intentionally. Read the compiler error and correct it.

Compile a class without a main() method. Then try to launch it and explain the difference.

Change a message in the source file. Recompile and verify the updated output.

Explain the complete flow from .java source code to the program output without looking at the notes.

## 12. Quick revision

- `.java` = source code.
- `javac` = compiler command.
- `.class` = compiled bytecode.
- `java ClassName` = launch a class.
- `main()` = conventional entry point.
- `;` = terminates most ordinary Java statements.
- `print()` = no automatic line break; `println()` = line break after printing.
- Recompile after source changes.
- One `.class` file is normally generated for each top-level class.
- Read compiler errors carefully.
- Successful compilation does not guarantee correct program behavior.

My recommendation: Practise the compile-and-run workflow yourself several times in your Java 21 setup. Don't just memorize the commands—understand what each command does and which file it uses.

Your next class can build on these foundations.
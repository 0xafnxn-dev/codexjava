

## 1. How many `public` classes can a Java file have?

**For a normal `.java` source file, you can have at most ONE `public` top-level class.** You can also have multiple non-public top-level classes in the same file.

Let's see every common possibility.

## 2. All possibilities

### Case 1: One public class — ✅ Valid

File: `Student.java`

```java
public class Student {
}

class Teacher {
}

class Employee {
}
```

- Public classes: 1
- Non-public classes: 2
- Result: Compiles successfully.

The filename must match the public class name.

### Case 2: No public classes — ✅ Valid

File: `Student.java`

```java
class Student {
}

class Teacher {
}

class Employee {
}
```

- Public classes: 0
- Non-public classes: 3
- Result: Compiles successfully.

The filename does not have to match any of these class names.

### Case 3: Two public classes — ❌ Invalid in one source file

File: `Student.java`

```java
public class Student {
}

public class Teacher {
}
```

**Why does it fail?**

The file is named `Student.java`, but `Teacher` is also a public top-level class. In the standard file-based Java compilation model, each public top-level class needs its matching filename.

**Fix:** Separate them into two files.

`Student.java`

```java
public class Student {
}
```

`Teacher.java`

```java
public class Teacher {
}
```

Now both files can compile successfully.

### Case 4: Public class name does not match filename — ❌ Invalid

File: `Student.java`

```java
public class Teacher {
}
```

The filename is `Student.java`, but the public class is `Teacher`.

**Fix:** Rename the file to `Teacher.java`, or change the class name to `Student`.

### Case 5: Non-public class name does not match filename — ✅ Valid

File: `Student.java`

```java
class Teacher {
}
```

This is valid because `Teacher` is not public.

After compiling:

```bash
javac Student.java
```

The compiler generates `Teacher.class`.

### Case 6: One public class with a `main()` method and other classes — ✅ Valid

File: `Student.java`

```java
public class Student {

    public static void main(String[] args) {
        System.out.println("Student");
    }
}

class Teacher {

    public static void main(String[] args) {
        System.out.println("Teacher");
    }
}
```

Compile:

```bash
javac Student.java
```

Run either class:

```bash
java Student
java Teacher
```

Both classes have a `main()` method, so either can be launched separately.

## 3. Quick revision table

| Situation | Valid? |
|---|---|
| Zero public top-level classes | ✅ Yes |
| One public top-level class | ✅ Yes |
| Two public top-level classes in one ordinary source file | ❌ No |
| Public class name matches filename | ✅ Yes |
| Public class name differs from filename | ❌ No |
| Non-public class name differs from filename | ✅ Yes |
| Multiple non-public top-level classes | ✅ Yes |

## 4. Remember this trick, bhai

**Public class → filename must match.**

**No public class → filename can be different.**

**Multiple classes → allowed.**

**Multiple public top-level classes in one ordinary `.java` file → not allowed.**

One extra detail: these rules refer to **top-level classes**. Nested classes inside another class have different rules.

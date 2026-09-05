# Java `Optional`

## 📌 What is `Optional` in Java?

`Optional<T>` is a class introduced in **Java 8** that is used to represent a value that **may or may not be present**.

It helps reduce the chances of getting:

```text
NullPointerException
```

Instead of directly returning `null`, a method can return an `Optional` that clearly indicates whether a value exists.

### Example

Without `Optional`:

```java
String name = null;

System.out.println(name.toUpperCase());
// NullPointerException
```

With `Optional`:

```java
Optional<String> name = Optional.ofNullable(null);

System.out.println(name);
// Optional.empty
```

---

# 📦 Importing Optional

```java
import java.util.Optional;
```

---

# 🏗️ Creating an Optional

There are three commonly used methods for creating an `Optional`.

## 1. `Optional.of()`

Used when you are **sure that the value is not null**.

```java
Optional<String> name = Optional.of("Krishna");

System.out.println(name);
```

Output:

```text
Optional[Krishna]
```
<img width="1467" height="309" alt="image" src="https://github.com/user-attachments/assets/817a5900-a0d7-45d2-91db-a68c0dbd3503" />


⚠️ If the value is `null`, `Optional.of()` throws `NullPointerException`.

```java
String name = null;

Optional<String> result = Optional.of(name);
```

This causes:

```text
NullPointerException
```

---

## 2. `Optional.ofNullable()`

Used when the value **may be null**.

```java
String name = null;

Optional<String> result = Optional.ofNullable(name);

System.out.println(result);
```

Output:

```text
Optional.empty
```

If the value is present:

```java
String name = "Krishna";

Optional<String> result = Optional.ofNullable(name);

System.out.println(result);
```

Output:

```text
Optional[Krishna]
```

### ⭐ Important

In most practical situations, `ofNullable()` is safer than `of()` when the value can potentially be `null`.

---

## 3. `Optional.empty()`

Creates an empty `Optional`.

```java
Optional<String> result = Optional.empty();

System.out.println(result);
```

Output:

```text
Optional.empty
```

---

# 🔍 Important Optional Methods

| Method                  | Purpose                                   |
| ----------------------- | ----------------------------------------- |
| `of()`                  | Creates Optional with non-null value      |
| `ofNullable()`          | Creates Optional that may contain null    |
| `empty()`               | Creates empty Optional                    |
| `isPresent()`           | Checks whether value exists               |
| `isEmpty()`             | Checks whether value doesn't exist        |
| `get()`                 | Gets the value                            |
| `orElse()`              | Returns default value if empty            |
| `orElseGet()`           | Generates default value if empty          |
| `orElseThrow()`         | Throws exception if empty                 |
| `orElseThrow(Supplier)` | Throws custom exception                   |
| `ifPresent()`           | Executes code if value exists             |
| `ifPresentOrElse()`     | Executes different code based on presence |
| `map()`                 | Transforms the value                      |
| `flatMap()`             | Transforms into another Optional          |
| `filter()`              | Keeps value if condition is true          |
| `or()`                  | Returns another Optional if empty         |
| `stream()`              | Converts Optional into Stream             |

---

# 1️⃣ `isPresent()`

Checks whether a value is present.

```java
Optional<String> name = Optional.of("Krishna");

System.out.println(name.isPresent());
```

Output:

```text
true
```

Example with empty Optional:

```java
Optional<String> name = Optional.empty();

System.out.println(name.isPresent());
```

Output:

```text
false
```

---

# 2️⃣ `isEmpty()`

Checks whether the Optional contains no value.

Available since **Java 11**.

```java
Optional<String> name = Optional.empty();

System.out.println(name.isEmpty());
```

Output:

```text
true
```

Comparison:

```java
name.isPresent(); // false
name.isEmpty();   // true
```

---

# 3️⃣ `get()`

Returns the value inside the Optional.

```java
Optional<String> name = Optional.of("Krishna");

System.out.println(name.get());
```

Output:

```text
Krishna
```

⚠️ If the Optional is empty:

```java
Optional<String> name = Optional.empty();

System.out.println(name.get());
```

It throws:

```text
NoSuchElementException
```

### ⭐ Recommendation

Avoid using `get()` without checking whether a value exists.

Instead of:

```java
optional.get();
```

Prefer:

```java
optional.orElse("Default");
```

or:

```java
optional.ifPresent(System.out::println);
```

---

# 4️⃣ `orElse()`

Returns the value if present.

Otherwise, returns a default value.

```java
Optional<String> name = Optional.empty();

String result = name.orElse("Unknown");

System.out.println(result);
```

Output:

```text
Unknown
```

If the value exists:

```java
Optional<String> name = Optional.of("Krishna");

String result = name.orElse("Unknown");

System.out.println(result);
```

Output:

```text
Krishna
```

---

# 5️⃣ `orElseGet()`

Provides a value using a `Supplier` when the Optional is empty.

```java
Optional<String> name = Optional.empty();

String result = name.orElseGet(() -> "Unknown");

System.out.println(result);
```

Output:

```text
Unknown
```

It can also call a method:

```java
String getDefaultName() {
    return "Unknown";
}
```

Then:

```java
String result = name.orElseGet(() -> getDefaultName());
```

---

# ⚡ `orElse()` vs `orElseGet()`

This is an important interview question.

### `orElse()`

```java
optional.orElse(getDefaultValue());
```

The default expression is evaluated **even if the Optional contains a value**.

### `orElseGet()`

```java
optional.orElseGet(() -> getDefaultValue());
```

The default value is generated **only when the Optional is empty**.

For expensive operations, `orElseGet()` can therefore be preferable.

---

# 6️⃣ `orElseThrow()`

Returns the value if present.

If the Optional is empty, it throws an exception.

```java
Optional<String> name = Optional.empty();

String result = name.orElseThrow();
```

This throws:

```text
NoSuchElementException
```

---

# 7️⃣ `orElseThrow(Supplier)`

Allows you to specify your own exception.

```java
Optional<String> name = Optional.empty();

String result = name.orElseThrow(
    () -> new RuntimeException("Name not found")
);
```

Output:

```text
RuntimeException: Name not found
```

A common real-world example:

```java
User user = userRepository
        .findById(id)
        .orElseThrow(() -> new RuntimeException("User not found"));
```

---

# 8️⃣ `ifPresent()`

Executes code only when a value exists.

```java
Optional<String> name = Optional.of("Krishna");

name.ifPresent(
    value -> System.out.println(value)
);
```

Output:

```text
Krishna
```

Using method reference:

```java
name.ifPresent(System.out::println);
```

---

# 9️⃣ `ifPresentOrElse()`

Available since **Java 9**.

Executes one block if the value exists and another block if it doesn't.

```java
Optional<String> name = Optional.empty();

name.ifPresentOrElse(
    value -> System.out.println("Name: " + value),
    () -> System.out.println("Name not found")
);
```

Output:

```text
Name not found
```

---

# 🔟 `map()`

`map()` is one of the most important Optional methods.

It transforms the value inside the Optional.

Suppose:

```java
Optional<String> name = Optional.of("Krishna");
```

We want the length of the name.

```java
Optional<Integer> length =
        name.map(value -> value.length());

System.out.println(length);
```

Output:

```text
Optional[7]
```

### Without Optional

```java
String name = "Krishna";

int length = name.length();
```

### With Optional

```java
Optional<String> name = Optional.of("Krishna");

Optional<Integer> length =
        name.map(String::length);
```

The type changes:

```text
Optional<String>
       ↓
      map()
       ↓
Optional<Integer>
```

---

# 1️⃣1️⃣ `filter()`

`filter()` keeps the value only when the condition is true.

```java
Optional<Integer> number = Optional.of(50);

Optional<Integer> result =
        number.filter(n -> n > 40);

System.out.println(result);
```

Output:

```text
Optional[50]
```

If the condition is false:

```java
Optional<Integer> number = Optional.of(20);

Optional<Integer> result =
        number.filter(n -> n > 40);

System.out.println(result);
```

Output:

```text
Optional.empty
```

### Flow

```text
Optional[50]
     ↓
filter(n -> n > 40)
     ↓
Optional[50]
```

But:

```text
Optional[20]
     ↓
filter(n -> n > 40)
     ↓
Optional.empty
```

---

# 1️⃣2️⃣ `flatMap()`

`flatMap()` is used when the mapping function itself returns an `Optional`.

Suppose:

```java
Optional<String> name = Optional.of("Krishna");
```

If we use `map()`:

```java
Optional<Optional<String>> result =
        name.map(value -> Optional.of(value.toUpperCase()));
```

This creates:

```text
Optional<Optional<String>>
```

Using `flatMap()`:

```java
Optional<String> result =
        name.flatMap(value ->
                Optional.of(value.toUpperCase()));
```

Now the result remains:

```text
Optional<String>
```

### ⭐ Difference

```text
map()
Optional<T> → Optional<R>

flatMap()
Optional<T> → Optional<R>
                     ↑
        function itself returns Optional
```

---

# 1️⃣3️⃣ `or()`

Available since **Java 9**.

Returns another Optional when the current Optional is empty.

```java
Optional<String> name = Optional.empty();

Optional<String> result =
        name.or(() -> Optional.of("Default"));

System.out.println(result);
```

Output:

```text
Optional[Default]
```

If the original value exists:

```java
Optional<String> name = Optional.of("Krishna");

Optional<String> result =
        name.or(() -> Optional.of("Default"));

System.out.println(result);
```

Output:

```text
Optional[Krishna]
```

---

# 1️⃣4️⃣ `stream()`

Available since **Java 9**.

Converts an Optional into a Stream.

```java
Optional<String> name = Optional.of("Krishna");

name.stream()
    .forEach(System.out::println);
```

Output:

```text
Krishna
```

For an empty Optional:

```java
Optional<String> name = Optional.empty();

name.stream()
    .forEach(System.out::println);
```

Nothing is printed.

---

# 🔥 Optional with Stream API

Optional is commonly used with Stream API.

Example:

```java
List<Integer> numbers =
        Arrays.asList(10, 20, 30, 40, 50);

Optional<Integer> result =
        numbers.stream()
               .filter(n -> n > 40)
               .findFirst();

System.out.println(result);
```

Output:

```text
Optional[50]
```

To get the actual value safely:

```java
Integer result =
        numbers.stream()
               .filter(n -> n > 40)
               .findFirst()
               .orElse(0);

System.out.println(result);
```

Output:

```text
50
```

---

# 🔎 `findFirst()` and Optional

Stream operations such as `findFirst()` return an Optional.

```java
Optional<Integer> result =
        numbers.stream()
               .filter(n -> n > 100)
               .findFirst();

System.out.println(result);
```

Output:

```text
Optional.empty
```

This is useful because there may be **no matching element**.

---

# 🔎 `findAny()` and Optional

```java
Optional<Integer> result =
        numbers.stream()
               .filter(n -> n > 20)
               .findAny();

System.out.println(result);
```

Possible output:

```text
Optional[30]
```

`findAny()` returns any matching element, while `findFirst()` returns the first matching element according to the stream's encounter order.

---

# 💼 Practical Example

Suppose we have:

```java
class Employee {

    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
```

We can write:

```java
Optional<Employee> employee =
        Optional.of(new Employee("Krishna"));
```

Get the employee name:

```java
String name =
        employee
            .map(Employee::getName)
            .orElse("Unknown");

System.out.println(name);
```

Output:

```text
Krishna
```

---

# 🔗 Chaining Optional Methods

Optional methods can be chained together.

```java
Optional<String> name =
        Optional.of("krishna");

String result =
        name
            .filter(n -> n.length() > 5)
            .map(String::toUpperCase)
            .orElse("UNKNOWN");

System.out.println(result);
```

Output:

```text
KRISHNA
```

### Flow

```text
Optional["krishna"]
        ↓
     filter()
        ↓
Optional["krishna"]
        ↓
      map()
        ↓
Optional["KRISHNA"]
        ↓
     orElse()
        ↓
      "KRISHNA"
```

---

# ⚠️ Important: Don't Use Optional Everywhere

`Optional` is primarily useful for representing an **optional return value**.

Avoid unnecessarily writing:

```java
Optional<String> name = Optional.of("Krishna");
```

for every local variable.

Instead, use it where absence of a value is meaningful, especially in APIs and return values.

---

# ❌ Avoid This

```java
if (optional.isPresent()) {
    System.out.println(optional.get());
}
```

Although valid, it often defeats the purpose of Optional.

Prefer:

```java
optional.ifPresent(System.out::println);
```

---

# ❌ Avoid Returning `null` from an Optional Method

Bad:

```java
public Optional<String> getName() {

    if (name == null) {
        return null;
    }

    return Optional.of(name);
}
```

Better:

```java
public Optional<String> getName() {
    return Optional.ofNullable(name);
}
```

An Optional-returning method should generally return either:

```text
Optional[value]
```

or:

```text
Optional.empty
```

rather than `null`.

---

# 📚 Quick Method Reference

```java
Optional.of(value)
Optional.ofNullable(value)
Optional.empty()

optional.isPresent()
optional.isEmpty()

optional.get()

optional.orElse(defaultValue)
optional.orElseGet(() -> defaultValue)

optional.orElseThrow()
optional.orElseThrow(() -> new RuntimeException())

optional.ifPresent(value -> ...)
optional.ifPresentOrElse(value -> ..., () -> ...)

optional.map(value -> ...)
optional.flatMap(value -> ...)
optional.filter(value -> ...)

optional.or(() -> Optional.of(...))

optional.stream()
```

---

# 🎯 Interview Questions

### Basic

1. What is `Optional` in Java?
2. Why was Optional introduced?
3. What is the difference between `of()` and `ofNullable()`?
4. What happens when `Optional.of(null)` is used?
5. What is `Optional.empty()`?
6. What is the difference between `isPresent()` and `isEmpty()`?
7. What happens when `get()` is called on an empty Optional?

### Intermediate

8. Difference between `orElse()` and `orElseGet()`?
9. Difference between `orElse()` and `orElseThrow()`?
10. What is `ifPresent()`?
11. What is `ifPresentOrElse()`?
12. What is the difference between `map()` and `flatMap()`?
13. How does `filter()` work with Optional?
14. What does `Optional.or()` do?
15. How does Optional work with Stream API?

### Advanced

16. Why should `Optional` generally not be used as a field?
17. Why should we avoid calling `get()` directly?
18. Can Optional contain `null`?
19. Can Optional be used as a method parameter?
20. Why is `orElseGet()` sometimes more efficient than `orElse()`?
21. How does `findFirst()` return an Optional?
22. How does `findAny()` return an Optional?
23. When should you use `map()` vs `flatMap()`?
24. Can an Optional itself be `null`?
25. What is the purpose of Optional in API design?

---

# 🧠 Key Points to Remember

> ⭐ `Optional` represents a value that may or may not exist.

> ⭐ `of()` should be used when the value is definitely non-null.

> ⭐ `ofNullable()` can safely handle `null`.

> ⭐ `empty()` creates an empty Optional.

> ⭐ Avoid blindly using `get()`.

> ⭐ Use `orElse()` for a direct fallback value.

> ⭐ Use `orElseGet()` when the fallback needs to be generated.

> ⭐ Use `orElseThrow()` when absence should result in an exception.

> ⭐ `map()` transforms the value.

> ⭐ `filter()` applies a condition.

> ⭐ `flatMap()` prevents nested `Optional<Optional<T>>`.

> ⭐ `findFirst()` and `findAny()` commonly return Optional.

> ⭐ Optional is especially useful for safely representing potentially missing return values.

---

# 🚀 Simple Mental Model

Think of Optional as a **box**.

```text
          Optional
        ┌───────────┐
        │  Krishna  │
        └───────────┘
             ↓
       value is present
```

or:

```text
          Optional
        ┌───────────┐
        │   empty   │
        └───────────┘
             ↓
       value is absent
```

Instead of asking:

```java
"Is this object null?"
```

you work with:

```java
Optional<T>
```

and explicitly handle both possibilities:

```text
Value exists  → use it
Value absent  → provide fallback / throw exception / do nothing
```

---

## 📖 Related Java Topics

* Java Collections
* Stream API
* Lambda Expressions
* Functional Interfaces
* Method References
* Generics
* Exception Handling
* `Collectors`
* `map()` and `flatMap()`
* `findFirst()` and `findAny()`

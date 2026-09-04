# Java Stream API — Intermediate Operations

Intermediate operations are operations that **transform, filter, or modify the flow of elements in a Stream**.

They return another `Stream`, which means multiple intermediate operations can be chained together.

```text
Stream
  ↓
Intermediate Operation
  ↓
Stream
  ↓
Intermediate Operation
  ↓
Stream
  ↓
Terminal Operation
```

Example:

```java
List<Integer> numbers = List.of(10, 20, 30, 40, 50);

numbers.stream()
       .filter(n -> n > 20)
       .map(n -> n * 2)
       .forEach(System.out::println);
```

---

# 1. `filter()`
## wherever output is reducing filter will come into to action.
`filter()` is used to select elements based on a condition.

It takes a `Predicate<T>` and returns a new Stream containing only the elements that satisfy the condition.

### Syntax

```java
stream.filter(condition);
```

### Example

```java
List<Integer> numbers = List.of(10, 15, 20, 25, 30);

numbers.stream()
       .filter(n -> n > 20)
       .forEach(System.out::println);
```

### Output

```text
25
30
```

### Common Use Cases

* Selecting users above a certain age
* Finding products within a price range
* Selecting even/odd numbers
* Filtering employees by department

---

# 2. `map()`

<img width="877" height="207" alt="image" src="https://github.com/user-attachments/assets/588ec716-85d8-4024-a1f4-981779f64ba6" />
`map()` is used to **transform each element** of a Stream into another value.

It takes a `Function<T, R>`.

### Syntax

```java
stream.map(function);
```

### Example

```java
List<Integer> numbers = List.of(1, 2, 3, 4);

numbers.stream()
       .map(n -> n * 10)
       .forEach(System.out::println);
```

### Output

```text
10
20
30
40
```

The original elements are transformed.

```text
1 → 10
2 → 20
3 → 30
4 → 40
```

---
## MAP() only works on 1D Array.So if we want to change this into 2D Array you need to use flatMap().

# 3. `flatMap()`

`flatMap()` is used when each element produces **multiple elements**, especially when working with nested collections.

It flattens multiple Streams into a single Stream.
<img width="858" height="410" alt="image" src="https://github.com/user-attachments/assets/5be6d572-7273-42c0-8b1e-370b92ae5077" />
## it takes 2D Arrays as an input and convert this to 1D Array.

### Example

```java
List<List<Integer>> numbers = List.of(
        List.of(1, 2),
        List.of(3, 4),
        List.of(5, 6)
);

numbers.stream()
       .flatMap(List::stream)
       .forEach(System.out::println);
```

### Output

```text
1
2
3
4
5
6
```

Without `flatMap()`:

```text
[[1, 2], [3, 4], [5, 6]]
```

With `flatMap()`:

```text
[1, 2, 3, 4, 5, 6]
```

### `map()` vs `flatMap()`

| `map()`                    | `flatMap()`                  |
| -------------------------- | ---------------------------- |
| Transforms elements        | Transforms and flattens      |
| One input → one output     | One input → multiple outputs |
| Maintains nested structure | Removes nested structure     |

---
<img width="1091" height="277" alt="image" src="https://github.com/user-attachments/assets/b7e8a718-b18c-4942-bb2d-0fc2e1f6fd12" />


# 4. `distinct()`


`distinct()` removes duplicate elements from a Stream.

### Example

```java
List<Integer> numbers =
        List.of(10, 20, 20, 30, 30, 40);

numbers.stream()
       .distinct()
       .forEach(System.out::println);
```

### Output

```text
10
20
30
40
```
<img width="997" height="228" alt="image" src="https://github.com/user-attachments/assets/f5e281a2-3a2e-4b49-be22-03d0602fe7db" />
It uses the element's equality mechanism to determine duplicates.

---

# 5. `sorted()`

`sorted()` is used to sort Stream elements according to their natural ordering.

### Example

```java
List<Integer> numbers =
        List.of(50, 10, 40, 20, 30);

numbers.stream()
       .sorted()
       .forEach(System.out::println);
```

### Output

```text
10
20
30
40
50
```

---
<img width="1207" height="185" alt="image" src="https://github.com/user-attachments/assets/5e33219a-0d58-486a-8951-f26da5201da1" />

## Custom Sorting with `Comparator`

You can provide your own sorting logic.

```java
List<String> names =
        List.of("Krishna", "Amit", "Raj", "Alexander");

names.stream()
     .sorted(Comparator.comparingInt(String::length))
     .forEach(System.out::println);
```

Here, names are sorted according to their length.

---

# 6. `limit()`

`limit()` restricts the Stream to a maximum number of elements.

### Example

```java
List<Integer> numbers =
        List.of(10, 20, 30, 40, 50);

numbers.stream()
       .limit(3)
       .forEach(System.out::println);
```

### Output

```text
10
20
30
```

### Use Cases

Useful when you need:

* Top 5 products
* First 10 users
* First N records

---

# 7. `skip()`

`skip()` skips the first `n` elements of a Stream.

### Example

```java
List<Integer> numbers =
        List.of(10, 20, 30, 40, 50);

numbers.stream()
       .skip(2)
       .forEach(System.out::println);
```

### Output

```text
30
40
50
```

---

# 8. `peek()`

`peek()` allows you to perform an action on elements as they pass through the Stream.

It is mainly useful for **debugging and observing a pipeline**, rather than implementing the main business logic.

### Example

```java
List<Integer> numbers =
        List.of(10, 20, 30);

numbers.stream()
       .filter(n -> n > 10)
       .peek(n -> System.out.println("After filter: " + n))
       .map(n -> n * 2)
       .forEach(System.out::println);
```

Possible output:

```text
After filter: 20
40
After filter: 30
60
```

### Important

`peek()` is lazy like other intermediate operations.

It does not execute unless a terminal operation causes the pipeline to run.

---

# 9. `takeWhile()`

`takeWhile()` was introduced in **Java 9**.

It takes elements **while the condition remains true**.

Once the condition becomes false, it stops processing the remaining ordered elements.

### Example

```java
List<Integer> numbers =
        List.of(10, 20, 30, 15, 40);

numbers.stream()
       .takeWhile(n -> n < 35)
       .forEach(System.out::println);
```

### Output

```text
10
20
30
```

When `15` satisfies the condition too, it is included; when `40` is reached, processing stops.

---

# 10. `dropWhile()`

`dropWhile()` was introduced in **Java 9**.

It skips elements while the condition is true and then processes the remaining elements.

### Example

```java
List<Integer> numbers =
        List.of(10, 20, 30, 40, 15, 50);

numbers.stream()
       .dropWhile(n -> n < 35)
       .forEach(System.out::println);
```

### Output

```text
40
15
50
```

Once `40` is encountered, the condition becomes false, so the remaining elements are kept.

---

# Intermediate Operations Summary

| Operation     | Purpose                               |
| ------------- | ------------------------------------- |
| `filter()`    | Select elements based on a condition  |
| `map()`       | Transform each element                |
| `flatMap()`   | Flatten nested Streams                |
| `distinct()`  | Remove duplicates                     |
| `sorted()`    | Sort elements                         |
| `limit()`     | Keep only the first N elements        |
| `skip()`      | Skip the first N elements             |
| `peek()`      | Observe elements during processing    |
| `takeWhile()` | Take elements while condition is true |
| `dropWhile()` | Drop elements while condition is true |

---

# Important Characteristics

### 1. They are Lazy

Intermediate operations do not execute immediately.

```java
numbers.stream()
       .filter(n -> n > 10)
       .map(n -> n * 2);
```

Nothing is processed until a terminal operation is added.

```java
numbers.stream()
       .filter(n -> n > 10)
       .map(n -> n * 2)
       .forEach(System.out::println);
```

---

### 2. They Return a Stream

Intermediate operations allow chaining:

```java
numbers.stream()
       .filter(n -> n > 10)
       .map(n -> n * 2)
       .sorted()
       .limit(5);
```

---

### 3. They Can Be Chained

A complete pipeline can contain multiple intermediate operations.

```java
List<Integer> result = numbers.stream()
        .filter(n -> n > 10)
        .distinct()
        .sorted()
        .map(n -> n * 2)
        .limit(5)
        .toList();
```

---

# Intermediate vs Terminal Operations

| Intermediate | Terminal      |
| ------------ | ------------- |
| `filter()`   | `forEach()`   |
| `map()`      | `collect()`   |
| `flatMap()`  | `count()`     |
| `sorted()`   | `reduce()`    |
| `distinct()` | `min()`       |
| `limit()`    | `max()`       |
| `skip()`     | `findFirst()` |
| `peek()`     | `findAny()`   |

### Key Difference

```text
Intermediate Operation
        ↓
Returns Stream
        ↓
Can continue pipeline
```

```text
Terminal Operation
        ↓
Produces final result
        ↓
Stream pipeline ends
```

---

# ⭐ Key Takeaways

* Intermediate operations are used to **transform or filter data**.
* They return another **Stream**.
* They are generally **lazy**.
* Multiple intermediate operations can be chained.
* A terminal operation is required to execute the pipeline.
* `filter()` → selects data.
* `map()` → transforms data.
* `flatMap()` → flattens nested data.
* `sorted()` → sorts data.
* `distinct()` → removes duplicates.
* `limit()` and `skip()` → control the number of processed elements.
* `peek()` → useful mainly for debugging.
* `takeWhile()` and `dropWhile()` are available from **Java 9**.

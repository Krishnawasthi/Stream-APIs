
# Java Streams API
<img width="1026" height="351" alt="image" src="https://github.com/user-attachments/assets/8ea79bad-890e-45ca-87a4-65cc8081a17f" />

## Map Will take one Stream as an input and convert it according to the Operation.
The **Java Streams API** was introduced in **Java 8** to process collections of objects in a clean, declarative, and functional style.

A Stream is **not a data structure**. It is a sequence of elements that allows us to perform operations such as filtering, mapping, sorting, and collecting.

<img width="835" height="435" alt="image" src="https://github.com/user-attachments/assets/6f414359-f7c8-4c21-bca9-13e1201ad97f" />

---

## What is a Stream?



A Stream represents a sequence of elements that can be processed through a pipeline of operations.

For example:

```java
List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

numbers.stream()
       .filter(n -> n > 20)
       .forEach(System.out::println);
```

### Output

```text
30
40
50
```
<img width="1192" height="325" alt="image" src="https://github.com/user-attachments/assets/c587f484-468c-4221-8359-b4dd369f40bf" />



Here:

* `stream()` creates a stream.
* `filter()` selects elements.
* `forEach()` processes each element.

---

## Stream vs Collection

| Collection                   | Stream                                |
| ---------------------------- | ------------------------------------- |
| Stores data                  | Processes data                        |
| Data structure               | Processing pipeline                   |
| Can be reused                | Cannot normally be reused             |
| Supports direct modification | Does not modify the source            |
| Eager operations             | Supports lazy intermediate operations |

---

## Stream Pipeline

A Stream pipeline generally consists of three parts:

```text
Source
  ↓
Intermediate Operations
  ↓
Terminal Operation
```

Example:

```java
numbers.stream()
       .filter(n -> n > 20)
       .map(n -> n * 2)
       .forEach(System.out::println);
```

### 1. Source

The source provides the data.

```java
numbers.stream();
```

### 2. Intermediate Operations

These transform or filter the stream.

## by the intermediate you cam create the chain of streams.

Examples:

```java
filter()
map()
sorted()
distinct()
limit()
skip()
```

### 3. Terminal Operation

The terminal operation produces the final result or side effect.

Examples:

```java
forEach()
collect()
count()
reduce()
min()
max()
```

---
<img width="835" height="435" alt="image" src="https://github.com/user-attachments/assets/03c6fffe-1973-4376-97d0-bd83f59b55b0" />

## terminal will called only once.

## How to Create a Stream

### From Collection

```java
List<String> names = Arrays.asList("John", "Alex", "David");

Stream<String> stream = names.stream();
```

### From Set

```java
Set<Integer> numbers = Set.of(10, 20, 30);

Stream<Integer> stream = numbers.stream();
```

### From Array

```java
int[] numbers = {10, 20, 30, 40};

IntStream stream = Arrays.stream(numbers);
```

### Using Stream.of()

```java
Stream<String> stream =
        Stream.of("Java", "Python", "JavaScript");
```

---

## Important Characteristics

### 1. Streams Don't Store Data

A Stream operates on data provided by a source.

```java
List<Integer> numbers = List.of(1, 2, 3);

numbers.stream();
```

The list stores the numbers, while the Stream processes them.

---

### 2. Streams Don't Modify the Original Collection

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

List<Integer> result = numbers.stream()
        .filter(n -> n % 2 == 0)
        .toList();
```

The original list remains unchanged.

---

### 3. Streams Are Usually Single-Use

Once a terminal operation is performed, the Stream is consumed.

```java
Stream<Integer> stream = Stream.of(1, 2, 3);

stream.forEach(System.out::println);

// Cannot reuse the same stream
stream.count(); // IllegalStateException
```

Create a new Stream when another pipeline is required.

---

## Lazy Evaluation

Intermediate operations are generally **lazy**.

They don't execute until a terminal operation is encountered.

```java
numbers.stream()
       .filter(n -> {
           System.out.println("Filtering " + n);
           return n > 10;
       });
```

Nothing is actually processed until a terminal operation is added.

```java
numbers.stream()
       .filter(n -> n > 10)
       .forEach(System.out::println);
```

---

## Functional Programming with Streams

Streams work closely with:

* Lambda expressions
* Functional interfaces
* Method references
* Optional
* Predicate
* Function
* Consumer
* Supplier

Example:

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5);

numbers.stream()
       .filter(n -> n % 2 == 0)
       .forEach(System.out::println);
```

---

## Sequential Stream

A normal Stream processes elements sequentially.

```java
numbers.stream()
       .forEach(System.out::println);
```

---

## Parallel Stream

A parallel stream can process elements using multiple threads.

```java
numbers.parallelStream()
       .forEach(System.out::println);
```

Parallel streams can be useful for suitable CPU-intensive workloads, but they should not be used automatically. For small collections or operations with shared mutable state, parallel processing may provide no benefit or can make things worse.

---

## Primitive Streams

Java provides specialized streams for primitive values:

```text
IntStream
LongStream
DoubleStream
```

Example:

```java
IntStream.range(1, 6)
         .forEach(System.out::println);
```

Output:

```text
1
2
3
4
5
```

Primitive streams can avoid unnecessary boxing and unboxing.

---

## Advantages of Streams

* Cleaner and more readable collection processing
* Supports functional-style programming
* Reduces boilerplate code
* Supports powerful operations such as filtering and grouping
* Supports sequential and parallel processing
* Makes data-processing pipelines easier to express

---

## When Should You Use Streams?

Streams are useful when you need to:

* Filter collections
* Transform objects
* Sort data
* Remove duplicates
* Calculate values
* Group objects
* Convert collections
* Perform aggregations
* Build readable data-processing pipelines

---

## Key Points

> ⭐ A Stream is **not a collection**.

> ⭐ A Stream **does not store data**.

> ⭐ Intermediate operations are generally **lazy**.

> ⭐ A terminal operation **ends the stream pipeline**.

> ⭐ A Stream is generally **single-use**.

> ⭐ Streams were introduced in **Java 8**.

> ⭐ Streams can work with both object and primitive data.

---

## Basic Stream Structure

```java
collection.stream()
          .intermediateOperation()
          .intermediateOperation()
          .terminalOperation();
```

Example:

```java
List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

List<Integer> result = numbers.stream()
        .filter(n -> n % 2 == 0)
        .map(n -> n * 10)
        .toList();
```

This pipeline:

```text
Collection
    ↓
Stream
    ↓
filter()
    ↓
map()
    ↓
toList()
    ↓
Result
```

## Here is  flow of program how stream works: 
<img width="801" height="450" alt="image" src="https://github.com/user-attachments/assets/51c5f2d3-b410-467b-9372-8af73a42d19f" />
## the actual Example:
<img width="1616" height="355" alt="image" src="https://github.com/user-attachments/assets/0a9e0494-247e-411c-b644-b88f26f23499" />


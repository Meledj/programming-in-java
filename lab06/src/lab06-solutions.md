# Lab5 - Java - elements of functional programming (I)

## 1) Functional interfaces, lambda expressions and method references

### Exercises

1. Explain the following concepts: functional interface, lambda expression, and method reference



   A functional interface is an interface that has exactly one abstract method and can be used as a target for lambda expressions.
   A lambda expression is a short, anonymous function used to implement the method of a functional interface.
   It provides a more concise alternative to anonymous classes.
   A method reference is an even shorter syntax that refers directly to an existing method instead of writing a lambda expression.
   

2. Write and test anonymous functions (lambda expressions) corresponding to :


   * (x) -> x - 2
   * (x, y) -> Math.sqrt(x*x + y*y)
   * (x, y, z) -> Math.sqrt(x*x + y*y + z*z)


3. Write and test anonymous functions corresponding to:  sqrt, abs, log, id


   * x -> Math.sqrt(x)
   * x -> Math.abs(x)
   * x -> Math.log(x)
   * x -> x


4. Given, complete the following code using lambda expressions:


   * FunIf<String, Integer> f1 = s -> s.length();
   * FunIf<Integer, String> f2 = i -> "Number: " + i;
   * FunIf<Double, Double> f3 = d -> d * d;
   * FunIf<Integer, Boolean> f4 = i -> i > 0;
   * FunIf<Boolean, Integer > f5 = b -> b ? 1 : 0;
   * FunIf<Boolean, Boolean > f6 = b -> !b;


5. Repeat the previous exercise using method references instead of lambda expressions (note: you should probably implement these methods first)

   * FunIf<String, Integer> f1 = Main::stringLength;

   * FunIf<Integer, String> f2 = Main::intToString;

   * FunIf<Double, Double> f3 = Main::square;

   * FunIf<Integer, Boolean> f4 = Main::isPositive;

   * FunIf<Boolean, Integer> f5 = Main::booleanToInt;

   * FunIf<Boolean, Boolean> f6 = Main::invert;
 

## 2) Standard functional interfaces

### Exercices

1. Familiarize yourself with the functional interfaces available in java.util.function package

   Done


2. For each of the standard functional interfaces white at least one example that demonstrates its use, i.e.:

      // BiConsumer<T, U>
      BiConsumer<String, String> bc = (s1, s2) -> System.out.println(s1 + " " + s2);
      bc.accept("Hello", "World");

        // BiFunction<T, U, R>
        BiFunction<Integer, Integer, Integer> bf = (a, b) -> a + b;
        System.out.println(bf.apply(3, 4));

        // BinaryOperator<T>
        BinaryOperator<Integer> bo = (a, b) -> a * b;
        System.out.println(bo.apply(5, 6));

        // Consumer<T>
        Consumer<String> c = s -> System.out.println(s);
        c.accept("Java");

        // Function<T, R>
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("Lambda"));

        // Predicate<T>
        Predicate<Integer> p = n -> n % 2 == 0;
        System.out.println(p.test(10));

        // Supplier<T>
        Supplier<Double> s = () -> Math.random();
        System.out.println(s.get());

        // UnaryOperator<T>
        UnaryOperator<Integer> uo = x -> x * x;
        System.out.println(uo.apply(7));


3. Explain the rationale behind the primitive type specialisations of the standard generic functional interfaces (e.g., BooleanSupplier, DoubleConsumer)


      Primitive specializations of functional interfaces (e.g., IntConsumer, DoubleSupplier) exist to avoid boxing/unboxing of int, double, boolean. They improve performance in loops and streams and make code clearer when working with primitives. Each has a method like accept(int) or getAsDouble() instead of the generic T.


## 3) Higher-order functions

### Exercises


1. Using sumOfWith, without defining any new functions, calculate ∑15i=1i5

   int sum = IntStream.rangeClosed(1, 15)
   .map(i -> i * i * i * i * i) // i^5
   .sum();


2. Write and test function

   return x -> IntStream.rangeClosed(0, n)
   .mapToDouble(k -> {
   double term = 1;
   for (int i = 1; i <= k; i++) term *= x / i;
   return term;
   })
   .sum();


3. Write and test function

import java.util.function.DoubleUnaryOperator;

public class Main {

    // approximation de la dérivée première
    static DoubleUnaryOperator dfr(DoubleUnaryOperator f, double h) {
        return x -> (f.applyAsDouble(x + h) - f.applyAsDouble(x)) / h;
    }

    public static void main(String[] args) {

        // fonction test : f(x) = x^2
        DoubleUnaryOperator f = x -> x * x;

        double x0 = 2.0;

        double[] hs = {1, 0.1, 0.01, 0.001, 0.0001};

        for (double h : hs) {
            DoubleUnaryOperator df = dfr(f, h);
            double approx = df.applyAsDouble(x0);
            double exact = 2 * x0;

            System.out.println("h = " + h +
                    "  approx = " + approx +
                    "  exact = " + exact +
                    "  error = " + Math.abs(approx - exact));
        }
    }
}


5. Analyse and test the following method :


`applyAll` takes a list of functions `Function<T,R>` and a value `x0` of type `T`.
It applies each function in the list to `x0` and stores the results in a new list.
The method returns these results as a `List<R>`.
`Collections.unmodifiableList` ensures the returned list cannot be modified.


   import java.util.*;
   import java.util.function.Function;

public class Main {

    private static <T, R> List<R> applyAll(List<Function<T, R>> fs, T x0) {
        List<R> ys = new ArrayList<>();

        for (var f : fs) {
            ys.add(f.apply(x0));
        }

        return Collections.unmodifiableList(ys);
    }

    public static void main(String[] args) {

        List<Function<Integer, Integer>> fs = List.of(
                x -> x + 1,
                x -> x * 2,
                x -> x * x
        );

        List<Integer> results = applyAll(fs, 3);

        System.out.println(results);
    }
}


## 4) Function composition

### Exercises

1. Using Function.compose create (fi∘gi)(x) for the following pairs of f and g:

   * Function<Double, Double> f1 = x -> 2 * x;
     Function<Double, Double> g1 = x -> x * x;

     Function<Double, Double> composition = f1.compose(g1);

     double result = composition.apply(3.0);
   * Function<Double, Double> f2 = Math::sin;

     Function<Double, Double> g2 = x -> (1 - x) / (1 + x * x);

     Function<Double, Double> composition = f2.compose(g2);

     double x = 1.0;
     double result = composition.apply(x);
   * Function<Double, Double> f3 =
     x -> (1 - Math.sin(x)) / (1 + 2 * x * x);

     Function<Double, Double> g3 = Math::cos;

     Function<Double, Double> composition = f3.compose(g3);

     double x = 1.0;
     double result = composition.apply(x);


2. Repeat the previous exercise using Function.andThen

   * Function<Double, Double> f1 = x -> 2 * x;
     Function<Double, Double> g1 = x -> x * x;
      Function<Double, Double> h1 = g1.andThen(f1);
   
   * Function<Double, Double> f2 = Math::sin;
     Function<Double, Double> g2 =
     x -> (1 - x) / (1 + x * x);
     Function<Double, Double> h2 = g2.andThen(f2);
     System.out.println(h2.apply(1.0));

   * Function<Double, Double> f3 =
   x -> (1 - Math.sin(x)) / (1 + 2 * x * x);
   Function<Double, Double> g3 = Math::cos;
   Function<Double, Double> h3 = g3.andThen(f3);
   System.out.println(h3.apply(1.0));


## 5) Dealing with optional data


### Exercises

1. Familiarize yourself with class Optional

   `Optional<T>` is a class in `java.util` that represents a value that may be **present or absent**.
   It is used to **avoid `NullPointerException`** instead of returning `null`.
   You can create it with `Optional.of()`, `Optional.ofNullable()`, or `Optional.empty()`.
   Common methods include `isPresent()`, `ifPresent()`, `map()`, and `orElse()` to safely handle the value.


2. Describe pros and cons of the following approaches to represent a "no-valid-result" of a function/method:
   * throwing an exception
   * returning null 
   * using Optional


Throwing an exception:
Pros: clearly signals an error and forces the caller to handle it.
Cons: exceptions are expensive and not ideal for normal control flow.


Returning null:
Pros: simple and lightweight.
Cons: can easily cause NullPointerException if the caller forgets to check.


Using Optional:
Pros: explicitly represents absence of a value and encourages safer handling.
Cons: adds slight overhead and can make code more verbose.

3. Write three variants of a method that returns the tail of a given list (see headOf_v1, headOf_v2, headOf_v3 in lst01_05)


import java.util.*;

public class Main {

    public static <T> List<T> tailOf_v1(List<T> list) {
        if (list == null || list.isEmpty()) return Collections.emptyList();
        return new ArrayList<>(list.subList(1, list.size()));
    }

    public static void main(String[] args) {
        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.println(tailOf_v1(nums)); // [2, 3, 4]
    }
}



public static <T> List<T> tailOf_v2(List<T> list) {
if (list == null || list.isEmpty()) return Collections.emptyList();
return Collections.unmodifiableList(list.subList(1, list.size()));
}


import java.util.Optional;

public static <T> Optional<List<T>> tailOf_v3(List<T> list) {
if (list == null || list.isEmpty()) return Optional.empty();
return Optional.of(List.copyOf(list.subList(1, list.size())));
}


4. Review the code of proj1 and identify the methods that could have Optional as the return type

Interface,Method,New Return Type,Reason
MyStack,peek(),Optional<E>,Avoids returning null if the stack is empty.
MyStack,pop(),Optional<E>,Explicitly indicates that the element might be absent.
MyQueue,peek(),Optional<E>,Secures the reading of the head of the queue.
MyQueue,dequeue(),Optional<E>,Gracefully handles removal from an empty queue.


## 6) Push the commits to the remote repository
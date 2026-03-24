# Lab4 - Java - elements of generic programming (I)

## 1) Concepts of parametric polymorphism, type constructor, and type variable

### Exercises

1. Familiarise yourself with The Java Tutorials > Generics

   *Done*

2. Look briefly at the chapters of Java Language Specification related to:
   * Generic Classes
   * Generic Methods
   * Generic Interfaces

   *Done*

## 2) Generic methods, classes, and interfaces

### Exercises

1. Explain the benefits of using generic types

    Generic types in Java improve type safety by catching errors at compile time instead of runtime. They eliminate the need for explicit casting, making the code cleaner and safer. Generics also promote code reusability, as one class or method can work with different data types. Additionally, they improve readability and maintainability by clearly specifying the type of data being used. 


2. Explain the syntax of:
   * generic class declaration
   
   A generic class is declared by placing a type parameter inside angle brackets (<>) after the class name.
   
   * generic method declaration

   A generic method declares its own type parameter before the return type.
      

3. Explain what a raw type is, why it is unsafe, and why the raw types are allowed in Java


   A raw type is a generic class or interface used without specifying its type parameter. They bypass type checking at compile time. They allow inserting any type of object. This can lead to runtime errors (e.g., ClassCastException). Raw types are allowed for backward compatibility with older versions of Java (before generics were introduced in Java 5).   

4. Given GenBox as defined in lst04_01 explain the compilation result of:

    * a) The code compiles with warnings, but it is unsafe because different types can be assigned to the same object due to the use of a raw type.
    * b) gb2.setX("abc"); give a Compilation error because "abc" is a String, not an Integer. gb2.setX(new GenBox(true)); give also a Compilation error because GenBox<Boolean> is not compatible with Integer


5. [c] Complete the method header in the following code so that it compiles:

    public static <T> void print(T[] elems)


6. [c] Refactor the source code to one file-one class structure
        Done


7. [c] Implement the generic class Pair<F,S> (see exc04_01):
   * add at least one constructor (two parameters: F fst and S snd)
   * add the accessors ("getters") and mutators ("setters")
   * add toString, equals, hashCode
   * add clone method
   * add unit test
    Done

## 3) Bounds for type variables

### Exercises

1. Explain the purpose of bounds for type variables

    Bounds on type variables control which types are allowed, provide compile-time safety, and let you use specific methods or interfaces on generic types.


2. Check if a type variable may have many interface bounds. Repeat this for class bounds.

    Yes, a type variable can have multiple interface bounds.
    Syntax example:
    <T extends InterfaceA & InterfaceB & InterfaceC>
    T must implement all listed interfaces.
    Only one class is allowed in the bounds (see below).
    Interfaces come after the class if there is a class bound.

    No, a type variable can have at most one class bound.
    Rules:
    If you include a class bound, it must be first.
    Then you can list any number of interfaces.


3. [c] Change the following generic function so that it compiles

   interface Movable {
   void goTo(double x, double y);
   }

    class Point implements Movable {
        private double x, y;
        public Point(double x, double y) { this.x = x; this.y = y; }
        public void goTo(double x, double y) { this.x = x; this.y = y; }
    }

    public class Main {
        private static <T extends Movable> void moveAll(T[] elems, double x, double y) {
        for (T e : elems) e.goTo(x, y);
        }

        public static void main(String[] args) {
            Point[] points = { new Point(0, 0), new Point(1, 1) };
            moveAll(points, 10, 20);
        }
    }

## 4) Subtyping and Wildcards

### Exercises

1. Explain the notions of
    * invariance
    * covariance 
    * contravariance
of generic types (type constructors)
   
* **Invariance:** `Generic<Sub>` is **not** a subtype of `Generic<Super>`, even if `Sub` extends `Super`.
* **Covariance:** `Generic<? extends Super>` allows **reading** elements safely as `Super`.
* **Contravariance:** `Generic<? super Sub>` allows **writing** elements of type `Sub` safely.
* These rules control **type safety** for generic types in Java.


2. Explain the notions of:
    * subtype wildcard
    * supertype wildcard 
    * unbounded wildcard

   ? extends T → safe reading (covariant)
    ? super T → safe writing (contravariant)
    ? → no specific type (read as Object, writing not safe)


3. from the following lines point out these that do not compile (explain each error):
  * GenBox<B> gb2 = new GenBox<C>(); Error compilation. GenBox<C> not sub-type of GenBox<B> even if C is a sub-type of B. Types générics are invariables.
  * GenBox<B> gb3 = new GenBox<A>(); Error compilation. GenBox<A> not compatible with GenBox<B> for the same reason of invariance.
  * GenBox<? extends B> gb6 = new GenBox<A>(); Error. A isn't a sub-class of B, so GenBox<A> can't be assigned to GenBox<? extends B>.
  * gb5.setX(new B()); Error of compilation. With ? extends B, we can't add nothing, because the type exact of gb5 is unknow (B or C). Only null could be add.
  * gb5.setX(new C()); Same reason as gb5.setX(new B());
  * GenBox<? super B> gb8 = new GenBox<C>(); Error compilation. C isn't a super-type of B, so GenBox<C> can't be assigned to GenBox<? super B>.
  * B b3 = gb9.getX(); Error. With ? super B, the type exact of gb9 is unknow (it can could be A, Object, etc.). We can't garanty we get a B.
  * B b4 = gb10.getX(); Error. With GenBox<?>, the type exact is unknow, so the compilator don't know is a B.
  * gb10.setX(new B()); Error. With GenBox<?>, we can't add (type is unknow). Only null is autorised
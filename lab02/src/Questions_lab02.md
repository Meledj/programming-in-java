# Lab 2 : Java - elements of OOP 

## 1) Final variables, methods, and classes
### Exercices
1. Look briefly at the chapters of **Java Language Specification** related to *final vatiables, methods*, and *classes*

   
   *Done*

2. Explain the benefits of using constants in programming


   *The benefits of using constants in programming are many :*
   - Readability : constants replace magics "values" by values with a meaning.
   - Maintainability : to change a value is more easier because it's on a only one location.
   - Safety & Immutability : Once initialised, you cannont change the values of constants, it's enhance the security and the integrity of the variables
   - Less mistakes : you don't need to copy values per values, you just need to tape the name of the variable
   - Efficience : Java compilator, optimise the code by replace directly the name of the constant by it value.


3. Explain the meaning of keyword **final** when used for :
   - local variables
      * Immutable of the reference : if primitive variable, value cannot be change. If object, the reference cannot be change, but the value of the object yes. Example Array
   
   - instance variables
      * Immutable of the value : The value of the instance cannot be change 

   - static constants
      * Immutable of the value : The value of the class cannot be change

   - methods
      * The function cannot be override and redifine in the subsclass for example
     
   - classes
      * The class can't have subclasses


4. Answer the following questions :
    - if a class contains only private data fields and no setter methods, is the class immutable ?
      * No the methods of the class can be redifine, and the class can have subclass. Data fields such as array can be modify

    - if all the data fields in a class are private and of primitive types, and the class does not contain any setter methods, is the class immutable ?
      * No the methods of the class can be redifine, and the class can have subclass
      

5. Explain why the following class is not immutable
   * getValue function can be redifine and the class in itself can have subclass and by modify


6. [c] Refactor the source code to ***one file-one class*** structure
   * Done

## 2) Enumeration classes (enums)
### Exercices
1. Look briefly at the chapters of Java Language Specification related to *enum classes*


2. Familiarise yourself with ***java.lang.Enum*** class


3. Analyse the following implementation of the singleton design pattern
    - Is this correct ? 
    - Thread-safe ?
      * This enum Singleton is structurally correct and thread-safe regarding instantiation, as the JVM guarantees INSTANCE is created uniquely and atomically. It provides built-in protection against reflection attacks and serialization issues that affect standard classes. However, while the instance is safe, the internal data (your value field) is not synchronized by default. To prevent race conditions in a multithreaded environment, you must use synchronized methods or AtomicInteger.


4. [c] Refactor the source code to ***one file-one class*** structure
   * Done
   
## 3) Nested classes
### Exercices

1.  Look briefly at the chapters of ***Java Language Specification*** related to *Nested classes (a static and non-static member classes, local classes, and anonymous classes*)


2. Explain the main differences between the types of nested classes available in Java
   * Java distinguishes between Static Nested Classes, which act like top-level classes and don't need a parent instance, and Inner Classes (Member, Local, Anonymous) which are tied to an outer object. Static classes only access static members, while inner classes can access all fields of the parent instance. Local and Anonymous classes are defined within methods for temporary logic or quick interface implementation. Generally, use static by default to save memory unless instance access is strictly necessary.


3. Answer the following questions :
    - Can an inner class be used in a class other than the class in which it nests ?
      * Yes, an inner class can be used outside its nesting class if its visibility (like public) allows it. A Static Nested Class is instantiated directly via the parent's name: new Outer.StaticChild(). However, a non-static Inner Class strictly requires an existing instance of the parent class to be created: outerInstance.new InnerChild(). 

    - Can the modifiers public, protected, private, and static be used for inner classes ?
      * Yes, nested classes can use all four access modifiers (public, protected, private, and package-private) to control visibility from other classes. The static keyword is also allowed, transforming the inner class into a Static Nested Class, which doesn't require an outer instance. Without static, it remains an Inner Class, tied to a parent object. These modifiers offer precise encapsulation within your class hierarchy.


4. [c] Refactor the source code to ***one file-one class*** structure
   * Done

## 4) Abstract Data Types (abstract classes and interfaces)
### Exercices 

1. Look briefly at the chapters of **Java Language Specification** related to *abstract classes* and *interfaces* 


2. Explain the main differences between abstract classes and interfaces in Java
   * Abstract class is a contract how the implementation need to be, detailled "is-a". Interface is a contract which tell what need to be used "can-do"


3. List possible types of members of Java Interfaces
   * Java interfaces can contain abstract methods (the core contract) and default or static methods (with implementations). Since Java 9, private methods are allowed for internal logic sharing. They can also hold constants (public static final fields) and nested types like classes or enums. Note that interfaces cannot have instance fields or constructors.


4. From the following list select the correct definition of an abstract class :
   * public abstract class B {
     abstract void m1();
     }
   
   * abstract class D { protected void m1(); }

   * abstract class E { abstract void m1(); }
   

5. From the following list select the correct definition of an interface :
   * interface D {
   void m1();
   }

6. Explain the output of running the class *Main* :
   * "b is an instance of A"
   * "b is an instance of C"

7. [c] Refactor the source code to ***one file-one class*** structure
   * Done

## 5) Functional interfaces and lambda expressions
### Exercises

1. Look briefly at the chapters of ***Java Language Specification*** related to *functional interfaces* and *lambda expressions*


2. Explain the relationship between lambda expressions and functional interfaces
   * Lambda expressions provide a clear and concise way to implement the single abstract method of a functional interface (SAM). They act as an instance of the interface, allowing you to treat functionality as an argument without the boilerplate of anonymous classes.


3. Write functional interfaces that correspond to the following function types :
    - $void \rightarrow int$
    - $int \rightarrow void$
    - $int \rightarrow int$
    - $(int, int) \rightarrow void$

    and then implement them (any implementation that compiles is good) using :
    - anonymous classes
    - lambda expressions
    *Note* : any implementation that compiles is good


4. [c] Refactor the source code to ***one file-one class*** structure


## 6) Mini project 02_01 (exc02-01)
[c] The implementation of interface *StackOfInts* : 

1. Add JavaDoc comments to the interface and all its methods


2. Add JavaDoc comments to *LinkedListBasedImpl* (the class itself ans all its methods)


3. Complete the linked list based implementation - LinkedListBasedImpl.

    *Notes* : 
    - use nested class *Node* as the linked list building block
    - use the simplest possible implementation of the linked list, i.e,
        * it can be ***unidirectional***
        * only two operations are required : adding and removing an element from the ***front of the list***


4. Write unit tests for differents cases


5. Add JavaDoc comments to *ArrayBasedImpl* (to the class itself and all its methods)


6. Write unit tests for different cases (i.e. apply a TDD-like approach)


7. Complete the array based implementation - ArrayBasedImpl.

    *Notes* :
   - it should be an *array of integers* (int), and not, for instance, *ArrayList<Integer>)
   - the size of the array should grow and shrink (according to some strategy) as elements are **pushed** and **poped**

## 7) Push the commits to the remote repository
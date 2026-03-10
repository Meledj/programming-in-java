# Lab 3 : element of OOP (III)

## 1) Java exceptions hierarchy
### Exercices
1. Familiare yourself with the Java Tutorials > Essential Java Classes > Exceptions
    
*Done*

2. Familiare yourself with the following classes:
    * Throwable
        * Error
        * Exception
            * IOException
            * RuntimeException
*Done*
        

3.  Look briefly at the chapter of Java Language Specification related to *Exceptions*
    
*Done*

## 2) throws, throw, try-catch, try-finally, and try-catch-finally
### Exercices
1. Look briefly at the chapters of Java Language Specification related to :
    * throws clause
    * throw statement 
    * try statement

    *Done*


2. Explain the differences between *checked* and *unchecked* exceptions


*Checked exceptions are exceptions that are checked at compile time. And Unchecked exceptions are exceptions that aren't checked at compile time.*

3. Explain the meaning of keywords *throw* and *throws* 

*The keyword throw is used to start an exception. And throws is used on the prototype of a method to indify it able to create an exception*

4. [c] Refactor the source code *one file-one class* structure

*Done*


5. [C] Add exception handling to the *StackOfInts*

*Done*

## 3) try-with-resources and AutoCloseable interface
### Exercices

1. Look briefly at the chapter of *Java Language Specification* related to try-with-resources

*Done*


2. Familiarise yourself with the *AutoCloseable* interface

*Done*


3. [c] Refactor the source code to *one file-one class* structure

*Done*

## 4) Reading and writing from/to the console
### Exercices

1. Look briefly at the content of files : Console.java, System.java, and Scanner.java

*Done*

2. Run agh.ii.prinjava.lab03.lst03_05.Main from the (external) console window

*Done*

## 5) Simple File I/O: text files
### Exercices

1. [c][optional] Write a function that counts the number of characters in a given text file
*Done*

2. [c][optional] Write a function that counts the number of lines in a given text file
*Done*

3. [c][optional] Write a function that concatenates two given files; consider two approach:
    * the second file is appended to the first one
    * the result is a new file
*Done*


4. [c][optional] Write a function that counts the number of words in a given text file
*Done*

5. [c][optional] Write a function that counts the number of whitespace characters in a given text file
*Done*

6. [c][optional] Write a function that changes, in a given text file, all TAB characters to SPACE character
*Done*

## 6) Simple File I/O: binary files
### Exercices

1. Explain briefly the applications of the following classes:
    * BufferedReader
    * BufferedWriter
    * FileReader
    * FileWriter
    * PrintWriter
    * FileInputStream
    * FileOutputStream
    * DataInputStream
    * DataOutputStream
    * ObjectInputStream
    * ObjectOutputStream
    * Files
    * Path
    * File

Text (Character Streams)

BufferedReader → Reads text efficiently (line by line)

BufferedWriter → Writes text efficiently

FileReader → Reads a text file

FileWriter → Writes to a text file

PrintWriter → Writes formatted text (print, println)

Binary Data (Byte Streams)

FileInputStream → Reads binary data

FileOutputStream → Writes binary data

Primitive Data Types (Structured Binary)

DataInputStream → Reads primitive types (int, double, boolean…)

DataOutputStream → Writes primitive types

Objects (Serialization)

ObjectInputStream → Reads serialized objects

ObjectOutputStream → Writes serialized objects

File Management

Files → Modern utility class (read, write, copy, delete…)

Path → Represents a file path (NIO)

File → Legacy class representing a file or directory 

2. [ c ] Extend the code in lst03_07 to be able to track how many times agh.ii.prinjav​a.lab03.lst03_07.Main has been executed. Hint: you can store a counter in the file and increment each time this program is executed.

*Done*

## 7) Java marker interfaces (Cloneable and Serializable)
### Exercices

1. Familiarise yourself with the content of *Serializable.java* and *Cloneable.java*
    *Done*

2. [ c ] Refactor the source code to *one file-one class* structure
    *Done*

## 8) Mini project 03_01
   *Done*
   
## 9) Push the commits to the remote repository
   *Done*
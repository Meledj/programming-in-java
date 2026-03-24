# Lab4 - Java - elements of generic programming (I)

## 1) Java Collections Framework - selected interfaces

### Exercises

1. Familiarise yourself with The Java Tutorials > Collections

   Done


2. Familiarise yourself with the following interfaces:
    
    Done


3. Look briefly at the Java Collections Framework class diagram

    Done

## 2) List<E> and its two implementations: ArrayList<E>, LinkedList<E>

### Exercices

1. Suppose lList is a LinkedList that contains a million int values. Which of the following two loops will run faster?
  
    The second loop is immensely faster.The first loop has to restart from the beginning of the list for every single element ($O(n^2)$), 
    which would take hours for a million entries. The second one uses an iterator that moves directly from one element to the next ($O(n)$), finishing the calculation almost instantly.


2. Explain the printout of the following code:

   The printout of the code will be: [1, 2, 4, 5]


3. Explain the printout of the following code:

   The printout of the code will be: [2, 4]

4. Explain the difference between the following pieces of code:

   The difference lies in how remove(i) is interpreted: l1 (Collection) treats i as an Object, searching for and removing the values $0, 1, 2$ (emptying the list). l2 (List) treats i as an index, which causes the elements to shift and triggers an IndexOutOfBoundsException on the third pass because the list has shrunk.


## Iterators, the for-each loop (aka. enhanced for loop), and forEach method

### Exercices

1. Familiarise yourself with the Iterator (design) pattern

    Done


2. Rewrite the following piece of code

    1. iterator and the while-loop

       Iterator<Integer> it = lst.iterator();
       while (it.hasNext()) {
       System.out.println(it.next());
       }

    2. iterator and the for-loop

       for (Iterator<Integer> it = lst.iterator(); it.hasNext(); ) {
       System.out.println(it.next());
       }
        
    3. enhnaced for-loop

       for (Integer value : lst) {
       System.out.println(value);
       }

    4. forEach method

       lst.forEach(value -> System.out.println(value));
       // Or even shorter using a method reference:
       // lst.forEach(System.out::println);


## 4) Queue<E>, Deque<E> and their implementations: PriorityQueue<E>, and ArrayDeque<E>

### Exercises

1. Familiarise yourself with:
    
    Done


2. Explain the execution result of the following method


The first line (for-each loop) prints the elements in their internal heap storage order, 
which is not fully sorted ($1, 3, 2, 6, 4, 5$). The second line (while loop with poll()) extracts elements one by one, triggering the re-sorting logic of the priority queue to print them in perfect ascending order ($1, 2, 3, 4, 5, 6$).


## 5) java.lang.Comparable and java.util.Comparator

### Exercises

1. Familiarise yourself with the following interfaces:

    Done


2. Check if the following code is correct, If not, fix the error.

   The Errors
   Missing Method: The Object class does not have a compareTo() method. Only classes that implement the Comparable interface have it.
    Wrong Casting: You are trying to cast the result of the comparison (an integer) to Comparable, which makes no sense. You must cast 
    the objects themselves to Comparable before calling the method.

   static Object max(Object o1, Object o2) {
   // Cast o1 to Comparable to access the compareTo method
   if (((Comparable) o1).compareTo(o2) >= 0) {
   return o1;
   } else {
    return o2;
    }
   }


3. Fill in the following code to create a Comparator for two strings in decreasing order of their length

Arrays.sort(cities, (s1, s2) -> Integer.compare(s2.length(), s1.length()));


## 6) Set<E> and its implementations: HashSet<E>, LinkedHashSet<E>, TreeSet<E>, and EnumSet<E extends Enum<E>>

### Exercises

1. Explain the key differences between the four implementations of the Set interface
    * HashSet: Uses a hash table for $O(1)$ performance but offers no guaranteed order of elements.
    * LinkedHashSet: Maintains insertion order using a linked list alongside the hash table, with slightly higher memory overhead.
    * TreeSet: Stores elements in a Red-Black Tree, keeping them sorted (natural or custom) with $O(\log n)$ performance.
    * EnumSet: Specialized for Enum types, using internal bit-vectors for extreme speed and minimal memory footprint.


2. Explain how to compute the union, intersection, and difference of two sets, using just the methods of the Set interface and without using loops
   
    To perform these operations on two sets s1 and s2 without using loops, use the bulk methods of the Set interface:
    * Union: s1.addAll(s2); (Adds all elements of s2 to s1).
    * Intersection: s1.retainAll(s2); (Keeps in s1 only the elements also present in s2).
    * Difference: s1.removeAll(s2); (Removes from s1 all elements that are found in s2).


3. Write a function that takes a TreeSet of strings and returns a new TreeSet with each string being transformed to uppercase

   public static TreeSet<String> toUppercase(TreeSet<String> inputSet) {
   return inputSet.stream()
   .map(String::toUpperCase)
   .collect(Collectors.toCollection(TreeSet::new));
   }


## 7) Map<K,V> and its implementations: HashMap<K,V>, LinkedHashMap<K,V>, TreeMap<K,V>, and EnumMap<K extends Enum<K>,V>

### Exercises


1. Explain the key differences between the four implementations of the Map interface
    * HashMap : La plus rapide ($O(1)$), mais n'offre aucun ordre précis pour les clés.
    * LinkedHashMap : Conserve l'ordre d'insertion des éléments grâce à une liste doublement chaînée.
    * TreeMap : Maintient les clés triées (ordre naturel ou comparateur) via un arbre rouge-noir ($O(\log n)$).
    * Hashtable : Version ancienne et synchronisée (thread-safe), plus lente et n'autorisant aucune valeur null.


2. Write a program that reads all words in a file and prints out how often each word occurred. Use a TreeMap<String, Integer>

   import java.io.File;
   import java.io.FileNotFoundException;
   import java.util.Map;
   import java.util.Scanner;
   import java.util.TreeMap;

public class WordCounter {
public static void main(String[] args) {
File file = new File("words.txt"); // Ensure this file exists in your project folder
Map<String, Integer> wordCounts = new TreeMap<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                // Read next word and convert to lowercase for accurate counting
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
                
                if (!word.isEmpty()) {
                    // merge() adds 1 if word is new, or adds 1 to the existing value
                    wordCounts.merge(word, 1, Integer::sum);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        }

        // Print results (alphabetically sorted by TreeMap)
        wordCounts.forEach((word, count) -> 
            System.out.println(word + ": " + count));
    }
}


## 8) Selected algorithms from java.util.Collections and java.util.Arrays

### Exercises


1. Familiarize yourself with the methods of Collections and Arrays utility classes
    
    Done


2. Explain why binarySearch algorithm requires sorted data

   Binary search works through elimination: at each step, it compares the target to the middle element. 
   If the data is sorted, this comparison allows you to safely discard an entire half of the list ($<$ or $>$). 
    Without sorting, the middle element provides no information about where other values are located, making the algorithm impossible.


3. Explain the difference between linear search and binary search in terms of the time complexity

   Linear search has $O(n)$ complexity, meaning its time grows proportionally to the number of elements as it checks them one by one. 
   In contrast, binary search has $O(\log n)$ complexity, as it divides the search area in half at each step. 
    This makes binary search exponentially faster for large, sorted datasets.

## 7) Push the commits to the remote repository

    
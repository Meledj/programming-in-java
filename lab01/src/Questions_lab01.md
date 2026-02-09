# Lab1 - element of OOP

## Working environnement setup

## 1) Concepts of encapsulation, inheritence, and polymorphism

1. Explain the concept of *encapsulation* and the way it is implemented in Java  


   *L'encapsulation est le fait de récupérer toutes les propriétés d'un objet, ainis que ses fonctions qui lui sont propres et de les rassembler au sein d'un même "bloc"
   mais également une abstraction de ces éléments là* 

2. Explain the following concepts :
   - mutator method (setter)
   - accessor method (getter)

   
   *L'abstraction permet de ne pas modifier et lire, les éléments dans une classe en utilisant le nom de l'instance . l'attribut
   . Pour pouvoir modifier ces attributs nous devons utiliser des méthodes appropriées (setters) et des méthodes appropriées pour les lire (getters)
   . Ils permettent donc de lire et écrire les valeurs des attributs de la classe en respectant le principe d'abstraction.*

3. Explain two different meanings/roles of :
    - this
    - super
   

   *This permet de d'appeler l'instance actuelle dans les méthodes de la classe, ou d'appeler un constructeur avec les paramètres entre parenthèses ex : this(2.0, "dog").*
   
   *Super permet d'appeler le constructeur de la classe mère au sein du constrcuteur de la classe fille*


4. Explain the concept of *inheritence* and the way it is implemented in Java


   *On implémente une classe "mère" qui sert de concept abstrait pour les classes "filles". Par exemple une classe véhicule comme classe mère et une classe "voiture" comme classe "fille".
   La classe fille hérite ensuite des propriétés et des méthodes de la classe mère. Dans cet exemple une voiture est un véhicule mais avec des attributs à lui particulier. En java on utilise extends, puis super dans le constructeur de la classe fille.*

5. Explain the concept of *polymorphism*, name its three main kinds/forms, and explain the way they are implemented in Java


   *C’est un concept puissant de la POO qui complète l’héritage.
   il consiste à fournir une interface unique à des objets pouvant avoir différents types.
   Upcast (une voiture est un véhicule) Down cast (de la classe mère vers la classe fille explicite).
   Fonctionne avec extends*


6. Explain the relationship between inheritance and sub-type/inclusion polymorphism
   

*quand plusieurs classes héritent d'une même classe mère, on peut utiliser le upcast pour prendre le type de la classe, qu'ils ont en commun et par conséquent pouvoir les stocker ensemble...*


7. Read Composition vs. Inheritance : How to Choose ?


   *Inheritance doit être choisi lorsque la classe est un concept abstrait, alors que la composition lorsque la classe,
   est réelle et pas concrète.*

8. In the analysed code identity *testable* methods and write a couple of unit tests for them (the IDE can help with it)


## 2) Static members (variables/contants and methods)

1. Explain the following concepts :
   * static variable (field/class member)
   * static constant
   * static method


*Static variable est une variable de la classe et non d'une instance de la classe
. Une static constant est une constante propre à la classe et non à une instance.
Une méthode statique est une méthode propre à la classe et non à une instance de la classe.*

2. Explain why *static constants* often have *public* visibility


*Les constantes statiques ont souvent une visibilité publique car vu que ce sont des constantes, elles en peuvent être modifiées et n'ont pas besoin d'être protéées.*

3. Explain why static methods do not have acess to instance members (methods and fields)


*Elles n'ont pas accès aux instances car elles ne peuvent être appellées que par la classe elle-même et non les instances de la classe.*

4. Give one example of a static method application


*Une méthode pour comparer plusieurs instances de la classe.

5. Write a couple of unit tests for **HelloImmutable** and **HelloJavaRecord**


## 3) Constructors, factory methods, and singletons

1. Describe the *object initialisation process* for a class derived from the **Object** class (including default values for different types of fields/variables, static variables, static constants, anonymous static blocks, anonymous blocks, constructors)


   *Au chargement de la classe : les variables statiques prennent leurs valeurs par défaut, puis les initialisations statiques et blocs static sont exécutés (une seule fois).
   À la création de l’objet : la mémoire est allouée et tous les champs d’instance reçoivent leurs valeurs par défaut.
   Initialisation de la super-classe : le constructeur de Object (via super()) est appelé en premier.
   Finalisation : les initialiseurs d’instance, blocs anonymes, puis le constructeur de la classe sont exécutés.*


2. For class **D9** from (defined in **ClassFamily.java**) :
    1. draw the class (inheritence) diagram
    2. explain the sequence of the constructor calls


B1 $==>$ D1 $==>$ D9  

*super() : appel du constructeur par défaut de la super class*  
   
*System.out.println("D9.D9()"); et System.out.println("About to execute: d1 = new D1(); // D1 extends B1"); : affichage d'informations dans la console pour l'utilisateur*
   
*d1 = new D1(); : crétion de l'attribut D1.* 


3. Compare capabilities of constructors and factory methods

   
   *constructors are simple and mandatory for basic object creation, while factory methods are more flexible, expressive, and powerful for advanced creation logic.*
   

4. Give at least two applications of the *singleton pattern*


   Gestion de configuration Utilisé pour stocker les paramètres globaux de l’application (fichier de config, propriétés système), afin que toutes les parties du programme utilisent la même instance.
   Système de journalisation (logger)

   Un logger singleton permet à toute l’application d’écrire dans le même journal, évitant la duplication des ressources et assurant la cohérence des logs.

5. Write a couple of unit test (JUnit 5) for singletons from *lst01_08*


   *Fait*

## 4) Immutable objects/classes and Java records

1. Explain a strategy for defining *immutables* objects


*Put this attributes in private and final*

2. Compare the concepts of the *immutable object* and *immutable class*


*Un objet immuable concerne une instance précise dont l’état est figé après sa création, tandis qu’une classe immuable concerne la conception de la classe elle-même.
L’immuabilité d’un objet peut dépendre de son usage et du contexte, alors qu’une classe immuable offre une garantie structurelle.
Un objet peut être immuable même si la classe n’impose pas strictement cette contrainte.
En revanche, une classe immuable garantit que toutes ses instances sont immuables.*

3. Explain the advantages of *immutable objects*


*Les objets immuables ne peuvent pas changer après leur création, ce qui les rend threads-safe et fiables dans les collections.
Ils simplifient le code en évitant les effets secondaires et facilitent le raisonnement.
Ils permettent également la réutilisation et le caching efficace d’objets existants.*

4. Give at least two uses of the *Java Records*


*Les Java Records sont utilisés pour modéliser des données immuables de façon simple et concise.
Ils servent à transférer des données entre méthodes ou systèmes (DTOs) et à stocker des valeurs clés dans des collections comme Map ou Set.*


5. Write a couple of unit test to for **HelloImmutable** and **HelloJavaRecord**


*Fait*

## 5) Overriding hashCode, equals, and toString

1. Explain the difference between == operator and *equals* method in Java (consider primitive and reference types)


*En Java, == compare les valeurs pour les types primitifs et les références pour les objets.
La méthode equals() compare le contenu réel des objets (par exemple, chaînes de caractères).
Donc == teste l’identité, tandis que equals() teste l’égalité logique.*

2. Explain the following formula o1.equals(o2) $\implies$ hasCode(o1)==hashCode(o2)


*Cela veut dire que si l'objet o1 et o2 ont les mêmes valeurs pour leurs attributs, alors cela implique qu'ils ont le même hashcode.*


3. Familiarize yourself with Java Object class


*Fait*

4. Explain the general contract of *hashCode* and *equals*


*Le contrat général dit que si equals() retourne vrai pour deux objets, leurs hashCode() doivent être égaux.
hashCode() doit toujours retourner la même valeur pendant la vie de l’objet si son état n’a pas changé.
Deux objets avec des hashCode() identiques ne sont pas forcément égaux, mais deux objets égaux doivent avoir le même hash code.*


5. Generate JavaDOC documentation for the project (*hint*: **Tools > Generate** JavaDoc )


*Fait*
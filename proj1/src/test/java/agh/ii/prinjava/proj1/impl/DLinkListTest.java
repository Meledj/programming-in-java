package agh.ii.prinjava.proj1.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de test unitaire pour {@link DLinkList}.
 * Vérifie le bon fonctionnement des opérations d'insertion, de suppression
 * et de représentation textuelle d'une liste doublement chaînée.
 */
class DLinkListTest {

    /**
     * Instance de la liste utilisée pour les tests.
     */
    private DLinkList<Integer> dLinkList;

    /**
     * Initialise une nouvelle instance de {@link DLinkList} avant chaque test.
     * Garantit l'indépendance des tests.
     */
    @BeforeEach
    void setUp() {
        dLinkList = new DLinkList<>();
    }

    /**
     * Nettoie les ressources après chaque test en invalidant l'instance de la liste.
     */
    @AfterEach
    void tearDown() {
        dLinkList = null;
    }

    /**
     * Teste l'insertion d'éléments en début de liste.
     * Vérifie que le dernier élément ajouté devient la nouvelle tête de liste.
     */
    @Test
    void addFirst() {
        dLinkList.addFirst(1);
        dLinkList.addFirst(2);
        // Attendu : [2, 1]
        assertEquals("[2, 1]", dLinkList.toString(), "L'élément ajouté en premier doit être en tête.");
    }

    /**
     * Teste l'insertion d'éléments en fin de liste.
     * Vérifie que l'ordre d'insertion est préservé.
     */
    @Test
    void addLast() {
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        // Attendu : [1, 2]
        assertEquals("[1, 2]", dLinkList.toString(), "L'ordre d'insertion doit être respecté.");
    }

    /**
     * Teste la suppression du premier élément.
     * Vérifie que la méthode retourne la bonne valeur et met à jour la structure.
     * Teste également le comportement sur une liste vide.
     */
    @Test
    void removeFirst() {
        dLinkList.addLast(10);
        dLinkList.addLast(20);

        Integer removed = dLinkList.removeFirst();

        assertAll(
                () -> assertEquals(10, removed, "Le premier élément supprimé devrait être 10."),
                () -> assertEquals("[20]", dLinkList.toString(), "La liste devrait contenir uniquement 20."),
                () -> {
                    dLinkList.removeFirst(); // Vide la liste
                    assertNull(dLinkList.removeFirst(), "La suppression sur une liste vide doit retourner null.");
                }
        );
    }

    /**
     * Teste la suppression du dernier élément.
     * Vérifie que le dernier nœud est correctement détaché et sa valeur retournée.
     */
    @Test
    void removeLast() {
        dLinkList.addLast(10);
        dLinkList.addLast(20);

        Integer removed = dLinkList.removeLast();

        assertEquals(20, removed, "Le dernier élément supprimé devrait être 20.");
        assertEquals("[10]", dLinkList.toString(), "La liste devrait être mise à jour après suppression.");
    }

    /**
     * Teste la méthode {@code toString()}.
     * Vérifie le formatage pour une liste vide et une liste contenant plusieurs éléments.
     */
    @Test
    void testToString() {
        // Cas : Liste vide
        assertEquals("[]", dLinkList.toString(), "Une liste vide doit être représentée par [].");

        // Cas : Liste avec éléments
        dLinkList.addLast(1);
        dLinkList.addLast(2);
        dLinkList.addLast(3);
        assertEquals("[1, 2, 3]", dLinkList.toString(), "Le formatage des éléments doit être correct.");
    }
}
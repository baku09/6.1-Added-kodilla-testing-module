package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {

    @Test
    void testGetBooks() {
        //Given
        Library library = new Library("Oryginalna Biblioteka");
        Book book1 = new Book("Harry i Potter i Insygnia Śmierci część 1", "J.K.Rowling", LocalDate.of(2010, 12, 14));
        Book book2 = new Book("Harry i Potter i Insygnia Śmierci część  2", "J.K.Rowling", LocalDate.of(2014, 12, 12));
        library.getBooks().add(book1);
        library.getBooks().add(book2);

        //When
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.clone();
            clonedLibrary.setName("Sklonowana Bibliotka ");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //Then
        assertEquals(2, library.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(library.getBooks(), clonedLibrary.getBooks());
        assertNotEquals(library, clonedLibrary);
        System.out.println("Original Library:");
        System.out.println(library.getName());
        System.out.println("Cloned Library:");
        System.out.println(clonedLibrary.getName());
    }
}

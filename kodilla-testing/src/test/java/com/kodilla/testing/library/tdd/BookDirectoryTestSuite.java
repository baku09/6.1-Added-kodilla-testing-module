package com.kodilla.testing.library.tdd;
import com.kodilla.testing.library.Book;
import com.kodilla.testing.library.BookLibrary;
import com.kodilla.testing.library.LibraryDatabase;
import com.kodilla.testing.library.LibraryUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookDirectoryTestSuite {
    @Test
    void testListBooksInHandsOfWhenUserHasNoBooks() {
        // Given
        LibraryDatabase libraryDatabase = mock(LibraryDatabase.class);
        BookLibrary library = new BookLibrary(libraryDatabase);
        LibraryUser user = new LibraryUser("Jakub", "Bąk", "252536");

        // When
        when(libraryDatabase.listBooksInHandsOf(user)).thenReturn(new ArrayList<>());
        List<Book> booksInHands = library.listBooksInHandsOf(user);

        // Then
        assertTrue(booksInHands.isEmpty());
    }

    @Test
    void testListBooksInHandsOfWhenUserHasOneBook() {
        // Given
        LibraryDatabase libraryDatabase = mock(LibraryDatabase.class);
        BookLibrary library = new BookLibrary(libraryDatabase);
        LibraryUser user = new LibraryUser("Jakub", "Bąk", "47854");
        Book book = new Book("Harry Potter", "J.K. Rowling", 2022);

        // When
        when(libraryDatabase.listBooksInHandsOf(user)).thenReturn(Collections.singletonList(book));
        List<Book> booksInHands = library.listBooksInHandsOf(user);

        // Then
        assertEquals(1, booksInHands.size());
        assertTrue(booksInHands.contains(book));
    }

    @Test
    void testListBooksInHandsOfWhenUserHasFiveBooks() {
        // Given
        LibraryDatabase libraryDatabase = mock(LibraryDatabase.class);
        BookLibrary library = new BookLibrary(libraryDatabase);
        LibraryUser user = new LibraryUser("Jakub", "Bąk", "201234");

        // When
        List<Book> userBooks = Arrays.asList(
                new Book("Book 1", "Author 1", 2021),
                new Book("Book 2", "Author 2",2022),
                new Book("Book 3", "Author 3",2003),
                new Book("Book 4", "Author 4",212),
                new Book("Book 5", "Author 5",2014)
        );
        when(libraryDatabase.listBooksInHandsOf(user)).thenReturn(userBooks);
        List<Book> booksInHands = library.listBooksInHandsOf(user);

        // Then
        assertEquals(5, booksInHands.size());
    }
}

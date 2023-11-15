package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary implements LibraryDatabase{
    LibraryDatabase libraryDatabase;


    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }


    @Override
    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        // Implementacja metody
        return libraryDatabase.listBooksInHandsOf(libraryUser);
    }

    @Override
    public boolean rentABook(LibraryUser libraryUser, Book book) {
        return false;
    }

    @Override
    public int returnBooks(LibraryUser libraryUser) {
        return 0;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }


}
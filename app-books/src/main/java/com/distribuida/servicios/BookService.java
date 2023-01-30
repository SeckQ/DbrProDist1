package com.distribuida.servicios;

import com.distribuida.db.Book;

import java.util.List;
import java.util.concurrent.ExecutionException;

public interface BookService {

    List<Book> findAllBooks() throws ExecutionException, InterruptedException;
    Book findBookById(Integer id) throws ExecutionException, InterruptedException;
    void insertBook(Book book) throws ExecutionException, InterruptedException;
    void updateBook(Integer id,Book book) throws ExecutionException, InterruptedException;
    void deleteBook(Integer id) throws ExecutionException, InterruptedException;

    void deleteBookByAuthor(Integer authorId) throws ExecutionException, InterruptedException;

}

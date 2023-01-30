package com.distribuida.rest;

import com.distribuida.db.Book;
import com.distribuida.servicios.BookService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.ExecutionException;

@ApplicationScoped
@Path("/books")
public class BookRest {
    @Inject private BookService bookService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Book findBookById(@PathParam("id") Integer id) throws ExecutionException, InterruptedException {
        System.out.println("Consultando Servicio findBookById*******************");
        return bookService.findBookById(id);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> findAllBooks () throws ExecutionException, InterruptedException {
        System.out.println("Consultando Servicio findAllBooks*******************");
        return bookService.findAllBooks();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertBook(Book book) throws ExecutionException, InterruptedException {
        System.out.println("Consultando Servicio insertBook*******************");
        bookService.insertBook(book);
        return Response.status(Response.Status.CREATED).build();
    }
    @PUT @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBook (Book book, @PathParam("id") Integer id) throws ExecutionException, InterruptedException {
        System.out.println("Consultando Servicio updateBook*******************");
        bookService.updateBook(id,book);
        return Response.status((Response.Status.OK) ).build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteBook (@PathParam("id") Integer id) throws ExecutionException, InterruptedException {
        System.out.println("Consultando Servicio deleteBook*******************");
        bookService.deleteBook(id);
        return Response.status((Response.Status.NO_CONTENT) ).build();
    }

    @DELETE
    @Path("/author/{authorId}")
    public Response deleteByAuthor(@PathParam("authorId") Integer authorId) throws ExecutionException, InterruptedException {
        bookService.deleteBookByAuthor(authorId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

}

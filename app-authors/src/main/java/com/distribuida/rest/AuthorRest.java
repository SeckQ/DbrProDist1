package com.distribuida.rest;


import com.distribuida.db.Author;
import com.distribuida.servicios.AuthorService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorRest {

    @Inject
    private AuthorService authorRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author findAuthorById(@PathParam("id") Long id){
        System.out.println("Consultando Servicio findAuthorById*******************");
        return authorRepository.findAuthorById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> findAllAuthors(){
        System.out.println("Consultando Servicio findAllAuthors*******************");
        return authorRepository.findAllAuthors();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void insertAuthor(Author author) {
        System.out.println("Consultando Servicio insertAuthor*******************");
        authorRepository.insertAuthor(author);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateAuthor(Author author, @PathParam("id") Long id) {
        System.out.println("Consultando Servicio updateAuthor*******************");
        authorRepository.updateAuthor(author, id);

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteAuthor(@PathParam("id") Long id) {
        System.out.println("Consultando Servicio deleteAuthor*******************");
        authorRepository.deleteAuthor(id);
    }
}

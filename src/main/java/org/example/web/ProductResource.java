package org.example.web;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.model.Product;
import org.example.service.ProductService;

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    @Inject
    private ProductService productService;

    @GET
    public List<Product> getAll() {
        return productService.getProducts();
    }

    @GET
    @Path("/{id}")
    public Product getById(@PathParam("id") Long id) {
        return productService.getById(id);
    }

    @POST
    public void create(Product p) {
        productService.save(p);
    }

    @PUT
    @Path("/{id}")
    public void update(@PathParam("id") Long id, Product p) {
        p.setId(id);
        productService.update(p);
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Long id) {
        productService.delete(id);
    }
}

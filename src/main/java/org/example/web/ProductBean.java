package org.example.web;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jdk.jfr.Name;
import org.example.model.Product;
import org.example.service.ProductService;

import java.io.Serializable;

@Name("productBean")
@RequestScoped  // with jsf
public class ProductBean implements Serializable {
    private Long id;
    private Product product;

    @Inject
    private ProductService productService;

    public void load() {
        if (id != null && product == null) {
            product = productService.getById(id);
        }
    }

    public String update() {
        productService.update(product);
        return "shop.xhtml?faces-redirect=true";
    }

    public String delete() {
        productService.delete(product.getId());
        return "shop.xhtml?faces-redirect=true";
    }

    // Getters and Setters
    public void setId(Long id) { this.id = id; }
    public Long getId() { return id; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }
}

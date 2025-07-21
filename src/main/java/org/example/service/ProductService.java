package org.example.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Product;
import org.example.repository.ProductRepository;

import java.io.IOException;
import java.util.List;

@ApplicationScoped
public class ProductService {
    @Inject
    private ProductRepository productRepository;

    public void createProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Product product = new Product();
        product.setName(req.getParameter("name"));
        product.setPrice(Double.parseDouble(req.getParameter("price")));
        product.setDescription(req.getParameter("description"));
        product.setImagePath(req.getParameter("imagePath"));

        this.productRepository.save(product);
        res.sendRedirect(req.getContextPath() + "/shop");
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getById(Long id) {
        return productRepository.findById(id);
    }

    public void update(Product p) {
        productRepository.update(p);
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }

    public void save(Product p){
        productRepository.save(p);
    }
}

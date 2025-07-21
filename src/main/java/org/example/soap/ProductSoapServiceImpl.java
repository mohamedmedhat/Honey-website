package org.example.soap;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import org.example.model.Product;
import org.example.service.ProductService;

import java.util.List;
// JAX-WS
@Stateless
@WebService(endpointInterface = "org.example.ws.ProductSoapService") // http://localhost:8080/honey/ProductSoapServiceImpl?wsdl
public class ProductSoapServiceImpl implements ProductSoapService {

    @Inject
    private ProductService service;

    public List<Product> getAll() {
        return service.getProducts();
    }

    @Override
    public Product getById(Long id) {
        return service.getById(id);
    }
}

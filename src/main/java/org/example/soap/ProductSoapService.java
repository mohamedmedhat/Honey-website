package org.example.soap;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.example.model.Product;

import java.util.List;

@WebService
public interface ProductSoapService {
    @WebMethod
    List<Product> getAll();

    @WebMethod
    Product getById(@WebParam(name = "id") Long id);
}

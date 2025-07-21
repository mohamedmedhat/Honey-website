package org.example.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.Product;
import org.example.service.ProductService;

import java.io.IOException;
import java.util.List;

@WebServlet("/shop")
public class ProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    public void init() {
        this.productService = (ProductService) getServletContext().getAttribute("productService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        switch (action) {
            case "edit":
                Long id = Long.parseLong(req.getParameter("id"));
                Product product = productService.getById(id);
                req.setAttribute("product", product);
                req.getRequestDispatcher("/WEB-INF/views/edit-product.jsp").forward(req, resp);
                break;
            case "delete":
                id = Long.parseLong(req.getParameter("id"));
                productService.delete(id);
                resp.sendRedirect(req.getContextPath() + "/shop");
                break;
            default:
                List<Product> products = productService.getProducts();
                req.setAttribute("products", products);
                req.getRequestDispatcher("/WEB-INF/views/shop.jsp").forward(req, resp);
                break;
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idParam = req.getParameter("id");
        Product product = (idParam != null && !idParam.isEmpty())
                ? productService.getById(Long.parseLong(idParam))
                : new Product();

        product.setName(req.getParameter("name"));
        product.setPrice(Double.parseDouble(req.getParameter("price")));
        product.setDescription(req.getParameter("description"));
        product.setImagePath(req.getParameter("imagePath"));

        if (idParam != null && !idParam.isEmpty()) {
            productService.update(product);
        } else {
            productService.save(product);
        }

        resp.sendRedirect(req.getContextPath() + "/shop");
    }


}

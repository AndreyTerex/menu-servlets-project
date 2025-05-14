package org.example.menu.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.menu.entity.Product;
import org.example.menu.entity.User;
import org.example.menu.service.ProductService;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(urlPatterns = "/secure/product")
public class ProductServlet extends HttpServlet {
    ProductService productService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        productService = (ProductService) config.getServletContext().getAttribute("productService");


    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        List<Product> products = productService.FindProductsByUserId(user.getId());
        req.setAttribute("products", products);
        req.getRequestDispatcher("/secure/productMenu.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String productName =  req.getParameter("productName");
        String productPrice = req.getParameter("productPrice");
        String productImage = req.getParameter("productImage");
        productService.save(productName,user.getId(), productPrice,productImage);
        resp.sendRedirect("/secure/product");
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String productId = req.getParameter("product-id");
        productService.removeByID(UUID.fromString(productId));
        resp.sendRedirect("/secure/product");
    }
}

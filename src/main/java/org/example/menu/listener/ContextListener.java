package org.example.menu.listener;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.example.crudmenu.dao.ProductDao;
import org.example.crudmenu.dao.UserDao;
import org.example.crudmenu.service.LoginAttemptsService;
import org.example.crudmenu.service.ProductService;
import org.example.crudmenu.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;

@WebListener
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        ObjectMapper objectMapper = new ObjectMapper();
        File userFile = new File("D:\\GIT\\menu\\src\\main\\resources\\users.json");
        File productFile = new File("D:\\GIT\\menu\\src\\main\\resources\\products.json");

        UserDao userDao = new UserDao(objectMapper,userFile);
        ProductDao productDao = new ProductDao(objectMapper,productFile);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        UserService userService = new UserService(userDao,encoder);
        ProductService productService = new ProductService(productDao,encoder);
        LoginAttemptsService loginAttemptsService = new LoginAttemptsService();
        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("productService", productService);
        servletContext.setAttribute("loginAttemptsService", loginAttemptsService);

    }
}

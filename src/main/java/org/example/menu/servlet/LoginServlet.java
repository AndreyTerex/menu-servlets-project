package org.example.menu.servlet;

import java.io.*;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.example.crudmenu.service.LoginAttemptsService;
import org.example.crudmenu.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    BCryptPasswordEncoder encoder;
    UserService userService;
    LoginAttemptsService loginAttemptsService;


    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        userService = (UserService) config.getServletContext().getAttribute("userService");
        encoder = (BCryptPasswordEncoder) config.getServletContext().getAttribute("encoder");
        loginAttemptsService = (LoginAttemptsService) config.getServletContext().getAttribute("loginAttemptsService");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("user") == null) {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/secure/accountMenu");
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if(loginAttemptsService.registerLoginAttempt(login,resp)){
            resp.sendError(HttpServletResponse.SC_FORBIDDEN);
        }
        else if (userService.findUserByCredentials(login, password).isPresent()) {
            HttpSession session = req.getSession();
            session.setAttribute("user", userService.findUserByCredentials(login, password).get());
            loginAttemptsService.resetLoginAttempt(login);
            resp.sendRedirect("/secure/accountMenu");
        }
        else{
                resp.sendRedirect("/login");
            }
        }
    }
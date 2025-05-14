package org.example.menu.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/secure/*")
public class AutoServletSecureFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession();

        boolean loggedIn = (session.getAttribute("user") !=null);

        if (loggedIn) {
            chain.doFilter(req, res); // пользователь авторизован, продолжаем
        } else {
            response.sendRedirect("/login"); // редирект на главную
        }
    }
}

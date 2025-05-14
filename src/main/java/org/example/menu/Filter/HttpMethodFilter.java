package org.example.menu.Filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class HttpMethodFilter extends HttpFilter {
    private final List<String> httpMethods = List.of("DELETE","PUT","PATCH");




    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String method = req.getParameter("_method");

        if(method != null && httpMethods.contains(method)) {
            HttpServletRequestWrapper requestWrapper = new HttpServletRequestWrapper(req) {
                @Override
                public String getMethod() {
                    return method;
                }
            };
            chain.doFilter(requestWrapper, res);
        }else {
            chain.doFilter(req, res);
        }
    }
}

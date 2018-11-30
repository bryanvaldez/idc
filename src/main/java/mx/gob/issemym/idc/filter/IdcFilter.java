/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.gob.issemym.idc.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

/**
 *
 * @author Bryan Valdez Jara <Bryan at ibryan.valdez@gmail.com>
 */
public class IdcFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        if (SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated() && ((HttpServletRequest) request).getRequestURI().equals("/login")) {
//            System.out.println("Usuario Authenticado redireccionado al main");
//            ((HttpServletResponse) response).sendRedirect("/");
//        }
//        if (SecurityContextHolder.getContext().getAuthentication() == null && !((HttpServletRequest) request).getRequestURI().equals("/login")) {
//            System.out.println("Usuario no Authenticado redireccionado al login");
//            ((HttpServletResponse) response).sendRedirect("/login");
//        }
        chain.doFilter(request, response);
    }

}

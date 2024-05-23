package com.emergentes.controlador;

import com.emergentes.utiles.Validate;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Validate validator = new Validate();
        if (validator.checkUser(email, password)) {
            HttpSession session = request.getSession(); 
            session.setAttribute("login", "Ok");
            response.sendRedirect("ClienteControlador");
        } else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

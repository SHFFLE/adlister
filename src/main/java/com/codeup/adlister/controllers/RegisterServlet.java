package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.UsersDao;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if(DaoFactory.getUsersDao().findByUsername(username) != null){
            response.sendRedirect("/login");
        } else if (password.isEmpty()){
            response.sendRedirect("/login");
        } else if (!email.contains("@")){
            response.sendRedirect("/login");
        } else {
            User validUser = new User();
            validUser.setUsername(username);
            validUser.setPassword(password);
            validUser.setEmail(email);
            validUser.setId(DaoFactory.getUsersDao().insert(validUser));
            request.getSession().setAttribute("user", validUser);
            response.sendRedirect("/profile");

        }
    }
}

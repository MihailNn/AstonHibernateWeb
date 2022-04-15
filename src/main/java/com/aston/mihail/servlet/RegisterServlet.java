package com.aston.mihail.servlet;

import com.aston.mihail.dao.UserDao;
import com.aston.mihail.model.User;
import com.aston.mihail.service.HashPassword;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("newLoginName");
        String password = request.getParameter("newPassword");
        UserDao userDao = new UserDao();
        User user = new User(login, HashPassword.getHash(password));
        try {
            if (userDao.save(user)) {
                request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward( request, response);
            } else{
                request.setAttribute("errorRegister", "Выберите другое имя, такой пользователь существет");
                request.getRequestDispatcher("/WEB-INF/views/register.jsp") .forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/register.jsp")
                .forward(request, response);
    }
}

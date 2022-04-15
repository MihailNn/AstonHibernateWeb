package com.aston.mihail.servlet;

import com.aston.mihail.dao.OwnerDao;
import com.aston.mihail.model.Owner;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "OwnerListServlet", value = "/OwnerListServlet")
public class OwnerListServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        OwnerDao ownerDao = new OwnerDao();
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone = request.getParameter("phone");
        String email= request.getParameter("email");
        try {
            if (name.isBlank() || surname.isBlank() ||phone.isBlank() || email.isBlank()) {
                request.setAttribute("errorMessage", "Заполните все поля");
            } else {
                ownerDao.save(new Owner(name, surname, phone, email));
            }
            request.setAttribute("group", ownerDao.findAll());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OwnerDao ownerDao = new OwnerDao();
        try {
            request.setAttribute("group", ownerDao.findAll());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("/WEB-INF/views/welcome.jsp")
                .forward(request, response);
    }
}
package com.webnote.Controler.Wellcome;

import com.webnote.Model.Function.Wellcome.Register;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class RegisterControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        String password2 = request.getParameter("password2");

        Register register = new Register();
        boolean isSuccess = register.register(username, password, name, password2);
        if (!isSuccess) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("register.jsp");
            request.setAttribute("message", register.getMessage());
            register.getMessage();
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else if (isSuccess) {
            response.sendRedirect("login.jsp");
        }
    }
}
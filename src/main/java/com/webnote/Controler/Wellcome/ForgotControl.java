package com.webnote.Controler.Wellcome;

import com.webnote.Model.Function.Wellcome.Forgot;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ForgotPass", value = "/forgot")
public class ForgotControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        String username = request.getParameter("email");
        String password2 = request.getParameter("password2");
        String password = request.getParameter("password");

        Forgot forgot = new Forgot();
        boolean isSuccess = forgot.forgotPass(username, password2, password);
        if (isSuccess) {
            response.sendRedirect("login.jsp");
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("forgot.jsp");
            request.setAttribute("message", forgot.getMessage());
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}

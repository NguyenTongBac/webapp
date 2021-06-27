package com.webnote.Controler.Wellcome;

import com.webnote.Model.Function.Wellcome.Login;
import com.webnote.Model.Database.Note;
import com.webnote.Model.Service.DoNote;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "login", value = "/login")
public class LoginControl extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        String password = session.getAttribute("password").toString();
        Login login = new Login();
        DoNote doNote = new DoNote();
        boolean isSuccess = login.login(username, password);
        if (isSuccess) {
            List<Note> notes = doNote.getAllNotes(username);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
            request.setAttribute("up", login.getCustomer());
            request.setAttribute("listS", notes);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            request.setAttribute("message", login.getMessage());
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        String username = request.getParameter("email");
        String password = request.getParameter("password");
        Login login = new Login();

        boolean isSuccess = login.login(username, password);
        if (isSuccess) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            DoNote doNote = new DoNote();
            List<Note> notes = doNote.getAllNotes(username);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
            request.setAttribute("listS", notes);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            request.setAttribute("message", login.getMessage());
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}
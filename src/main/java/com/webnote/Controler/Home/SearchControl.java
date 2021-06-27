package com.webnote.Controler.Home;

import com.webnote.Model.Function.Home.Search;
import com.webnote.Model.Function.Wellcome.Login;
import com.webnote.Model.Database.Note;
import com.webnote.Model.Service.DoNote;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet", value = "/search")
public class SearchControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html:charset=utf-8");
        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();
        String search = request.getParameter("searchTileNote");
        Search search1 = new Search();
        boolean isSuccess = search1.search(username, search);
        if (isSuccess) {
            DoNote doNote = new DoNote();
            List<Note> notes = doNote.getListNotes(username, search);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
            request.setAttribute("listS", notes);
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        } else {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("errors.jsp");
            request.setAttribute("message", "search failed");
            try {
                requestDispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }
    }
}

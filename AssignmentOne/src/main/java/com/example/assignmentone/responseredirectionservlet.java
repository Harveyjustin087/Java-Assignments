package com.example.assignmentone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseredirectionservlet", value = "/responseredirectionservlet")
public class responseredirectionservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        String url = request.getParameter("searchEngine");
        if (url != null) {
            response.sendRedirect(url);
        } else {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("No search engine was selected.");
        }
    }
}
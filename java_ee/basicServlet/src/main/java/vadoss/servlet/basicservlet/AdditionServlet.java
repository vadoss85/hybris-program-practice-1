package vadoss.servlet.basicservlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "AdditionServlet", value = "/AdditionServlet")
public class AdditionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("number1") != null && request.getParameter("number2") != null) {
            Long num1 = Long.parseLong(request.getParameter("number1"));
            Long num2 = Long.parseLong(request.getParameter("number2"));

            PrintWriter writer = response.getWriter();

            writer.println("the sum is: " + (num1 + num2));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

package vadoss.userapplicationusecase.userapplicationusecase;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

//@WebServlet(name = "ReadUserServlet", value = "/readUserServlet")
public class ReadUserServlet extends HttpServlet {
    private Connection connection;

    public void init(ServletConfig config) {
        try {
            ServletContext context = config.getServletContext();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from user");
            PrintWriter writer = response.getWriter();

            writer.print("<table>");
            writer.print("<tr>");
            writer.print("<th>");
            writer.print("First name");
            writer.print("</th>");
            writer.print("<th>");
            writer.print("last name");
            writer.print("</th>");
            writer.print("<th>");
            writer.print("Email");
            writer.print("</th>");
            writer.print("<tr>");

            while (result.next()) {
                writer.println("<tr>");
                writer.println("<td>");
                writer.println(result.getString(1));
                writer.println("</td>");
                writer.println("<td>");
                writer.println(result.getString(2));
                writer.println("</td>");
                writer.println("<td>");
                writer.println(result.getString(3));
                writer.println("</td>");
                writer.println("</tr>");
            }
            writer.print("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void destroy() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

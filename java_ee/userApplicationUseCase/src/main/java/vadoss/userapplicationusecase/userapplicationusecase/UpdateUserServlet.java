package vadoss.userapplicationusecase.userapplicationusecase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "UpdateUserServlet", value = "/updateServlet")
public class UpdateUserServlet extends HttpServlet {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("update user set password='" + password + "' where email='" + email + "'");

            PrintWriter writer = response.getWriter();
            if (result > 0) {
                writer.print("<h1>Password updated<h1>");
            } else {
                writer.print("<h1>Error updating password<h1>");
            }
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

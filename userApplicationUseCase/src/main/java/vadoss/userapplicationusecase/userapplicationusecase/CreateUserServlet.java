package vadoss.userapplicationusecase.userapplicationusecase;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/addServlet", initParams = {@WebInitParam(name="dbUrl",value = "jdbc:mysql://localhost/mydb"), @WebInitParam(name="dbUser", value = "admin"), @WebInitParam(name="dbPassword",value = "_PASSword1_")})
public class CreateUserServlet extends HttpServlet {
    private Connection connection;

    public void init(ServletConfig config) {
        try {
            ServletContext context = config.getServletContext();

            Enumeration<String> params =  context.getInitParameterNames();

            while (params.hasMoreElements()) {
                String n = params.nextElement();
                System.out.println("Context param: " + n);
                System.out.println("Context param value: " + context.getInitParameter(n));
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(context.getInitParameter("dbUrl"), context.getInitParameter("dbUser"), context.getInitParameter("dbPassword"));
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate("insert into user values('" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "')");

            PrintWriter writer = response.getWriter();
            if (result > 0) {
                writer.print("<h1>User created<h1>");
            } else {
                writer.print("<h1>Error creating the user<h1>");
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

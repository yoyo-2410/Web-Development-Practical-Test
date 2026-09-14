import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userservlet")
public class userservlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private final String USERNAME = "admin";
    private final String PASSWORD = "12345";

    public userservlet() {
        super();
    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.getWriter().append("Served at: ")
                .append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        // Get parameters from HTML form
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        out.println("<html><body>");

        // Validate user
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {

            out.println("<h2>Login Successful!</h2>");
            out.println("<p>Welcome, " + username + "!</p>");

        } else {

            out.println("<h2>Login Failed!</h2>");
            out.println("<p>Invalid username or password.</p>");
        }

        out.println("<br><a href='user.html'>Back to Login</a>");
        out.println("</body></html>");
    }
}

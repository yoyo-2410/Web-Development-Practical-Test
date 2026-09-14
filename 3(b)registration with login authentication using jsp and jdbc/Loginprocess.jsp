<%@ page import="java.sql.*" %>

<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/batchb",
            "root",
            ""
        );

        ps = con.prepareStatement(
            "SELECT * FROM users WHERE username=? AND password=?"
        );

        ps.setString(1, username);
        ps.setString(2, password);

        rs = ps.executeQuery();

        if (rs.next()) {

            session.setAttribute("username", username);

            response.sendRedirect("welcome.jsp");

        } else {

            out.println("<h3>Invalid Username or Password</h3>");
            out.println("<a href='login.jsp'>Try Again</a>");
        }

    } catch (Exception e) {

        out.println("Exception: " + e.getMessage());

    } finally {

        if (rs != null)
            rs.close();

        if (ps != null)
            ps.close();

        if (con != null)
            con.close();
    }
%>

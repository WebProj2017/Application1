package controller;

import java.io.IOException;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import repository.AccountRepository;
import util.Encript;
import util.Settings;

/**
 *
 * @author IU-CSE Team
 */

@WebServlet("/GetFeed")
public class GetFeed extends HttpServlet {

    public static String name() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        
        String name =request.getParameter("nameF");
        String phone=request.getParameter("fonoF");
        String mail = request.getParameter("mailF");
        String Interested =request.getParameter("use");
        String Issuecode = request.getParameter("sub");
        String contain = request.getParameter("feed");
        Settings.removeWebUserSession(request);
        out.println("<h2>YOUR SUBMIT HAS BEEN RECORDED");
        response.sendRedirect("index.jsp");
    }

}

package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author IU-CSE Team
 */
@WebServlet("/Series3API")
public class Series3API extends HttpServlet {

    public static final String SERIES3_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"320i\",\"productName\":\"BMW 320i\","
            + "\"productPrice\":38.000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/320i.jpeg\"},"
            + "{\"productId\":\"330i\",\"productName\":\"BMW 330i\","
            + "\"productPrice\":46.000,\"supplierId\":\"S004\",";
            

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(SERIES3_JSON_STRING);
    }

}

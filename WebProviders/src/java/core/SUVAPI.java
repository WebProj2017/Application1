package core;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author IU-CSE Team
 */
@WebServlet("/suvApi")
public class SUVAPI extends HttpServlet {

    public static final String SUV_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"x3\",\"productName\":\"BMW X3 25i\","
            + "\"productPrice\":43000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/x3.png\"},"
            + "{\"productId\":\"x5\",\"productName\":\"BMW X5 35d\","
            + "\"productPrice\":61000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/x5.jpg\"}]}";
            

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(SUV_JSON_STRING);
//       Gson gson = new Gson();
//       String test = gson.toJson(new Category());
    }

}

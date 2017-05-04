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
@WebServlet("/savApi")
public class SAVAPI extends HttpServlet {

    public static final String SAV_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"x4\",\"productName\":\"BMW X4 35i\","
            + "\"productPrice\":50000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/x4.jpg\"},"
            + "{\"productId\":\"x6\",\"productName\":\"BMW X6 45i\","
            + "\"productPrice\":63000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/x6.jpg\"}]}";
            

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(SAV_JSON_STRING);
//       Gson gson = new Gson();
//       String test = gson.toJson(new Category());
    }

}

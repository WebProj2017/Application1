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
@WebServlet("/dreamcarApi")
public class DreamCarAPI extends HttpServlet {

    public static final String DREAMCAR_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"420ic\",\"productName\":\"BMW 420i Coupe\","
            + "\"productPrice\":45500,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/420ic.jpg\"},"
            + "{\"productId\":\"420icv\",\"productName\":\"BMW 420i Convertible\","
            + "\"productPrice\":53000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/420icv.jpg\"},"            
            + "{\"productId\":\"640ic\",\"productName\":\"BMW 640i Gran Coupe\","
            + "\"productPrice\":83000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/640ic.jpg\"}]}";
            

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(DREAMCAR_JSON_STRING);
//       Gson gson = new Gson();
//       String test = gson.toJson(new Category());
    }

}

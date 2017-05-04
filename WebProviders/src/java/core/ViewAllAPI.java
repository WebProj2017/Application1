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
@WebServlet("/ViewAllAPI")
public class ViewAllAPI extends HttpServlet {

    public static final String VIEWALL_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"320i\",\"productName\":\"BMW 320i\","
            + "\"productPrice\":38000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/320i.jpeg\"},"
            + "{\"productId\":\"330i\",\"productName\":\"BMW 330i\","
            + "\"productPrice\":46000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/330i.jpg\"},"
            + "{\"productId\":\"320iGT\",\"productName\":\"BMW 320i GT\","
            + "\"productPrice\":46000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/320igt.jpg\"},"
            + "{\"productId\":\"330iGT\",\"productName\":\"BMW 330i GT\","
            + "\"productPrice\":46000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/320igt.jpg\"}]}";
            

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(VIEWALL_JSON_STRING);
//       Gson gson = new Gson();
//       String test = gson.toJson(new Category());
    }

}

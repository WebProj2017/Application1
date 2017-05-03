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
@WebServlet("/series7Api")
public class Series7API extends HttpServlet {

    public static final String SERIES7_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"730Li\",\"productName\":\"BMW 730Li\","
            + "\"productPrice\":99000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/730li.jpg\"},"
            + "{\"productId\":\"740Li\",\"productName\":\"BMW 740Li\","
            + "\"productPrice\":120000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/740li.png\"},"
            + "{\"productId\":\"750Li\",\"productName\":\"BMW 750Li\","
            + "\"productPrice\":150000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/750li.jpg\"}]}";
            

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(SERIES7_JSON_STRING);
//       Gson gson = new Gson();
//       String test = gson.toJson(new Category());
    }

}

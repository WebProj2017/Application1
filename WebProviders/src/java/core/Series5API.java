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
@WebServlet("/series5Api")
public class Series5API extends HttpServlet {

    public static final String SERIES5_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"520i\",\"productName\":\"BMW 520i\","
            + "\"productPrice\":52000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/520i.jpg\"},"
            + "{\"productId\":\"530i\",\"productName\":\"BMW 530i\","
            + "\"productPrice\":58000,\"supplierId\":\"S004\","
            + "\"info\":\"/WebProviders/images/530i.jpg\"}]}";
            

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(SERIES5_JSON_STRING);
//       Gson gson = new Gson();
//       String test = gson.toJson(new Category());
    }

}

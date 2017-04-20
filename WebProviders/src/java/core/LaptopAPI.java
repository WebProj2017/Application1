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
@WebServlet("/laptopApi")
public class LaptopAPI extends HttpServlet {

    public static final String LAPTOP_JSON_STRING = "{\"products\":["
            + "{\"productId\":\"lap1\",\"productName\":\"Microsoft Surface Book\","
            + "\"productPrice\":850.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/MSBook.jpg\"},"
            + "{\"productId\":\"lap2\",\"productName\":\"Macbook Pro Retina 2016 Touchbar\","
            + "\"productPrice\":1250.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/MBP2016.jpeg\"},"
            + "{\"productId\":\"lap3\",\"productName\":\"Dell XPS 13\","
            + "\"productPrice\":750.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/xps13.jpq\"},"
            + "{\"productId\":\"lap4\",\"productName\":\"HP EliteBook\","
            + "\"productPrice\":550.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/elite.jpg\"},"
            + "{\"productId\":\"lap5\",\"productName\":\"Asus Zenbook\","
            + "\"productPrice\":450.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/zenbook.jpg\"},"
            + "{\"productId\":\"lap6\",\"productName\":\"Samsung Notebook 9\","
            + "\"productPrice\":850.0,\"supplierId\":\"S001\","
            + "\"info\":\"/WebProviders/images/note9.jpg\"}]}";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.print(LAPTOP_JSON_STRING);
    }

}

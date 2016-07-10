import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by Gvozd on 10.07.2016.
 */
public class SessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        session.setAttribute("answer", req.getParameter("answer"));
        out.println("Your last answer was: "+ session.getAttribute("answer") +"\n");

        out.println("Attribs:");
        Enumeration sesNames = session.getAttributeNames();
        while (sesNames.hasMoreElements()) {
            String name = sesNames.nextElement().toString();
            Object value = session.getAttribute(name);
            out.println(name + " = " + value + "<br>");
        }

        out.println("<!DOCTYPE HTML> \n <html>\n <head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <title>Тег META, атрибут charset</title>\n" +
                " </head>\n"  +
                " <body>\n");

        out.println("<form action=\"/HelloWorld\">\n" +
                "  <p><b>Как по вашему мнению расшифровывается аббревиатура &quot;ОС&quot;?</b></p>\n" +
                "  <p><input type=\"radio\" name=\"answer\" value=\"a1\">Офицерский состав<Br>\n" +
                "  <input type=\"radio\" name=\"answer\" value=\"a2\">Операционная система<Br>\n" +
                "  <input type=\"radio\" name=\"answer\" value=\"a3\">Большой полосатый мух</p>\n" +
                "  <p><input type=\"submit\"></p>\n" +
                " </form>");

        out.println("</body>\n +" +
                " </html>");

    }
}

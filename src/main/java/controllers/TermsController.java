package controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "TermsController", urlPatterns = "/terms")
public class TermsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object count = req.getSession().getServletContext().getAttribute("countTerms");
        if(count == null) {
            req.getSession().getServletContext().setAttribute("countTerms", "1");
        }else {
            Object value = req.getSession().getServletContext().getAttribute("countTerms");
            int v = Integer.parseInt(value.toString());
            v++;
            req.getSession().getServletContext().setAttribute("countTerms", v);
        }

        resp.getWriter().print("<h1>Terms page</h1>" + req.getSession().getServletContext().getAttribute("countTerms"));
    }
}

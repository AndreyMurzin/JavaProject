package controllers;

import database.DBManager;
import entity.Discipline;
import entity.Term;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "TermsController", urlPatterns = "/terms")
public class TermsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String selected = req.getParameter("selected");
        ArrayList<Term> terms = DBManager.getAllActiveTerms();
        Term selectedTerm = null;
        if(selected == null || selected.equals("")) {
            selectedTerm = terms.get(0);
        }else {
            for (Term t: terms) {
                if (selected.equals(t.getId()+"")){
                    selectedTerm = t;
                }
            }
        }

        ArrayList<Discipline> disciplines =
                DBManager.getAllActiveDisciplinesByTerm(selectedTerm.getId());

        req.setAttribute("terms", terms);
        req.setAttribute("selectedTerm", selectedTerm);
        req.setAttribute("disciplines", disciplines);

        req.getRequestDispatcher("WEB-INF/jsp/terms.jsp").forward(req, resp);

    }
}

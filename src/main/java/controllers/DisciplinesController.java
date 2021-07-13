package controllers;

import database.DBManager;
import entity.Discipline;
import services.CookiesServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DisciplinesController", urlPatterns = "/disciplines")
public class DisciplinesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie counter = CookiesServices.getCookieByName(cookies, "counter");
        if (counter == null) {
            counter = new Cookie("counter", "1");
        }else {
            int value = Integer.parseInt(counter.getValue());
            value++;
            counter.setValue(String.valueOf(value));
        }

        resp.addCookie(counter);

        ArrayList<Discipline> disciplines = DBManager.getAllActiveDisciplines();
        req.setAttribute("disciplines", disciplines);
        req.getRequestDispatcher("WEB-INF/jsp/disciplines.jsp").forward(req, resp);
    }
}

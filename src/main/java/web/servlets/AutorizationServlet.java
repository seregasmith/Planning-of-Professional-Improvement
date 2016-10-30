package web.servlets;

import web.services.AuthorizationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Smith on 30.10.2016.
 */
public class AutorizationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Auth.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("LogOut") != null) {
            AuthorizationService.logOut(Integer.parseInt(req.getParameter("user_id")));
            req.getRequestDispatcher("/Auth.jsp").forward(req, resp);
        }
    }
}

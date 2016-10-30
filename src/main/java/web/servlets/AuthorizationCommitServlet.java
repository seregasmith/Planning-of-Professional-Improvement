package web.servlets;

import local.entities.User;
import web.services.AuthorizationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Smith on 30.10.2016.
 */
public class AuthorizationCommitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("LogIn") != null){
            String e_mail = req.getParameter("e-mail");
            String pass = req.getParameter("password");
            User user = AuthorizationService.getUserOfSystem(e_mail,pass);
            if( user != null ) {
                req.setAttribute("user", user);
                req.getRequestDispatcher("/Dashboard.jsp").forward(req,resp);
//                resp.sendRedirect(req.getContextPath() + "/dashboard");
            }else{
                resp.sendRedirect(req.getContextPath() + "/auth");
            }
        }
    }
}

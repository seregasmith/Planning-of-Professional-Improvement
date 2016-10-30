package web.servlets;

import local.entities.User;
import web.services.AuthorizationService;
import web.services.RegistrationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Smith on 30.10.2016.
 */
public class RegistrationCommitServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("OK") != null){
            User user = new User();
            user.setName( req.getParameter("name") );
            user.setSurname( req.getParameter("surname") );
            user.setEmail( req.getParameter("email") );
            String pass = req.getParameter("password");
            if(RegistrationService.registerUser(user,pass))
                resp.sendRedirect(req.getContextPath() + "/auth");
        }
    }
}

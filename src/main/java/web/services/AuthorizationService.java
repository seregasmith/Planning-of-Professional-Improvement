package web.services;

import local.db.DBWrapper;
import local.entities.User;

import java.sql.SQLException;

import static java.lang.Thread.sleep;

/**
 * Created by Smith on 30.10.2016.
 */
public class AuthorizationService {

    public static User getUserOfSystem(String email, String password){
        try {
            User user = DBWrapper.getInstance().getUser(email,password);
            if(user != null)
                DBWrapper.getInstance().setUserLoggedIn(user.getId());
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean logOut(int user_id){
        try {
            return DBWrapper.getInstance().setUserLoggedOut(user_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

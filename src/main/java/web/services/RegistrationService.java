package web.services;

import local.db.DBWrapper;
import local.entities.User;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by Smith on 30.10.2016.
 */
public class RegistrationService {
    public static boolean registerUser(User user, String password){
        try {
            return DBWrapper.getInstance().registerNewUser(user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

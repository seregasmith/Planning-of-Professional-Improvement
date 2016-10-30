package local.db;

import local.entities.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBWrapper
{
    private static Connection con;
    private static DBWrapper instance;
    private static DataSource dataSource;

    private DBWrapper() {
    }

    public static synchronized DBWrapper getInstance() {
        if (instance == null) {
            try {
                instance = new DBWrapper();
                Context ctx = new InitialContext();
                instance.dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/PPI");
                con = dataSource.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public User getUser(String email, String password) throws SQLException {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT id, name, surname, email FROM sys_user LIMIT 1");
        User user = null;
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSurname(rs.getString("surname"));
            user.setEmail(rs.getString("email"));
        }
        rs.close();
        stmt.close();
        return user;
    }

    public boolean registerNewUser(User user, String password) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO sys_user VALUES (nextval('user_id_seq'),?,?,?,?)");
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getSurname());
        stmt.setString(3, user.getEmail());
        stmt.setString(4, password);
        boolean res = stmt.execute();
        stmt.close();
        return res;
    }

    public boolean setUserLoggedIn(int user_id) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("INSERT INTO logged_user VALUES (?)");
        stmt.setInt(1, user_id);
        boolean res = stmt.execute();
        stmt.close();
        return res;
    }

    public boolean setUserLoggedOut(int user_id) throws SQLException {
        PreparedStatement stmt = con.prepareStatement("DELETE FROM logged_user WHERE  user_id = (?)");
        stmt.setInt(1, user_id);
        boolean res = stmt.execute();
        stmt.close();
        return res;
    }
}
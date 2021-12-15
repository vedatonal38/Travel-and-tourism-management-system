package com.vedat.database;

import com.vedat.modules.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Vedat Önal
 */
public class AdminDB implements Db {
    
    public static Admin query(String username, String password) throws ClassNotFoundException {
        Admin admin = null;
        String sql = "SELECT * FROM admin WHERE username=? AND password_=?";
        Class.forName(jdbc_name);
        
        try(Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int id_ = rs.getInt("id");
                String fullname = rs.getString("fullname");
                String email = rs.getString("email");
                
                admin = new Admin(id_, username, fullname, email, password);
            }
            connection.close();
        } catch(SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return admin;
    }
}

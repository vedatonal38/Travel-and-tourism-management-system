package com.vedat.database;

import static com.vedat.database.Db.drive_;
import static com.vedat.database.Db.pwd;
import static com.vedat.database.Db.root;
import com.vedat.modules.Customer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Vedat Önal
 */
public class CustomerDB implements Db {

    public static Customer query_where(String id) throws ClassNotFoundException {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE id=?";
        
        Class.forName(jdbc_name);

        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id_ = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String surname = rs.getString("surname");

                customer = new Customer(id_, username, "********", email, name, surname);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }

        
        return customer;
    }
    public static Customer query(String username_or_email, String password) throws ClassNotFoundException {
        Customer customer = null;
        String sql = "SELECT * FROM customer WHERE (username=? OR email=?) AND password_=?";
        Class.forName(jdbc_name);

        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, username_or_email);
            ps.setString(2, username_or_email);
            ps.setString(3, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id_ = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String surname = rs.getString("surname");

                customer = new Customer(id_, username, password, email, name, surname);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }

        return customer;
    }

    public static boolean insert(Customer customer) throws ClassNotFoundException {
        ArrayList<Customer> cus = getCustomers();

        if (equals_(cus, customer)) {
            String sql = "INSERT INTO customer (id, username, password_, email, name, surname) VALUES (?, ?, ?, ?, ?, ?);";
            Class.forName(jdbc_name);

            try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                    PreparedStatement ps = connection.prepareStatement(sql);) {
//            ps.setString(1, username_or_email);
                ps.setInt(1, cus.get(cus.size() - 1).getId() + 1);
                ps.setString(2, customer.getUsername());
                ps.setString(3, customer.getPassword());
                ps.setString(4, customer.getEmail());
                ps.setString(5, customer.getName());
                ps.setString(6, customer.getSurname());

                ps.execute();
                connection.close();
                return true;
            } catch (SQLException ex) {
                DbErrorMessage.printSQLException(ex);
            }
        }
        return false;
    }

    private static boolean equals_(ArrayList<Customer> cus, Customer customer) throws ClassNotFoundException {
        for (Customer c : cus) {
            if (c.equals_customer_username(customer)) {
                // aynı var mı? evet (kayıt yapma)
                return false;
            }
        }
        // aynısı yoksa (kayıt yap)
        return true;
    }

    public static ArrayList<Customer> getCustomers() throws ClassNotFoundException {
        String sql = "SELECT * FROM customer;";
        ArrayList<Customer> customers = new ArrayList<>();

        Class.forName(jdbc_name);

        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id_ = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password_");
                String email = rs.getString("email");
                String name = rs.getString("name");
                String surname = rs.getString("surname");

                Customer customer = new Customer(id_, username, password, email, name, surname);
                customers.add(customer);
            }

            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }

        return customers;
    }
}

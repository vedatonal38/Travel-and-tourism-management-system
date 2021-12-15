package com.vedat.database.Moduls;

import com.vedat.database.Db;
import static com.vedat.database.Db.drive_;
import static com.vedat.database.Db.pwd;
import static com.vedat.database.Db.root;
import com.vedat.database.DbErrorMessage;
import com.vedat.modules.BusDriver.Bus;
import com.vedat.modules.BusDriver.Seat;
import com.vedat.modules.City;
import com.vedat.modules.Country;
import com.vedat.modules.Hotels.Hotels;
import com.vedat.modules.Packages.Packages;
import com.vedat.modules.Vehicle.TypeDescription;
import com.vedat.modules.Vehicle.Vehicles;
import com.vedat.modules.reservations.BusBooking;
import com.vedat.modules.reservations.Hotel_booking;
import com.vedat.modules.reservations.PackagesBooking;
import com.vedat.modules.reservations.VehicleRenals;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vedat Önal
 */
public class ModulsDatas implements Db {
    
    public static boolean delete_vehicle(String id) throws ClassNotFoundException {
        String sql_models = "DELETE FROM models WHERE (id = ?);";
        String sql_vehicle = "DELETE FROM vehicles WHERE (id = ?);";
        Class.forName(jdbc_name);
        // MODEL TABLE DELETE
        boolean bool = true;
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql_vehicle);) {
            ps.setString(1, id);
            ps.execute();
            connection.close();
//            return true;
        } catch (SQLException ex) {
            bool = false;
            DbErrorMessage.printSQLException(ex);
        }
        // VEHİCLES TABLE DELETE
        if (bool) {
            try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                    PreparedStatement ps = connection.prepareStatement(sql_models);) {
                ps.setString(1, id);
                ps.execute();
                connection.close();
                return true;
            } catch (SQLException ex) {
                DbErrorMessage.printSQLException(ex);
            }
        }
        
        return false;
    }
    
    public static boolean update_vehicles_status_set_0(int id) throws ClassNotFoundException {
        String sql = "UPDATE vehicles SET status_ = '0' WHERE (id = ?);";
        Class.forName(jdbc_name);
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        return false;
    }
    
    public static boolean update_vehicles_status_set_1(int id) throws ClassNotFoundException {
        String sql = "UPDATE vehicles SET status_ = '1' WHERE (id = ?);";
        Class.forName(jdbc_name);
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setInt(1, id);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        return false;
    }
    
    public static void update_vehicls_full() throws ClassNotFoundException {
        ArrayList<VehicleRenals> vehicleRenalses = new ArrayList<>();
        String sql = "SELECT * FROM travel.vehicle_renals where date(date_to) = date(now());";
        Class.forName(jdbc_name);
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_ = rs.getInt("id");
                Date date_from = rs.getDate("date_from");
                Date date_to = rs.getDate("date_to");
                int cus_id = rs.getInt("Customer_id");
                int rental_status_id = rs.getInt("rental_status_id");
                int veh_id = rs.getInt("vehicles_id");
                int Admin_id = rs.getInt("Admin_id");
                VehicleRenals r = new VehicleRenals(id_, date_from, date_to, cus_id, veh_id, Admin_id, rental_status_id);
                vehicleRenalses.add(r);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        for (int i = 0; i < vehicleRenalses.size(); i++) {
            VehicleRenals renals = vehicleRenalses.get(i);
            Boolean status = update_vehicles_status_set_0(renals.getVeh_id());
            if (!status) {
                System.err.println("ERROR : update vehicls full");
            }
        }
    }
    
    public static boolean insert_vehicle_renal(VehicleRenals renals) throws ClassNotFoundException {
        String sql_desc = "INSERT INTO rental_status (id, description) VALUES (?, ?);";
        String sql_vehicle = "INSERT INTO vehicle_renals (id, date_from, date_to, Customer_id, rental_status_id, "
                + "vehicles_id, Admin_id) VALUES (?, ?, ?, ?, ?, ?, ?);";
        Class.forName(jdbc_name);
        // RENTAL STATUS TABLE INSERT INTO
        boolean bool = true;
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql_desc);) {
            ps.setInt(1, renals.getId());
            ps.setString(2, renals.getDescription());
            
            ps.execute();
            connection.close();
//            return true;
        } catch (SQLException ex) {
            bool = false;
            DbErrorMessage.printSQLException(ex);
        }

        // VEHİCLE RENALS TABLE INSERT INTO
        if (bool) {
            try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                    PreparedStatement ps = connection.prepareStatement(sql_vehicle);) {
                ps.setInt(1, renals.getId());
                ps.setDate(2, renals.getDate_from());
                ps.setDate(3, renals.getDate_to());
                ps.setInt(4, renals.getCus_id());
                ps.setInt(5, renals.getId());
                ps.setInt(6, renals.getVeh_id());
                ps.setInt(7, renals.getAdmin_id());
                
                ps.execute();
                connection.close();
                return true;
            } catch (SQLException ex) {
                DbErrorMessage.printSQLException(ex);
            }
        }
        
        return false;
    }
    
    public static boolean insert_vehicle(Vehicles vehicle) throws ClassNotFoundException {
        String sql_vehicle = "INSERT INTO vehicles (id, current_mileage, date_mot_due, engine_size, models_id, vehicle_type_id, city_id, price, brand, status_) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        
        String sql_models = "INSERT INTO models (id, daily_hire_rate, model_name) VALUES (?, ?, ?);";
        Class.forName(jdbc_name);
        // MODEL TABLE INSERT INTO
        boolean bool = true;
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql_models);) {
            ps.setInt(1, vehicle.getId());
            ps.setString(2, vehicle.getModels().getDaily_hire_rate());
            ps.setString(3, vehicle.getModels().getModel_name());
            
            ps.execute();
            connection.close();
//            return true;
        } catch (SQLException ex) {
            bool = false;
            DbErrorMessage.printSQLException(ex);
        }

        // VEHİCLES TABLE INSERT INTO
        if (bool) {
            try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                    PreparedStatement ps = connection.prepareStatement(sql_vehicle);) {
                ps.setInt(1, vehicle.getId());
                ps.setString(2, vehicle.getCurrent_mileage());
                ps.setString(3, vehicle.getDate_mot_due());
                ps.setString(4, vehicle.getEngine_size());
                ps.setInt(5, vehicle.getId());
                ps.setInt(6, vehicle.getType_description().getId());
                ps.setInt(7, Integer.parseInt(vehicle.getCity_name()));// city id get 
                ps.setDouble(8, vehicle.getPrice());
                ps.setString(9, vehicle.getBrand());
                ps.setInt(10, 0);
                
                ps.execute();
                connection.close();
                return true;
            } catch (SQLException ex) {
                DbErrorMessage.printSQLException(ex);
            }
        }
        
        return false;
    }
    
    public static TypeDescription query_where_type_description(String id) throws ClassNotFoundException {
        TypeDescription td = null;
        String sql = "SELECT * FROM travel.vehicle_type where id =" + id + ";";
        Class.forName(jdbc_name);
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id_ = rs.getInt("id");
                String name = rs.getString("type_description");
                td = new TypeDescription(id_, name);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return td;
    }
    
    public static ArrayList<TypeDescription> query_select_type_description() throws ClassNotFoundException {
        ArrayList<TypeDescription> type_descriptions = new ArrayList<>();
        String sql = "SELECT * FROM vehicle_type order by id asc;";
        Class.forName(jdbc_name);
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("type_description");
                TypeDescription td = new TypeDescription(id, name);
                type_descriptions.add(td);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return type_descriptions;
    }
    
    public static ArrayList<Country> query_select_country() throws ClassNotFoundException {
        ArrayList<Country> countrys = new ArrayList<>();
        String sql = "SELECT * FROM country order by id asc;";
        Class.forName(jdbc_name);
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Country country = new Country(id, name);
                countrys.add(country);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return countrys;
    }
    
    public static ArrayList<City> query_where_city(String country_id) throws ClassNotFoundException {
        ArrayList<City> cityList = new ArrayList<>();
        String sql = "SELECT city.id,city.name_ FROM city where city.country_id =? order by city.id asc;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ps.setString(1, country_id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name_");
                City city = new City(id, name);
                cityList.add(city);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return cityList;
    }
    
    public static ArrayList<City> query_select_city() throws ClassNotFoundException {
        ArrayList<City> cityList = new ArrayList<>();
        String sql = "SELECT city.id,city.name_,country.name FROM city inner join country on city.country_id = country.id order by city.id asc;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name_");
                String country_name = rs.getString("name");
                City city = new City(id, name, country_name);
                cityList.add(city);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return cityList;
    }
    
    public static int last_index_vehicles_renals() {
        try {
            ArrayList<VehicleRenals> vehicleRenalses = ModulsDatas.query_select_vehicle_renals();
            if (!vehicleRenalses.isEmpty()) {
                int length = vehicleRenalses.size() - 1;
                return vehicleRenalses.get(length).getId() + 1;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModulsDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 1;
    }
    
    public static int last_index_vehicles() {
        try {
            ArrayList<Vehicles> vehicleses = ModulsDatas.query_select_vehicles();
            int lastIndex = 0;
            int size = vehicleses.size();
            if (size != 0) {
                lastIndex = vehicleses.get(size - 1).getId();
            }
            return lastIndex + 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModulsDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    
    public static Vehicles query_where_vehicles(String id) throws ClassNotFoundException {
        Vehicles vehicles = null;
        String sql = "SELECT v.id, v.current_mileage, v.date_mot_due, v.engine_size, v.price, v.brand, v.status_, v.car_img, m.daily_hire_rate, m.model_name, \n"
                + "vt.type_description, city.name_, country.name FROM travel.vehicles v \n"
                + "inner join models m on v.models_id= m.id\n"
                + "inner join vehicle_type vt on v.vehicle_type_id = vt.id \n"
                + "inner join city on v.city_id = city.id\n"
                + "inner join country on city.country_id = country.id where v.id=? order by v.id asc;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String current_mileage = rs.getString("current_mileage");
                String date_mot_due = rs.getString("date_mot_due");
                String engine_size = rs.getString("engine_size");
                double price = rs.getDouble("price");
                String brand = rs.getString("brand");
                String car_img = rs.getString("car_img");
                int status = rs.getInt("status_");
                // models
                String m_daily_hire_rate = rs.getString("daily_hire_rate");
                String m_model_name = rs.getString("model_name");
                // type
                String type_description = rs.getString("type_description");
                // city & country
                String city_name = rs.getString("name_");
                String country_name = rs.getString("name");
                
                vehicles = new Vehicles(Integer.parseInt(id), current_mileage, date_mot_due, engine_size, m_daily_hire_rate, m_model_name, type_description, city_name, country_name, price, brand, status, car_img);
                
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return vehicles;
    }
    
    public static ArrayList<VehicleRenals> query_select_vehicle_renals() throws ClassNotFoundException {
        ArrayList<VehicleRenals> vehicleRenalses = new ArrayList<>();
        String sql = "SELECT * FROM travel.vehicle_renals;";// order by id asc";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_ = rs.getInt("id");
                Date date_from = rs.getDate("date_from");
                Date date_to = rs.getDate("date_to");
                int cus_id = rs.getInt("Customer_id");
                int rental_status_id = rs.getInt("rental_status_id");
                int veh_id = rs.getInt("vehicles_id");
                int Admin_id = rs.getInt("Admin_id");
                VehicleRenals r = new VehicleRenals(id_, date_from, date_to, cus_id, veh_id, Admin_id, rental_status_id);
                vehicleRenalses.add(r);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return vehicleRenalses;
    }
    
    public static ArrayList<Vehicles> query_select_vehicles() throws ClassNotFoundException {
        ModulsDatas.update_vehicls_full();
        ArrayList<Vehicles> vehiclesList = new ArrayList<>();
        String sql = "SELECT v.id, v.current_mileage, v.date_mot_due, v.engine_size, v.price, v.brand, v.status_, v.car_img, m.daily_hire_rate, m.model_name, vt.type_description, city.name_, country.name\n"
                + "FROM travel.vehicles v \n"
                + "inner join models m on v.models_id= m.id\n"
                + "inner join vehicle_type vt on v.vehicle_type_id = vt.id\n"
                + "inner join city on v.city_id = city.id\n"
                + "inner join country on city.country_id = country.id order by v.id asc;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                String current_mileage = rs.getString("current_mileage");
                String date_mot_due = rs.getString("date_mot_due");
                String engine_size = rs.getString("engine_size");
                double price = rs.getDouble("price");
                String brand = rs.getString("brand");
                String car_img = rs.getString("car_img");
                int status = rs.getInt("status_");
                // models
                String m_daily_hire_rate = rs.getString("daily_hire_rate");
                String m_model_name = rs.getString("model_name");
                // type
                String type_description = rs.getString("type_description");
                // city & country
                String city_name = rs.getString("name_");
                String country_name = rs.getString("name");
                
                Vehicles vehicles = new Vehicles(id_, current_mileage, date_mot_due, engine_size, m_daily_hire_rate, m_model_name, type_description, city_name, country_name, price, brand, status, car_img);
                vehiclesList.add(vehicles);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return vehiclesList;
    }
    
    public static boolean delete_bus(String id) throws ClassNotFoundException {
        String sql_bus = "DELETE FROM driver WHERE (id = ?);";
        
        Class.forName(jdbc_name);
        // VEHİCLES TABLE DELETE
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql_bus);) {
            ps.setString(1, id);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return false;
    }
    
    public static boolean insert_packageBooking(PackagesBooking booking) throws ClassNotFoundException {
        String sql = "INSERT INTO pack_booking (id, creat, packages_id, Customer_id, Admin_id) VALUES (?, now(), ?, ?, ?);";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ps.setInt(1, booking.getId());
            ps.setInt(2, booking.getPackage_id());
            ps.setInt(3, booking.getCus_id());
            ps.setInt(4, booking.getAdmin_id());
            
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return false;
    }
    
    public static boolean insert_hotelBooking(Hotel_booking booking) throws ClassNotFoundException {
        String sql = "INSERT INTO hotel_booking (id, date_from, date_to, hotels_id, Customer_id, Admin_id) VALUES (?, ?, ?, ?, ?, ?);";
        
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ps.setInt(1, booking.getId());
            ps.setDate(2, booking.getDate_from());
            ps.setDate(3, booking.getDate_to());
            ps.setInt(4, booking.getHotel_id());
            ps.setInt(5, booking.getCus_id());
            ps.setInt(6, booking.getAdmin_id());
            
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        return false;
    }
    
    public static boolean insert_busBookings(ArrayList<Seat> seats, BusBooking booking) throws ClassNotFoundException {
        String sql_bookings = "INSERT INTO bus_booking (id, date_from, date_to, Driver_id, Customer_id, Admin_id) VALUES (?, ?, ?, ?, ?, ?);";
        String sql_seat = "INSERT INTO seats (id, Driver_id, Customer_id, seat_no, cinsiyet, seat_index) VALUES (?, ?, ?, ?, ?, ?);";
        
        Class.forName(jdbc_name);
        // SEATS TABLE INSERT INTO
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql_seat);) {
            for (Seat seat : seats) {
                ps.setInt(1, seat.getId());
                ps.setInt(2, seat.getDriver_id());
                ps.setInt(3, seat.getCustomer_id());
                ps.setString(4, seat.getSeat_no());
                ps.setInt(5, seat.getCinsiyet());
                ps.setInt(6, seat.getSeat_index());
                
                ps.execute();
            }
            
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }

        // BUSBOOKING TABLE INSERT INTO
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql_bookings);) {
            
            ps.setInt(1, booking.getId());
            ps.setString(2, booking.getDate_from());
            ps.setString(3, booking.getDate_to());
            ps.setInt(4, booking.getDriver_id());
            ps.setInt(5, booking.getCus_id());
            ps.setInt(6, booking.getAdmin_id());
            
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return false;
    }
    
    public static boolean insert_bus(Bus bus) throws ClassNotFoundException {
        String sql_bus = "INSERT INTO driver (id, agancet_name, loc_from, loc_to, price) VALUES (?, ?, ?, ?, ?);";
        
        Class.forName(jdbc_name);

        // BUS TABLE INSERT INTO
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql_bus);) {
            
            ps.setInt(1, bus.getId());
            ps.setString(2, bus.getAgancet_name());
            ps.setString(3, bus.getFrom_city_name());
            ps.setString(4, bus.getTo_city_name());
            ps.setDouble(5, bus.getPrice());
            
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return false;
    }
    
    public static Packages query_where_packages(String id) throws ClassNotFoundException {
        Packages packages = null;
        String sql = "SELECT p.id, p.title, p.description, city.name_ as city, country.name as country, p.price, p.start_date, p.end_date,datediff(p.end_date, p.start_date) as days, h.name as hotel_name, h.price as hprice, b.agancet_name, b.price as bprice, h.hotel_img\n"
                + "FROM travel.packages p \n"
                + "inner join driver b on b.id = p.bus_id\n"
                + "inner join hotels h on h.id = p.hotel_id\n"
                + "inner join city on p.city_id= city.id\n"
                + "inner join country on city.country_id = country.id where p.id=?; ";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int id_ = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String cityName = rs.getString("city");
                String countryName = rs.getString("country");
                Double price = rs.getDouble("price");
                Double hPrice = rs.getDouble("hprice");
                Double bPrice = rs.getDouble("bprice");
                Date start_date = rs.getDate("start_date");
                Date stop_date = rs.getDate("end_date");
                int days = rs.getInt("days");
                String hotelName = rs.getString("hotel_name");
                String agancetName = rs.getString("agancet_name");
                String hotel_img = rs.getString("hotel_img");
                
                packages = new Packages(id_, title, description, cityName, countryName, price, hPrice, bPrice, start_date, stop_date, days, hotelName, hotel_img, agancetName);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return packages;
    }
    
    public static ArrayList<Packages> query_select_Packages() throws ClassNotFoundException {
        ArrayList<Packages> packageses = new ArrayList<>();
        String sql = "SELECT * FROM travel.packages;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int city_id = rs.getInt("city_id");
                double price = rs.getDouble("price");
                Date start_date = rs.getDate("start_date");
                Date stop_date = rs.getDate("end_date");
                int hotels_id = rs.getInt("hotel_id");
                int bus_id = rs.getInt("bus_id");
                
                Packages packages = new Packages(id_, title, description, city_id, price, start_date, stop_date, hotels_id, bus_id);
                packageses.add(packages);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return packageses;
    }
    
    public static ArrayList<PackagesBooking> query_where_select_PackagesBooking(String cus_id) throws ClassNotFoundException {
        ArrayList<PackagesBooking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM pack_booking where Customer_id =?;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ps.setString(1, cus_id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                Date creat = rs.getDate("creat");
                int packages_id = rs.getInt("packages_id");
                int Customer_id = rs.getInt("Customer_id");
                int Admin_id = rs.getInt("Admin_id");
                
                PackagesBooking booking = new PackagesBooking(id_, creat, Customer_id, packages_id, Admin_id);
                bookings.add(booking);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return bookings;
    }
    
    
    public static ArrayList<PackagesBooking> query_select_PackagesBooking() throws ClassNotFoundException {
        ArrayList<PackagesBooking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM pack_booking;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                Date creat = rs.getDate("creat");
                int packages_id = rs.getInt("packages_id");
                int Customer_id = rs.getInt("Customer_id");
                int Admin_id = rs.getInt("Admin_id");
                
                PackagesBooking booking = new PackagesBooking(id_, creat, Customer_id, packages_id, Admin_id);
                bookings.add(booking);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return bookings;
    }
    
    public static ArrayList<Hotel_booking> query_select_HotelBooking() throws ClassNotFoundException {
        ArrayList<Hotel_booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM hotel_booking;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                Date date_from = rs.getDate("date_from");
                Date date_tto = rs.getDate("date_to");
                int hotels_id = rs.getInt("hotels_id");
                int Customer_id = rs.getInt("Customer_id");
                int Admin_id = rs.getInt("Admin_id");
                
                Hotel_booking booking = new Hotel_booking(id_, date_from, date_tto, Customer_id, hotels_id, Admin_id);
                bookings.add(booking);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return bookings;
    }
    
    public static ArrayList<VehicleRenals> query_where_select_VehicleRenals(String id) throws ClassNotFoundException {
        ArrayList<VehicleRenals> vehicleRenalses = new ArrayList<>();
        String sql = "SELECT vh.id,vh.date_from,vh.date_to,ty.description,vh.vehicles_id,vh.Customer_id,vh.Admin_id FROM travel.vehicle_renals vh \n"
                + "inner join rental_status ty on ty.id = vh.rental_status_id\n"
                + "where vh.Customer_id=?;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                Date date_from = rs.getDate("date_from");
                Date date_to = rs.getDate("date_to");
                int cus_id = rs.getInt("Customer_id");
                int rental_status_id = rs.getInt("rental_status_id");
                int veh_id = rs.getInt("vehicles_id");
                int Admin_id = rs.getInt("Admin_id");
                VehicleRenals r = new VehicleRenals(id_, date_from, date_to, cus_id, veh_id, Admin_id, rental_status_id);
                vehicleRenalses.add(r);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return vehicleRenalses;
    }
    
    public static ArrayList<Hotel_booking> query_where_select_HotelBookings(String cus_id) throws ClassNotFoundException {
        ArrayList<Hotel_booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM hotel_booking where Customer_id = ?;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ps.setString(1, cus_id);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                Date date_from = rs.getDate("date_from");
                Date date_tto = rs.getDate("date_to");
                int hotels_id = rs.getInt("hotels_id");
                int Customer_id = rs.getInt("Customer_id");
                int Admin_id = rs.getInt("Admin_id");
                
                Hotel_booking booking = new Hotel_booking(id_, date_from, date_tto, Customer_id, hotels_id, Admin_id);
                bookings.add(booking);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return bookings;
    }
    
    public static Hotel_booking query_where_select_HotelBooking(String id) throws ClassNotFoundException {
        Hotel_booking bookings = null;
        String sql = "SELECT * FROM hotel_booking where id=?;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                int id_ = rs.getInt("id");
                Date date_from = rs.getDate("date_from");
                Date date_tto = rs.getDate("date_to");
                int hotels_id = rs.getInt("hotels_id");
                int Customer_id = rs.getInt("Customer_id");
                int Admin_id = rs.getInt("Admin_id");
                
                bookings = new Hotel_booking(id_, date_from, date_tto, Customer_id, hotels_id, Admin_id);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return bookings;
    }
    
    public static int last_index_PackagesBooking() {
        
        try {
            ArrayList<PackagesBooking> bookings = ModulsDatas.query_select_PackagesBooking();
            int lastIndex = 0;
            int size = bookings.size();
            if (size != 0) {
                lastIndex = bookings.get(size - 1).getId();
            }
            return lastIndex + 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModulsDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int last_indexHotelBooking() {
        try {
            ArrayList<Hotel_booking> bookings = ModulsDatas.query_select_HotelBooking();
            int lastIndex = 0;
            int size = bookings.size();
            if (size != 0) {
                lastIndex = bookings.get(size - 1).getId();
            }
            return lastIndex + 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModulsDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }

    // query_select_busBooking
    public static int last_indexBusBooking() {
        try {
            ArrayList<BusBooking> bookings = ModulsDatas.query_select_busBooking();
            int lastIndex = 0;
            int size = bookings.size();
            if (size != 0) {
                lastIndex = bookings.get(size - 1).getId();
            }
            return lastIndex + 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModulsDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public static int last_index_buses() {
        try {
            ArrayList<Bus> buses = ModulsDatas.query_select_buses();
            int lastIndex = 0;
            int size = buses.size();
            if (size != 0) {
                lastIndex = buses.get(size - 1).getId();
            }
            return lastIndex + 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModulsDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static int last_index_seats() {
        
        try {
            ArrayList<Seat> seats = ModulsDatas.query_select_seats();
            int lastIndex = 0;
            int size = seats.size();
            if (size != 0) {
                lastIndex = seats.get(size - 1).getId();
            }
            return lastIndex + 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModulsDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static ArrayList<Seat> query_select_seats() throws ClassNotFoundException {
        ArrayList<Seat> seats = new ArrayList<>();
        String sql = "SELECT * FROM travel.seats;";
        
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_ = rs.getInt("id");
                int custemor = rs.getInt("id");
                String seat_no = rs.getString("seat_no");
                int cinsiyet = rs.getInt("cinsiyet");
                int seat_index = rs.getInt("seat_index");
                Seat seat = new Seat(id_, custemor, seat_no, cinsiyet, seat_index);
                seats.add(seat);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return seats;
    }
    
    public static ArrayList<Seat> query_select_seats(String bus_driver_id) throws ClassNotFoundException {
        ArrayList<Seat> seats = new ArrayList<>();
        ArrayList<Integer> seats_no = new ArrayList<>();
        String sql = "SELECT * FROM travel.seats where Driver_id =?;";
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, bus_driver_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_ = rs.getInt("id");
                int custemor = rs.getInt("Customer_id");
                String seat_no = rs.getString("seat_no");
                int cinsiyet = rs.getInt("cinsiyet");
                int seat_index = rs.getInt("seat_index");
                Seat seat = new Seat(id_, custemor, seat_no, cinsiyet, seat_index);
                seats.add(seat);
                seats_no.add(Integer.parseInt(seat_no));
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        //  seat        index   mod
        //  1-4-7...    5       1%3=1
        //  2-5-8...    2       2%3=2
        //  3-6-9..     1       3%3=0
        for (int index = 1; index <= 40; index++) {
            Boolean trun = true;
            for (int i = 0; i < seats_no.size(); i++) {
                Integer integer = seats_no.get(i);
                if (integer == index) {
                    trun = false;
                    break;
                }
            }
            if (trun) {
                Seat st = null;//new Seat(0, -1, index, 0, sira);
                if (index % 3 == 1) {
                    st = new Seat(0, -1, Integer.toString(index), 0, 5);
                } else if (index % 3 == 2) {
                    st = new Seat(0, -1, Integer.toString(index), 0, 2);
                } else if (index % 3 == 0) {
                    st = new Seat(0, -1, Integer.toString(index), 0, 1);
                }
                seats.add(st);
            }
        }
        
        return seats;
    }
    
    public static Hotels query_where_hotel(String id) throws ClassNotFoundException {
        Hotels hotel = null;
        String sql = "SELECT h.id, city.name_ as city,country.name as country,h.name,h.addres,h.price,h.hotel_img FROM travel.hotels h\n"
                + "inner join city on h.city_id = city.id\n"
                + "inner join country on city.country_id = country.id\n"
                + "where h.id =?;";
        
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String adres = rs.getString("addres");
                String city = rs.getString("city");
                String country = rs.getString("country");
                String hotel_img = rs.getString("hotel_img");
                double price = rs.getDouble("price");
                hotel = new Hotels(Integer.parseInt(id), city, country, name, adres, price, hotel_img);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return hotel;
    }
    
    public static Bus query_where_bus(String id) throws ClassNotFoundException {
        Bus bus = null;
        String sql = "SELECT b.id, b.agancet_name, city.name_ as fromCity, country.name as fromCountry, t.name_ as toCity, ct.name as toCountry, b.price FROM driver b\n"
                + "inner join city on b.loc_from = city.id\n"
                + "inner join city t on b.loc_to = t.id\n"
                + "inner join country on city.country_id = country.id \n"
                + "inner join country ct on t.country_id = ct.id \n"
                + "where b.id =?;";
        
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String agancet_name = rs.getString("agancet_name");
                String fromCity = rs.getString("fromCity");
                String fromCountry = rs.getString("fromCountry");
                String toCity = rs.getString("toCity");
                String toCountry = rs.getString("toCountry");
                double price = rs.getDouble("price");
                bus = new Bus(Integer.parseInt(id), agancet_name, fromCity, fromCountry, toCity, toCountry, price);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        return bus;
    }
    
    public static ArrayList<BusBooking> query_where_select_busBooking(String cus_id) throws ClassNotFoundException {
        ArrayList<BusBooking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM travel.bus_booking where Customer_id = ?;";
        
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ps.setString(1, cus_id);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                String date_from = rs.getString("date_from");
                String date_to = rs.getString("date_to");
                int driver = rs.getInt("Driver_id");
                int customer = rs.getInt("Customer_id");
                int admin = rs.getInt("Admin_id");
                BusBooking b = new BusBooking(id_, date_from, date_to, customer, driver, admin);
                bookings.add(b);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return bookings;
    }
    
    public static ArrayList<BusBooking> query_select_busBooking() throws ClassNotFoundException {
        ArrayList<BusBooking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM travel.bus_booking;";
        
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                String date_from = rs.getString("date_from");
                String date_to = rs.getString("date_to");
                int driver = rs.getInt("Driver_id");
                int customer = rs.getInt("Customer_id");
                int admin = rs.getInt("Admin_id");
                BusBooking b = new BusBooking(id_, date_from, date_to, customer, driver, admin);
                bookings.add(b);
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return bookings;
    }
    
    public static ArrayList<Bus> query_select_buses() throws ClassNotFoundException {
        ArrayList<Bus> buses = new ArrayList<>();
        String sql = "SELECT b.id, b.agancet_name, city.name_ as fromCity, country.name as fromCountry, t.name_ as toCity, ct.name as toCountry, b.price FROM driver b\n"
                + " inner join city on b.loc_from = city.id\n"
                + " inner join city t on b.loc_to = t.id\n"
                + " inner join country on city.country_id = country.id \n"
                + " inner join country ct on t.country_id = ct.id \n"
                + " order by b.id asc;";
        
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                String agancet_name = rs.getString("agancet_name");
                String fromCity = rs.getString("fromCity");
                String fromCountry = rs.getString("fromCountry");
                String toCity = rs.getString("toCity");
                String toCountry = rs.getString("toCountry");
                double price = rs.getDouble("price");
                Bus bus = new Bus(id_, agancet_name, fromCity, fromCountry, toCity, toCountry, price);
                buses.add(bus); 
            }
            
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return buses;
    }
    
    public static boolean delete_hotel(String id) throws ClassNotFoundException {
        String sql_hotel = "DELETE FROM hotels WHERE (id = ?);";
        
        Class.forName(jdbc_name);
        // VEHİCLES TABLE DELETE
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql_hotel);) {
            ps.setString(1, id);
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return false;
    }
    
    public static boolean insert_hotels(Hotels hotels) throws ClassNotFoundException {
        String sql_hotel = "INSERT INTO hotels (id, city_id, name, addres, price) VALUES (?, ?, ?, ?, ?);";
        
        Class.forName(jdbc_name);

        // BUS TABLE INSERT INTO
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql_hotel);) {
            
            ps.setInt(1, hotels.getId());
            ps.setString(2, hotels.getCity_name());
            ps.setString(3, hotels.getName());
            ps.setString(4, hotels.getAddres());
            ps.setDouble(5, hotels.getPrice());
            
            ps.execute();
            connection.close();
            return true;
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        
        return false;
    }
    
    public static int last_index_hotelses() {
        try {
            ArrayList<Hotels> hotelses = ModulsDatas.query_select_hotel();
            int lastIndex = 0;
            int size = hotelses.size();
            if (size != 0) {
                lastIndex = hotelses.get(size - 1).getId();
            }
            return lastIndex + 1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModulsDatas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public static ArrayList<Hotels> query_select_hotel() throws ClassNotFoundException {
        ArrayList<Hotels> hotelses = new ArrayList<>();
        String sql = "SELECT h.id, h.name, city.name_ as city, country.name as country, h.addres, h.price, h.hotel_img FROM hotels h \n"
                + " inner join city on h.city_id = city.id\n"
                + " inner join country on city.country_id = country.id \n"
                + " order by h.id asc;";
        Class.forName(jdbc_name);
        
        try (Connection connection = DriverManager.getConnection(drive_, root, pwd);
                PreparedStatement ps = connection.prepareStatement(sql);) {
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                int id_ = rs.getInt("id");
                String name = rs.getString("name");
                String city_name = rs.getString("city");
                String country_name = rs.getString("country");
                String addres = rs.getString("addres");
                String hotel_img = rs.getString("hotel_img");
                double price = rs.getDouble("price");
                
                Hotels hotels = new Hotels(id_, city_name, country_name, name, addres, price, hotel_img);
                hotelses.add(hotels);
            }
            connection.close();
        } catch (SQLException ex) {
            DbErrorMessage.printSQLException(ex);
        }
        return hotelses;
    }
    
}// end class

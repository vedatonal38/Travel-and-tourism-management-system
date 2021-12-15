package com.vedat.modules.reservations;

import com.vedat.modules.Vehicle.Vehicles;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Vedat Önal
 */
public class VehicleRenals implements Serializable {
    
    private int id;
    private Date date_from;
    private Date date_to;
    private int cus_id;
    private int veh_id;
    private int admin_id;
    private int status_id;
    private String description;
    
    private Vehicles vehicles;

    public VehicleRenals(int id, Date date_from, Date date_to, int cus_id, 
            int veh_id, int admin_id, String description) {
        this.id = id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.cus_id = cus_id;
        this.veh_id = veh_id;
        this.admin_id = admin_id;
        this.description =description;
    }
    
    public VehicleRenals(int id, String date_from, String date_to, int cus_id, 
            int veh_id, int admin_id, String description) {
        this.id = id;
        this.date_from = this.convertDate(date_from);
        this.date_to = this.convertDate(date_to);// 2023-06-23
        this.cus_id = cus_id;
        this.veh_id = veh_id;
        this.admin_id = admin_id;
        this.description =description;
    }
    
    public VehicleRenals(int id, String date_from, String date_to, int cus_id, 
            int veh_id, int admin_id, int status_id) {
        this.id = id;
        this.date_from = this.convertDate(date_from);
        this.date_to = this.convertDate(date_to);// 2023-06-23
        this.cus_id = cus_id;
        this.veh_id = veh_id;
        this.admin_id = admin_id;
        this.status_id = status_id;
    }
        
    public VehicleRenals(int id,Date date_from, Date date_to, int cus_id, 
            int veh_id, int admin_id, int status) {
        this.id = id;
        this.date_from = date_from;
        this.date_to = date_to;// 2023-06-23
        this.cus_id = cus_id;
        this.veh_id = veh_id;
        this.admin_id = admin_id;
        this.status_id = status;
    }
    public VehicleRenals(int id, Date date_from, Date date_to, int cus_id, int admin_id,String description , Vehicles vehicles) {
        this.id = id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.cus_id = cus_id;
        this.admin_id = admin_id;
        this.description = description;
        this.vehicles = vehicles;
    }
    
    private Date convertDate(String date) {
        return Date.valueOf(date);
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date_from
     */
    public Date getDate_from() {
        return date_from;
    }

    /**
     * @param date_from the date_from to set
     */
    public void setDate_from(Date date_from) {
        this.date_from = date_from;
    }

    /**
     * @return the date_to
     */
    public Date getDate_to() {
        return date_to;
    }

    /**
     * @param date_to the date_to to set
     */
    public void setDate_to(Date date_to) {
        this.date_to = date_to;
    }

    /**
     * @return the cus_id
     */
    public int getCus_id() {
        return cus_id;
    }

    /**
     * @param cus_id the cus_id to set
     */
    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    /**
     * @return the veh_id
     */
    public int getVeh_id() {
        return veh_id;
    }

    /**
     * @param veh_id the veh_id to set
     */
    public void setVeh_id(int veh_id) {
        this.veh_id = veh_id;
    }

    /**
     * @return the admin_id
     */
    public int getAdmin_id() {
        return admin_id;
    }

    /**
     * @param admin_id the admin_id to set
     */
    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    /**
     * @return the vehicles
     */
    public Vehicles getVehicles() {
        return vehicles;
    }

    /**
     * @param vehicles the vehicles to set
     */
    public void setVehicles(Vehicles vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    
}

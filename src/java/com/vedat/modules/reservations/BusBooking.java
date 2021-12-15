package com.vedat.modules.reservations;

import com.vedat.modules.BusDriver.Bus;
import java.io.Serializable;

/**
 *
 * @author Vedat Önal
 */
public class BusBooking implements Serializable {

    private int id;
    private String date_from;
    private String date_to;
    private int cus_id;
    private int driver_id;
    private int admin_id;

    private Bus bus;

    public BusBooking(int id, String date_from, String date_to, int cus_id,
            int driver_id, int admin_id) {
        this.id = id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.cus_id = cus_id;
        this.driver_id = driver_id;
        this.admin_id = admin_id;
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
    public String getDate_from() {
        return date_from;
    }

    /**
     * @param date_from the date_from to set
     */
    public void setDate_from(String date_from) {
        this.date_from = date_from;
    }

    /**
     * @return the date_to
     */
    public String getDate_to() {
        return date_to;
    }

    /**
     * @param date_to the date_to to set
     */
    public void setDate_to(String date_to) {
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
     * @return the driver_id
     */
    public int getDriver_id() {
        return driver_id;
    }

    /**
     * @param driver_id the driver_id to set
     */
    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
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
     * @return the bus
     */
    public Bus getBus() {
        return bus;
    }

    /**
     * @param bus the bus to set
     */
    public void setBus(Bus bus) {
        this.bus = bus;
    }

}

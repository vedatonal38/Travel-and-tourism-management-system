package com.vedat.modules.BusDriver;

import com.vedat.modules.Customer;
import java.io.Serializable;

/**
 *
 * @author Vedat Önal
 */
public class Seat implements Serializable {
    
    private int id;
    private int driver_id;
    private int customer_id;
    private String seat_no;
    private int cinsiyet;
    private int seat_index;
    
    private Customer customer;
    
    public Seat(int id, int driver_id, int customer_id, String seat_no, int cinsiyet, int seat_index) {
        this.id = id;
        this.driver_id = driver_id;
        this.customer_id = customer_id;
        this.seat_no = seat_no;
        this.cinsiyet = cinsiyet;
        this.seat_index = seat_index;
    }
    public Seat(int id, int customer_id, String seat_no, int cinsiyet, int seat_index) {
        this.id = id;
        this.customer_id = customer_id;
        this.seat_no = seat_no;
        this.cinsiyet = cinsiyet;
        this.seat_index = seat_index;
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
     * @return the customer_id
     */
    public int getCustomer_id() {
        return customer_id;
    }

    /**
     * @param customer_id the customer_id to set
     */
    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    /**
     * @return the seat_no
     */
    public String getSeat_no() {
        return seat_no;
    }

    /**
     * @param seat_no the seat_no to set
     */
    public void setSeat_no(String seat_no) {
        this.seat_no = seat_no;
    }

    /**
     * @return the cinsiyet
     */
    public int getCinsiyet() {
        return cinsiyet;
    }

    /**
     * @param cinsiyet the cinsiyet to set
     */
    public void setCinsiyet(int cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    /**
     * @return the seat_index
     */
    public int getSeat_index() {
        return seat_index;
    }

    /**
     * @param seat_index the seat_index to set
     */
    public void setSeat_index(int seat_index) {
        this.seat_index = seat_index;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
}

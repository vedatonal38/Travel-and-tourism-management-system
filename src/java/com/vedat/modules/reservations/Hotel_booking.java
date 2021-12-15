package com.vedat.modules.reservations;

import com.vedat.modules.Hotels.Hotels;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Vedat Önal
 */
public class Hotel_booking implements Serializable {

    private int id;
    private Date date_from;
    private Date date_to;
    private int cus_id;
    private int hotel_id;
    private int admin_id;

    private Hotels hotels;

    public Hotel_booking(int id, Date date_from, Date date_to, int cus_id, 
            int hotel_id, int admin_id) {
        this.id = id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.cus_id = cus_id;
        this.hotel_id = hotel_id;
        this.admin_id = admin_id;
    }
    
    public Hotel_booking(int id, String date_from, String date_to, int cus_id, 
            int hotel_id, int admin_id) {
        this.id = id;
        this.date_from = this.convertDate(date_from);
        this.date_to = this.convertDate(date_to);
        this.cus_id = cus_id;
        this.hotel_id = hotel_id;
        this.admin_id = admin_id;
    }

    public Hotel_booking(int id, Date date_from, Date date_to, int cus_id, int admin_id, Hotels hotels) {
        this.id = id;
        this.date_from = date_from;
        this.date_to = date_to;
        this.cus_id = cus_id;
        this.admin_id = admin_id;
        this.hotels = hotels;
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
     * @return the hotel_id
     */
    public int getHotel_id() {
        return hotel_id;
    }

    /**
     * @param hotel_id the hotel_id to set
     */
    public void setHotel_id(int hotel_id) {
        this.hotel_id = hotel_id;
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
     * @return the hotels
     */
    public Hotels getHotels() {
        return hotels;
    }

    /**
     * @param hotels the hotels to set
     */
    public void setHotels(Hotels hotels) {
        this.hotels = hotels;
    }

    
}

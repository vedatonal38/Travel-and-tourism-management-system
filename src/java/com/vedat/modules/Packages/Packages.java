package com.vedat.modules.Packages;

import java.sql.Date;

/**
 *
 * @author Vedat Önal
 */
public class Packages {

    private int id;
    private String title;
    private String description;
    private String countryName;
    private String cityName;
    private int city_id;
    private double price;
    private double hotelPrice;
    private double busPrice;
    private Date start_date;
    private Date stop_date;
    private String hotelName;
    private String hotelImg;
    private int hotel_id;
    private int days;
    private String agancetName;
    private int bus_id;

    public Packages(int id, String title, String description, String cityName, String countryName, double price, double hPrice, double bPrice, Date start_date, Date stop_date,int days, String hotelName, String hotel_img, String agancetName) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.cityName = cityName;
        this.countryName = countryName;
        this.price = price;
        this.hotelPrice = hPrice;
        this.busPrice = bPrice;
        this.start_date = start_date;
        this.stop_date = stop_date;
        this.days = days;
        this.hotelName = hotelName;
        this.hotelImg = hotel_img;
        this.agancetName = agancetName;
    }

    public Packages(int id, String title, String description, int city_id, double price, Date start_date, Date stop_date, int hotel_id, int bus_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.city_id = city_id;
        this.price = price;
        this.start_date = start_date;
        this.stop_date = stop_date;
        this.hotel_id = hotel_id;
        this.bus_id = bus_id;
    }

    public Packages(int id, String title, String description, int city_id, double price, String start_date, String stop_date, int hotel_id, int bus_id) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.city_id = city_id;
        this.price = price;
        this.start_date = convertDate(start_date);
        this.stop_date = convertDate(stop_date);
        this.hotel_id = hotel_id;
        this.bus_id = bus_id;
    }

    private Date convertDate(String date) {
        return Date.valueOf(date);
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
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

    /**
     * @return the city_id
     */
    public int getCity_id() {
        return city_id;
    }

    /**
     * @param city_id the city_id to set
     */
    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the start_date
     */
    public Date getStart_date() {
        return start_date;
    }

    /**
     * @param start_date the start_date to set
     */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    /**
     * @return the stop_date
     */
    public Date getStop_date() {
        return stop_date;
    }

    /**
     * @param stop_date the stop_date to set
     */
    public void setStop_date(Date stop_date) {
        this.stop_date = stop_date;
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
     * @return the bus_id
     */
    public int getBus_id() {
        return bus_id;
    }

    /**
     * @param bus_id the bus_id to set
     */
    public void setBus_id(int bus_id) {
        this.bus_id = bus_id;
    }

    /**
     * @return the cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName the cityName to set
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return the countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * @param countryName the countryName to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * @return the hotelName
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * @param hotelName the hotelName to set
     */
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * @return the agancetName
     */
    public String getAgancetName() {
        return agancetName;
    }

    /**
     * @param agancetName the agancetName to set
     */
    public void setAgancetName(String agancetName) {
        this.agancetName = agancetName;
    }

    /**
     * @return the hotelPrice
     */
    public double getHotelPrice() {
        return hotelPrice;
    }

    /**
     * @param hotelPrice the hotelPrice to set
     */
    public void setHotelPrice(double hotelPrice) {
        this.hotelPrice = hotelPrice;
    }

    /**
     * @return the busPrice
     */
    public double getBusPrice() {
        return busPrice;
    }

    /**
     * @param busPrice the busPrice to set
     */
    public void setBusPrice(double busPrice) {
        this.busPrice = busPrice;
    }

    /**
     * @return the hotelImg
     */
    public String getHotelImg() {
        return hotelImg;
    }

    /**
     * @param hotelImg the hotelImg to set
     */
    public void setHotelImg(String hotelImg) {
        this.hotelImg = hotelImg;
    }

}

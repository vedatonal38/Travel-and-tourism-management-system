package com.vedat.modules.Hotels;

import java.io.Serializable;

/**
 *
 * @author Vedat Önal
 */
public class Hotels implements Serializable {

    private int id;
    // CITY & COUNTRY NAMES
    private String city_name;
    private String country_name;
    //
    private String name;
    private String addres; //text
    // Fiyatlandırma
    private Double price;
    // img
    private String hotel_img;

    public Hotels(int id, String city_name, String country_name, String name, String addres, Double price,String hotel_img) {
        this.id = id;
        this.city_name = city_name;
        this.country_name = country_name;
        this.name = name;
        this.addres = addres;
        this.price = price;
        this.hotel_img = hotel_img;
    }
    
    public Hotels(int id, String city_name, String country_name, String name, String addres, Double price) {
        this.id = id;
        this.city_name = city_name;
        this.country_name = country_name;
        this.name = name;
        this.addres = addres;
        this.price = price;
//        this.hotel_img = hotel_img;
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
     * @return the city_name
     */
    public String getCity_name() {
        return city_name;
    }

    /**
     * @param city_name the city_name to set
     */
    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    /**
     * @return the country_name
     */
    public String getCountry_name() {
        return country_name;
    }

    /**
     * @param country_name the country_name to set
     */
    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the addres
     */
    public String getAddres() {
        return addres;
    }

    /**
     * @param addres the addres to set
     */
    public void setAddres(String addres) {
        this.addres = addres;
    }

    /**
     * @return the price
     */
    public Double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    public String getHotel_img() {
        return hotel_img;
    }

    public void setHotel_img(String hotel_img) {
        this.hotel_img = hotel_img;
    }

    
}

package com.vedat.modules.Vehicle;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Vedat Önal
 */
public class Vehicles implements Serializable {

    private int id;
    private String current_mileage;// mevcut kilometre.
    private String date_mot_due; // Tarih Motu (model yılı). -->  new java.util.Date(timestamp.getTime());
    private String engine_size; // motor hacmi.
    // MODELS
    private Models models; // Günlük kiralama oranı.
    // VEHİCLE TYPE
    private TypeDescription type_description; // Tip Açıklama.
    // CITY & COUNTRY NAMES
    private String city_name;// .
    private String country_name;// .
    // Fiyatlandırma
    private Double price; //.
    // marka
    private String brand;//.
    // status 
    private int status;
    // Arac resim
    private String car_img;//.

    public Vehicles() {
    }

    /**
     * Type Description
     *
     * @param type_description
     */
    public Vehicles(String type_description) {
        this.type_description = new TypeDescription(type_description);
    }

    public Vehicles(int id, String current_mileage, String date_mot_due,
            String engine_size, String daily_hire_rate, String model_name,
            TypeDescription td, String city_name, String country_name,
            Double price, String brand, int status, String car_img) {
        this.id = id;
        this.current_mileage = current_mileage;
        this.date_mot_due = date_mot_due;
        this.engine_size = engine_size;
        this.models = new Models(daily_hire_rate, model_name);
        this.type_description = td;
        this.city_name = city_name;
        this.country_name = country_name;
        this.price = price;
        this.brand = brand;
        this.status = status;
        this.car_img = car_img;
    }

    public Vehicles(int id, String current_mileage, String date_mot_due,
            String engine_size, String daily_hire_rate, String model_name,
            String type_description, String city_name, String country_name,
            Double price, String brand, int status,String car_img) {
        this.id = id;
        this.current_mileage = current_mileage;
        this.date_mot_due = date_mot_due;
        this.engine_size = engine_size;
        this.models = new Models(daily_hire_rate, model_name);
        this.type_description = new TypeDescription(type_description);
        this.city_name = city_name;
        this.country_name = country_name;
        this.price = price;
        this.brand = brand;
        this.status = status;
        this.car_img = car_img;
       
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
     * @return the current_mileage
     */
    public String getCurrent_mileage() {
        return current_mileage;
    }

    /**
     * @param current_mileage the current_mileage to set
     */
    public void setCurrent_mileage(String current_mileage) {
        this.current_mileage = current_mileage;
    }

    /**
     * @return the date_mot_due
     */
    public String getDate_mot_due() {
        return date_mot_due;
    }

    /**
     * @param date_mot_due the date_mot_due to set
     */
    public void setDate_mot_due(String date_mot_due) {
        this.date_mot_due = date_mot_due;
    }

    /**
     * @return the engine_size
     */
    public String getEngine_size() {
        return engine_size;
    }

    /**
     * @param engine_size the engine_size to set
     */
    public void setEngine_size(String engine_size) {
        this.engine_size = engine_size;
    }

    /**
     * @return the type_description
     */
    public TypeDescription getType_description() {
        return type_description;
    }

    /**
     * @param type_description the type_description to set
     */
    public void setType_description(String type_description) {
        this.type_description = new TypeDescription(type_description);
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

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the models
     */
    public Models getModels() {
        return models;
    }

    /**
     *
     * @param daily_hire_rate
     * @param model_name
     */
    public void setModels(String daily_hire_rate, String model_name) {
        this.models = new Models(daily_hire_rate, model_name);
    }

    /**
     * @return the car_img
     */
    public String getCar_img() {
        return car_img;
    }

    /**
     * @param car_img the car_img to set
     */
    public void setCar_img(String car_img) {
        this.car_img = car_img;
    }

}

package com.vedat.modules;

import java.io.Serializable;

/**
 *
 * @author Vedat Önal
 */
public class City implements Serializable {

    private int id;
    private String name;
    private String country_name;

    public City(int id, String name, String country_name) {
        this.id = id;
        this.name = name;
        this.country_name = country_name;
    }

    public City(int id, String name) {
        this.id = id;
        this.name = name;
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

    
}

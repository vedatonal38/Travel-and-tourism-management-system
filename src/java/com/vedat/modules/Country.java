package com.vedat.modules;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Vedat Önal
 */
public class Country implements Serializable {
    
    private int id;
    private String name;
    private ArrayList<City> citys;

    public Country(int id, String name, int c) {
        this.id = id;
        this.name = name;
        this.citys = new ArrayList<>();
    }

    
    public Country(int id, String name) {
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
     * @return the citys
     */
    public ArrayList<City> getCitys() {
        return citys;
    }

    /**
     * @param citys the citys to set
     */
    public void setCitys(City citys) {
        this.citys.add(citys);
    }
    
    
    
}

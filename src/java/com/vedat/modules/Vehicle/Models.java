package com.vedat.modules.Vehicle;

import java.io.Serializable;

/**
 *
 * @author Vedat Önal
 */
public class Models implements Serializable {

    private String daily_hire_rate; // Günlük kiralama oranı.
    private String model_name; // model adı.

    public Models(String daily_hire_rate, String model_name) {
        this.daily_hire_rate = daily_hire_rate;
        this.model_name = model_name;
    }

    /**
     * @return the daily_hire_rate
     */
    public String getDaily_hire_rate() {
        return daily_hire_rate;
    }

    /**
     * @param daily_hire_rate the daily_hire_rate to set
     */
    public void setDaily_hire_rate(String daily_hire_rate) {
        this.daily_hire_rate = daily_hire_rate;
    }

    /**
     * @return the model_name
     */
    public String getModel_name() {
        return model_name;
    }

    /**
     * @param model_name the model_name to set
     */
    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    
}

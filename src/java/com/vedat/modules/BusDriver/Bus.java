package com.vedat.modules.BusDriver;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vedat Önal
 */
public class Bus implements Serializable {

    private int id;
    private String agancet_name;
    // CITY & COUNTRY NAMES (FROM)
    private String from_city_name;
    private String from_country_name;
    // CITY & COUNTRY NAMES (TO)
    private String to_city_name;
    private String to_country_name;
    // Fiyatlandırma
    private Double price;
    // RANDOM DATETIME
    private String[] time = {"00:00", "01:00", "02:00",
        "03:00", "04:00", "05:00",
        "06:00", "07:00", "08:00",
        "09:00", "10:00", "11:00",
        "12:00", "13:00", "14:00",
        "15:00", "16:00", "17:00",
        "18:00", "19:00", "20:00",
        "21:00", "22:00", "23:00"}; // length = 24
    private String dateFrom, dateTo, timeFrom, timeTo;

    public Bus(int id, String agancet_name, String from_city_name, String from_country_name,
            String to_city_name, String to_country_name, Double price) {
        this.id = id;
        this.agancet_name = agancet_name;
        this.from_city_name = from_city_name;
        this.from_country_name = from_country_name;
        this.to_city_name = to_city_name;
        this.to_country_name = to_country_name;
        this.price = price;
        // 
        this.dateFrom = this.getFromDate();
        this.timeFrom = this.getRandomTime(time);
        this.dateTo = this.getRandomToDate();
        this.timeTo = this.getRandomTime(time);
    }

    public String getDifferenceDate() {
        SimpleDateFormat obj = new SimpleDateFormat("yyyyy-MM-dd HH:mm");
        long time_difference=0;
        try {
            Date fr = obj.parse(this.dateFrom + " " + this.timeFrom);
            Date to = obj.parse(this.dateTo + " " + this.timeTo);
            
            time_difference = to.getTime() - fr.getTime();

        } catch (ParseException ex) {

            return null;
        }

        // Calucalte time difference in years  
        // long years_difference = (time_difference / (1000 * 60 * 60 * 24 * 365));
        // Calucalte time difference in days  
        long days_difference = (time_difference / (1000 * 60 * 60 * 24)) % 365;
        // Calucalte time difference in hours  
        long hours_difference = (time_difference / (1000 * 60 * 60)) % 24;
        // Calucalte time difference in minutes  
        // long minutes_difference = (time_difference / (1000 * 60)) % 60;
        // Calucalte time difference in seconds  
        // long seconds_difference = (time_difference / 1000) % 60;

        return days_difference +"gün "+hours_difference+"sa";
    }

    private <T> T getRandomTime(T[] arr) {
        int item = ThreadLocalRandom.current().nextInt(arr.length);
        return arr[item];
    }

    public String getFromDate() {
        LocalDate from = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return from.format(formatter);
    }

    public String getRandomToDate() {
        LocalDate s = LocalDate.now();
        int[] nextMonth = this.getNextMonthArrayInt();
        LocalDate end = LocalDate.of(nextMonth[0], nextMonth[1], nextMonth[2]);
        long e = end.toEpochDay();// ilerde
        long se = s.toEpochDay();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        long randomEpocDay = ThreadLocalRandom.current().longs(se, e).findAny().getAsLong();
        return LocalDate.ofEpochDay(randomEpocDay).format(formatter);

    }

    private String getNextMonth() {
        String ref = this.getFromDate();
        String[] reff = ref.split("-");
        int year = Integer.parseInt(reff[0]);
        int month = Integer.parseInt(reff[1]);
//        int day = Integer.parseInt(reff[2]);

        if (month == 12) {
            year++;
            month = 1;
            reff[0] = "" + year;
            reff[1] = "0" + month;
        } else {
            month++;
            if (month < 10) {
                reff[1] = "0" + month;
            } else {
                reff[1] = "" + month;
            }
        }
        return reff[0] + "-" + reff[1] + "-" + reff[2];
    }

    private String[] getNextMonthArray() {
        String ref = this.getFromDate();
        String[] reff = ref.split("-");
        int year = Integer.parseInt(reff[0]);
        int month = Integer.parseInt(reff[1]);
//        int day = Integer.parseInt(reff[2]);

        if (month == 12) {
            year++;
            month = 1;
            reff[0] = "" + year;
            reff[1] = "0" + month;
        } else {
            month++;
            if (month < 10) {
                reff[1] = "0" + month;
            } else {
                reff[1] = "" + month;
            }
        }
        return reff;
    }

    private int[] getNextMonthArrayInt() {
        String ref = this.getFromDate();
        String[] reff = ref.split("-");
        int[] date = {Integer.parseInt(reff[0]),// year
            Integer.parseInt(reff[1]), // mounth
            Integer.parseInt(reff[2]) // day 
    };
        if (date[1] == 12) {
            date[0]++;
            date[1] = 1;
        } else {
            date[1]++;
        }

        return date;
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
     * @return the agancet_name
     */
    public String getAgancet_name() {
        return agancet_name;
    }

    /**
     * @param agancet_name the agancet_name to set
     */
    public void setAgancet_name(String agancet_name) {
        this.agancet_name = agancet_name;
    }

    /**
     * @return the from_city_name
     */
    public String getFrom_city_name() {
        return from_city_name;
    }

    /**
     * @param from_city_name the from_city_name to set
     */
    public void setFrom_city_name(String from_city_name) {
        this.from_city_name = from_city_name;
    }

    /**
     * @return the from_country_name
     */
    public String getFrom_country_name() {
        return from_country_name;
    }

    /**
     * @param from_country_name the from_country_name to set
     */
    public void setFrom_country_name(String from_country_name) {
        this.from_country_name = from_country_name;
    }

    /**
     * @return the to_city_name
     */
    public String getTo_city_name() {
        return to_city_name;
    }

    /**
     * @param to_city_name the to_city_name to set
     */
    public void setTo_city_name(String to_city_name) {
        this.to_city_name = to_city_name;
    }

    /**
     * @return the to_country_name
     */
    public String getTo_country_name() {
        return to_country_name;
    }

    /**
     * @param to_country_name the to_country_name to set
     */
    public void setTo_country_name(String to_country_name) {
        this.to_country_name = to_country_name;
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
     * @return the dateFrom
     */
    public String getDateFrom() {
        return dateFrom;
    }

    /**
     * @return the dateTo
     */
    public String getDateTo() {
        return dateTo;
    }

    /**
     * @return the timeFrom
     */
    public String getTimeFrom() {
        return timeFrom;
    }

    /**
     * @return the timeTo
     */
    public String getTimeTo() {
        return timeTo;
    }
}

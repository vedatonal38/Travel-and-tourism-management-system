package com.vedat.modules.reservations;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Vedat Önal
 */
public class PackagesBooking implements Serializable {
    
    private int id;
    private Date creat;
    private int cus_id;
    private int package_id;
    private int admin_id;

    // 
    public PackagesBooking(int id, Date creat, int cus_id, int package_id, int admin_id) {
        this.id = id;
        this.creat = creat;
        this.cus_id = cus_id;
        this.package_id = package_id;
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
     * @return the creat
     */
    public Date getCreat() {
        return creat;
    }

    /**
     * @param creat the creat to set
     */
    public void setCreat(Date creat) {
        this.creat = creat;
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
     * @return the package_id
     */
    public int getPackage_id() {
        return package_id;
    }

    /**
     * @param package_id the package_id to set
     */
    public void setPackage_id(int package_id) {
        this.package_id = package_id;
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

    
}

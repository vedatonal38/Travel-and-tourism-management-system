package com.vedat.modules;

import java.io.Serializable;

/**
 *
 * @author Vedat Önal
 */
public class Admin implements Serializable{

    private int id;
    private String username;
    private String fullname;
    private String email;
    private String password;
    // split
    private String name;
    private String surname;

    // login 1
    public Admin(int id, String username, String fullname, String email, String password) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        
        this.fullNameSplit(fullname);
    }
    
    // login 2
    public Admin(int id, String username, String fullname, String email, String password, String name, String surname) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }
    
    private void fullNameSplit(String fullname) {
        String[] split = fullname.split(" ");
        this.name = split[0];
        if(split.length == 2) {
            this.surname = split[1];
        } else {
            this.surname = "";
            for (int i = 1; i < split.length; i++) {
                String string = split[i];
                if(i < split.length)
                    this.surname += string + " ";
                else 
                    this.surname += string;
            }
        }
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
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the name
     */
    public String getName() {
        
        return name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }
    
    
}

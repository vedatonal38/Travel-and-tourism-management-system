package com.vedat.modules.Vehicle;

import java.io.Serializable;

/**
 *
 * @author Vedat Önal
 */
public class TypeDescription implements Serializable {

    // VEHİCLE TYPE
    private int id;
    private String type_description; // Tip Açıklama.

    public TypeDescription(String type_description) {
        this.type_description = type_description;
    }

    public TypeDescription(int id, String type_description) {
        this.id = id;
        this.type_description = type_description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    /**
     * @return the type_description
     */
    public String getType_description() {
        return type_description;
    }

    /**
     * @param type_description the type_description to set
     */
    public void setType_description(String type_description) {
        this.type_description = type_description;
    }

}

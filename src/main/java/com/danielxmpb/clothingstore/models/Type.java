package com.danielxmpb.clothingstore.models;

/**
 *
 * @author Daniel Pérez
 */
public class Type {

    private Integer idType;
    private String name;

    public Type() {
    }

    public Type(Integer idType, String name) {
        this.idType = idType;
        this.name = name;
    }

    public Integer getIdType() {
        return idType;
    }

    public void setIdType(Integer idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

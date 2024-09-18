package com.danielxmpb.clothingstore.models;

/**
 *
 * @author Daniel Pérez
 */
public class Size {

    private Integer idSize;
    private String name;

    public Size() {
    }

    public Size(Integer idSize, String name) {
        this.idSize = idSize;
        this.name = name;
    }

    public Integer getIdSize() {
        return idSize;
    }

    public void setIdSize(Integer idSize) {
        this.idSize = idSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

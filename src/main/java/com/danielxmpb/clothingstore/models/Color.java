package com.danielxmpb.clothingstore.models;

/**
 *
 * @author Daniel Pérez
 */
public class Color {

    private Integer idColor;
    private String name;

    public Color() {
    }

    public Color(Integer idColor, String name) {
        this.idColor = idColor;
        this.name = name;
    }

    public Integer getIdColor() {
        return idColor;
    }

    public void setIdColor(Integer idColor) {
        this.idColor = idColor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

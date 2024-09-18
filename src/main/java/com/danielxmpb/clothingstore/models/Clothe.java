package com.danielxmpb.clothingstore.models;

import java.util.List;

/**
 *
 * @author Daniel Pérez
 */
public class Clothe {

    private String idClothe;
    private String name;
    private String description;
    private Integer price;
    private Integer stock;
    private double rating;
    private String image;
    private String idOwner;
    private List<Color> colors;
    private List<Size> sizes;
    private List<Type> types;

    public Clothe() {
    }

    public Clothe(String idClothe, String name, String description, Integer price, Integer stock, double rating,
            String image, String idOwner, List<Color> colors, List<Size> sizes, List<Type> types) {
        this.idClothe = idClothe;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.rating = rating;
        this.image = image;
        this.idOwner = idOwner;
        this.colors = colors;
        this.sizes = sizes;
        this.types = types;
    }

    public Clothe(String idClothe, String name, Integer price, Integer stock, double rating, String image) {
        this.idClothe = idClothe;
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.rating = rating;
        this.image = image;
    }

    public String getIdClothe() {
        return idClothe;
    }

    public void setIdClothe(String idClothe) {
        this.idClothe = idClothe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIdOwner() {
        return idOwner;
    }

    public void setIdOwner(String idOwner) {
        this.idOwner = idOwner;
    }

    public List<Color> getColors() {
        return colors;
    }

    public void setColors(List<Color> colors) {
        this.colors = colors;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

}

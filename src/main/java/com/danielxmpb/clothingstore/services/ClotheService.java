package com.danielxmpb.clothingstore.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.danielxmpb.clothingstore.models.Clothe;
import com.danielxmpb.clothingstore.repository.DatabaseConnection;

/**
 *
 * @author Daniel Pérez
 */
public class ClotheService {

    public List<Clothe> getAllClothes() throws SQLException {
        List<Clothe> clothes = new ArrayList<>();
        String query = "SELECT cl.id_clothe, cl.name, cl.price, cl.stock, cl.rating FROM clothes cl;";
        ResultSet response = new DatabaseConnection().select(query);
        while (response.next()) {
            Clothe clothe = new Clothe();
            clothe.setIdClothe(response.getString("id_clothe"));
            clothe.setName(response.getString("name"));
            clothe.setPrice(response.getInt("price"));
            clothe.setStock(response.getInt("stock"));
            clothe.setRating(response.getDouble("rating"));
            clothes.add(clothe);
        }
        return clothes;
    }

}

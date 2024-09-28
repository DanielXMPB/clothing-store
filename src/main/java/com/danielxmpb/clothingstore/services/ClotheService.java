package com.danielxmpb.clothingstore.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.danielxmpb.clothingstore.models.Clothe;
import com.danielxmpb.clothingstore.repository.DatabaseConnection;

/**
 *
 * @author Daniel Pérez
 */
public class ClotheService {

    public List<Clothe> getAllClothes() throws SQLException {
        List<Clothe> clothes = new ArrayList<>();
        String query = "SELECT cl.id_clothe, cl.name, cl.price, cl.stock, cl.rating, cl.image FROM clothes cl;";

        try (Connection conn = new DatabaseConnection().connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Clothe clothe = new Clothe();
                clothe.setIdClothe(rs.getString("id_clothe"));
                clothe.setName(rs.getString("name"));
                clothe.setPrice(rs.getInt("price"));
                clothe.setStock(rs.getInt("stock"));
                clothe.setRating(rs.getDouble("rating"));
                clothe.setImage(rs.getString("image"));
                clothes.add(clothe);
            }
        } catch (Exception e) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, e);
        }
        return clothes;
    }

}

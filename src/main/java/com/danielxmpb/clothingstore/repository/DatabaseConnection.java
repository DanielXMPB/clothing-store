package com.danielxmpb.clothingstore.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel Pérez
 */
public class DatabaseConnection {
    String database = "clothing_store";
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "daniel101002";
    String driver = "com.mysql.cj.jdbc.Driver";
    Connection conn;

    public DatabaseConnection() {
    }

    public Connection connect() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url + database, user, password);
            System.out.println("Successful connection");
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Connection error");
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }

    public boolean setAutoCommit(boolean parametro, Connection conn) {
        try {
            conn.setAutoCommit(parametro);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean commit(Connection conn) {
        try {
            conn.commit();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean rollback(Connection conn) {
        try {
            conn.rollback();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void disconnect(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean insert(String query) {
        Connection conn = connect();
        if (setAutoCommit(false, conn)) {
            try {
                Statement st = conn.createStatement();
                st.executeQuery(query);
                st.close();
                conn.commit();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                rollback(conn);
                return false;
            } finally {
                disconnect(conn);
            }
        } else {
            disconnect(conn);
            return false;
        }
    }

    @SuppressWarnings("finally")
    public ResultSet select(String query) {
        Connection conn = connect();
        ResultSet response = null;
        try {
            Statement st = conn.createStatement();
            response = st.executeQuery(query);
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            disconnect(conn);
            return response;
        }
    }

    public boolean upadte(String query) {
        Connection conn = connect();
        if (setAutoCommit(false, conn)) {
            try {
                Statement st = conn.createStatement();
                st.executeQuery(query);
                st.close();
                conn.commit();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                rollback(conn);
                return false;
            } finally {
                disconnect(conn);
            }
        } else {
            disconnect(conn);
            return false;
        }
    }

    public boolean delete(String query) {
        Connection conn = connect();
        if (setAutoCommit(false, conn)) {
            try {
                Statement st = conn.createStatement();
                st.executeQuery(query);
                st.close();
                conn.commit();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                rollback(conn);
                return false;
            } finally {
                disconnect(conn);
            }
        } else {
            disconnect(conn);
            return false;
        }
    }
}

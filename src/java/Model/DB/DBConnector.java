/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Stewrat
 */
public class DBConnector {
    public static final String TABLE_ITEM = "items";
    public static final String TABLE_CUSTOMER = "customers";
    public static final String TABLE_USER = "users";
    public static final String TABLE_TRANSACTION = "transactions";
    public static final String TABLE_TRANS_PROD = "transaction_products";
    public static final String TABLE_REVIEW = "reviews";

    public static final String USER_ID = "user_id";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String ACC_TYPE = "acc_type";
    public static final String BILL_ADD = "bill_add";
    public static final String SHIP_ADD = "ship_add";
            
    public static final String ITEM_ID = "item_id";
    public static final String TYPE = "type";
    public static final String BRAND = "brand";
    public static final String SIZE = "size";
    public static final String STOCK = "stock";
    public static final String PRICE = "price";
    public static final String QTY = "qty";
    
    public static final String TRANS_ID = "transaction_id";
    public static final String DATE = "date";
    
    public static final String REVIEW = "review";
    
    private String driverName;
    private String url;
    private String database;
    private String username;
    private String password;

    /**
     * constructor for connection
     *
     * @param dN driver name
     * @param url URL
     * @param db database to access
     * @param un username
     * @param pw password
     */
    private DBConnector() {
        driverName = "com.mysql.jdbc.Driver";
        database = "securde-shoeshop";
        url = "jdbc:mysql://localhost:3306/" + database;
        username = "root";
        password = "mervin1234";//tempo

    }

    public static Connection getConnection() {
        DBConnector dbcon = new DBConnector();
        try {
            Class.forName(dbcon.getDriverName());
            Connection con = DriverManager.getConnection(dbcon.getUrl(), dbcon.getUsername(), dbcon.getPassword());

            return con;
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static int generateID(){
        Random rand= new Random();
        
        return rand.nextInt() % 1000000;
    }
}

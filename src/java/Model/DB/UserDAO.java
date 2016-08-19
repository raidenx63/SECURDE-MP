/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DB;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Stewrat
 */
public class UserDAO {
    
    public static User getUser(int id) {
        User temp = new User();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_USER + " WHERE " + DBConnector.USER_ID + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                temp.setId(rs.getInt(DBConnector.USER_ID));
                temp.setName(rs.getString(DBConnector.NAME));
                temp.setAccType(rs.getInt(DBConnector.ACC_TYPE));
            }

            return temp;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static User getUser(String username) {
        User temp = new User();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_USER + " WHERE " + DBConnector.USERNAME + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                temp.setId(rs.getInt(DBConnector.USER_ID));
                temp.setUsername(rs.getString(DBConnector.USERNAME));
                temp.setPassword(rs.getString(DBConnector.PASSWORD));
                temp.setName(rs.getString(DBConnector.NAME));
                temp.setAccType(rs.getInt(DBConnector.ACC_TYPE));
            }

            return temp;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList();
        User temp = new User();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_USER;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                temp.setId(rs.getInt(DBConnector.USER_ID));
                temp.setUsername(rs.getString(DBConnector.USERNAME));
                temp.setPassword(rs.getString(DBConnector.PASSWORD));
                temp.setName(rs.getString(DBConnector.NAME));
                temp.setAccType(rs.getInt(DBConnector.ACC_TYPE));

                list.add(temp);
            }

            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static void insertUser(User prod){
        prod.setId(DBConnector.generateID());
        String query = "INSERT INTO " + DBConnector.TABLE_USER + "(" + DBConnector.USER_ID + ", " + DBConnector.USERNAME + ", " + DBConnector.PASSWORD + ", " + DBConnector.EMAIL + ", " + DBConnector.NAME + ", " + DBConnector.ACC_TYPE + ") VALUES(?,?,?,?,?,?)";
        Connection con = (Connection) DBConnector.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, prod.getId());
            ps.setString(2, prod.getUsername());
            ps.setString(3, prod.getPassword());
            ps.setString(4, prod.getEmail());
            ps.setString(5, prod.getName());
            ps.setInt(6, prod.getAccType());  

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
    }
    
    public static void insertCustomer(User prod){
        String query = "INSERT INTO " + DBConnector.TABLE_USER + "(" + DBConnector.USER_ID + ", " + DBConnector.USERNAME + ", " + DBConnector.PASSWORD + ", " + DBConnector.EMAIL + ", " + DBConnector.NAME + ", " + DBConnector.ACC_TYPE + ") VALUES(?,?,?,?,?,?)";
        Connection con = (Connection) DBConnector.getConnection();
        
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, prod.getId());
            ps.setString(2, prod.getUsername());
            ps.setString(3, prod.getPassword());
            ps.setString(4, prod.getEmail());
            ps.setString(5, prod.getName());
            ps.setInt(6, prod.getAccType());  

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }             
    }
    
    public static void deleteUser(int id) {
        String query = "DELETE FROM " + DBConnector.TABLE_USER + " WHERE " + DBConnector.USER_ID + " = ?";

        Connection con = (Connection) DBConnector.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
    
}

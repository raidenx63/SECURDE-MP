/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DB;

import Model.Item;
import Model.Review;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stewrat
 */
public class ReviewDAO {

    public static ArrayList<Review> getAllReviewByUserId(int id) {
        ArrayList<Review> list = new ArrayList();
        Review temp = new Review();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * "
                + "FROM " + DBConnector.TABLE_USER + " u," + DBConnector.TABLE_ITEM + " i," + DBConnector.TABLE_REVIEW + "r "
                + "WHERE u." + DBConnector.USER_ID + " = r." + DBConnector.USER_ID + " AND i." + DBConnector.ITEM_ID + " = r." + DBConnector.ITEM_ID 
                + "AND u." + DBConnector.USER_ID + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                temp.setId(rs.getInt(DBConnector.USER_ID));
                temp.setName(rs.getString(DBConnector.NAME));
                temp.setText(rs.getString(DBConnector.REVIEW));

                list.add(temp);
            }

            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Review> getAllReviewByItemId(int id) {
        ArrayList<Review> list = new ArrayList();
        Review temp = new Review();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * "
                + "FROM " + DBConnector.TABLE_USER + " u," + DBConnector.TABLE_ITEM + " i," + DBConnector.TABLE_REVIEW + "r "
                + "WHERE u." + DBConnector.USER_ID + " = r." + DBConnector.USER_ID + " AND i." + DBConnector.ITEM_ID + " = r." + DBConnector.ITEM_ID 
                + "AND i." + DBConnector.ITEM_ID + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                temp.setId(rs.getInt(DBConnector.USER_ID));
                temp.setName(rs.getString(DBConnector.NAME));
                temp.setText(rs.getString(DBConnector.REVIEW));

                list.add(temp);
            }

            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void insertReview(int userId, int itemId, Review prod) {
        
        String query = "INSERT INTO " + DBConnector.TABLE_REVIEW + "(" + DBConnector.ITEM_ID + ", " + DBConnector.USER_ID + ", " + DBConnector.REVIEW + ") VALUES(?,?,?)";
        Connection con = (Connection) DBConnector.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, itemId);
            ps.setString(3, prod.getText()); 

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
        
    }
    
    public static void deleteReview(int userId, int itemId) {
        String query = "DELETE FROM " + DBConnector.TABLE_REVIEW + " WHERE " + DBConnector.USER_ID + " = ? AND " + DBConnector.ITEM_ID + " = ?";

        Connection con = (Connection) DBConnector.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, userId);
            ps.setInt(2, itemId);

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DB;

import Model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stewrat
 */
public class ItemDAO {

    public static Item getItem(int id) {
        Item temp = new Item();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_ITEM + " WHERE " + DBConnector.ITEM_ID + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                temp.setId(rs.getInt(DBConnector.ITEM_ID));
                temp.setType(rs.getString(DBConnector.TYPE));
                temp.setBrand(rs.getString(DBConnector.BRAND));
                temp.setSize(rs.getInt(DBConnector.SIZE));
                temp.setStock(rs.getInt(DBConnector.STOCK));
                temp.setPrice(rs.getInt(DBConnector.PRICE));
            }

            return temp;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Item> getAllItem() {
        ArrayList<Item> list = new ArrayList();
        Item temp = new Item();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_ITEM;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                temp.setId(rs.getInt(DBConnector.ITEM_ID));
                temp.setType(rs.getString(DBConnector.TYPE));
                temp.setBrand(rs.getString(DBConnector.BRAND));
                temp.setSize(rs.getInt(DBConnector.SIZE));
                temp.setStock(rs.getInt(DBConnector.STOCK));
                temp.setPrice(rs.getInt(DBConnector.PRICE));

                list.add(temp);
            }

            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static ArrayList<Item> getItemsByType(int type){
        ArrayList<Item> list = new ArrayList();
        Item temp = new Item();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_ITEM + " WHERE " + DBConnector.TYPE + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, type);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                temp.setId(rs.getInt(DBConnector.ITEM_ID));
                temp.setType(rs.getString(DBConnector.TYPE));
                temp.setBrand(rs.getString(DBConnector.BRAND));
                temp.setSize(rs.getInt(DBConnector.SIZE));
                temp.setStock(rs.getInt(DBConnector.STOCK));
                temp.setPrice(rs.getInt(DBConnector.PRICE));
                
                list.add(temp);
            }

            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
        
    }

    public static void insertItem(Item prod) {
        String query = "INSERT INTO " + DBConnector.TABLE_ITEM + "(" + DBConnector.TYPE + ", " + DBConnector.BRAND + ", " + DBConnector.SIZE + ", " + DBConnector.STOCK + ", " + DBConnector.PRICE + ", " + DBConnector.QTY + ") VALUES(?,?,?,?,?,?)";
        Connection con = (Connection) DBConnector.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, prod.getType());
            ps.setString(2, prod.getBrand());
            ps.setInt(3, prod.getSize());
            ps.setInt(4, prod.getStock());
            ps.setFloat(5, prod.getPrice());
            ps.setInt(6, prod.getQty());

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void deleteItem(int id) {
        String query = "DELETE FROM " + DBConnector.TABLE_ITEM + " WHERE " + DBConnector.ITEM_ID + " = ?";

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

    public static void updateItem(ArrayList<String> columnNames, ArrayList<String> values, int id) {
        String query = "UPDATE " + DBConnector.TABLE_ITEM + " SET ";

        for (int i = 0; i < columnNames.size(); i++) {
            query += columnNames.get(i) + " = " + values.get(i) + ", ";
        }

        query = query.substring(0, query.lastIndexOf(","));

        query += "WHERE " + DBConnector.ITEM_ID + " = ?";

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

    public static ArrayList<Item> getAllTransItems(int id) {
        ArrayList<Item> list = new ArrayList();
        Item temp = new Item();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_TRANS_PROD + "WHERE " + DBConnector.TRANS_ID + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                temp.setId(rs.getInt(DBConnector.ITEM_ID));
                temp.setQty(rs.getInt(DBConnector.QTY));

                list.add(temp);
            }
            
            for (Item item : list) {
                Item temp2 = getItem(item.getId());
                temp2.setQty(item.getQty());
                
                list.remove(item);
                list.add(temp2);
            }

            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

}

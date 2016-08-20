/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DB;

import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stewrat
 */
public class CustomerDAO {
    
    public static Customer getCustomer(int id) {
        Customer temp = new Customer();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_USER + " u, " + DBConnector.TABLE_CUSTOMER + " c, " + " WHERE u." + DBConnector.USER_ID + " = c." + DBConnector.USER_ID + " AND c." + DBConnector.USER_ID + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                temp.setId(rs.getInt(DBConnector.USER_ID));
                temp.setName(rs.getString(DBConnector.NAME));
                temp.setAccType(rs.getInt(DBConnector.ACC_TYPE));
                temp.setShipAdd(rs.getString(DBConnector.SHIP_ADD));
                temp.setBillAdd(rs.getString(DBConnector.BILL_ADD));
            }

            return temp;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
    public static Customer getCustomer(String username) {
        Customer temp = new Customer();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_USER + " u, " + DBConnector.TABLE_CUSTOMER + " c, " + " WHERE u." + DBConnector.USER_ID + " = c." + DBConnector.USER_ID + " AND c." + DBConnector.USERNAME + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                temp.setId(rs.getInt(DBConnector.USER_ID));
                temp.setName(rs.getString(DBConnector.NAME));
                temp.setAccType(rs.getInt(DBConnector.ACC_TYPE));
                temp.setShipAdd(rs.getString(DBConnector.SHIP_ADD));
                temp.setBillAdd(rs.getString(DBConnector.BILL_ADD));
            }

            return temp;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> list = new ArrayList();
        Customer temp = new Customer();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_USER + " u, " + DBConnector.TABLE_CUSTOMER + " c, " + " WHERE u." + DBConnector.USER_ID + " = c." + DBConnector.USER_ID;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                temp.setId(rs.getInt(DBConnector.USER_ID));
                temp.setName(rs.getString(DBConnector.NAME));
                temp.setAccType(rs.getInt(DBConnector.ACC_TYPE));
                temp.setShipAdd(rs.getString(DBConnector.SHIP_ADD));
                temp.setBillAdd(rs.getString(DBConnector.BILL_ADD));

                list.add(temp);
            }

            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void insertCustomer(Customer prod) {
        prod.setId(DBConnector.generateID());
        
        UserDAO.insertCustomer(prod);
        
        String query = "INSERT INTO " + DBConnector.TABLE_CUSTOMER + "(" + DBConnector.USER_ID + ", " + DBConnector.BILL_ADD + ", " + DBConnector.SHIP_ADD + ") VALUES(?,?,?)";
        Connection con = (Connection) DBConnector.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, prod.getId());
            ps.setString(2, prod.getBillAdd());
            ps.setString(3, prod.getShipAdd()); 

            ps.executeUpdate();

            ps.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
        
    }
    
    public static void deleteCustomer(int id) {
        String query = "DELETE FROM " + DBConnector.TABLE_CUSTOMER + " WHERE " + DBConnector.USER_ID + " = ?";

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

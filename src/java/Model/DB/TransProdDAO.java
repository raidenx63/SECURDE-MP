/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DB;

import Model.Customer;
import Model.Item;
import Model.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Stewrat
 */
public class TransProdDAO {

    public static Transaction getTransProd(int id) {
        Transaction temp = new Transaction();
        Customer c = new Customer();
        Item i = new Item();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_TRANSACTION + "t, " + DBConnector.TABLE_TRANS_PROD + "p" + " WHERE t." + DBConnector.TRANS_ID + " = p." + DBConnector.TRANS_ID + " AND " + DBConnector.TRANS_ID + " = ?";

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                temp.setId(rs.getInt(DBConnector.TRANS_ID));
                c = CustomerDAO.getCustomer(rs.getInt(DBConnector.USER_ID));

                temp.setUser(c);

                ArrayList<Item> list = ItemDAO.getAllTransItems(temp.getId());

                temp.setList(list);
            }

            return temp;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Transaction> getAllTransProd() {
        ArrayList<Transaction> list = new ArrayList();
        Transaction temp = new Transaction();
        Customer c = new Customer();
        Item i = new Item();
        Connection con = (Connection) DBConnector.getConnection();
        String query = "SELECT * FROM " + DBConnector.TABLE_TRANSACTION + " t, " + DBConnector.TABLE_TRANS_PROD + " p" + " WHERE t." + DBConnector.TRANS_ID + " = p." + DBConnector.TRANS_ID;

        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                temp.setId(rs.getInt(DBConnector.TRANS_ID));
                c = CustomerDAO.getCustomer(rs.getInt(DBConnector.USER_ID));

                temp.setUser(c);

                ArrayList<Item> iList = ItemDAO.getAllTransItems(temp.getId());

                temp.setList(iList);

                list.add(temp);
            }

            return list;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static void insertTransProd(Transaction prod) {
        String query = "INSERT INTO " + DBConnector.TABLE_TRANS_PROD + "(" + DBConnector.TRANS_ID + ", " + DBConnector.ITEM_ID + ", " + DBConnector.QTY + ") VALUES(?,?,?)";
        Connection con = (Connection) DBConnector.getConnection();
        try {
            PreparedStatement ps = (PreparedStatement) con.prepareStatement(query);
            
            for (Item item : prod.getList()) {
                ps.setInt(1, prod.getId());
                ps.setInt(2, item.getId());
                ps.setInt(3, item.getQty());

                ps.executeUpdate();
            }

            ps.close();
            con.close();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void deleteTransProd(int id) {
        String query = "DELETE FROM " + DBConnector.TABLE_TRANS_PROD + " WHERE " + DBConnector.TRANS_ID + " = ?";

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

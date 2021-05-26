package com.eatery.data;

import com.eatery.models.Burger;
import com.eatery.models.Drinks;
import com.eatery.models.Fries;
import com.eatery.models.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlHelper implements DBHelper {
    private Connection con;

    public MySqlHelper() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/drive_thru", "root", "password");
    }

    @Override
    public int createItem(Item item) throws SQLException {
        int itemIdCount = -1;
        try {

            String query = "INSERT INTO items (ItemName, Price, Visibility, Offers, Type)"
                    + " values (?, ?, ?, ?, ?, ?)";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, item.getItemName());
            preparedStmt.setInt(2, item.getPrice());
            preparedStmt.setBoolean(3, item.getVisibility());
            preparedStmt.setInt(4, item.getOffers());
            preparedStmt.setString(5, item.getType());

            // execute the prepared statement
            itemIdCount = preparedStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }

        return itemIdCount;
    }

    @Override
    public Item getItem(int itemId) throws SQLException {
        Item item = null;
        try {
            String query = "SELECT * FROM ITEMS WHERE ITEMID = ?";

            // create the mysql insert prepared statement
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, itemId);


            // execute the prepared statement
            ResultSet resultSet = preparedStmt.executeQuery();
            String itemName = resultSet.getString("ItemName");
            int price = resultSet.getInt("Price");
            Boolean visibility = resultSet.getBoolean("Visibility");
            int offers = resultSet.getInt("Offers");
            String type = resultSet.getString("Type");

            if(type.equalsIgnoreCase("Burger")) {
                item = new Burger(itemId, itemName, price, visibility, offers, type);
            } else if(type.equalsIgnoreCase("Fries")) {
                item = new Fries(itemId, itemName, price, visibility, offers, type);
            } else {
                item = new Drinks(itemId, itemName, price, visibility, offers, type);
            }

        } catch(Exception s){
                s.printStackTrace();
        } finally {
            con.close();
        }

        return item;
    }


    @Override
    public List<Item> getItems() {
        ArrayList<Item> result = new ArrayList<>();
        try {
            String query = "select * from items";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            ResultSet resultSet = preparedStmt.executeQuery();

            while (resultSet.next()) {
                int itemId = resultSet.getInt("ItemId");
                String itemName = resultSet.getString("ItemName");
                int price = resultSet.getInt("Price");
                Boolean visibility = resultSet.getBoolean("Visibility");
                int offers = resultSet.getInt("Offers");
                String type = resultSet.getString("Type");

                Item item;
                if(type.equalsIgnoreCase("Burger")) {
                    item = new Burger(itemId, itemName, price, visibility, offers, type);
                } else if(type.equalsIgnoreCase("Fries")) {
                    item = new Fries(itemId, itemName, price, visibility, offers, type);
                } else {
                    item = new Drinks(itemId, itemName, price, visibility, offers, type);
                }
                result.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean updateItem(Item item) {
        return false;
    }

    @Override
    public boolean deleteItem(Item item) {
        return false;
    }
}

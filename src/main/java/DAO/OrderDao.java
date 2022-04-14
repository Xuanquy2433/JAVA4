package DAO;

import DTO.Item;
import DTO.OrderDTO;
import Utils.DBProvider;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author XuanQuy
 */
public class OrderDao {

    public boolean insert(OrderDTO order) {
        Connection conn = DBProvider.getConnection();
        try {
            System.out.println("them order");
            String sql = "INSERT INTO orders(userId,customerName, addressShip,phone , total,status, createAt) VALUES(?, ?,?, ?, ?,?, ?)";
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                pst.setInt(1, order.getUserId());
                pst.setString(2, order.getCustomerName());
                pst.setString(3, order.getAddressShip());
                pst.setString(4, order.getPhone());
                pst.setFloat(5, order.getTotal());
                pst.setString(6, order.getStatus());
//                pst.setDate(6, (Date) order.getCreateAt());
                pst.setDate(7, java.sql.Date.valueOf(java.time.LocalDate.now()));
                int result = pst.executeUpdate();
                long orderId = 0;
                if (result > 0) {
                    System.err.println("go here sql detail");
                    ResultSet generatedKeys = pst.getGeneratedKeys();

                    if (generatedKeys.next()) {
                        orderId = generatedKeys.getInt(1);
                    }

                    if (orderId > 0) {
                        Integer orderIdConvert = (int) (long) orderId;
                        ArrayList<Item> items = order.getItems();
                        String sqlDetail2 = "INSERT INTO orderdetail (orderId, productId, price, quantity) VALUES(?, ?, ?, ?)";
                        PreparedStatement pst1 = conn.prepareStatement(sqlDetail2);

                        for (Item item : items) {
                            pst1.setInt(1, (int) orderId);
                            pst1.setInt(2, item.getMaSp());
                            pst1.setFloat(3, item.getPrice());
                            pst1.setInt(4, item.getSoLuong());
                            pst1.executeUpdate();
                        }

                    }

                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;

    }
}

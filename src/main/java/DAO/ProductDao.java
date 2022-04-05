/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ProductDTO;
import Utils.DBProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XuanQuy
 */
public class ProductDao {

    Connection conn = DBProvider.getConnection();

    public int create(ProductDTO cat) {
        boolean result = false;
        int id = 0;
        try {
            String sql = "INSERT INTO product(name, image, price, description) VALUES(?, ?, ?,?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, cat.getName());
            pst.setString(2, cat.getImage());
            pst.setInt(3, cat.getPrice());
            pst.setString(4, cat.getDescription());
            if (pst.executeUpdate() > 0) {
                // Retrieves any auto-generated keys created as a result of executing this Statement object
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                }
                System.out.println("id" + id);
            }
            return id;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public ProductDTO getDetailByid(int id) {
        ProductDTO cat = new ProductDTO();
        try {
            String sql = "SELECT * FROM product where id =  ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
                cat.setImage(rs.getString("image"));
                cat.setPrice(rs.getInt("price"));
                cat.setDescription(rs.getString("description"));
            }
            return cat;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ProductDTO> getList() {
        DecimalFormat twoPlaces = new DecimalFormat("0.00");
        List<ProductDTO> ListCat = new ArrayList<ProductDTO>();
        try {
            String sql = "SELECT * FROM product";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                ProductDTO product = new ProductDTO(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getInt(4), rst.getString(5));
                ListCat.add(product);
            }
            return ListCat;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(ProductDTO cat) {
        try {
            String sql = "update  product set name = ? ,image=?, price = ? ,description =? where  id = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, cat.getName());
            pst.setString(2, cat.getImage());
            pst.setInt(3, cat.getPrice());
            pst.setString(4, cat.getDescription());
            pst.setInt(5, cat.getId());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        boolean result = false;
        try {
            String sql = "DELETE from product where id=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            int ketqua = pst.executeUpdate();
            if (ketqua > 0) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CategoryDTO;
import Utils.DBProvider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XuanQuy
 */
public class CategoryDao {

    Connection conn = DBProvider.getConnection();

    public int create(CategoryDTO cat) {
        boolean result = false;
        int id = 0;
        try {
            String sql = "INSERT INTO category(name, description, image) VALUES(?, ?, ?)";
            PreparedStatement pst = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, cat.getName());
            pst.setString(2, cat.getDescription());
            pst.setString(3, cat.getImage());
            //int ketqua = pst.executeUpdate();
//            if (ketqua > 0) {

            if (pst.executeUpdate() > 0) {
                // Retrieves any auto-generated keys created as a result of executing this Statement object
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    id = generatedKeys.getInt(1);
                }
                System.out.println("id" + id);
            }
            return id;
            // }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    public CategoryDTO getDetailByid(int id) {
        CategoryDTO cat = new CategoryDTO();
        try {
            String sql = "SELECT * FROM category where id =  ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
                cat.setDescription(rs.getString("description"));
                cat.setImage(rs.getString("image"));
            }
            return cat;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CategoryDTO> getList() {
        List<CategoryDTO> ListCat = new ArrayList<CategoryDTO>();
        try {
            String sql = "SELECT * FROM category";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                CategoryDTO category = new CategoryDTO(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4));
                ListCat.add(category);
            }
            return ListCat;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean update(CategoryDTO cat) {
        try {
            String sql = "update  category set name = ? ,description =?,image=? where  id = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, cat.getName());
            pst.setString(2, cat.getDescription());
            pst.setString(3, cat.getImage());
            pst.setInt(4, cat.getId());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean dalete(int id) {
        CategoryDTO cat = new CategoryDTO();
        try {
            String sql = "delete from category where  id = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setInt(1, cat.getId());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author XuanQuy
 */
public class CategoryDao {
    Connection conn = DBProvider.getConnection();

    public boolean create(CategoryDTO cat) {
        try {
            String sql = "INSERT INTO category(name, description,image) VALUES (?,?,?)";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, cat.getName());
            pst.setString(2, cat.getDescription());
            pst.setString(3, cat.getImage());

            int rs = pst.executeUpdate();
            if (rs > 0) {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
        List<CategoryDTO> listCat = new ArrayList<CategoryDTO>();

        try {
            String sql = "SELECT * FROM category";
            PreparedStatement pst = conn.prepareCall(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                CategoryDTO cat = new CategoryDTO();
                cat.setId(rs.getInt("id"));
                cat.setName(rs.getString("name"));
                cat.setDescription(rs.getString("description"));
                cat.setImage(rs.getString("image"));
                listCat.add(cat);
            }
            return listCat;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCat;

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

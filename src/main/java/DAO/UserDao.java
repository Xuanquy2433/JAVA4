/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.CategoryDTO;
import DTO.UserDTO;
import Utils.DBProvider;
import Utils.HashPassword;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author XuanQuy
 */
public class UserDao {
    
    Connection conn = DBProvider.getConnection();
    private static MessageDigest md;
    
    private String MD5(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    //mã hóa MD5 Using MessageDigest Class
    public String authen(String text) throws NoSuchAlgorithmException {
        
        MessageDigest md;
        
        md = MessageDigest.getInstance("MD5");
        
        md.update(text.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter.printHexBinary(digest).toUpperCase();
    }
    
    public boolean create(UserDTO user) {
        boolean result = false;
        try {
            String sql = "INSERT INTO user(userName, password,email,role) VALUES (?,?,?,?)";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getRole());
            int ketQua = pst.executeUpdate();
            if (ketQua >= 1) {
                result = true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean create2(UserDTO user) {
        try {
            String sql = "INSERT INTO user(userName, password,email,role,name) VALUES (?,?,?,?,?)";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, HashPassword.encrypt(user.getPassword()));
            System.out.println("hash Pass" + HashPassword.encrypt(user.getPassword()));
            pst.setString(3, user.getEmail());
            pst.setString(4, user.getRole());
            pst.setString(5, user.getName());
            
            int rs = pst.executeUpdate();
            if (rs >= 1) {
                return true;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean isLogin(String username, String password) {
        boolean result = false;
        try {
            String sql = "SELECT Count(*) FROM user where userName = ? and password = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                result = true;
                System.out.println("dung tk mk");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sai tk mk");
        }
        return false;
    }
    
    public boolean login(String username, String password) {
        boolean result = false;
        try {
            
            String sql = "SELECT * FROM user where userName = ? and password = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, username);
            pst.setString(2, HashPassword.encrypt(password));
            System.out.println("passssssssssss: " + HashPassword.encrypt(password));
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                System.out.println("dung mk");
                result = true;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
            
        }
        return result;
    }
    
    public boolean isExist(String username) {
        try {
            
            String sql = "SELECT * FROM user where userName = ? ";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, username);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return true;
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
            
        }
        return false;
    }
    
    public String role(String username, String password) {
        try {
            
            String sql = "SELECT * FROM user where userName = ? and password = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, username);
            pst.setString(2, HashPassword.encrypt(password));
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                System.out.println("da vao role admin");
                return rs.getString("role");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
            
        }
        return "";
    }
    
    public String name(String username, String password) {
        try {
            
            String sql = "SELECT * FROM user where userName = ? and password = ?";
            PreparedStatement pst = conn.prepareCall(sql);
            pst.setString(1, username);
            pst.setString(2, HashPassword.encrypt(password));
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                return rs.getString("name");
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class
                    .getName()).log(Level.SEVERE, null, ex);
            
        }
        return "";
    }
    
    public List<UserDTO> getList() {
        List<UserDTO> ListCat = new ArrayList<UserDTO>();
        try {
            String sql = "SELECT * FROM user";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                UserDTO category = new UserDTO(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6));
                ListCat.add(category);
            }
            return ListCat;
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}

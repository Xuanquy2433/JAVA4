/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author XuanQuy
 */
public class DBProvider {

    public static Connection getConnection() {
        String dbURL = "jdbc:mysql://localhost:3306/db_jav4";
        String userName = "root";
        String password = "";

        Connection conn = null;
        try {
            //call driver
//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect db sucsess");

        } catch (Exception e) {
            System.out.println("connect db failed");
            e.printStackTrace();
        }
        return conn;

    }
}

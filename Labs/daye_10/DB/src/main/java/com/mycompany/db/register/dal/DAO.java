/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.db.register.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.derby.jdbc.ClientDriver;

/**
 *
 * @author fazloka
 */
public class DAO {

    public static int register(userDTO user) throws SQLException {

        int result = -1;
        DriverManager.registerDriver(new ClientDriver());
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "root", "root");
        String checkQuery = "SELECT COUNT(*) FROM UserTable WHERE email = ?";
        PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
        checkStatement.setString(1, user.getUsername());
        ResultSet rs = checkStatement.executeQuery();
        if (rs.next() && rs.getInt(1) > 0) {
            System.out.println("User already exists!");
            return 0;
        }

        rs.close();
        checkStatement.close();

        String insertQuery = "INSERT INTO UserTable (email, password) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(insertQuery);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());
        result = statement.executeUpdate();
        
        statement.close();
        connection.close();
        return result;
    }

    public static boolean login(userDTO user) throws SQLException {
        boolean result = false;
        DriverManager.registerDriver(new ClientDriver());
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/register", "root", "root");
        String query = "SELECT * FROM UserTable WHERE EMAIL = ? AND PASSWORD = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, user.getUsername());
        statement.setString(2, user.getPassword());

        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            result = true;
        }

        rs.close();
        statement.close();
        connection.close();

        return result;

    }

}

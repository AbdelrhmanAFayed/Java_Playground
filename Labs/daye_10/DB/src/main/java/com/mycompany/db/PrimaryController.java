/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.db;

import com.mycompany.db.register.dal.DAO;
import com.mycompany.db.register.dal.userDTO;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author fazloka
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextField tf_user;
    @FXML
    private Button logbtn;
    @FXML
    private Button regbtn;
    @FXML
    private TextField tf_pass;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void LogHandle(MouseEvent event) {
        userDTO currUser = new userDTO(tf_user.getText(), tf_pass.getText());

        try {
            if (DAO.login(currUser)) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Login Success");
                alert.setHeaderText(null);
                alert.setContentText("You are logged in!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password!");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RegHanndle(MouseEvent event) {
        userDTO currUser = new userDTO(tf_user.getText(), tf_pass.getText());

        try {
            switch (DAO.register(currUser)) {
                case 0:
                    Alert alertExists = new Alert(Alert.AlertType.WARNING);
                    alertExists.setTitle("Registration Failed");
                    alertExists.setHeaderText(null);
                    alertExists.setContentText("This email is already registered. Try a different one.");
                    alertExists.showAndWait();
                    break;

                case 1: 
                    Alert alertSuccess = new Alert(Alert.AlertType.INFORMATION);
                    alertSuccess.setTitle("Registration Successful");
                    alertSuccess.setHeaderText(null);
                    alertSuccess.setContentText("User registered successfully!");
                    alertSuccess.showAndWait();
                    break;

                default: 
                    Alert alertError = new Alert(Alert.AlertType.ERROR);
                    alertError.setTitle("Error");
                    alertError.setHeaderText(null);
                    alertError.setContentText("An unexpected error occurred. Please try again.");
                    alertError.showAndWait();
                    break;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.db;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    }

    @FXML
    private void RegHanndle(MouseEvent event) {
    }
    
}

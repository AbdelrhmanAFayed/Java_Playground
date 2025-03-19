/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.msg_app;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author fazloka
 */
public class PrimaryController implements Initializable {

    @FXML
    private TextArea ta;
    @FXML
    private TextField tf;
    
     Client myClient = null ;

    /**
     * Initializes the controller class.
     */
    public class Client {

        Socket mySocket;
        DataInputStream dis;
        PrintStream ps;
        
        public void listen()
        {
            try
            {ta.appendText(dis.readLine());
            ta.appendText("\n");
            }
           catch (IOException ex) {
                ex.printStackTrace();}
           
        }
           
        public Client() {
            //System.out.println("Hello");
            try {
                mySocket = new Socket("127.0.0.1", 5005);
                dis = new DataInputStream(mySocket.getInputStream());
                ps = new PrintStream(mySocket.getOutputStream());
                
                
                
                
                
              
               //String replyMsg = dis.readLine();
               // System.out.println(replyMsg);
               
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally { 
                try {
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        }
    }

        @Override
        public void initialize(URL url, ResourceBundle rb
        ) {
            myClient = new Client();
            new Thread(new Runnable() {
            
            public void run() {
                while(true){
              myClient.listen();}
            }
             }).start();
           
        }

        @FXML
        private void Send_MSG(MouseEvent event
        ) {
             myClient.ps.println(tf.getText());
             tf.clear();

        }

    }

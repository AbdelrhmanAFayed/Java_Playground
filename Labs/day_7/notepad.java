
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert.AlertType;



public class notepad extends Application {

    BorderPane bpane;
    MenuBar mbar;
    Menu file;
    Menu edit;
    Menu help;
    MenuItem fileoptions[] = new MenuItem[5];
    MenuItem editoptions[] = new MenuItem[8];
    MenuItem helpoptions[] = new MenuItem[1];
    TextArea ta;

    
    
    public void init() throws Exception {
        
        ta = new TextArea();
        
    
        fileoptions[0] = new MenuItem("New");
        fileoptions[1] = new MenuItem("Open...");
        fileoptions[2] = new MenuItem("Save");
        fileoptions[3] = new SeparatorMenuItem();
        fileoptions[4] = new MenuItem("Exit");
        
        editoptions[0] = new MenuItem("Undo");
        editoptions[1] = new SeparatorMenuItem();
        editoptions[2] = new MenuItem("Cut");
        editoptions[3] = new MenuItem("Copy");
        editoptions[4] = new MenuItem("Paste");
        editoptions[5] = new MenuItem("Delete");
        editoptions[6] = new SeparatorMenuItem();
        editoptions[7] = new MenuItem("Select All");

        helpoptions[0] = new MenuItem("About Notepad");


        file=new Menu("File");
        file.getItems().add(fileoptions[0]);
        file.getItems().add(fileoptions[1]);
        file.getItems().add(fileoptions[2]);
        file.getItems().add(fileoptions[3]);
        file.getItems().add(fileoptions[4]);

        edit=new Menu("Edit");
        edit.getItems().add(editoptions[0]);
        edit.getItems().add(editoptions[1]);
        edit.getItems().add(editoptions[2]);
        edit.getItems().add(editoptions[3]);
        edit.getItems().add(editoptions[4]);
        edit.getItems().add(editoptions[5]);
        edit.getItems().add(editoptions[6]);
        edit.getItems().add(editoptions[7]);
        

        help=new Menu("Help");
        help.getItems().add(helpoptions[0]);
        
     
        mbar=new MenuBar();
        mbar.getMenus().addAll(file,edit,help);
        bpane=new BorderPane();
        bpane.setTop(mbar);
        bpane.setCenter(ta);
    }
     
     public void start(Stage primaryStage) throws Exception {
         
     
         
        fileoptions[0].setOnAction(new EventHandler<ActionEvent>(){
             public void handle(ActionEvent event) {
                 ta.clear();            }
         });

         fileoptions[1].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open File");
                File selectedFile = fileChooser.showOpenDialog(null);
                ta.clear();
                ta.setText(selectedFile.getName());
                        
        }
        });
        fileoptions[2].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save File");
                File selectedFile = fileChooser.showOpenDialog(null);
                
                ta.clear();
                ta.setText(selectedFile.getName());
                
            }
        });
      
        fileoptions[4].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                System.out.println("Application Closed");
                primaryStage.close();
           }
        });

        
        editoptions[0].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                ta.undo();
           }
        });
      
        editoptions[2].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
            ta.cut();    
            }
        });
        editoptions[3].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                ta.copy();
           }
        });
        editoptions[4].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                ta.paste();
           }
        });
        editoptions[5].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                ta.deleteText(ta.getSelection());
           }
        });
      
        editoptions[7].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                ta.selectAll();
           }
        });
        helpoptions[0].setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("About");
                alert.setHeaderText("JavaFX Notepad");
                alert.setContentText("14/3/2025");
                alert.showAndWait();
           }
        });
        

        
        
        
        
        
        

        
        


         Scene myS=new Scene(bpane,500,200);
         primaryStage.setScene(myS);
         primaryStage.setTitle("FX Notepad");
         primaryStage.show();
     
     
         
     }

   

    public static void main(String[] args) {
        
        Application.launch(args);
        
    }
}
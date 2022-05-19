/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import hellofx.ConnectionClass;
import java.sql.*;
import java.util.Optional;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HelloFXController implements Initializable {

    @FXML private Label thelabel;
    @FXML private TextField name;
    @FXML private TextField email;
    @FXML private TextField phnnum;
    @FXML private TextField address;
    @FXML private TextField password;
    @FXML private TextField gender;

    
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
        
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();

        try {

            Statement statement = connection.createStatement();

            PreparedStatement stmt  =connection.prepareStatement("insert into user values (?,?,?,?,?,?)");
            stmt.setString(1,name.getText());
            stmt.setString(2,password.getText());
            stmt.setString(3,phnnum.getText());
            stmt.setString(4,address.getText());
            stmt.setString(5,gender.getText());
            stmt.setString(6,email.getText());
            

          int status = stmt.executeUpdate();
            if (status > 0) {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setAlertType(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Success");
                alert.show();
            }
            else {
                Alert alert = new Alert(Alert.AlertType.NONE);
                alert.setAlertType(Alert.AlertType.ERROR);
                alert.setContentText("Invalid ");
                alert.show();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
    
    }   
    public void changeloginButtonPushed(ActionEvent event) throws IOException
    {
         Parent loginView = FXMLLoader.load(getClass().getResource("Log_in_page.fxml"));
         Scene loginScene = new Scene (loginView);
         
         Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(loginScene);
         window.show();
    }  
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handlebutton(ActionEvent event) {
        thelabel.setText("Hello Anik");
    }
    
}
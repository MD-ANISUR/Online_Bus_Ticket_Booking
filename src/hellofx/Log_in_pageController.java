/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import hellofx.ConnectionClass;
import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.net.Socket;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * FXML Controller class
 *
 * @author Asus
 */
public class Log_in_pageController implements Initializable {
    
        @FXML private TextField email;
        @FXML private PasswordField password;
        ResultSet resultSet = null;
        PreparedStatement pst = null;
    
        public void SignInButton(ActionEvent actionEvent) {

        String username = email.getText();
        String pass = password.getText();
        if ( username.equals("") && pass.equals("")) {
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.ERROR);
            a.setContentText("Invalid username or password");

            a.show();
        } else {
            try {
                ConnectionClass connectionClass = new ConnectionClass();
                Connection connection = connectionClass.getConnection();
                pst = connection.prepareStatement("select * from user where email=? and password=?");
                pst.setString(1, username);
                pst.setString(2, pass);
                resultSet = pst.executeQuery();
                if (resultSet.next()) {
                    
                    Parent parent = FXMLLoader.load(getClass().getResource("homeFXML.fxml"));
                    Scene scene = new Scene(parent);
                    Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    window.setMaximized(false);

                } else {
                    Alert alert = new Alert(Alert.AlertType.NONE);
                    alert.setAlertType(Alert.AlertType.ERROR);
                    alert.setContentText("Invalid username or password");
                    alert.show();
                }

            } catch (SQLException | IOException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HomeFXMLController implements Initializable {

    @FXML private ComboBox source;
    @FXML private ComboBox dest;
    @FXML private DatePicker date;
    
    
    @FXML
    private TableColumn<?, ?> atime;

    @FXML
    private TableColumn<?, ?> dtime;

    @FXML
    private TableColumn<?, ?> fare;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableView<?> table;
    
    public void getInformation(){
        String from = (String) source.getValue();
        String to = (String) dest.getValue();
        LocalDate date1 = date.getValue();
        //System.out.println(from+" "+to+" "+date1);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        source.getItems().add("Dhaka");
        source.getItems().add("Chittagong");
        source.getItems().add("Rajshahi");
        source.getItems().add("Cumilla");
        source.getItems().add("Sylhet");
        dest.getItems().add("Dhaka");
        dest.getItems().add("Cumilla");
        dest.getItems().add("Sylhet");
        dest.getItems().add("Khulna");
    }    
    
}
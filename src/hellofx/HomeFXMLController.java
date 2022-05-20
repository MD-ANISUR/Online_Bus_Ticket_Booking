/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HomeFXMLController implements Initializable {

    @FXML private ComboBox source1;
    @FXML private ComboBox dest1;
    @FXML private DatePicker date;
    String yellow = "-fx-background-color:#ffb805";
    
    
    @FXML
    private TableColumn<Service, Integer> atime;

    @FXML
    private TableColumn<Service, Integer> dtime;

    @FXML
    private TableColumn<Service, Integer> fare;

    @FXML
    private TableColumn<Service, String> service;

    @FXML
    private TableView<Service> tableview;
    
    
    
    
    @FXML
    private Button A3;

    @FXML
    private Button A4;

    @FXML
    private Button B1;

    @FXML
    private Button B2;

    @FXML
    private Button B3;

    @FXML
    private Button B4;

    @FXML
    private Button C1;

    @FXML
    private Button C2;

    @FXML
    private Button C3;

    @FXML
    private Button C4;

    @FXML
    private Button D1;

    @FXML
    private Button D2;

    @FXML
    private Button D3;

    @FXML
    private Button D4;

    @FXML
    private Button a2;

    @FXML
    private Button bt_1;
    
    
    @FXML
    void A1(ActionEvent event) {
        
    }

    @FXML
    void A2(ActionEvent event) {
        
    }

    @FXML
    void a3(ActionEvent event) {

    }

    @FXML
    void a4(ActionEvent event) {

    }

    @FXML
    void b1(ActionEvent event) {

    }

    @FXML
    void b2(ActionEvent event) {
        B2.setStyle(yellow);
    }

    @FXML
    void b3(ActionEvent event) {

    }

    @FXML
    void b4(ActionEvent event) {

    }

    @FXML
    void c1(ActionEvent event) {

    }

    @FXML
    void c2(ActionEvent event) {

    }

    @FXML
    void c3(ActionEvent event) {

    }

    @FXML
    void c4(ActionEvent event) {

    }

    @FXML
    void d1(ActionEvent event) {

    }

    @FXML
    void d2(ActionEvent event) {

    }

    @FXML
    void d3(ActionEvent event) {

    }

    @FXML
    void d4(ActionEvent event) {

    } 
    
    public void getInformation(){
        String from = (String) source1.getValue();
        String to = (String) dest1.getValue();
        LocalDate date1 = date.getValue();
        //System.out.println(from+" "+to+" "+date1);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        source1.getItems().add("Dhaka");
        source1.getItems().add("Chittagong");
        source1.getItems().add("Rajshahi");
        source1.getItems().add("Cumilla");
        source1.getItems().add("Sylhet");
        dest1.getItems().add("Dhaka");
        dest1.getItems().add("Cumilla");
        dest1.getItems().add("Sylhet");
        dest1.getItems().add("Khulna");
        dest1.getItems().add("Rajshahi");
        
        
    }

    public void search(ActionEvent actionEvent)  {
        loaddata();
    }
    private void loaddata() {



        ObservableList <Service> data = FXCollections.observableArrayList();



        String source = source1.getSelectionModel().getSelectedItem().toString();
        String dest = dest1.getSelectionModel().getSelectedItem().toString();
        String Date = ((LocalDate)this.date.getValue()).format(DateTimeFormatter.ISO_LOCAL_DATE);
        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        PreparedStatement pst;
        try {
            pst = connection.prepareStatement("select *  from search where source ='"+source+"' and dest = '"+dest+"'and date = '"+Date+"' ");
            ResultSet rs = pst.executeQuery();
            while (rs.next())
            {
               data.add(new Service(
                rs.getString(1),
                rs.getString(2),
                rs.getString(3),
                rs.getInt(4),
                rs.getTime(5),
                rs.getTime(6),
                rs.getString(8)));


            }
            service.setCellValueFactory(new PropertyValueFactory<>("service"));
            fare.setCellValueFactory(new PropertyValueFactory<>("fare"));
            dtime.setCellValueFactory(new PropertyValueFactory<>("dtime"));  
            atime.setCellValueFactory(new PropertyValueFactory<>("atime"));
            tableview.setItems(data);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }    
    
}
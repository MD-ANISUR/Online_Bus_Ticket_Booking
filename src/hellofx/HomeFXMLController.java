/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hellofx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class HomeFXMLController implements Initializable {

    @FXML private ComboBox source1;
    @FXML private ComboBox dest1;
    @FXML private DatePicker date;
    ResultSet resultSet;
    PreparedStatement pst;
    boolean bta1,bta2,bta3,bta4,btb1,btb2,btb3,btb4,btc1,btc2,btc3,btc4,btd1,btd2,btd3,btd4;
    String x;
    static String farex;
    Boolean count;
    int seatCounta=0,seatCountb=0,seatCountc=0,seatCountd=0,seatCounte=0,seatCountf=0,seatCountg=0,seatCounth=0,seatCounti=0,
            seatCountj=0,seatCountk=0,seatCountl=0,seatCountm=0,seatCountn=0,seatCounto=0,seatCountp=0;

    String yellow = "-fx-background-color:#ffb805";
    String red = "-fx-background-color:#FF0000";
    String green = "-fx-background-color:#39FF14";
    ArrayList<Integer> list2 = new ArrayList<>();
    ArrayList<Integer> list4 = new ArrayList<>();
    ArrayList<Integer> list =  new ArrayList<Integer>();
    ArrayList<Integer> list6 =  new ArrayList<Integer>();
    
    
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
            
    public TextField txtname;
    public TextField txtphone;
    public TextField txtseat;
    public Label sourcelabel;
    public Label serlabel;
    public Label totalfare;
    public Label dlabel;
    public Label datelabel;
    public Label flabel;
    
    
    
    
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
    private Button rset;
    
    @FXML
    private Button reset;
    
    @FXML
    private Button book;
    
    @FXML
    private Button cancel;
    
    @FXML
    private Button proceed;
    
    public void s(String st){ //setting the name of the service
        this.x=st;
    }
     public void fare(String f){this.farex=f;}
    
    @FXML
    void A1(ActionEvent event)  {
        String service1 = x; //service assigning
        if(x==null){ //no service selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }else{ ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='A1' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next();
                int s = r.getInt(1);
                if (s == 1) { //seat is already selected
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();

                } else {
                    bt_1.setOnAction(e -> {
                        bta1 = true;
                        seatCounta = 1; //counting the seat for booking
                        bt_1.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));
                    });
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
           }
        }


     @FXML
    void A2(ActionEvent event) {
            String service1 = x;
            if(x==null){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setAlertType(Alert.AlertType.WARNING);
                alert.setContentText("Select a bus first!");
                Optional<ButtonType> result = alert.showAndWait();

            }
            else{ConnectionClass connectionClass = new ConnectionClass();
                Connection connection = connectionClass.getConnection();
                try {
                    PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='A2' and service='" + service1 + "'");
                    ResultSet r = ps1.executeQuery();
                    r.next();
                    int s = r.getInt(1);
                    if(s == 1 || bta2){ Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setAlertType(Alert.AlertType.WARNING);
                        alert.setContentText("oops! The seat is booked already. Select another");
                        Optional<ButtonType> result = alert.showAndWait();}
                    else{
                        a2.setOnAction(e -> {
                            bta2 = true;
                            seatCountb = 1;
                            a2.setStyle(yellow);
                            txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                    seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                        });
                    }

                }
                catch (SQLException e) {
                    e.printStackTrace();}

                }


        }

    @FXML
    void a3(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='A3' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    A3.setOnAction(e -> {
                        bta3 = true;
                        seatCountc = 1;
                        A3.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }}



    @FXML
    void a4(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='A4' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    A4.setOnAction(e -> {
                        bta4 = true;
                        seatCountd = 1;
                        A4.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
        }


    @FXML
    void b1(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='B1' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    B1.setOnAction(e -> {
                        btb1 = true;
                        seatCounte = 1;
                        B1.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }

       }
    @FXML
    void b2(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='B2' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    B2.setOnAction(e -> {
                        btb2 = true;
                        seatCountf = 1;
                        B2.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
        }


    @FXML
    void b3(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='B3' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    B3.setOnAction(e -> {
                        btb3 = true;
                        seatCountg = 1;
                        B3.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
        }


    @FXML
    void b4(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='B4' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    B4.setOnAction(e -> {
                        btb4 = true;
                        seatCounth = 1;
                        B4.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
       }
    @FXML
    void c1(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='C1' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    C1.setOnAction(e -> {
                        btc1 = true;
                        seatCounti = 1;
                        C1.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
        }
    @FXML
    void c2(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='C2' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    C2.setOnAction(e -> {
                        btc2 = true;
                        seatCountj = 1;
                        C2.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
        }
    @FXML
    void c3(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='C3' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    C3.setOnAction(e -> {
                        btc3 = true;
                        seatCountk = 1;
                        C3.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
        }


    @FXML
    void c4(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='C4' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    C4.setOnAction(e -> {
                        btc4 = true;
                        seatCountl = 1;
                        C4.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
        }


    @FXML
    void d1(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='D1' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    D1.setOnAction(e -> {
                        btd1 = true;
                        seatCountm = 1;
                        D1.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
        }

    @FXML
    void d2(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='D2' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    D3.setOnAction(e -> {
                        btd2 = true;
                        seatCountn = 1;
                        D3.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
        }

    @FXML
    void d3(ActionEvent event) {
        String service1 = x;
        if(x==null){ //If service not selected
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='D3' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1); //Extracting the seat value 0 or 1
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    D3.setOnAction(e -> {
                        bta2 = true;
                        seatCounto = 1;
                        D3.setStyle(yellow);
                        //Below code is for finding the total number of seat user selected
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
       }

    @FXML
    void d4(ActionEvent event) {
        String service1 = x;
        if(x==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setContentText("Select a bus first!");
            Optional<ButtonType> result = alert.showAndWait();

        }
        else{ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            try {
                PreparedStatement ps1 = connection.prepareStatement("select count from seats WHERE seatname='D4' and service='" + service1 + "'");
                ResultSet r = ps1.executeQuery();
                r.next() ;
                int s = r.getInt(1);
                if(s == 1){ Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setAlertType(Alert.AlertType.WARNING);
                    alert.setContentText("oops! The seat is booked already. Select another");
                    Optional<ButtonType> result = alert.showAndWait();}
                else{
                    D4.setOnAction(e -> {
                        btd4 = true;
                        seatCountp = 1;
                        D4.setStyle(yellow);
                        txtseat.setText(String.valueOf(seatCounta+seatCountb+seatCountc+seatCountd+seatCounte+seatCountf+seatCountg+seatCounth+
                                seatCounti+seatCountj+seatCountk+seatCountl+seatCountm+seatCountn+seatCounto+seatCountp));


                    });
                }

            }
            catch (SQLException e) {
                e.printStackTrace();}

        }
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
        dest1.getItems().add("Chittagong");
        
        //connect();
        setcellvalue();
        
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
    
        public void setcellvalue(){ //this function set the details of journey like bus name, date, source dest and checks whether
                                    //the seat is booked or not to show the red column
        String service1 = x;
        tableview.setOnMouseClicked(e-> {


            Service service = tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex());
            System.out.println(service.getSource());
            //setting the service name, date etc thing to the view
            sourcelabel.setText(service.getSource());
            serlabel.setText(service.getService());
            dlabel.setText(service.getDestination());
            flabel.setText(String.valueOf(service.getFare()));
            datelabel.setText(String.valueOf(service.getDt()));
            String srvc = service.getService();
            s(srvc); //setting the service provider name

            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            PreparedStatement pst;
            try {
                pst=connection.prepareStatement("SELECT count FROM seats WHERE service='"+srvc+"'");

                ResultSet resultSet = pst.executeQuery();

                //adding the query result to a list
                while (resultSet.next()){
                    list.add(resultSet.getInt(1));


                }
                //if the seat value is 1(booked) then seat color is red
                if(list.get(0)==1){
                    bt_1.setStyle("-fx-background-color:red");
                }
               if(list.get(1)==1){
                    a2.setStyle("-fx-background-color:red");

                }
                if(list.get(2)==1){
                    A3.setStyle("-fx-background-color:red");
                }
                if(list.get(3)==1){
                    A4.setStyle("-fx-background-color:red");

                }
                if(list.get(4)==1){
                    B1.setStyle("-fx-background-color:red");
                }

                if(list.get(5)==1){
                    B2.setStyle("-fx-background-color:red");
                }
                if(list.get(6)==1){
                    B3.setStyle("-fx-background-color:red");

                }
                if(list.get(7)==1){
                    B4.setStyle("-fx-background-color:red");
                }
                if(list.get(8)==1){
                    C1.setStyle("-fx-background-color:red");

                }
                if(list.get(9)==1){
                    C2.setStyle("-fx-background-color:red");
                }
                if(list.get(10)==1){
                    C3.setStyle("-fx-background-color:red");

                }
                if(list.get(11)==1){
                    C4.setStyle("-fx-background-color:red");
                }
                if(list.get(12)==1){
                    D1.setStyle("-fx-background-color:red");

                }
                if(list.get(13)==1){
                    D2.setStyle("-fx-background-color:red");
                }
                if(list.get(14)==1){
                    D3.setStyle("-fx-background-color:red");

                }
                if(list.get(15)==1){
                    D4.setStyle("-fx-background-color:red");

                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });
        }
        
    @FXML
    void rset(ActionEvent event) {

       String service1 = x;

        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();
        try {
            PreparedStatement ps1 = connection.prepareStatement("select count,uname from seats WHERE (seatname='A1' or seatname='A2' or seatname='A3' or seatname='A4' or seatname='B1' or seatname='B2' or seatname='B3' or seatname='B4' or seatname='C1' or seatname='C2' or seatname='C3' or seatname='C4' or seatname='D1' or seatname='D2' or seatname='D3' or seatname='D4') and service='" + service1 + "'");
            ResultSet r = ps1.executeQuery();
            while (r.next()) {
                list2.add(r.getInt(1));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        rset.setOnAction(e -> {
            txtseat.setText("");
            if(list2.get(0) == 0){
                bta1 = false;
                seatCounta = 0;
                bt_1.setStyle(green);

            }
            if(list2.get(1) == 0){
                bta2 = false;
                seatCountb = 0;
                a2.setStyle(green);

            }
            if(list2.get(2) ==0){
                bta3 = false;
                seatCountc = 0;
                A3.setStyle(green);

            }
            if(list2.get(3) == 0){
                bta4 = false;
                seatCountd=0;
                A4.setStyle(green);

            }
            if(list2.get(4) == 0){
                btb1 = false;
                seatCounte = 0;
                B1.setStyle(green);
            }
            if(list2.get(5) == 0){
                btb2 = false;
                seatCountf = 0;
                B2.setStyle(green);

            }
            if(list2.get(6) == 0){
                btb3 = false;
                seatCountg = 0;
                B3.setStyle(green);

            }
            if(list2.get(7) == 0){
                btb4 = false;
                seatCounth = 0;
                B4.setStyle(green);
            }
            if(list2.get(8) == 0){
                btc1 = false;
                seatCounti = 0;
                C1.setStyle(green);}
            if(list2.get(9) == 0){
                btc2 = false;
                seatCountj = 0;

                C2.setStyle(green);}
            if(list2.get(10) == 0) {
                btc3 = false;
                seatCountk = 0;

                C3.setStyle(green);}
            if(list2.get(11) == 0) {
                    btc4 = false;
                    seatCountl = 0;
                    C4.setStyle(green);
                }
            if (list2.get(12) == 0){
                    btd1 = false;
                    seatCountm = 0;

                    D1.setStyle(green);

                }
            if (list2.get(13) == 0) {
                    btd2 = false;
                    seatCountn = 0;
                    D2.setStyle(green);
                }
            if (list2.get(14) == 0)  {
                    btd3 = false;

                    seatCounto = 0;

                    D3.setStyle(green);
                }
            if (list2.get(15) == 0) {
                    btd4 = false;
                    seatCountp = 0;

                    D4.setStyle(green);
                }

        });

        }
    
    
     public void selection() { //This function update the database of seat boolean value
        String service1 = x;

        ConnectionClass connectionClass = new ConnectionClass();
        Connection connection = connectionClass.getConnection();


            if(bta1){ //Here, if condition checks the boolean value true false for the specific seat
                try {
            PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='A1' and service='"+service1+"'");
            ps.executeUpdate();}
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        if(bta2){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='A2' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(bta3){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='A3' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(bta4){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='A4' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btc1){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='C1' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btc2){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='C2' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btc3){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='C3' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btc4){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='c4' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(btb1){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='B1' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btb2){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='B2' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btb3){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='B3' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btb4){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='B4' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btd1){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='D1' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btd2){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='D2' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btd3){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='D3' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(btd4){
            try {
                PreparedStatement ps = connection.prepareStatement("UPDATE seats SET count = 1 WHERE seatname='D4' and service='"+service1+"'");
                ps.executeUpdate();}
            catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
    
        public void bookticket(ActionEvent event) throws IOException {
        String se = x; //service provider

        book.setOnAction(e->{
            ConnectionClass connectionClass = new ConnectionClass();
            Connection connection = connectionClass.getConnection();
            PreparedStatement pst;
            try {
                pst=connection.prepareStatement("SELECT count FROM seats WHERE service='"+se+"'");

                ResultSet resultSet = pst.executeQuery();


                while (resultSet.next()){
                    list6.add(resultSet.getInt(1)); //inserting to an list where seat is already booked(1)


                }}
                catch(Exception ei){
                    System.out.println(ei);
                }



            if((list6.get(0)==1 && bta1) // If condition, checks the seat is available or not
                ||(list6.get(1)==1 && bta2)
                || (list6.get(2)==1 && bta3)
                ||(list6.get(3)==1 && bta4)
                ||(list6.get(4)==1 && btb1)
                ||(list6.get(5)==1 && btb2)
                ||(list6.get(6)==1 && btb3)
                ||(list6.get(7)==1 && btb4)
                ||(list6.get(8)==1 && btc1)
                ||(list6.get(9)==1 && btc2)
                ||(list6.get(10)==1 && btc3)
                ||(list6.get(11)==1 && btc4)
                ||(list6.get(12)==1 && btd1)
                ||(list6.get(13)==1 && btd2)
                ||(list6.get(14)==1 && btd3)
                ||(list6.get(15)==1 && btd4)
        ){Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Sorry! The Seat is booked");
            alert.showAndWait();}
        else{

            selection();


            Service selectedrow = tableview.getSelectionModel().getSelectedItem();
            if (selectedrow == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("No bus selected");
                alert.showAndWait();
            } else {
                setcellvalue();
                //String avaiseat =avaiseats.getText();
                String name = txtname.getText();
                String no= txtphone.getText();
                String seatss = txtseat.getText();
                String date = datelabel.getText();
                String far = flabel.getText();
                String sourc = sourcelabel.getText();
                String des = dlabel.getText();
                String ser = serlabel.getText();



                Statement statement = null;
                try {

                       //Fare calculation
                    int tot = Integer.parseInt(String.valueOf(far)) * Integer.parseInt(String.valueOf(seatss)); //Fare calculation
                    totalfare.setText(String.valueOf(tot));
                    String tfare = totalfare.getText();
                    fare(tfare);

                    statement = connection.createStatement();
                    int status = statement.executeUpdate("insert into bookings values('" + name + "','" + no + "','" + sourc + "','" + des + "','" + ser + "'," +
                            "'" + date + "','" + seatss + "','" + tfare + "')");
                }
                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }}});


    }
        
        public void proceed(ActionEvent actionEvent) {




        try {
            Parent parent = FXMLLoader.load(getClass().getResource("payment.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        
        public void refresh(ActionEvent actionEvent) {




        try {
            Parent parent = FXMLLoader.load(getClass().getResource("homeFXML.fxml"));
            Scene scene = new Scene(parent);
            Stage window = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    
}
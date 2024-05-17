package UI;

import classes.Flight;
import classes.Passenger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MyTicket implements Initializable {



    @FXML
    private Button button;
    @FXML
    private TableColumn<Flight,String>cn;


    @FXML
    private TableColumn<Flight, String> price;
    @FXML
    private TableColumn<Flight,String>ct;
    @FXML
    private TableColumn<Flight,String>tg;
    @FXML
    private TableColumn<Flight,String>date;

    @FXML
    private TableView<Flight> table;
    ObservableList<Flight> ticket= FXCollections.observableArrayList();

   


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if(Login.u1.getMyticket()!=null) {
            for (int i = 0; i < Login.u1.getMyticket().size(); i++) {


                ticket.addAll(Login.u1.getMyticket().get(i).getFlight());
                System.out.println();

            }

        }

        price.setCellValueFactory(new PropertyValueFactory<Flight, String>("price"));
        ct.setCellValueFactory(new PropertyValueFactory<Flight,String>("currentCity"));
        tg.setCellValueFactory(new PropertyValueFactory<Flight, String>("TargetCity"));
        date.setCellValueFactory(new PropertyValueFactory<Flight, String>("flightDate"));
        cn.setCellValueFactory(new PropertyValueFactory<Flight, String>("companyName"));

        table.setItems(ticket);


    }

    public void remove (ActionEvent event){
        int selectedID= table.getSelectionModel().getSelectedIndex();
        table.getItems().remove(selectedID);







    }

}

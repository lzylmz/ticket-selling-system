package UI;

import classes.Ticket;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.*;

import java.awt.event.TextEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Menu {
    @FXML
    Button showMyTicket;
    @FXML
    Button buyticket;
    @FXML
     Button wallet;






public void showClick(ActionEvent event)throws Exception{
    FXMLLoader showpage = new FXMLLoader(getClass().getResource("MyTicket.fxml"));
    Parent root = showpage.load();
    Stage stage = new Stage();


    stage.setTitle("Myticket");
    stage.setScene(new Scene(root));

    stage.show();

}
public void buyticket(ActionEvent event) throws Exception {

    Seats seats=new Seats();
    Stage s=new Stage();
    seats.start(s);



}
public void mywallet(ActionEvent event)throws Exception{
    try {
        FXMLLoader walletpage = new FXMLLoader(getClass().getResource("wallet.fxml"));
        Parent root = walletpage.load();
        Stage stage = new Stage();


        stage.setTitle("wallet");
        stage.setScene(new Scene(root));

        stage.show();
    }catch (Exception e){


        System.out.println(e);
    }





}







}

package UI;

import classes.Wallet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class wallet {
    @FXML
    Button btn;
    @FXML
   TextField upload;


    public void uploadmoney(ActionEvent e)throws Exception{

         int amount=Integer.parseInt(upload.getText());

         Login.u1.chargeWallet(amount);










    }




}

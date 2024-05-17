package UI;

import classes.Passenger;
import classes.Ticket;
import classes.User;
import classes.Wallet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;


public class Login {
    @FXML
    TextField eMail;
    @FXML
    PasswordField password;
   static User u1 = new User("Fırat", "fbilgen4021@gmail.com", "123456", 100000,new Wallet());



    @FXML
    Button btn;

    Stage menuStage;
    Scene menuScene;


    public  void loginClick(ActionEvent event) throws IOException {




            if ( u1.getPassword().equals(password.getText())&& u1.getEmail().equals(eMail.getText())) {
                try {


                    URL url = new File("G:\\project\\OOP PROCECT son\\Ticketselling system\\src\\UI\\Menu.fxml").toURI().toURL();
                    Parent root = FXMLLoader.load(url);
                    menuStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    menuScene = new Scene(root);
                    menuStage.setTitle("Menu");
                    menuStage.setScene(menuScene);
                    menuStage.show();

                } catch (Exception e) {
                    System.out.println(e);

                }


            } else {
                Alert info = new Alert(Alert.AlertType.ERROR);
                info.setContentText("Password or e-mail is in correct");
                info.show();




            }

        }

    }


























package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;


public class Login {

    @FXML
    Label dbConLb;




    public void statusDB(javafx.event.ActionEvent event) throws IOException, SQLException {

            if(!AdminsDB.getConnection().isClosed()){
                dbConLb.setText("connected");
            }else{
                dbConLb.setText("not connected!");
            }

    }
}

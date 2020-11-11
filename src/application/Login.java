package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Login {

    @FXML
    Label dbConLb;

    @FXML
    TextField username;

    @FXML
    TextField password;

    @FXML
    Label check;

    public void statusDB(javafx.event.ActionEvent event) throws IOException, SQLException {

            if(!AdminsDB.getConnection().isClosed()){
                dbConLb.setText("connected");
            }else{
                dbConLb.setText("not connected!");
            }
    }

     public void enterCP(ActionEvent event) throws IOException, SQLException{
              List <Admins> list = AdminsDB.getAdmins();
              Map<String, String> map = new HashMap<String, String>();
              for(Admins a: list){
                  map.put(a.getUsername(), a.getPassword());
              }

              if(map.containsKey(username.getText().trim())){
                  String val2 = map.get(username.getText().trim());
                  if(val2.equals(password.getText().trim()));
                  check.setText("Success");
              }else {
                  check.setText("Failed try again");
              }
     }
}

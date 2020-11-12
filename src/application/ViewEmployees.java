package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ViewEmployees implements Initializable {
    @FXML
    TableView<Employee> table;
    @FXML
    TableColumn<Employee, Integer> id;
    @FXML
    TableColumn<Employee, String> fname;
    @FXML
    TableColumn<Employee, String> lname;
    @FXML
    TableColumn<Employee, Float> salary;
    @FXML
    TableColumn<Employee, Integer> age;
    @FXML
    TableColumn<Employee, String> department;
    @FXML
    TableColumn<Employee, String> address;
    @FXML
    TableColumn<Employee, String> date_of_birth;

    public ObservableList<Employee> data = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String sql = "SELECT * FROM `employee` WHERE 1";
        Connection connection = DBInfo.getConnection();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                data.add(new Employee(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getFloat(4),
                        resultSet.getInt(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8)
                ));
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
        fname.setCellValueFactory(new PropertyValueFactory<Employee, String>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<Employee, String>("lname"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee, Float>("salary"));
        age.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("age"));
        department.setCellValueFactory(new PropertyValueFactory<Employee, String >("department"));
        address.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        date_of_birth.setCellValueFactory(new PropertyValueFactory<Employee, String>("date_of_birth"));

        table.setItems(data);

    }
}

package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class UpdateDeleteEmployee {

    @FXML
    TextField id;
    @FXML
    TextField fname;
    @FXML
    TextField lname;
    @FXML
    TextField salary;
    @FXML
    TextField age;
    @FXML
    TextField department;
    @FXML
    TextField address;
    @FXML
    TextField date_of_birth;
    @FXML
    TextField gender;
    @FXML
    TextField education;
    @FXML
    TextField experience;
    @FXML
    TextField contract_start;
    @FXML
    TextField contract_end;
    @FXML
    TextField nationality;
    @FXML
    TextField mother_language;
    @FXML
    TextField other_language;

    public void getEmployeeById(ActionEvent event){
        String ID = id.getText().trim();
        int idEmployee = Integer.parseInt(ID);
        Employee employee = DBInfo.getEmployeeId(idEmployee);
        fname.setText(employee.getFname());
        lname.setText(employee.getLname());
        salary.setText(String.valueOf(employee.getSalary()));
        age.setText(String.valueOf(employee.getAge()));
        department.setText(employee.getDepartment());
        address.setText(employee.getAddress());
        date_of_birth.setText(employee.getDate_of_birth());
        gender.setText(employee.getGender());
        education.setText(employee.getGender());
        experience.setText(employee.getExperience());
        contract_start.setText(employee.getContract_start());
        contract_end.setText(employee.getContract_end());
        nationality.setText(employee.getNationality());
        mother_language.setText(employee.getMother_language());
        other_language.setText(employee.getOther_language());

    };






}

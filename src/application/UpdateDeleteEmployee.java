package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.text.ParseException;
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

    public void getEmployeeById(ActionEvent event) throws IOException, ParseException {
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

    public void updateEmploye(ActionEvent event) throws IOException {
        String dateBirth = date_of_birth.getText().trim();
        String dateContract_start = contract_start.getText().trim();
        String dateContract_end = contract_end.getText().trim();

        String firstName =  fname.getText().trim();
        String lastName = lname.getText().trim();
        String textSalary = salary.getText().trim();
        String textAge = age.getText().trim();
        String textDepartment = department.getText().trim();
        String textAddress = address.getText().trim();
        String textGender = gender.getText().toString();
        String textEducation = education.getText().trim();
        String textExperience = experience.getText().trim();
        String textNationality = nationality.getText().trim();
        String motherLanguage = mother_language.getText().trim();
        String otherLanguage = other_language.getText().trim();

        Employee employee = new Employee();
        employee.setId(Integer.parseInt(id.getText().trim()));
        employee.setFname(firstName);
        employee.setLname(lastName);
        employee.setSalary(Float.parseFloat(textSalary));
        employee.setAge(Integer.parseInt(textAge));
        employee.setDepartment(textDepartment);
        employee.setAddress(textAddress);
        employee.setDate_of_birth(dateBirth);
        employee.setGender(textGender);
        employee.setEducation(textEducation);
        employee.setExperience(textExperience);
        employee.setContract_start(dateContract_start);
        employee.setContract_end(dateContract_end);
        employee.setNationality(textNationality);
        employee.setMother_language(motherLanguage);
        employee.setOther_language(otherLanguage);
        if(DBInfo.update(employee) > 0){

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Update");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Record updated successfully!");

            alert.showAndWait();

            fname.setText("");
            lname.setText("");
            salary.setText("");
            age.setText("");
            department.setText("");
            address.setText("");
            gender.setText("");
            education.setText("");
            experience.setText("");
            nationality.setText("");
            mother_language.setText("");
            other_language.setText("");
            date_of_birth.setText("");
            contract_start.setText("");
            contract_end.setText("");
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data Update");
            alert.setHeaderText("ERROR Dialog");
            alert.setContentText("Sorry unable to updete record!");

            alert.showAndWait();
        }

    }

    public void deleteEmployee(ActionEvent event) throws IOException{
        int empId = Integer.parseInt(id.getText().trim());
        if(DBInfo.delete(empId) > 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data Delete");
            alert.setHeaderText("Information Dialog");
            alert.setContentText("Record deleted successfully!");

            alert.showAndWait();

            fname.setText("");
            lname.setText("");
            salary.setText("");
            age.setText("");
            department.setText("");
            address.setText("");
            gender.setText("");
            education.setText("");
            experience.setText("");
            nationality.setText("");
            mother_language.setText("");
            other_language.setText("");
            date_of_birth.setText("");
            contract_start.setText("");
            contract_end.setText("");
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Data Insert");
            alert.setHeaderText("ERROR Dialog");
            alert.setContentText("Sorry unable to delete record!");

            alert.showAndWait();
        }

    }






}

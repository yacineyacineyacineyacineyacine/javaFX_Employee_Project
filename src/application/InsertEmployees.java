package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.time.LocalDate;

public class InsertEmployees {
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
    DatePicker date_of_birth;
    @FXML
    TextField gender;
    @FXML
    TextField education;
    @FXML
    TextField experience;
    @FXML
    DatePicker contract_start;
    @FXML
    DatePicker contract_end;
    @FXML
    TextField nationality;
    @FXML
    TextField mother_language;
    @FXML
    TextField other_language;

    public void InsertData(ActionEvent event) throws IOException {
        LocalDate dateBirth = date_of_birth.getValue();
        LocalDate dateContract_start = contract_start.getValue();
        LocalDate dateContract_end = contract_end.getValue();

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
        String dateOfBirth = dateBirth.toString();
        String dateContractStart = dateContract_start.toString();
        String dateContractEnd = dateContract_end.toString();

        Employee employee = new Employee();
        employee.setFname(firstName);
        employee.setLname(lastName);
        employee.setSalary(Integer.parseInt(textSalary));
        employee.setAge(Integer.parseInt(textAge));
        employee.setDepartment(textDepartment);
        employee.setAddress(textAddress);
        employee.setDate_of_birth(dateOfBirth);
        employee.setGender(textGender);
        employee.setEducation(textEducation);
        employee.setExperience(textExperience);
        employee.setContract_start(dateContractStart);
        employee.setContract_end(dateContractEnd);
        employee.setNationality(textNationality);
        employee.setMother_language(motherLanguage);
        employee.setOther_language(otherLanguage);
        if(DBInfo.save(employee) > 0){
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
            date_of_birth.setValue(null);
            contract_start.setValue(null);
            contract_end.setValue(null);
        };
       // String sql  = "INSERT INTO `employee` (fname, lname, salary, age, departement, address, date_of_birth, gender, education, experience, contract_start, contract_end, nationality, mother_language, other_language) Values ()";




    }
}

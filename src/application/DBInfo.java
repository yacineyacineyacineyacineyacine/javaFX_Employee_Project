package application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBInfo {
    static Connection con = null;
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/employees";
            con = DriverManager.getConnection(url, "root","");
            System.out.println("Connected!");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public static int save(Employee emp){
        int st =0;
        String sql = "INSERT INTO employee(fname, lname, salary, age, departement, address, date_of_birth, gender, education, experience, contract_start, contract_end, nationality, mother_lunguage, other_lunguage) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        Connection connection = DBInfo.getConnection();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, emp.getFname());
            preparedStatement.setString(2, emp.getLname());
            preparedStatement.setFloat(3, emp.getSalary());
            preparedStatement.setInt(4, emp.getAge());
            preparedStatement.setString(5, emp.getDepartment());
            preparedStatement.setString(6, emp.getAddress());
            preparedStatement.setString(7, emp.getDate_of_birth());
            preparedStatement.setString(8, emp.getGender());
            preparedStatement.setString(9, emp.getEducation());
            preparedStatement.setString(10, emp.getExperience());
            preparedStatement.setString(11, emp.getContract_start());
            preparedStatement.setString(12, emp.getContract_end());
            preparedStatement.setString(13, emp.getNationality());
            preparedStatement.setString(14, emp.getMother_language());
            preparedStatement.setString(15, emp.getOther_language());
            st = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }
    public static int update(Employee emp){
        int st =0;
        String sql = "UPDATE employee SET fname=?, lname=?, salary=?, age=?, departement=?, address=?, date_of_birth=?, gender=?, education=?, experience=?, contract_start=?, contract_end=?, nationality=?, mother_lunguage=?, other_lunguage=? WHERE id=?";

        Connection connection = DBInfo.getConnection();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, emp.getFname());
            preparedStatement.setString(2, emp.getLname());
            preparedStatement.setFloat(3, emp.getSalary());
            preparedStatement.setInt(4, emp.getAge());
            preparedStatement.setString(5, emp.getDepartment());
            preparedStatement.setString(6, emp.getAddress());
            preparedStatement.setString(7, emp.getDate_of_birth());
            preparedStatement.setString(8, emp.getGender());
            preparedStatement.setString(9, emp.getEducation());
            preparedStatement.setString(10, emp.getExperience());
            preparedStatement.setString(11, emp.getContract_start());
            preparedStatement.setString(12, emp.getContract_end());
            preparedStatement.setString(13, emp.getNationality());
            preparedStatement.setString(14, emp.getMother_language());
            preparedStatement.setString(15, emp.getOther_language());
            preparedStatement.setInt(16, emp.getId());
            st = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public static int delete(int id){
        int st =0;
        String sql = "DELETE FROM employee WHERE id=?";
        Connection connection = DBInfo.getConnection();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            st = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return st;
    }

    public static Employee getEmployeeId(int id){

        Employee emp = new Employee();
        String sql = "SELECT * FROM employee WHERE id=?";
        Connection connection = DBInfo.getConnection();
        try {
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                emp.setId(resultSet.getInt(1));
                emp.setFname(resultSet.getString(2));
                emp.setLname(resultSet.getString(3));
                emp.setSalary(resultSet.getFloat(4));
                emp.setAge(resultSet.getInt(5));
                emp.setDepartment(resultSet.getString(6));
                emp.setAddress(resultSet.getString(7));
                emp.setDate_of_birth(resultSet.getString(8));
                emp.setGender(resultSet.getString(9));
                emp.setEducation(resultSet.getString(10));
                emp.setExperience(resultSet.getString(11));
                emp.setContract_start(resultSet.getString(12));
                emp.setContract_end(resultSet.getString(13));
                emp.setNationality(resultSet.getString(14));
                emp.setMother_language(resultSet.getString(15));
                emp.setOther_language(resultSet.getString(16));

                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return emp;
    }

    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<Employee>();

        try {
            String sql = "SELECT * FROM `employees` WHERE 1";
            Connection connection = DBInfo.getConnection();
            PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Employee emp = new Employee();
                emp.setId(resultSet.getInt(1));
                emp.setFname(resultSet.getString(2));
                emp.setLname(resultSet.getString(3));
                emp.setSalary(resultSet.getFloat(4));
                emp.setAge(resultSet.getInt(5));
                emp.setDepartment(resultSet.getString(6));
                emp.setAddress(resultSet.getString(7));
                emp.setDate_of_birth(resultSet.getString(8));
                emp.setGender(resultSet.getString(9));
                emp.setEducation(resultSet.getString(10));
                emp.setExperience(resultSet.getString(11));
                emp.setContract_start(resultSet.getString(12));
                emp.setContract_end(resultSet.getString(13));
                emp.setNationality(resultSet.getString(14));
                emp.setMother_language(resultSet.getString(15));
                emp.setOther_language(resultSet.getString(16));
                list.add(emp);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


}

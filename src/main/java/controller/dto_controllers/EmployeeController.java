package controller.dto_controllers;

import dto.Employee;
import dto.Item;
import entity.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import service.custom.EmployeeService;
import service.custom.impl.EmployeeServiceImpl;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeController {

    private final EmployeeService employeeService= new EmployeeServiceImpl();
    private static EmployeeController instance;
    private EmployeeController(){}


    public static EmployeeController getInstance() {
        return instance==null?instance=new EmployeeController():instance;
    }

    public boolean addEmployee(Employee employee){
        return employeeService.addEmployee(employee);
    }

    public Employee searchEmployeeById(String id){
        return employeeService.searchEmployee(id);
    }

    public boolean updateEmployee(Employee employee){
        return employeeService.updateEmployee(employee);
    }
    public boolean deleteEmployee(String id){
        return employeeService.deleteEmployee(id);
    }
    public ObservableList<String> getAllEmployees(){
        return employeeService.getEmployeeIds();
    }












}

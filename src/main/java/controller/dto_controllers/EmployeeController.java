package controller.dto_controllers;

import dto.Employee;
import javafx.collections.ObservableList;
import service.custom.EmployeeService;
import service.custom.impl.EmployeeServiceImpl;

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


    public boolean authenticateEmployee(String email, String password) {
//        ObservableList<EmployeeEntity> allEmployees = getAllEmployees();
//        Encryptor encryptor = new Encryptor();
//        try {
//            for (EmployeeEntity employee:allEmployees){
//                if (employee.getEmail().equals(email) && employee.getPassword().equals(encryptor.encryptString(password))){
//                    currentEmployee=new ModelMapper().map(employee,Employee.class);
//                    return true;
//                }
//            }
//            return false;
//        } catch (NoSuchAlgorithmException e) {
//            return false;
//        }
        return false;
    }
}

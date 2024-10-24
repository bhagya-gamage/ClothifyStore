package service.custom.impl;

import dto.Employee;
import entity.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.EmployeeDao;
import service.custom.EmployeeService;
import util.DaoType;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDao= DaoFactory.getInstance().getDaoType(DaoType.EMPLOYEE);

    @Override
    public boolean addEmployee(Employee employee) {
        EmployeeEntity entity = new ModelMapper().map(employee,EmployeeEntity.class);
        return  employeeDao.save(entity);

    }

    @Override
    public boolean deleteEmployee(String id){
        System.out.println(id);
        return employeeDao.delete(id);
    }

    @Override
    public ObservableList<Employee> getAllEmployees() {
        ObservableList<Employee> employees = FXCollections.observableArrayList();
        employeeDao.getAll().forEach(employee -> {
            Employee employee1 = new ModelMapper().map(employee,Employee.class);
            employees.add(employee1);
        });
        return employees;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        EmployeeEntity entity = new ModelMapper().map(employee, EmployeeEntity.class);
        return employeeDao.update(entity);

    }

    @Override
    public Employee searchEmployee(String id) {
        EmployeeEntity employee = employeeDao.search(id);
        return employee==null? null:new ModelMapper().map(employee, Employee.class);

    }



    @Override
    public ObservableList<String> getEmployeeIds() {
        ObservableList<EmployeeEntity> all = employeeDao.getAll();
        ObservableList<String> employeeIds= FXCollections.observableArrayList();
        for (EmployeeEntity employee : all){
            employeeIds.add(employee.getEmpId());
        }
        return employeeIds;

    }
}

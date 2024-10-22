package service.custom.impl;

import dto.Employee;
import entity.EmployeeEntity;
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
    public boolean deleteEmployee(String id) {
        return employeeDao.delete(id);
    }

    @Override
    public ObservableList<EmployeeEntity> getAllEmployees() {
        return employeeDao.getAll();
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

//    @Override
//    public ObservableList<EmployeeEntity> getEmployeeIds() {
//        return employeeDao.getAll();
//    }
}

package repository.custom.impl;

import entity.EmployeeEntity;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import repository.custom.EmployeeDao;
import util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean save(EmployeeEntity employee) {
        System.out.println("Repository : " + employee );

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<EmployeeEntity> getAll() {
        return null;
    }

    @Override
    public boolean Update(EmployeeEntity employeeEntity) {
        return false;
    }

    @Override
    public EmployeeEntity search(String id) {
        return null;
    }
}

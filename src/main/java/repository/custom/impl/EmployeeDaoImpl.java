package repository.custom.impl;

import entity.EmployeeEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.EmployeeDao;
import util.HibernateUtil;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public boolean save(EmployeeEntity employee) {
        System.out.println("Repository : " + employee );

        Session session = HibernateUtil.getEmployeeSession();
        session.beginTransaction();
        session.persist(employee);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        try {
            Session session = HibernateUtil.getEmployeeSession();
            session.beginTransaction();
            session.remove(session.get(EmployeeEntity.class,id));
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public ObservableList<EmployeeEntity> getAll() {
        ObservableList<EmployeeEntity> employee= FXCollections.observableArrayList();
        try {
            Session session = HibernateUtil.getEmployeeSession();
            Query<EmployeeEntity> query = session.createQuery("FROM EmployeeEntity", EmployeeEntity.class);
            List<EmployeeEntity> employeeEntityList=query.list();
            employee.addAll(employeeEntityList);
            return employee;
        } catch (HibernateException e) {
            return employee;
        }
    }

    @Override
    public boolean update(EmployeeEntity employeeEntity) {
        try {
            Session session = HibernateUtil.getEmployeeSession();
            session.beginTransaction();
            session.merge(employeeEntity.getEmpId(),employeeEntity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public EmployeeEntity search(String id) {
        try {
            Session session = HibernateUtil.getEmployeeSession();
            return session.get(EmployeeEntity.class, id);
        } catch (HibernateException e) {
            return null;
        }
    }
}

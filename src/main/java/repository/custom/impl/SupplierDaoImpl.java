package repository.custom.impl;

import entity.EmployeeEntity;
import entity.ItemEntity;
import entity.SupplierEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.SupplierDao;
import util.HibernateUtil;

import java.util.List;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public boolean save(SupplierEntity supplier) {
        System.out.println("Repository : " + supplier);

        Session session = HibernateUtil.getSupplierSession();
        session.beginTransaction();
        session.persist(supplier);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        try {
            Session session = HibernateUtil.getSupplierSession();
            session.beginTransaction();
            session.remove(session.get(SupplierEntity.class,id));
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public ObservableList<SupplierEntity> getAll() {
        ObservableList<SupplierEntity> supplier= FXCollections.observableArrayList();
        try {
            Session session = HibernateUtil.getSupplierSession();
            Query<SupplierEntity> query = session.createQuery("FROM EmployeeEntity", SupplierEntity.class);
            List<SupplierEntity> supplierEntityList=query.list();
            supplier.addAll(supplierEntityList);
            return supplier;
        } catch (HibernateException e) {
            return supplier;
        }
    }

    @Override
    public boolean update(SupplierEntity supplierEntity) {
        try {
            Session session = HibernateUtil.getSupplierSession();
            session.beginTransaction();
            session.merge(supplierEntity.getSupId(),supplierEntity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }    }

    @Override
    public SupplierEntity search(String id) {
        try {
            Session session = HibernateUtil.getEmployeeSession();
            return session.get(SupplierEntity.class, id);
        } catch (HibernateException e) {
            return null;
        }
    }
}

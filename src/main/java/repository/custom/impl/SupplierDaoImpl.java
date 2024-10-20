package repository.custom.impl;

import entity.SupplierEntity;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import repository.custom.SupplierDao;
import util.HibernateUtil;

public class SupplierDaoImpl implements SupplierDao {
    @Override
    public boolean save(SupplierEntity supplier) {
        System.out.println("Repository : " + supplier);

        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(supplier);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<SupplierEntity> getAll() {
        return null;
    }

    @Override
    public boolean Update(SupplierEntity supplierEntity) {
        return false;
    }

    @Override
    public SupplierEntity search(String id) {
        return null;
    }
}

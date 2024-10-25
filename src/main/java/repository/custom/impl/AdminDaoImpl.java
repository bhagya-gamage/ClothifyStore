package repository.custom.impl;

import entity.AdminEntity;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import repository.custom.AdminDao;
import util.HibernateUtil;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean save(AdminEntity adminEntity) {
        Session session = HibernateUtil.getAdminSession();
        session.beginTransaction();
        try {
            session.persist(adminEntity);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public ObservableList<AdminEntity> getAll() {
        return null;
    }

    @Override
    public boolean update(AdminEntity adminEntity) {
        return false;
    }

    @Override
    public AdminEntity search(String id) {
        return null;
    }
}

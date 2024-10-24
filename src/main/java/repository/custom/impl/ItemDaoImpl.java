package repository.custom.impl;

import entity.EmployeeEntity;
import entity.ItemEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.ItemDao;
import util.HibernateUtil;

import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(ItemEntity item) {

        Session session = HibernateUtil.getItemSession();
        session.beginTransaction();
        try {
            session.persist(item);
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
        try {
            Session session = HibernateUtil.getItemSession();
            session.beginTransaction();
            session.remove(session.get(ItemEntity.class,id));
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public ObservableList<ItemEntity> getAll() {
        ObservableList<ItemEntity> item= FXCollections.observableArrayList();
        try {
            Session session = HibernateUtil.getItemSession();
            Query<ItemEntity> query = session.createQuery("FROM ItemEntity", ItemEntity.class);
            List<ItemEntity> itemEntityList=query.list();
            item.addAll(itemEntityList);
            return item;
        } catch (HibernateException e) {
            return item;
        }
    }

    @Override
    public boolean update(ItemEntity itemEntity) {
        try {
            Session session = HibernateUtil.getItemSession();
            session.beginTransaction();
            session.merge(itemEntity.getItemId(),itemEntity);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public ItemEntity search(String id) {
        try {
            Session session = HibernateUtil.getEmployeeSession();
            return session.get(ItemEntity.class, id);
        } catch (HibernateException e) {
            return null;
        }
    }
}

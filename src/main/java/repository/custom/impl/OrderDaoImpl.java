package repository.custom.impl;

import entity.ItemEntity;
import entity.OrderEntity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.custom.OrderDao;
import util.HibernateUtil;

import java.util.List;

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean save(OrderEntity orderEntity) {
        Session session = HibernateUtil.getOrderSession();
        session.beginTransaction();
        session.persist(orderEntity);
        session.getTransaction().commit();
        session.close();
        return false;    }

    @Override
    public boolean delete(String id) {
        try {
            Session session = HibernateUtil.getOrderSession();
            session.beginTransaction();
            session.remove(session.get(OrderEntity.class,id));
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            return false;
        }
    }

    @Override
    public ObservableList<OrderEntity> getAll() {
        ObservableList<OrderEntity> order= FXCollections.observableArrayList();
        try {
            Session session = HibernateUtil.getOrderSession();
            Query<OrderEntity> query = session.createQuery("FROM OrderEntity", OrderEntity.class);
            List<OrderEntity> orderEntityList=query.list();
            order.addAll(orderEntityList);
            return order;
        } catch (HibernateException e) {
            return order;
        }    }

    @Override
    public boolean update(OrderEntity orderEntity) {
//        try {
//            Session session = HibernateUtil.getOrderSession();
//            session.beginTransaction();
//            session.merge(orderEntity.getItemId(),orderEntity);
//            session.getTransaction().commit();
//            session.close();
//            return true;
//        } catch (HibernateException e) {
//            return false;
//        }
        return false;
    }

    @Override
    public OrderEntity search(String id) {
        try {
            Session session = HibernateUtil.getOrderSession();
            return session.get(OrderEntity.class, id);
        } catch (HibernateException e) {
            return null;
        }
    }
}

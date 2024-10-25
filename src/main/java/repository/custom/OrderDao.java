package repository.custom;

import entity.OrderDetailEntity;
import entity.OrderEntity;
import javafx.collections.ObservableList;
import repository.CrudDao;

public interface OrderDao extends CrudDao<OrderEntity> {
     boolean save(OrderEntity orderEntity, ObservableList <OrderDetailEntity> orderDetailEntities);
}

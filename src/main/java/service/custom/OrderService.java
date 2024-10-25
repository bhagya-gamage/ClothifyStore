package service.custom;

import dto.Order;
import dto.OrderDetails;
import entity.OrderEntity;
import javafx.collections.ObservableList;
import service.SuperService;

public interface OrderService extends SuperService {
    ObservableList<OrderDetails> getAllOrders();

    Boolean addOrder(Order order, ObservableList<OrderDetails> orderDetails);

    OrderEntity searchOrderById(String id);

    boolean updateOrder(Order order,ObservableList<OrderDetails> orderDetails);

    boolean deleteOrder(String id);

}

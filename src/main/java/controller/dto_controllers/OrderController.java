package controller.dto_controllers;


import dto.Employee;
import dto.Order;
import dto.OrderDetails;
import entity.OrderEntity;
import javafx.collections.ObservableList;
import service.custom.OrderService;
import service.custom.impl.OrderServiceImpl;

public class OrderController {
    private final OrderService orderService= new OrderServiceImpl();
    private static OrderController instance;
    private OrderController(){}

    public static OrderController getInstance() {
        return instance==null?instance=new OrderController():instance;
    }

    public void placeOrder(Order order, ObservableList<OrderDetails> orderDetails) {
        orderService.addOrder(order,orderDetails);
    }

    public OrderEntity searchOrderById(String id){
        return orderService.searchOrderById(id);
    }
}

package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private String orderId;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private Double orderTotal;
    private String custName;
    private String custEmail;

    private List<OrderDetails> orderDetailsList;


    public Order(String orderId, LocalTime orderTime, Double orderTotal, String custName, String custEmail, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderTime = orderTime;
        this.orderTotal = orderTotal;
        this.custName = custName;
        this.custEmail = custEmail;
        this.orderDate = orderDate;
    }


}

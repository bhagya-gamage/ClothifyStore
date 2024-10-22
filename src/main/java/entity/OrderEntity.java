package entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class OrderEntity {
    @Id
    private String orderId;
    private String customerName;
    private String customerEmail;
    private LocalDate orderDate;
    private LocalTime orderTime;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderDetailEntity> orderDetails;

    private Double orderTotal;
}

package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OrderEntity {
    @Id
    private String orderId;
    private LocalDate orderDate;
    private LocalTime orderTime;
    private Double orderTotal;
    private String custName;
    private String custEmail;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<OrderDetailEntity> orderDetails;

}

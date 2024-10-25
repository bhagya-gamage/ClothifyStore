package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OrderDetailEntity {
    @Id
    @ManyToOne
    @JoinColumn(name="orderId")
    private OrderEntity order;
    @Id
    private String itemId;
    private String itemName;
    private Integer itemQty;
    private Double unitPrice;
    private String itemSize;
}

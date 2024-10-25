package dto;

import entity.OrderEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetails {
    private Order order;
    private String itemId;
    private String itemName;
    private Integer itemQty;
    private Double unitPrice;
    private String itemSize;

}

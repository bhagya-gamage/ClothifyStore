package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ItemEntity {
    @Id
    private String itemId;
    private String itemName;
    private String itemQty;
    private String unitPrice;
    private String itemSize;
}

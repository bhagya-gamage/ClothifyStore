package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {
    private String supId;
    private String supName;
    private String companyName;
    private String supAddress;
    private String supEmail;
    private String item;
}

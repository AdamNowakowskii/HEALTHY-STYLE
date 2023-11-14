package app.healftystyle.shop;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailInformation {
    private String firstName;
    private String address;
    private String zipCode;
    private String city;
    private String email;
}

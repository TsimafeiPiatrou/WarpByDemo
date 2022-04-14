package model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Product {

    @Builder.Default
    private String title = "default title";
    @Builder.Default
    private Double price = 100.00;
    @Builder.Default
    private String image = null;

}

package org.example.menu.entity;

import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private UUID productId;
    private UUID userId;
    private String productName;
    private String productPrice;
    private String productImageUrl;

}

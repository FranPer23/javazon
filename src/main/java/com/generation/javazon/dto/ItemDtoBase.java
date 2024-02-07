package com.generation.javazon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ItemDtoBase {
    private String name, description, producedBy, madeIn, img_url;
    private double price;
    private boolean available;
}

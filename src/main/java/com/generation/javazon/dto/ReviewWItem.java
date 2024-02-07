package com.generation.javazon.dto;

import com.generation.javazon.entities.Item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder

public class ReviewWItem extends ReviewDtoBase {

    private Integer id;
    private Item item;;
}

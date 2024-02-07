package com.generation.javazon.dtoservices;

import org.springframework.stereotype.Service;

import com.generation.javazon.dto.ItemDtoR;
import com.generation.javazon.dto.ItemDtoWFull;
import com.generation.javazon.dto.ItemDtoWNoReview;
import com.generation.javazon.entities.Item;

@Service
public class ItemConverter {
    public Item dtoRToItem(ItemDtoR dto) {
        return Item
                .builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .producedBy(dto.getProducedBy())
                .madeIn(dto.getMadeIn())
                .img_url(dto.getImg_url())
                .price(dto.getPrice())
                .available(dto.isAvailable())
                .build();
    }

    public ItemDtoWFull ItemToDtoWFull(Item e) {
        return ItemDtoWFull
                .builder()
                .id(e.getId())
                .name(e.getName())
                .description(e.getDescription())
                .producedBy(e.getProducedBy())
                .madeIn(e.getMadeIn())
                .img_url(e.getImg_url())
                .price(e.getPrice())
                .available(e.isAvailable())
                .reviews(e.getReviews())
                .build();
    }

    public ItemDtoWNoReview ItemToDtoWNoReview(Item e) {
        return ItemDtoWNoReview
                .builder()
                .id(e.getId())

                .name(e.getName())
                .description(e.getDescription())
                .producedBy(e.getProducedBy())
                .madeIn(e.getMadeIn())
                .img_url(e.getImg_url())
                .price(e.getPrice())
                .available(e.isAvailable())
                .build();
    }
}

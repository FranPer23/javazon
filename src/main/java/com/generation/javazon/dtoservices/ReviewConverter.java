package com.generation.javazon.dtoservices;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.javazon.dto.ReviewDtoRpost;
import com.generation.javazon.dto.ReviewDtoRput;
import com.generation.javazon.dto.ReviewWItem;
import com.generation.javazon.dto.ReviewWNoItem;
import com.generation.javazon.entities.Item;
import com.generation.javazon.entities.Review;
import com.generation.javazon.repositories.ItemRepository;

@Service

public class ReviewConverter {
    @Autowired
    ItemRepository iRepo;

    public ReviewWNoItem reviewWNoItem(Review r) {
        return ReviewWNoItem
                .builder()
                .id(r.getId())
                .sender(r.getSender())
                .score(r.getScore())
                .date(r.getDate())
                .build();
    }

    public ReviewWItem reviewWItem(Review r) {
        return ReviewWItem
                .builder()
                .id(r.getId())
                .sender(r.getSender())
                .score(r.getScore())
                .date(r.getDate())
                .build();
    }

    public Review dtoRpostToReview(ReviewDtoRpost dto) {
        Item padre = iRepo.findById(dto.getItem_id()).get();
        return Review
                .builder()
                .sender(dto.getSender())
                .score(dto.getScore())
                .date(dto.getDate())
                .item(padre)

                .build();
    }

    public Review dtoRputTReview(ReviewDtoRput dto) {
        Item padre = null;

        Integer item_id = dto.getItem_id();

        if (item_id != null) {
            Optional<Item> op = iRepo.findById(item_id);

            if (op.isPresent())
                padre = op.get();
        }
        return Review
                .builder()
                .id(dto.getId())
                .sender(dto.getSender())
                .score(dto.getScore())
                .date(dto.getDate())
                .item(padre)
                .build();
    }

}

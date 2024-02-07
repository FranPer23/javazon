package com.generation.javazon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javazon.entities.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}

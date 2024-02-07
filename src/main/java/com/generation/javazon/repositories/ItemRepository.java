package com.generation.javazon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.javazon.entities.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

}

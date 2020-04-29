package com.guitar.db.repository;

import java.util.List;

import com.guitar.db.model.ModelType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelTypeJpaRepository extends JpaRepository<ModelType, Long> {
    List<ModelType> findByNameIsNull();
}
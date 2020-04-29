package com.guitar.db.repository;

import java.math.BigDecimal;
import java.util.List;

import com.guitar.db.model.Model;
import com.guitar.db.model.ModelType;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ModelJpaRepository extends JpaRepository<Model, Long>, ModelJpaRepositoryCustom {

    List<Model> findByPriceLessThan(BigDecimal price);

    List<Model> findByPriceLessThanEqual(BigDecimal price);

    List<Model> findByPriceGreaterThan(BigDecimal price);

    List<Model> findByPriceGreaterThanEqual(BigDecimal price);

    List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal priceLess, BigDecimal priceGreater );

    List<Model> findByModelTypeNameIn(List<String> types);

    @Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
    Page<Model> queryByPriceRangeAndWoodType(@Param("lowest") BigDecimal lowest, 
                                             @Param("highest") BigDecimal highest,
                                             @Param("wood") String wood,
                                             Pageable page);


    List<Model> findAllModelsByType(@Param("name") String name);

}
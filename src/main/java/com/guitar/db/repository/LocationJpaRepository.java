package com.guitar.db.repository;

import java.util.List;

import com.guitar.db.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationJpaRepository extends JpaRepository<Location, Long> {

    /// Query DSL: https://spring.io/blog/2011/04/26/advanced-spring-data-jpa-specifications-and-querydsl/
    List<Location> findByStateLike(String stateName);

    List<Location> findByStateNotLike(String stateName);

    List<Location> findByStateStartWith(String stateName); //not necessary to use %

    List<Location> findByStateEndingWith(String stateName);

    List<Location> findByStateContaining(String stateName);

    Location findFirstByState(String stateName);

    Long countByStateLike(String stateName);

    List<Location> findByStateOrCountry(String value1, String value2);

    List<Location> findByStateAndCountry(String value1, String value2);

    List<Location> findByStateNot(String state);

    


}
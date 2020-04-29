package com.guitar.db.repository;

import java.util.Date;
import java.util.List;

import com.guitar.db.model.Manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ManufacturerJpaRepository extends JpaRepository<Manufacturer, Long> {

    public List<Manufacturer> findByFoundedDateBefore(Date dateObj);

    public List<Manufacturer> findByFoundedDateAfter(Date dateObj);

    public List<Manufacturer> findByFoundedDateBetween(Date dateObj1, Date dateObj2);

    public Manufacturer findByName(String man);

    public List<Manufacturer> findByActiveTrue();

    public List<Manufacturer> findByActiveFalse();

    public List<Manufacturer> getAllThatSellAcoustics(String name);
    
}
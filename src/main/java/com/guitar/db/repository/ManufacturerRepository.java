package com.guitar.db.repository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Manufacturer;

@Repository
public class ManufacturerRepository {

	@Autowired
	private ManufacturerJpaRepository manufacturerJpaRepository;

	/**
	 * Create
	 */
	public Manufacturer create(Manufacturer man) {
		return manufacturerJpaRepository.saveAndFlush(man);
	}

	/**
	 * Update
	 */
	public Manufacturer update(Manufacturer man) {
		return manufacturerJpaRepository.saveAndFlush(man);
	}

	/**
	 * Delete
	 */
	public void delete(Manufacturer man) {
		manufacturerJpaRepository.delete(man);
	}

	/**
	 * Find
	 */
	public Manufacturer find(Long id) {
		return manufacturerJpaRepository.findById(id).get();
	}

	/**
	 * Custom finder
	 */
	public List<Manufacturer> getManufacturersFoundedBeforeDate(Date date) {
		List<Manufacturer> mans = manufacturerJpaRepository.findByFoundedDateBefore(date);
		return mans;
	}

	/**
	 * Custom finder
	 */
	public Manufacturer getManufacturerByName(String name) {
		Manufacturer man = manufacturerJpaRepository.findByName(name);
		return man;
	}

	/**
	 * Native Query finder
	 */
	public List<Manufacturer> getManufacturersThatSellModelsOfType(String modelType) {
		return manufacturerJpaRepository.getAllThatSellAcoustics(modelType);
	}
}

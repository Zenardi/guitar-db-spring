package com.guitar.db.repository;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.guitar.db.model.Model;

@Repository
public class ModelRepository {

	@Autowired
	private ModelJpaRepository modelJpaRepository;

	/**
	 * Create
	 */
	public Model create(Model mod) {
		return modelJpaRepository.saveAndFlush(mod);
	}

	/**
	 * Update
	 */
	public Model update(Model mod) {
		return modelJpaRepository.saveAndFlush(mod);
	}

	/**
	 * Delete
	 */
	public void delete(Model mod) {
		modelJpaRepository.delete(mod);
	}

	/**
	 * Find
	 */
	public Model find(Long id) {
		return modelJpaRepository.findById(id).get();
	}

	/**
	 * Custom finder
	 */
	public List<Model> getModelsInPriceRange(BigDecimal lowest, BigDecimal highest) {
		return modelJpaRepository.findByPriceGreaterThanEqualAndPriceLessThanEqual(lowest, highest);
	}

	/**
	 * Custom finder
	 */
	public Page<Model> getModelsByPriceRangeAndWoodType(BigDecimal lowest, BigDecimal highest, String wood) {
		
		//TODO Paging and Sorting should come from frontend
		Pageable page = PageRequest.of(0, 2, Sort.by("name").ascending());
		
		return modelJpaRepository.queryByPriceRangeAndWoodType(lowest, highest, "%" + wood + "%", page);
		
	}

	/**
	 * NamedQuery finder
	 */
	public List<Model> getModelsByType(String modelType) {
		return modelJpaRepository.findAllModelsByType(modelType);
	}

	/**
	 * Count
	 */
	public Long getModelCount() {
		return modelJpaRepository.count();
	}
}

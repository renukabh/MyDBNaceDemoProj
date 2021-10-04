package com.db.clm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.db.clm.model.Nace;
import com.db.clm.repository.NaceRepository;

@Service
@Transactional
public class NaceService {
	@Autowired
	NaceRepository naceRepository;

	// getting all nace record by using the method findaAll() of Repository
	// @Query("SELECT * FROM nace t where t.id = :id")
	public List<Nace> getAllnacelist() {
		List<Nace> nacelist = new ArrayList<Nace>();
		naceRepository.findAll().forEach(nace1 -> nacelist.add(nace1));
		return nacelist;
	}

	// getting a specific record by using the method findById() of Repository
	public Nace getNaceByOrder(int order) {
		if(naceRepository.exists(order))
		{
		return naceRepository.findOne(order);
		}
		return null;
	}

	// saving a specific record by using the method save() of Repository
	public Nace saveOrUpdate(Nace nace) {
		return naceRepository.save(nace);
	}

	/*
	 * // deleting a specific record by using the method deleteById() of Repository
	 * public void delete(int order) { naceRepository.deleteById(order); }
	 */
	// updating a record
	public Nace update(Nace nace) {
		return naceRepository.save(nace);
	}
}

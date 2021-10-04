package com.db.clm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.db.clm.model.Nace;

@Repository
public interface NaceRepository extends JpaRepository<Nace, Integer> {
}

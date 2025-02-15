package edu.cscc.repository;

import edu.cscc.model.Vinyl;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

public interface VinylRepository extends CrudRepository<Vinyl, Long>{
}

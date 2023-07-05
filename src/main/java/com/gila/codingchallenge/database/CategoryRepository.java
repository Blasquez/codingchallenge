package com.gila.codingchallenge.database;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gila.codingchallenge.model.Category;

@Transactional
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	Optional<Category> findByName(final String name);
}

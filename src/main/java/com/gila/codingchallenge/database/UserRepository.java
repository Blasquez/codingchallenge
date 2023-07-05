package com.gila.codingchallenge.database;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gila.codingchallenge.model.Category;
import com.gila.codingchallenge.model.User;

@Transactional
@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	
	Page<User> findAllBySubscribed(Pageable pageable, Category category);

}

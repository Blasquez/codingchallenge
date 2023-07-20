package com.gila.codingchallenge.database;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gila.codingchallenge.model.Notification;

@Transactional
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}

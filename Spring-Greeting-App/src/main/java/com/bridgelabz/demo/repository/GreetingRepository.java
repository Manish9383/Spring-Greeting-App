package com.bridgelabz.demo.repository;

import com.bridgelabz.demo.model.GreetingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingMessage, Long> {
}

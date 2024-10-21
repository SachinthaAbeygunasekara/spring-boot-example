package com.sample;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustmorRepository extends JpaRepository<Customer, Integer> {
}

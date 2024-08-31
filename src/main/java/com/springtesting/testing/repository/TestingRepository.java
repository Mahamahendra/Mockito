package com.springtesting.testing.repository;

import com.springtesting.testing.Entity.Testing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestingRepository extends JpaRepository<Testing, Integer> {
}

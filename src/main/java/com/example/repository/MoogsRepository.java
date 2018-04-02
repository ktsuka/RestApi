package com.example.repository;

import com.example.domain.Moogs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MoogsRepository extends JpaRepository<Moogs, Integer> {
    @Query("SELECT m FROM Moogs m")
    List<Moogs> findAll();

}

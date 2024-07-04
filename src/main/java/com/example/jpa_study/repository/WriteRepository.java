package com.example.jpa_study.repository;

import com.example.jpa_study.entity.Write;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WriteRepository extends JpaRepository<Write, Long> {

    List<Write> findAllByUserId(String id);
}

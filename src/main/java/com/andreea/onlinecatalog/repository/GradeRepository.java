package com.andreea.onlinecatalog.repository;


import com.andreea.onlinecatalog.model.Discipline;
import com.andreea.onlinecatalog.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade,Integer> {
}

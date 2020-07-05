package com.andreea.onlinecatalog.repository;


import com.andreea.onlinecatalog.model.Discipline;
import com.andreea.onlinecatalog.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplineRepository extends JpaRepository<Discipline,String> {
}

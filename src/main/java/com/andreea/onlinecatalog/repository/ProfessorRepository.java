package com.andreea.onlinecatalog.repository;

import com.andreea.onlinecatalog.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor,Integer> {
}

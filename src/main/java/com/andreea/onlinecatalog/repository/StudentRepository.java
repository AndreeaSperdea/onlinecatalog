package com.andreea.onlinecatalog.repository;


import com.andreea.onlinecatalog.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}

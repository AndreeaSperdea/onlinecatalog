package com.andreea.onlinecatalog.repository;


import com.andreea.onlinecatalog.model.Grade;
import com.andreea.onlinecatalog.model.SchoolGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolGroupRepository extends JpaRepository<SchoolGroup,Integer> {
}

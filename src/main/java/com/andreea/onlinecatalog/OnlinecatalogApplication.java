package com.andreea.onlinecatalog;

import com.andreea.onlinecatalog.model.Student;
import com.andreea.onlinecatalog.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlinecatalogApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnlinecatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Student student=new Student();
//		Student student2=new Student();
//
//		student.setFirstName("Andreea");
//		student.setLastName("Sperdea");
//
//		student2.setFirstName("Ion");
//		student2.setLastName("Popescu");
//
//		studentRepository.save(student);
//		studentRepository.save(student2);
//
//		for (Student s:studentRepository.findAll()
//			 ) {
//			System.out.println(s.getStudentId()+ " "+s.getFirstName()+ " "+ s.getLastName());

//		}


	}
}

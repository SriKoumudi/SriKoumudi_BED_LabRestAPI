package com.gl.studentfestreg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.studentfestreg.entity.Student;
import com.gl.studentfestreg.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public void run(String... args) throws Exception {

//		  Student student1 = new Student(1,"Ramesh", "Fadatare", "FSD","India");
//		  studentRepository.save(student1);
//		  
//		  Student student2 = new Student(2,"Sanjay", "Jadhav", "Backend","UK");
//		  studentRepository.save(student2);
//		  
//		  Student student3 = new Student(3,"tony", "stark", "Frontend","US");
//		  studentRepository.save(student3);
//		 

	}

}

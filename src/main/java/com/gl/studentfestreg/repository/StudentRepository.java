package com.gl.studentfestreg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.studentfestreg.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}

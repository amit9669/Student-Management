package com.qsp.springbootstudentpractice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springbootstudentpractice.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	Student findStudentByEmail(String email);

	@Query("select s from Student s where s.phone=?1")
	Student findStudentByPhone(long phone);

	List<Student> findByAddress(String address);

	List<Student> findByAge(int age);

	@Query("select s from Student s where s.name=?1")
	Student findByName(String name);

	@Query("select s from Student s where s.percentage>=?1")
	List<Student> findStudentWhosPercentageGreaterThan(double percentage);

	@Query("select s from Student s where s.percentage<=?1")
	List<Student> findStudentWhosPercentageLessThan(double percentage);
}

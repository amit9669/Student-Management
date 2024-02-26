package com.qsp.springbootstudentpractice.dao;

import java.util.List;
import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootstudentpractice.dto.Student;
import com.qsp.springbootstudentpractice.repo.StudentRepo;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepo repo;

	public Student saveStudent(Student student) {
		return repo.save(student);
	}

	public Student findStudent(int id) {
		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public List<Student> findAllStudent() {
		return repo.findAll();
	}

	public Student deleteStudent(int id) {
		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.deleteById(id);
			return optional.get();
		}
		return null;
	}

	public Student updateStudent(int id, Student student) {
		Optional<Student> optional = repo.findById(id);
		if (optional.isPresent()) {
			student.setId(id);
			return repo.save(student);
		} else {
			return null;
		}
	}

	public Student findByEmail(String email) {
		return repo.findStudentByEmail(email);
	}

	public Student findByPhone(long phone) {
		return repo.findStudentByPhone(phone);
	}

	public List<Student> findStudentWhosPercentageGreaterThan(double percentage) {
		return repo.findStudentWhosPercentageGreaterThan(percentage);
	}

	public List<Student> findStudentWhosPercentageLessThan(double percentage) {
		return repo.findStudentWhosPercentageLessThan(percentage);
	}

	public List<Student> findByAddress(String address) {
		return repo.findByAddress(address);
	}

	public List<Student> findByAge(int age) {
		return repo.findByAge(age);
	}

	public Student findByName(String name) {
		return repo.findByName(name);
	}
}

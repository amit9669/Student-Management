package com.qsp.springbootstudentpractice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootstudentpractice.dto.Student;
import com.qsp.springbootstudentpractice.service.StudentService;
import com.qsp.springbootstudentpractice.util.ResponseStructure;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping("/student")
	public ResponseStructure<Student> save(@RequestBody Student student) {
		return service.saveStudent(student);
	}

	@GetMapping("/findById")
	public ResponseEntity<ResponseStructure<Student>> find(@RequestParam int id) {
		return service.findStudentById(id);
	}

	@GetMapping("/findAll")
	public ResponseStructure<List<Student>> findAll() {
		return service.getAll();
	}

	@DeleteMapping("/deleted/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id) {
		return service.deleteStudent(id);
	}

	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestParam int id,
			@RequestBody Student student) {
		return service.updateStudent(id, student);
	}

	@GetMapping("/findbyemail")
	public ResponseEntity<ResponseStructure<Student>> findByEmail(@RequestParam String email) {
		return service.findStudentByEmail(email);
	}

	@GetMapping("/findByPhone")
	public ResponseStructure<Student> findByPhone(@RequestParam long phone) {
		return service.findStudentByPhone(phone);
	}

	@GetMapping("/findStudentWhosPercentageGreaterThan")
	public List<Student> findStudentWhosPercentageGreaterThan(@RequestParam double percentage) {
		return service.findStudentWhosPercentageGreaterThan(percentage);
	}

	@GetMapping("/findStudentWhosPercentageLessThan")
	public List<Student> findStudentWhosPercentageLessThan(@RequestParam double percentage) {
		return service.findStudentWhosPercentageLessThan(percentage);
	}

	@GetMapping("/findByAddress")
	public ResponseStructure<List<Student>> findByAddress(@RequestParam String address) {
		return service.findStudentByAddress(address);
	}

	@PatchMapping("/updateEmail/{id}")
	public ResponseEntity<ResponseStructure<Student>> UpdateEmail(@PathVariable int id, @RequestParam String email) {
		return service.updateEmail(id, email);
	}

	@PatchMapping("/updatePhone/{id}")
	public ResponseEntity<ResponseStructure<Student>> UpdatePhone(@PathVariable int id, @RequestParam long phone) {
		return service.updatePhone(id, phone);
	}

	@PatchMapping("/updateSecuredMarks/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateSecuredMarks(@PathVariable int id,
			@RequestParam int securedmarks) {
		return service.updateSecuredMarks(id, securedmarks);
	}

	@PatchMapping("/updateAge/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateAge(@PathVariable int id, @RequestParam int age) {
		return service.updateAge(id, age);
	}

	@GetMapping("/findStudentByAge")
	public ResponseStructure<List<Student>> findStudentByAge(@RequestParam int age) {
		return service.findStudentByAge(age);
	}

	@GetMapping("/findStudentByName")
	public ResponseEntity<ResponseStructure<Student>> findStudentByName(@RequestParam String name) {
		return service.findStudentByName(name);
	}

	@PatchMapping("/updateName/{id}")
	public ResponseEntity<ResponseStructure<Student>> updateStudentName(@PathVariable int id,
			@RequestParam String name) {
		return service.updateName(id, name);
	}

	@DeleteMapping("/deleteName/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudentByName(@PathVariable int id,
			@RequestParam String name) {
		return service.deleteStudentByName(id, name);
	}
}

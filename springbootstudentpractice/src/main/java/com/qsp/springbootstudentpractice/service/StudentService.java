package com.qsp.springbootstudentpractice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springbootstudentpractice.dao.StudentDao;
import com.qsp.springbootstudentpractice.dto.Student;
import com.qsp.springbootstudentpractice.exception.AddressNotFound;
import com.qsp.springbootstudentpractice.exception.AgeNotFound;
import com.qsp.springbootstudentpractice.exception.EmailNotPresent;
import com.qsp.springbootstudentpractice.exception.IdNotFound;
import com.qsp.springbootstudentpractice.exception.NameNotFound;
import com.qsp.springbootstudentpractice.exception.NoDataAvailable;
import com.qsp.springbootstudentpractice.exception.PhoneNotPresent;
import com.qsp.springbootstudentpractice.util.ResponseStructure;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public ResponseStructure<Student> saveStudent(Student student) {
		double percentage1 = (double) student.getSecuredmarks() / student.getTotalmarks() * 100;
		student.setPercentage(percentage1);
		double percentage = student.getPercentage();
		if (percentage < 35) {
			student.setGrade("Fail");
		} else if (percentage >= 35 && percentage < 50) {
			student.setGrade("Pass");
		} else if (percentage >= 50 && percentage < 65) {
			student.setGrade("Second_Class");
		} else if (percentage >= 65 && percentage < 90) {
			student.setGrade("First_Class");
		} else if (percentage >= 90) {
			student.setGrade("Distinction");
		}
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		structure.setMessage("Data Inserted Successfully!!!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveStudent(student));
		return structure;
	}

	public ResponseEntity<ResponseStructure<Student>> findStudentById(int id) {
		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {
			structure.setMessage("Data Found!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
		} else {
			throw new IdNotFound("Student Id Not Found");
		} 

	}

	public ResponseStructure<List<Student>> getAll() {
		List<Student> list = dao.findAllStudent();
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		if (list.isEmpty()) {
			throw new NoDataAvailable("No Data Available");
		} else {
			structure.setMessage("Data Found!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
		}
		return structure;
	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {
			structure.setMessage("Data Found and Deleted!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.deleteStudent(id));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Student Id Not Found");
		}

	}

	public ResponseEntity<ResponseStructure<Student>> updateStudent(int id, Student student) {
		Student dbstudent = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (dbstudent != null) {
			double percentage1 = (double) student.getSecuredmarks() / student.getTotalmarks() * 100;
			student.setPercentage(percentage1);
			double percentage = student.getPercentage();
			if (percentage < 35) {
				student.setGrade("Fail");
			} else if (percentage >= 35 && percentage < 50) {
				student.setGrade("Pass");
			} else if (percentage >= 50 && percentage < 65) {
				student.setGrade("Second_Class");
			} else if (percentage >= 65 && percentage < 90) {
				student.setGrade("First_Class");
			} else if (percentage >= 90) {
				student.setGrade("Distinction");
			}
			structure.setMessage("Data Updated Successfully!!!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dao.updateStudent(id, student));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Student Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> findStudentByEmail(String email) {
		List<Student> list = dao.findAllStudent();
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (list.isEmpty()) {
			throw new EmailNotPresent("Email not Found");
		} else {
			structure.setMessage("Data Found!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByEmail(email));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
		}

	}

	public ResponseStructure<Student> findStudentByPhone(long phone) {
		List<Student> list = dao.findAllStudent();
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (list.isEmpty()) {
			throw new PhoneNotPresent("Phone Not Found");
		} else {
			structure.setMessage("Data Found!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByPhone(phone));
		}
		return structure;
	}

	public List<Student> findStudentWhosPercentageGreaterThan(double percentage) {
		return dao.findStudentWhosPercentageGreaterThan(percentage);
	}

	public List<Student> findStudentWhosPercentageLessThan(double percentage) {
		return dao.findStudentWhosPercentageLessThan(percentage);
	}

	public ResponseStructure<List<Student>> findStudentByAddress(String address) {
		List<Student> list = dao.findAllStudent();
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		if (list.isEmpty()) {
			throw new AddressNotFound("No Address Found");
		} else {
			structure.setMessage("Data Found!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByAddress(address));
		}
		return structure;
	}

	public ResponseEntity<ResponseStructure<Student>> updateEmail(int id, String email) {
		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {
			structure.setMessage("Data Found and Update successfully!!");
			structure.setStatus(HttpStatus.OK.value());
			student.setEmail(email);
			structure.setData(dao.updateStudent(id, student));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Student Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updatePhone(int id, long phone) {
		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {
			structure.setMessage("Data Found and Update successfully!!");
			structure.setStatus(HttpStatus.OK.value());
			student.setPhone(phone);
			structure.setData(dao.updateStudent(id, student));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Student Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updateSecuredMarks(int id, int securedmarks) {
		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {

			structure.setMessage("Data Found and Update successfully!!");
			structure.setStatus(HttpStatus.OK.value());
			student.setSecuredmarks(securedmarks);
			double percentage1 = (double) student.getSecuredmarks() / student.getTotalmarks() * 100;
			student.setPercentage(percentage1);
			double percentage = student.getPercentage();
			if (percentage < 35) {
				student.setGrade("Fail");
			} else if (percentage >= 35 && percentage < 50) {
				student.setGrade("Pass");
			} else if (percentage >= 50 && percentage < 65) {
				student.setGrade("Second_Class");
			} else if (percentage >= 65 && percentage < 90) {
				student.setGrade("First_Class");
			} else if (percentage >= 90) {
				student.setGrade("Distinction");
			}
			structure.setData(dao.updateStudent(id, student));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Student Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updateAge(int id, int age) {
		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {
			structure.setMessage("Data Found and Update successfully!!");
			structure.setStatus(HttpStatus.OK.value());
			student.setAge(age);
			structure.setData(dao.updateStudent(id, student));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Student Id Not Found");
		}
	}

	public ResponseStructure<List<Student>> findStudentByAge(int age) {
		List<Student> list = dao.findAllStudent();
		ResponseStructure<List<Student>> structure = new ResponseStructure<List<Student>>();
		if (list.isEmpty()) {
			throw new AgeNotFound("Age Not Found");
		} else {
			structure.setMessage("Data Found!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.findByAge(age));
			return structure;
		}
	}

	public ResponseEntity<ResponseStructure<Student>> findStudentByName(String name) {
		Student student = dao.findByName(name);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();

		if (student != null) {
			structure.setMessage("Data found");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.FOUND);
		} else {
			throw new NameNotFound("Name not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> updateName(int id, String name) {
		Student student = dao.findStudent(id);
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (student != null) {
			structure.setMessage("Data Found and Updated Successfully!!");
			structure.setStatus(HttpStatus.OK.value());
			student.setName(name);
			structure.setData(dao.updateStudent(id, student));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		} else {
			throw new IdNotFound("Student Id Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<Student>> deleteStudentByName(int id, String name) {
		List<Student> list = dao.findAllStudent();
		ResponseStructure<Student> structure = new ResponseStructure<Student>();
		if (list.isEmpty()) {
			throw new IdNotFound("Student Id Not Found");
		} else {
			structure.setMessage("Data Found!!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(dao.deleteStudent(id));
			return new ResponseEntity<ResponseStructure<Student>>(structure, HttpStatus.OK);
		}
	}
}

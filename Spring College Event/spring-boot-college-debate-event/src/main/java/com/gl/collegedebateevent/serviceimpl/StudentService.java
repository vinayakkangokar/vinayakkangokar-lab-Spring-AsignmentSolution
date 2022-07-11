package com.gl.collegedebateevent.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gl.collegedebateevent.entity.Student;
import com.gl.collegedebateevent.repository.RoleRepository;
import com.gl.collegedebateevent.repository.StudentRepository;
import com.gl.collegedebateevent.repository.UserRepository;
import com.gl.collegedebateevent.service.IStudentService;

@Service
public class StudentService implements IStudentService {

	private StudentRepository studentRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	BCryptPasswordEncoder bcryptPasswordEncoder;

	@Autowired
	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(long studentId) {
		Student student = null;
		Optional<Student> optionalResult = studentRepository.findById(studentId);
		if (optionalResult.isPresent()) {
			student = optionalResult.get();
		} else {
			throw new RuntimeException("No registration found for student with id - " + studentId);
		}
		return student;
	}

	@Override
	public boolean save(Student student) {
		Student savedStudent = studentRepository.save(student);
		return savedStudent.getName().equals(student.getName());
	}

	@Override
	public boolean deleteById(long studentId) {
		try {
			studentRepository.deleteById(studentId);
			// Verify if record was deleted successfully
			Optional<Student> student = studentRepository.findById(studentId);
			if (!student.isPresent()) {
				return true;
			}
		} catch (java.util.NoSuchElementException ex) {
			// student registration record has been deleted successfully
			return true;
		} catch (Exception ex) {
			// Something went wrong while deleting the record
			System.out.println("Error occurred while deleting the record - " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
		return false;
	}
}

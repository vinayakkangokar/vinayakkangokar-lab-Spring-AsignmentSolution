package com.gl.collegedebateevent.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gl.collegedebateevent.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findStudentRegistrationByName(String name);

}

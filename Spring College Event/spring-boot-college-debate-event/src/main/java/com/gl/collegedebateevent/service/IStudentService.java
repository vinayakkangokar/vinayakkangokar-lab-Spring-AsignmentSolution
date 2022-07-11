package com.gl.collegedebateevent.service;

import java.util.List;

import com.gl.collegedebateevent.entity.Student;

public interface IStudentService {

	public List<Student> findAll();

	public Student findById(long studentId);

	public boolean save(Student student);

	public boolean deleteById(long studentId);

}

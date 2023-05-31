package com.softra.dao;

import java.util.List;

import com.softra.model.Student;

public interface Idao {

	void saveStudent(Student stud);
	void modifyStudent(Student stud);
	
	public List<Student> getAllStudents();
	public Student getStudentById(int sid);
	
	public String getStudentNameById(int sid);
	
	int getStudentCount();
}

package com.softra.service;

import java.util.List;

import com.softra.model.Student;

public interface IService {

	void saveStudents(List<Student> list);
	void modifyStudents(List<Student> list);
}

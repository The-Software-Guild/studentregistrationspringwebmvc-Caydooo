package com.softra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softra.dao.Idao;
import com.softra.model.Student;

public class StudentService implements IService {

	@Autowired
	private Idao dao;
	
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public StudentService() {
		//System.out.println("Inside default constructor for StudentService");
	}
	
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void saveStudents(List<Student> list) {
		//System.out.println("Inside saveStudents in StudentService (Service Layer)");
		
		for(Student e : list) {
			dao.saveStudent(e);
		}
	}

	public void modifyStudents(List<Student> list) {
		//System.out.println("Inside modifyStudents in StudentService (Service Layer)");

		for(Student e : list) {
			dao.modifyStudent(e);
		}
	}

}

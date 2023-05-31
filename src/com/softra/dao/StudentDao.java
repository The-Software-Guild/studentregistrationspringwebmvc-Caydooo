package com.softra.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.softra.model.Student;

public class StudentDao implements Idao {

	@Autowired
	private JdbcTemplate template;
	@Autowired
	private PlatformTransactionManager transactionManager;
	
	public StudentDao() {
		//System.out.println("Inside default constructor for EmployeeDAO");
	}
	
	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public void saveStudent(Student stud) {
		//System.out.println("Inside DAO layer - saveEmployee");
		String sql = "INSERT INTO student VALUES (?, ?, ?, ?, ?)";
		template.update(sql, stud.getSid(), stud.getName(), stud.getAge(), stud.getMobile(), stud.getAddress());
	}

	@Override
	public void modifyStudent(Student stud) {
		//System.out.println("Inside DAO layer");
		String sql = "UPDATE student SET address=? WHERE id=?";
		template.update(sql, stud.getAddress(), stud.getSid());
	}

	@Override
	public List<Student> getAllStudents() {
		String sql = "SELECT * FROM student";
		
		//return template.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
		return template.query(sql, new StudentRowMapper());
	}

	@Override
	public Student getStudentById(int sid) {

		String sql = "SELECT * FROM student WHERE id=?";
		
		return template.queryForObject(sql, new Object[]{sid}, new StudentRowMapper());
	}

	@Override
	public String getStudentNameById(int sid) {

		String sql = "SELECT fname FROM student WHERE id=?";
		
		return template.queryForObject(sql, String.class, sid);
	}

	@Override
	public int getStudentCount() {

		String sql = "SELECT COUNT(*) FROM student";
		
		return template.queryForObject(sql, Integer.class);
	}

}

package com.softra.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.softra.model.Student;
import com.softra.service.IService;

@Controller
public class RegistrationController {

	@Autowired
	private IService service;
	@Autowired
	@Qualifier(value = "studVal")
	private Validator validator;
	
	@RequestMapping("/") 
	public String home(){
	    return "redirect:/savestudent.htm"; 
	} 
	
	@RequestMapping(value = "/savestudent.htm", method = RequestMethod.GET)
	public String showStudForm(Map<String, Student> map) {
		System.out.println("Inside showStudForm of StudentController");
		map.put("s", new Student());
		
		return "studregform";
	}
	
	@RequestMapping(value = "/savestudent.htm", method = RequestMethod.POST)
	//public String persistEmployee(@RequestParam("eid") Integer id, String fname, String lname, Map<String, Employee> map) {
	//public String persistEmployee(@ModelAttribute("e") Employee e, Map<String, Employee> map) {
	public String persistStudent(@ModelAttribute("s") Student s, BindingResult result, Map<String, Student> map) {
		System.out.println("Inside persistStudent of StudentController");		
		System.out.println(s);

		// Now invoking service layer to store the Employee
		System.out.println("Invoking service layer...");
		map.put("s", s);

		List<Student> list = new ArrayList<>();
		list.add(s);
		
		//EmployeeValidator empVal = new EmployeeValidator();
		validator.validate(s, result);
		if(result.hasErrors()) {
			return "studregform";
		}
		service.saveStudents(list);
		
		return "success";
	}
}

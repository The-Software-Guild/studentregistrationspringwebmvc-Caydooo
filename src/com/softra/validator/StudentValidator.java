package com.softra.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.softra.model.Student;

@Component("studVal")
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class clas) {
		System.out.println("Inside supports of StudentValidator");
		return Student.class.equals(clas);
	}

	@Override
	public void validate(Object target, Errors error) {
		System.out.println("Inside validate of StudentValidator");
		Student stud = (Student)target;
		ValidationUtils.rejectIfEmpty(error, "name", "name.error");
		ValidationUtils.rejectIfEmpty(error, "age", "age.error");
		ValidationUtils.rejectIfEmpty(error, "mobile", "mobile.error");
		ValidationUtils.rejectIfEmpty(error, "address", "address.error");
	}

}

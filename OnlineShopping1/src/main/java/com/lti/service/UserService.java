package com.lti.service;

import java.util.List;

import com.lti.model.User;
import com.lti.model.User1;

public interface UserService {
	public boolean addUser(User user);

	public User findUser(User1 user);

	/*
	 * public boolean updateStudentDetails(Student student);
	 * 
	 * public boolean deleteStudentByRollNumber(int rollnumber);
	 */

	// public List<Student> AllStudent();
}

package com.lti.dao;

import java.util.List;

import com.lti.model.User;
import com.lti.model.User1;

public interface UserDao {
	public int createUser(User user);

	// public int updateStudent(Student student);
	//
	// public int deleteStudentByRollNumber(int rollNumber);*/
	//
	// //public List<Student> AllStudents();

	public void beginTransaction();

	public void commitTransaction();

	public void rollBackTransaction();

	public User readUser(User1 user);
}

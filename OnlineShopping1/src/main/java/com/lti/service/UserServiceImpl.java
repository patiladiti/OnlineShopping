package com.lti.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.UserDao;
import com.lti.dao.UserDaoImpl;

import com.lti.model.User;
import com.lti.model.User1;

@Service("service")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao dao;

	@Override
	public boolean addUser(User user) {

		int result = dao.createUser(user);
		if (result == 1)
			return true;
		else
			return false;
	}

	@Override
	public User findUser(User1 user) {
		User result = dao.readUser(user);
		return result;
	}

	/*
	 * public StudentDao getDao() { return dao; }
	 * 
	 * public void setDao(StudentDao dao) { this.dao = dao; }
	 * 
	 * @Override public boolean updateStudentDetails(Student student) {
	 * dao.beginTransaction(); int result = dao.updateStudent(student); if
	 * (result == 1) { dao.commitTransaction(); return true; } else {
	 * dao.rollBackTransaction(); return false;
	 * 
	 * } }
	 * 
	 * @Override public boolean deleteStudentByRollNumber(int rollnumber) {
	 * dao.beginTransaction(); int result =
	 * dao.deleteStudentByRollNumber(rollnumber); if (result == 1) {
	 * dao.commitTransaction(); return true; } else { dao.rollBackTransaction();
	 * return false; } }
	 */

	// @Override
	/*
	 * public List<Student> AllStudent() { List<Student> list = new
	 * ArrayList<Student>(); list = dao.AllStudents(); return list; }
	 */
}

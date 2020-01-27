package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.User;
import com.lti.model.User1;
import com.lti.service.UserService;

@RestController
@RequestMapping(path = "User")
@CrossOrigin
public class UserRestController {
	@Autowired
	private UserService service;

	// http://localhost:9091/students
	// @RequestMapping(method = RequestMethod.GET, produces =
	// MediaType.APPLICATION_JSON_VALUE)
	/*
	 * public List<Student> findAllStudents() { List<Student> students =
	 * service.AllStudent(); return students; }
	 */

	// http://localhost:9091/User
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public User1 readUser(@RequestBody User1 user) {
		ResponseEntity<String> response;
		String username = user.getUserName();
		String password = user.getPassword();
		System.out.println(username + " and " + password);
		User users = service.findUser(user);

		if (users != null) {
			response = new ResponseEntity<>("Login Successful", HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<>("Invalid Login", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return user;
	}

	// http://localhost:9091/User
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody User user) {
		ResponseEntity<String> response;
		boolean result = service.addUser(user);
		if (result) {
			response = new ResponseEntity<String>("User is added", HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<String>("user is not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return user;
	}

	/*
	 * @RequestMapping(path="{rollNumber}",method = RequestMethod.DELETE) public
	 * void deleteStudent(@PathVariable("rollNumber") int rollNumber) { boolean
	 * result = service.deleteStudentByRollNumber(rollNumber); } //
	 * http://localhost:9091/students
	 * 
	 * @RequestMapping(method = RequestMethod.PUT, consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public void updateStudent(@RequestBody
	 * Student student) { boolean result =
	 * service.updateStudentDetails(student); }
	 */

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		ResponseEntity<String> error = new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return error;
	}

}

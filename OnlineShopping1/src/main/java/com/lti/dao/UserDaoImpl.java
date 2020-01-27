package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.User;
import com.lti.model.User1;

@Repository
public class UserDaoImpl implements UserDao {
	@PersistenceContext
	private EntityManager entityManager;

	public UserDaoImpl() {

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int createUser(User user) {
		entityManager.persist(user);
		return 1;
	}

	@Override
	@Transactional
	public User readUser(User1 user) {

		TypedQuery<User> query = entityManager
				.createQuery("From User u where u.userName = :username and u.password = :password", User.class);

		query.setParameter("username", user.getUserName());
		query.setParameter("password", user.getPassword());

		User users = query.getSingleResult();

		System.out.println(users);
		// entityManager.getTransaction().commit();
		// String pass=users.getPassword();
		// String user_name=users.getUserName();
		//
		// if(user_name.equals(users.getUserName()) &&
		// pass.equals(users.getPassword())){
		// return users;
		// }
		// else{
		// return null;
		// }

		if (users != null) {
			return users;
		} else {
			return null;
		}
	}

	/*
	 * @Override
	 * 
	 * @Transactional(propagation=Propagation.REQUIRED) public int
	 * updateStudent(Student student) { String
	 * q="update Student s set s.studentName='"+student.getStudentName()+
	 * "',s.studentScore="
	 * +student.getStudentScore()+"where s.rollNumber="+student.getRollNumber();
	 * Query query=entityMangaer.createQuery(q); return query.executeUpdate(); }
	 * 
	 * @Override
	 * 
	 * @Transactional(propagation=Propagation.REQUIRED) public int
	 * deleteStudentByRollNumber(int rollNumber) {
	 * 
	 * //int result=entityMangaer.remove(); String
	 * q="Delete from Student s where s.rollNumber=:rollNumber"; Query
	 * query=entityMangaer.createQuery(q); query.setParameter("rollNumber",
	 * rollNumber); int result = query.executeUpdate(); entityMangaer.clear();
	 * return result; }
	 */

	@Override
	public void beginTransaction() {

	}

	@Override
	public void commitTransaction() {

	}

	@Override

	public void rollBackTransaction() {
		entityManager.getTransaction().rollback();
	}

	/*
	 * @Override public List<Student> AllStudents() { String
	 * jpql="From Student"; TypedQuery<Student>
	 * tquery=entityMangaer.createQuery(jpql,Student.class); return
	 * tquery.getResultList(); }
	 */
}

package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IUserDao;
import com.app.model.User;

@Repository
public class UserDaoImpl implements IUserDao{

	// create object fro HibernateTemplate class
	@Autowired
	private HibernateTemplate ht;

	// saving user in DB table
	public Integer saveUser(User user) {

		return (Integer) ht.save(user);
	}

	// update a user details based on userId
	public void updateUser(User user) {

		ht.update(user);
	}

	// delete a user details based on userId
	public void deleteUser(Integer userId) {

		ht.delete(new User(userId));
	}

	// get one user user details based on userId
	public User getUserById(Integer userId) {

		return ht.get(User.class, userId);
	}

	// get all user user details based on userId
	public List<User> getAllUsers() {

		return ht.loadAll(User.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Object[]> getUsersCount() {

		String hql =   "select gender,count(gender) from "
				+User.class.getCanonicalName()
				+" group by gender";

		List<Object[]> users = (List<Object[]>) ht.find(hql);

		return users;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public boolean isEmailOrMobileExist(String type, String userEmailOrmobile) {

		long count=0;

		String hql="select count("+type+") from "+User.class.getName()+" where "+type+"=?";

		List<Long> whUserType=(List<Long>) ht.find(hql, userEmailOrmobile);

		if (whUserType!=null && !whUserType.isEmpty()) {
			count=whUserType.get(0);
		}
		return count>0?true:false;
	}
}

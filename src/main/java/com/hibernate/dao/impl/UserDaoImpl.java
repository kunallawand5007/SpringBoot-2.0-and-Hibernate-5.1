/**
 * 
 */
package com.hibernate.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.dao.UserDao;
import com.hibernate.model.User;

/**
 * @author kunal.lawand
 *
 */
@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	EntityManagerFactory entityManger;

	@Override
	public int saveUser(User user) {

		try (Session openSession = entityManger.unwrap(SessionFactory.class).openSession()) {
			System.out.println(openSession.isConnected());

			openSession.save(user);
			openSession.beginTransaction().commit();

		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return user.getUserid();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		List<User> userList = new ArrayList<User>();
		try (Session openSession = entityManger.unwrap(SessionFactory.class).openSession()) {
			System.out.println("HashCode:" + openSession.hashCode());
			userList = openSession.createCriteria(User.class).list();
			openSession.beginTransaction().commit();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return userList;
	}

}

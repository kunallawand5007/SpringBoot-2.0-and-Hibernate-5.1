/**
 * 
 */
package com.hibernate.dao;

import java.util.List;

import com.hibernate.model.User;

/**
 * @author kunal.lawand
 *
 */
public interface UserDao {

	int saveUser(User user);

	List<User> getAllUser();
}

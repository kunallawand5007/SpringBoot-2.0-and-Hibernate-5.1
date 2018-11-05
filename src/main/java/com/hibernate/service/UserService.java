/**
 * 
 */
package com.hibernate.service;

import java.util.List;

import com.hibernate.model.User;

/**
 * @author kunal.lawand
 *
 */
public interface UserService {

	int save(User user);
	
	List<User> list();

}

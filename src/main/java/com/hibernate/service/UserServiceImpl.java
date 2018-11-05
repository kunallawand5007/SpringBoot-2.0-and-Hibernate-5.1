/**
 * 
 */
package com.hibernate.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.dao.RoleDao;
import com.hibernate.dao.UserDao;
import com.hibernate.model.Roles;
import com.hibernate.model.User;

/**
 * @author kunal.lawand
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Autowired
	RoleDao roleDao;

	@Override
	public int save(User user) {
		 int saveUser = userDao.saveUser(user);
		 Set<Roles> roleses = user.getRoleses();
		 for (Roles roles : roleses) {
			 roleDao.saveRole(roles, user);
		}
		 return saveUser;
		 
	}

	@Override
	public List<User> list() {
		return userDao.getAllUser();
	}

}

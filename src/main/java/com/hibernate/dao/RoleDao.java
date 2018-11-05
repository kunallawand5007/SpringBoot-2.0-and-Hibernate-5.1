/**
 * 
 */
package com.hibernate.dao;

import com.hibernate.model.Roles;
import com.hibernate.model.User;

/**
 * @author kunal.lawand
 *
 */
public interface RoleDao {

	
	int saveRole(Roles roles,User user);
}

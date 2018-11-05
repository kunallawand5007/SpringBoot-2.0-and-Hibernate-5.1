/**
 * 
 */
package com.hibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.model.User;
import com.hibernate.service.UserService;

/**
 * @author kunal.lawand
 *
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/save", headers = "accept=application/json", method = RequestMethod.POST)
	public ResponseEntity<String> save(@RequestBody User user) {
		userService.save(user);
		return new ResponseEntity<String>("", HttpStatus.OK);
	}

	@RequestMapping(value = "/get", headers = "accept=application/json", method = RequestMethod.POST)
	public ResponseEntity<List<User>> save() {
		return new ResponseEntity<List<User>>(userService.list(), HttpStatus.OK);
	}

}

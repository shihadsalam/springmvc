
package com.webapp.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.webapp.config.AppConfiguration;
import com.webapp.model.User;
import com.webapp.services.UserService;

/**
 * Simple tester for Spring-Data-JPA.
 **/
public class SpringDataJPATest {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfiguration.class);
		ctx.refresh();

		UserService userService = ctx.getBean(UserService.class);
		
		List<User> users = new ArrayList<>();
		users.add(new User("usr1", "male", "9876345678", new Date(1989, 03, 05), "ID-1"));
		users.add(new User("usr2", "male", "8876345678", new Date(1975, 12, 12), "ID-2"));
		userService.addUsers(users);

		System.out.println("findAll=" + userService.getAllUsers());

		System.out.println("findByName is 'usr1': " + userService.getUserByName("usr1"));
		
		ctx.close();

	}
}

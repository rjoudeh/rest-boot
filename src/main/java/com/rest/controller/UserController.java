package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionData;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	ConnectionRepository connectionRepository;

	@Autowired
	private ConnectionFactoryLocator connectionFactoryLocator;

	@Autowired
	Facebook face;

	@RequestMapping(value = "/fb", method = RequestMethod.GET)
	public String fbLogin(@RequestParam(name = "token") String token) {
		System.out.println("fb token: " + token);

		FacebookConnectionFactory connectionFactory = (FacebookConnectionFactory) connectionFactoryLocator
				.getConnectionFactory("facebook");

		AccessGrant accessGrant = new AccessGrant(token);
		Connection<Facebook> connection = connectionFactory.createConnection(accessGrant);

		ConnectionData data = connection.createData();

		return "";
	}
}

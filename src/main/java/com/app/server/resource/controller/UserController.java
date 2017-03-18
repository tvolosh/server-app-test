package com.app.server.resource.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import com.app.server.resource.dao.RoleDao;
import com.app.server.resource.dao.UserDao;
import com.app.server.resource.model.Role;
import com.app.server.resource.model.User;
import com.app.server.resource.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserServices userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

	@RequestMapping(method = RequestMethod.GET, value = "/user")
	public Map<String, Object> admin(Principal user) {
		Map<String, Object> hasil = new HashMap<String, Object>();
		hasil.put("response", Boolean.TRUE);
		hasil.put("user", user.getName());
		return hasil;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/test")
	public Map<String, Object> test() {

        Map<String, Object> hasil = new HashMap<String, Object>();

        userDao.deleteAll();
        roleDao.deleteAll();
        
		Role role = new Role();
        role.setName("USER_ROLE");
        roleDao.save(role);

        hasil.put("response", Boolean.TRUE);
        hasil.put("message", "test unprotected api");
        hasil.put("saved role", roleDao.findAll());

		User user = new User();
        user.setUsername("UserTest");
        user.setPassword("$2a$10$EtY4VMtfEh0x7DKWwuLzkOJDkfP2apv2ZvhMUvOVHSllaTwHPxhRi");
        user.setRole(role);

        userDao.save(user);

        hasil.put("saved user", userDao.findAll());

		return hasil;
	}
}
package com.app.server.resource.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	
	@RequestMapping(method = RequestMethod.GET, value = "/")
    String home() {
        return "Hello World!";
  
  }
}
package com.tutorial.springboot.controller;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

	@RequestMapping(value = "/login",  method = RequestMethod.GET)
	public String loginMessage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		return "login";
	}
}

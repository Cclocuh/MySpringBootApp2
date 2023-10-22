package com.gcu.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.entity.User;
import com.gcu.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/login")
	public String loginForm() {
		return "login"; // Render the login form
	}

	@GetMapping("/register")
	public String registrationForm(Model model) {
		model.addAttribute("user", new User());
		return "registration";
	}

	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "redirect:/login";
	}

	@GetMapping("/profile")
	public String userProfile(Model model, Principal principal) {
		String username = principal.getName(); // Get the currently logged-in user's username
		User user = userService.findUserByUsername(username);
		model.addAttribute("user", user);
		return "profile"; // Render the user's profile page
	}

}

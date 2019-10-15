package com.capp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capp.command.LoginCommand;
import com.capp.command.UserCommand;
import com.capp.domain.User;
import com.capp.exception.UserBlockedException;
import com.capp.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/", "/index"})
	public String index(Model m) {
		m.addAttribute("command", new LoginCommand());
		return "index";   //JSP - /WEB-INF/view/index.jsp
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m, HttpSession httpSession)  {
		try {
			User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
			if (loggedInUser == null) {
				m.addAttribute("err", "Login Failed!! Enter Valid Credentials.");
				return "index";
			}else {
				// SUCCESS
				// Check the role and direct to a approriate dashboard.
				if(loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
					// add user detail in session(Assign session to logged in user)
					addUserInSession(loggedInUser, httpSession);
					return "redirect:/admin/dashboard";
				}else if (loggedInUser.getRole().equals(UserService.ROLE_USER)) {
					// add user detail in session(Assign session to logged in user)
					addUserInSession(loggedInUser, httpSession);
					return "redirect:/user/dashboard";
				}else {
					//Add error message and go to login form
					 m.addAttribute("err", "Invalid User Role");
					 return "/index";   //JSP - Login form
				}
			}
			
		} catch (UserBlockedException e) {
			// add error message and go back to login-form
			 m.addAttribute("err", e.getMessage());
			 return "index";   //JSP - Login form
		}
	}
	
	@RequestMapping(value = "/user/dashboard")
	public String userDashboard() {
		return "user_dashboard";   //JSP
	}
	
	@RequestMapping(value = {"/admin/dashboard"})
	public String adminDashboard() {
		return "admin_dashboard";   //JSP
	}
	
	@RequestMapping(value = {"/admin/users"})
	public String getUserList(Model m) {
		m.addAttribute("userList", userService.getUserList());
		return "users";   //JSP
	}
	
	@RequestMapping(value = "reg_form")
	public String registrationForm(Model m) {
		UserCommand cmd = new UserCommand();
		m.addAttribute("command", cmd);
		return "reg_form";   //JSP
	}
	
	@RequestMapping(value = "/admin/change_status")
	@ResponseBody
	public String changeLoginStaus(@RequestParam Integer userId, @RequestParam Integer loginStatus) {
		try {
			userService.changeLoginStatus(userId, loginStatus);
			return "SUCCESS: Status Changed";
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR: Status NOT Changed";
		}
	}
	
	@RequestMapping(value = "/check_avail")
	@ResponseBody
	public String checkAvailability(@RequestParam String username) {
		if (userService.isUsernameExist(username)) {
			return "This username is taken. Choose another name";
		}else {
			return "You can take this";
		}
	}
	
	@RequestMapping(value = "/register")
	public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m) {
		try {
			User user = cmd.getUser();
			user.setRole(UserService.ROLE_USER);
			user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
			userService.register(user);
			return "redirect:index?act=reg";   //Login Page
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			m.addAttribute("err", "Username is already registered. Please select another username.");
			return "reg_form"; // JSP
		}
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index?act=lo";   //action logout done
	}
	
	private void addUserInSession(User u, HttpSession session) {
		session.setAttribute("user", u);
		session.setAttribute("userId", u.getUserId());
		session.setAttribute("role", u.getRole());
	}

}

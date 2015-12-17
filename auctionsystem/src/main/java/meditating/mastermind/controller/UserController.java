package meditating.mastermind.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import meditating.mastermind.domain.User;
import meditating.mastermind.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@ModelAttribute("addUser") User user) {
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.GET)
	public String getAddNewUserForm(@ModelAttribute("addUser") User newUser) {
		return "addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String processAddNewUserForm(@ModelAttribute("addUser") @Valid User userToBeAdded, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			return "addUser";
		}

		try {
			System.out.println(userToBeAdded.getAddress().getZipcode());
			userService.save(userToBeAdded);
		} catch (Exception up) {
			System.out.println("Transaction Failed!!!");

		}

		return "redirect:/login";
	}

}

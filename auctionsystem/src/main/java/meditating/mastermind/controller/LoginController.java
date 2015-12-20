package meditating.mastermind.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import meditating.mastermind.domain.Credentials;
import meditating.mastermind.domain.User;
import meditating.mastermind.service.UserService;

@SessionAttributes("loggedInUser")

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping("/error-forbidden")
	public String errorForbidden() {
		return "error-forbidden";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus session) {
		SecurityContextHolder.getContext().setAuthentication(null);
		session.setComplete();
		return "redirect:/welcome";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String postLogin(String username, String password, Model model, HttpSession session) {

		if (username == null || password == null) {
			model.addAttribute("message", "None of field can be empty");
		}
		Credentials credentials = userService.isCorrectUsernameAndPassword(username, password);

		if (credentials != null) {
			/*
			 * System.out.println(credentials.getId());
			 * System.out.println(userService.findByUserNumber(credentials.getId
			 * ()));
			 */
			User user = userService.findByUserNumber(credentials.getId());
			model.addAttribute("loggedInUser", user);
			return "redirect:/welcome";
		}
		model.addAttribute("message", "Username or password didn't matched");
		return "login";

		// return "redirect:/welcome";
	}

}

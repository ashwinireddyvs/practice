package com.practice.springboot.MyFirstWebApp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@SessionAttributes("name")
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	//login?name=Srihan
	@RequestMapping("samplelogin")
	public String gotoLoginPage(@RequestParam String name,ModelMap model) {
		log.debug("request param is {}",name);
		
		model.put("name",name);
		return "samplelogin";
	}
	
	@RequestMapping(value="login", method = RequestMethod.GET)
	public String gotoLoginPage() {
				return "login";
	}
	
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String gotoWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		

		//login?name=ashwini ==> RequestParam
		//even for form data ==> Request
		if(authenticationService.authenticate(name, password)) {
			model.put("name",name);
			model.put("password",password);
			return "welcome";
		}
		model.put("errorMsg","Invalid Credentials! Please try again.");
		return "login";
				
	}
	
	
}

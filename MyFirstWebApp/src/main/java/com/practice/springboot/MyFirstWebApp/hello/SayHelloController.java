package com.practice.springboot.MyFirstWebApp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	
	// "say-hello" ==> "Hello! what are you learning today"
	@RequestMapping("say-hello")
	@ResponseBody //or else it looks for the view, if not found it  return 404
	public String sayHello() {
		return "Hello! what are you learning today";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody //or else it looks for the view, if not found it  return 404
	public String sayHelloHtml() {
		
		return """	
			<html>
				<head>
					<title>My First HTML page</title>
				</head>
				<body>
					My First html page with body
				</body>
			</html>
			""";
	}
	
	// say-hello-jsp == > sayHello.jsp
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		
		return "sayHello";
	}
	
	
}

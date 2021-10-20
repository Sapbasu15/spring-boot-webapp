package com.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource messageSource;

	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
	public HelloWorldBean helloWorld() {
		return new HelloWorldBean("Hello World Bean..!");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-internationalized")
	public String helloWorldInternationalized() {
		return messageSource.getMessage("greetings.message", null, "Default Greetings", LocaleContextHolder.getLocale());
	}
}

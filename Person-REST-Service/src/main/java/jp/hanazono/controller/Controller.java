package jp.hanazono.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.hanazono.domain.Person;

@RestController("/")
@RequestMapping("/")
public class Controller {

	@RequestMapping("/")
	public Person test() {
		Person person = new Person(0, "fname", "lname", 99);
		return person;

	}

}

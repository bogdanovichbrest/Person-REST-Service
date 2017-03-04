package jp.hanazono.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.hanazono.dao.PersonDAO;
import jp.hanazono.domain.Person;

@RestController("/")
@RequestMapping("/")
public class Controller {
	@Autowired
	@Qualifier("personDAO")
	PersonDAO dao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Person> getAllPersons() {

		return dao.getAllPersons();

	}

}

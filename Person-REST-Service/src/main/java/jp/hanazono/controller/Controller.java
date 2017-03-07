package jp.hanazono.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deletePerson(@RequestBody Person person) {
		System.out.println(person.getId());
		dao.deletePerson(person);
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void updatePerson(Person person) {
		dao.updatePerson(person);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addPerson(@RequestBody Person person) {

		dao.addPerson(person);
	}

}

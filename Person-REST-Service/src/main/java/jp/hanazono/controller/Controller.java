package jp.hanazono.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public List<Person> deletePerson(HttpServletRequest request) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		dao.deletePerson(dao.findByID(id));
		return dao.getAllPersons();
	}
	
	@RequestMapping(value="/", method = RequestMethod.PUT)
	public List<Person> updatePerson(HttpServletRequest request)
	{
		Person person = new Person();
		person.setId(Integer.parseInt(request.getParameter("id")));
		person.setFirstname(request.getParameter("firstname"));
		person.setLastname(request.getParameter("lastname"));
		person.setAge(Integer.parseInt(request.getParameter("age")));
		dao.updatePerson(person);
		return dao.getAllPersons();
	}
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public List<Person> addPerson(HttpServletRequest request)
	{
		Person person = new Person();
		person.setFirstname(request.getParameter("firstname"));
		person.setLastname(request.getParameter("lastname"));
		person.setAge(Integer.parseInt(request.getParameter("age")));
		dao.addPerson(person);
		return dao.getAllPersons();
	}

}

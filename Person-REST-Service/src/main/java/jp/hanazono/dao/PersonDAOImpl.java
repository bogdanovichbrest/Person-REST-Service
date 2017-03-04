package jp.hanazono.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jp.hanazono.domain.Person;

public class PersonDAOImpl implements PersonDAO{
	@Autowired
	@Qualifier("PersonDataSource")
	DriverManagerDataSource dataSource;
	JdbcTemplate template;
	
	public void init()
	{
		template.setDataSource(dataSource);
	}
	

	public void addPerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public void updatePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public void deletePerson(Person person) {
		// TODO Auto-generated method stub
		
	}

	public Person findByID(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return null;
	}

}

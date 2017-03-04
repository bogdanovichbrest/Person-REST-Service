package jp.hanazono.dao;

import java.util.List;

import jp.hanazono.domain.Person;

public interface PersonDAO {
	
	public void addPerson(Person person);
	public void updatePerson(Person person);
	public void deletePerson(Person person);
	public Person findByID(Integer id);
	public List<Person> getAllPersons();
	
}

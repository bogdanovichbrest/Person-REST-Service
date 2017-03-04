package jp.hanazono.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import jp.hanazono.domain.Person;

public class PersonDAOImpl implements PersonDAO{
	@Autowired
	@Qualifier("PersonDataSource")
	DriverManagerDataSource dataSource;
	JdbcTemplate template;
	
	public void init()
	{
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}
	

	public void addPerson(Person person) {
		StringBuilder sb = new StringBuilder();
		sb.append("INSERT INTO PERSON VALUES(");
		sb.append(person.getId()+",'");
		sb.append(person.getFirstname()+"','");
		sb.append(person.getLastname()+"',");
		sb.append(person.getAge()+");");
		
		template.execute(sb.toString());
		
	}

	public void updatePerson(Person person) {
		StringBuilder sb = new StringBuilder();
		sb.append("UPDATE PERSON SET FIRSTNAME='");
		sb.append(person.getFirstname()+"',LASTNAME='");
		sb.append(person.getLastname()+"',AGE=");
		sb.append(person.getAge()+" WHERE ID=");
		sb.append(person.getId()+";");
		
		template.update(sb.toString());
		
	}

	public void deletePerson(Person person) {
		template.execute("DELETE * FROM PERSON WHERE ID = " + person.getId());
		
	}

	public Person findByID(Integer id) {
		
		return template.query("SELECT * FROM PERSON WHERE ID = ", rowMapper).get(0);
	}

	public List<Person> getAllPersons() {

		return template.query("SELECT * FROM PERSON", rowMapper);
	}
	
	private RowMapper<Person> rowMapper = new RowMapper<Person>() {

		public Person mapRow(ResultSet rs, int numRow) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("ID"));
			person.setFirstname(rs.getString("FIRSTNAME"));
			person.setLastname(rs.getString("LASTNAME"));
			person.setAge(rs.getInt("AGE"));
			return person;
		}
	};

}

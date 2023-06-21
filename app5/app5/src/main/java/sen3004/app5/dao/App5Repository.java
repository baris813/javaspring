package sen3004.app5.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import sen3004.app5.model.Person;

@Repository
public class App5Repository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Person> rowMapper = new RowMapper<Person>() {

		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getLong("id"));
			person.setFirstName(rs.getString("fname"));
			person.setLastName(rs.getString("lname"));
			person.setDateOfBirth(rs.getObject("dob", LocalDate.class));
			
			return person;
		}
		
	};
	
	public List<Person> findAll(){
		String sql = "select * from person";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public Person findById(long id){
		String sql = "select * from person where id = ?";
		return DataAccessUtils.singleResult(jdbcTemplate.query(sql, rowMapper, id));
	}

	public void create(Person person) {
		String sql = "insert into person(fname, lname, dob) values(?, ?, ?)";
		jdbcTemplate.update(sql, person.getFirstName(), person.getLastName(), person.getDateOfBirth());
	}

	public void delete(long id) {
		String sql = "delete from person where id = ?";
		jdbcTemplate.update(sql, id);
	} 
}

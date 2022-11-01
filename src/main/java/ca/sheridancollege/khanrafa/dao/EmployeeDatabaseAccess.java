package ca.sheridancollege.khanrafa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;



import ca.sheridancollege.khanrafa.bean.Employee;
//repo setup and various database functions used in the program
@Repository
public class EmployeeDatabaseAccess {
	@Autowired
	protected NamedParameterJdbcTemplate jdbc;
	
	public long addEmployee(Employee employee) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String insert="INSERT INTO employee (empName, empAddress, empPhone) " 	
					+ "VALUES  (:empName, :empAddress,  :empPhone);";
		namedParameters.addValue("empName", employee.getEmpName());
		namedParameters.addValue("empAddress", employee.getEmpAddress());
		namedParameters.addValue("empPhone", employee.getEmpPhone());
		int rowsAffected = jdbc.update(insert, namedParameters);
		return rowsAffected;
		}
	
	public List<Employee>  selectEmployees() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "SELECT * FROM employee";
		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
//	public List<Employee> findByEmpNum (String empNum){
//		String inSql = String.join(",",  Collections.nCopies(empNum.size(), ?))
//		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
//		String query = "SELECT employee FROM EMPLOYEE WHERE empNum in (?)";		
//		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<Employee>(Employee.class));
		
//	}
	public List<Employee> selectEmpByEmpNum(String empNumInput){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String empByEmpNum = "SELECT * FROM employee where empNum = :empNum";
		namedParameters.addValue("empNum", empNumInput);
		return jdbc.query(empByEmpNum, namedParameters, new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public List<Employee> selectEmpByPhone(String phoneInput){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String empByPhone = "SELECT * FROM employee WHERE phone = :phone";
		namedParameters.addValue("phone", phoneInput);
		return jdbc.query(empByPhone, namedParameters, new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public List<Employee> deleteEmpByNum (List<Employee> empNumDelete){
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String deleteEmpByNum = "DELETE FROM employee WHERE empNum = :empNum";
		return jdbc.query(deleteEmpByNum, namedParameters, new BeanPropertyRowMapper<Employee>(Employee.class));
		
	}

}

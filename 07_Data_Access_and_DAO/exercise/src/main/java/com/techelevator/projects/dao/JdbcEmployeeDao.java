package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		String sqlReturnAll = "SELECT * from employee;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlReturnAll);

		while (results.next()) {
			Employee employee = mapRowToEmployee(results);
			employeeList.add(employee);
		}
		return employeeList;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employeeList = new ArrayList<>();
		String sqlSearchName = "SELECT * FROM employee WHERE first_name ILIKE ? AND last_name ILIKE ?;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchName, "%" + firstNameSearch + "% ", "%" + lastNameSearch + "%");
		while (results.next()){
			Employee employee = mapRowToEmployee(results);
			employeeList.add(employee);
		}
		return employeeList;
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee employee = new Employee();
		employee.setId(results.getLong("department_id"));
		return employee;
	}



	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employeesList = new ArrayList<>();
		String sqlSearchByProjectID = "select employee_id, department_id, first_name, last_name, birth_date, hire_date from employee " +
				"join project_employee using (employee_id) where project_id = ?;";
		jdbcTemplate.update(sqlSearchByProjectID);

		return employeesList;
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlFk = "DELETE FROM project_employee " +
				"WHERE project_id = ?;";

		String sql = "DELETE FROM project_employee " +
				"WHERE employee_id = ?;";
		jdbcTemplate.update(sqlFk,projectId);
		jdbcTemplate.update(sql, employeeId);
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		return new ArrayList<>();
	}


}

package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(Long id) {
		Department department = null;
		String sqlDepartment = "SELECT department_id, name FROM department WHERE department_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlDepartment, id);
		if (results.next()){
			department = mapRowToDepartment(results);
		}
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departmentList = new ArrayList<>();
		String sqlAllDepartments = "SELECT * FROM department";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlAllDepartments);

		while (results.next()){
			Department department = mapRowToDepartment(results);
			departmentList.add(department);
		}
		return departmentList;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {
		String sqlUpdateDepartment = "UPDATE department SET name = ? WHERE department_id = ?;";
		jdbcTemplate.update(sqlUpdateDepartment,updatedDepartment.getName(),updatedDepartment.getId());
	}

	private Department mapRowToDepartment(SqlRowSet results){
		Department department = new Department();

		department.setId(results.getLong("department_id"));
		department.setName(results.getString("name"));

		return department;
	}
}

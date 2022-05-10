package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(Long projectId) {
		Project project = null;
		String sqlGetProject = "Select ? from project";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetProject, projectId);
		return project;
	}

	@Override
	public List<Project> getAllProjects() {
		List<Project> projectList = new ArrayList<>();
		String sqlGetAllProjects = "select * FROM project";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllProjects);

		while (results.next()){
			Project project = mapRowToProject(results);
			projectList.add(project);
		}
		return projectList;
	}

	@Override
	public Project createProject(Project newProject) {
		String sqlWords = "INSERT INTO project (project_id, name, from_date, to_date) VALUES (?,?,?,?);";
		jdbcTemplate.update(sqlWords, newProject.getId(), newProject.getName(), newProject.getFromDate(), newProject.getToDate());
		return newProject;
	}

	@Override
	public void deleteProject(Long projectId) {
		String sqlFk = "DELETE FROM project_employee " +
				"WHERE project_id = ?;";

		String sql = "DELETE FROM project " +
				"WHERE project_id = ?;";
		jdbcTemplate.update(sqlFk,projectId);
		jdbcTemplate.update(sql, projectId);
	}
	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getLong("project_id"));
		project.setName(rowSet.getString("name"));
		if (rowSet.getDate("from_date") != null){
			project.setFromDate(((Objects.requireNonNull(rowSet.getDate("from_date")))).toLocalDate());
		}
		if (rowSet.getDate("to_date") != null){
			project.setToDate(((Objects.requireNonNull(rowSet.getDate("to_date")))).toLocalDate());
		}
		return project;
	}
	

}

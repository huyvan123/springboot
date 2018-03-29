package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DAO.TeacherDAO;
import com.entity.Teacher;

@RestController
public class TeacherController {
	@Autowired
	private TeacherDAO dao;
	
	@RequestMapping(value = "/teachers",method = RequestMethod.GET)
	public List<Teacher> findAllTeacher(){
		return this.dao.findAll();
	}
	
	@RequestMapping(value = "/teacher/add", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public int addTeacher(@RequestBody Teacher teacher) {
		System.out.println("name: "+ teacher.getName());
		
		return this.dao.addTeacher(teacher);
	}
	
	@RequestMapping(value = "/teacher/update", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public int updateTeacher(@RequestBody Teacher teacher) {
		return this.dao.editTeacher(teacher);
	}
	
	@RequestMapping(value = "/teacher/delete", method = RequestMethod.DELETE)
	public int deleteTeacher(@RequestParam("id") int id) {
		System.out.println("id: "+id);
		Teacher teacher = this.dao.getTeacher(id);
		return this.dao.deleteTeacher(teacher);
	}
	
}

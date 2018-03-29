package com.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.entity.Teacher;

@Repository
@Transactional
public class TeacherDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Teacher> findAll(){
		return this.entityManager.createQuery("FROM Teacher", Teacher.class).getResultList();
	}
	
	public Teacher getTeacher(int id) {
		return this.entityManager.createQuery("FROM Teacher t WHERE t.id = :id", Teacher.class).setParameter("id", id).getSingleResult();
	}
	
	public int addTeacher(Teacher teacher) {
		this.entityManager.persist(teacher);
		return 1;
	}
	
	public int editTeacher(Teacher teacher) {
		this.entityManager.merge(teacher);
		return 1;
	}
	
	public int deleteTeacher(Teacher teacher) {
		this.entityManager.remove(teacher);
		return 1;
	}
}

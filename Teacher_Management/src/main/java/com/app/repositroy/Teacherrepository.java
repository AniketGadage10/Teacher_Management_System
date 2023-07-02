package com.app.repositroy;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Teacher;

@Repository
public interface Teacherrepository extends JpaRepository<Teacher, Long>{
		
		Optional<Teacher> findByTnameAndPhoneno(String tname,int phone);
}

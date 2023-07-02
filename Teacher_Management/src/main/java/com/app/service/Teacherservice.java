package com.app.service;

import java.util.List;

import com.app.dto.fulldetailsdto;
import com.app.dto.responsedto;
import com.app.entities.Teacher;


public interface Teacherservice {

	Teacher InsertTeacher(Teacher t);
	
	fulldetailsdto Findbyid(Long id);
	
	Teacher UpdateTeacher(Teacher t);

	responsedto deletTeacher(Long id);
	
	fulldetailsdto Findbynamendphone(String name,int phone);
	
	List<Teacher> getlist();
}

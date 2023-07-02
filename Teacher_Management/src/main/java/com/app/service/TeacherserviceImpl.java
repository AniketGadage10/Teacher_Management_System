package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.fulldetailsdto;
import com.app.dto.responsedto;
import com.app.entities.Teacher;
import com.app.exception.Teacherexception;
import com.app.repositroy.Teacherrepository;

@Service
@Transactional
public class TeacherserviceImpl implements Teacherservice {

	@Autowired
	private Teacherrepository tdao;

	@Autowired
	private ModelMapper mp;

	@Override
	public Teacher InsertTeacher(Teacher t) {

		return tdao.save(t);
	}

	@Override
	public fulldetailsdto Findbyid(Long id) {
		Teacher t = tdao.findById(id).orElseThrow(() -> new Teacherexception("Invalid id "));
		fulldetailsdto d = mp.map(t, fulldetailsdto.class);
		return d;
	}

	@Override
	public Teacher UpdateTeacher(Teacher t) {
		if (!tdao.existsById(t.getId())) {
			throw new Teacherexception("Teacher By Id Is Not Present");
		}
		return tdao.save(t);
	}

	@Override
	public responsedto deletTeacher(Long id) {

		if (!tdao.existsById(id)) {
			throw new Teacherexception("Teacher By Id Is Not Present");
		}

		tdao.deleteById(id);
		return new responsedto("Teacher By ID" + id + " Deleted Sucessfully");
	}

	@Override
	public fulldetailsdto Findbynamendphone(String name, int phone) {

		Teacher t = tdao.findByTnameAndPhoneno(name, phone)
				.orElseThrow(() -> new Teacherexception("Invalid Teacher Details"));
		fulldetailsdto dto=mp.map(t, fulldetailsdto.class);
		return dto;
	}

	@Override
	public List<Teacher> getlist() {
		
		return tdao.findAll();
	}

}

package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.responsedto;
import com.app.dto.respsignindto;
import com.app.entities.Teacher;
import com.app.service.TeacherserviceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/Teacher")
public class Teachercontroller {
	@Autowired
	private TeacherserviceImpl tser;

	@GetMapping("/teachers")
	public ResponseEntity<?> getlist()
	{
		return ResponseEntity.status(HttpStatus.OK).body(tser.getlist());
		
	}
	@PostMapping("/insertion")
	public ResponseEntity<?> insertteacher(@RequestBody Teacher t) {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(tser.InsertTeacher(t));
	}

	@GetMapping("/{tid}")
	public ResponseEntity<?> getteacher(@PathVariable Long tid) {
		
		return ResponseEntity.status(HttpStatus.OK).body(tser.Findbyid(tid));
	}
	
	@PostMapping("/updatation")
	public ResponseEntity<?> updatationteacher(@RequestBody Teacher t)
	{
		System.out.println(t.getId());
		return ResponseEntity.status(HttpStatus.OK).body(tser.UpdateTeacher(t));	
	}
	
	@DeleteMapping("/{tid}")
	public ResponseEntity<?> deletionByid(@PathVariable Long tid)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(tser.deletTeacher(tid));
	}
	
	@PostMapping("/signin")
	public ResponseEntity<?> validation(@RequestBody respsignindto sign)
	{
		return ResponseEntity.status(HttpStatus.OK)
				.body(tser.Findbynamendphone(sign.getTname(),sign.getPhoneno()));
	}
	
	
 }

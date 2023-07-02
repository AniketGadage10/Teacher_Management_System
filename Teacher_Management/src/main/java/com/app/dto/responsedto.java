package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@ToString
@Getter
@Setter
public class responsedto {
	private String msg;
	private LocalDate date;
	public responsedto(String msg) 
	{
		this.msg=msg;
		date=LocalDate.now();
	}	
}

package com.reservation.dto;


import java.util.Date;

import lombok.Data;


@Data
public class CalendarDto {
	private String title;
	private Date start;
	private Date end;
	private String url;
	private String color;
	private String textColor;
	private boolean allDay = false;	
	

}

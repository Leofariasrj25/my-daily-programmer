package br.com.lfsantos.mydailyprog.intermediate.chl1;

import java.util.Calendar;

public class Event implements Comparable<Event>{
	private static int unusedID = 1;
	
	private final int id;
	private Calendar date;
	private String description;
	
	public Event(Calendar creationDate, String details) {
		this.date = creationDate;
		this.description = details;
		this.id = unusedID;
		Event.unusedID++;
	}
	
	public Event(int id, Calendar creationDate, String details) {
		this.id = id;
		this.description = details;
		this.date = creationDate;
	}
	
	public int getID() {
		return id;
	}
	
	public Calendar getDate() {
		return (Calendar) date.clone();
	}
	
	public void setDate(Calendar timeAndDate) {
		if(timeAndDate != null) {
			this.date = (Calendar) timeAndDate.clone();
		}
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String updatedDescription) {
		this.description = updatedDescription;
	}

	@Override
	public int compareTo(Event event) {
		return event.getDate().compareTo(date);
	}
}

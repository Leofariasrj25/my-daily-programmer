//reddit thread: https://www.reddit.com/r/dailyprogrammer/comments/pihtx/intermediate_challenge_1/

/*
	create a program that will allow you to enter events organizable by hour. 
	There must be menu options of some form, and you must be able to easily edit, add, and delete 
	events without directly changing the source code.
*/

package br.com.lfsantos.mydailyprog.intermediate.chl1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	private EventRecorder recorder = null;
	private EventLoader loader = null;	
	private List<Event> events = null;	
	private String saveLocation = null;
		
	private int status= 0;
	private Scanner reader = new Scanner(System.in);
	
	Main(String file) {
		loader = new EventLoader(file);
		events = loader.load();
	}
	
	public static void main(String[] args) {
		Main eventsManager = new Main("src/br/com/lfsantos/dailyprog/intermediate/chl1/events.txt");
		
		while(eventsManager.getStatus() != -1) {
			eventsManager.menu();
			
			switch(eventsManager.getStatus()) {
				case 1: eventsManager.create(); eventsManager.menu(); break;
				case 2: eventsManager.list(); eventsManager.menu(); break;
				case 3: eventsManager.update(); eventsManager.menu(); break;
				case 4: eventsManager.remove(); eventsManager.menu(); break; 
				case 0: eventsManager.save(); System.exit(0);
			}
		}
	}	

	private int getStatus() {
		return this.status;
	}
	
	void menu(){
		System.out.println("Main Menu");
		System.out.println("1: Create an event");
		System.out.println("2: List of events");
		System.out.println("3: Edit event");
		System.out.println("4: Delete event");
		System.out.println("0: exit");
		
		System.out.print("Option: ");
				
		try {
			status = Integer.parseInt(reader.nextLine());
		}
		catch(NumberFormatException e) {
				invalidInput();
		}
		
		if (status > 4 || status < 0) {
			invalidInput();
		}
		
		System.out.println("");
	}
	
	private void invalidInput() {
		System.out.println("Enter a valid number between 0-5");
		menu();
	}

	void create() {
		System.out.println("Create event: ");
		
		System.out.print("Type the day (dd/MM/yyyy) :");	
		String eventDate = reader.nextLine();
		
		System.out.print("Type the hour of the event (hh:mm) : ");
		String eventTime = reader.nextLine();
	
		System.out.print("Description: ");
		String description = reader.nextLine();
	
		Calendar creationDate = this.convertData(eventDate, eventTime);
		Event event = new Event(creationDate, description);
		events.add(event);
		
		Collections.sort(events);
		
		System.out.print("");
	}
	
	private void list() {
		
		if(events.size() > 0) {
		
			String separator = "==========================================";
			System.out.println("List of Events: ");
			
			for(Event e : events) {
				System.out.println(separator);
				System.out.println("id: " + e.getID());
				System.out.println("Date and time: " + formatDate(e.getDate()));
				System.out.println("description: " + e.getDescription());
				System.out.println(separator);
			}
			
			System.out.println("");
		}
		else {
			System.out.println("nothing to display, please add an event \n");
		}
	}
	
	private void update() {
		System.out.print("Enter the id of the event you wish to edit: ");
		int eventID = Integer.parseInt(reader.nextLine());
		
		System.out.print("Enter the new description: ");
		String newDescription = reader.nextLine();
		
		System.out.println("searching...");
		
		for (Event event : events) {
			
			if(event.getID() == eventID) {
				event.setDescription(newDescription);
				System.out.println("Event updated!. \n");
				break;
			}	
		}
	}
	
	private void remove() {
		System.out.print("Type the id of the event you want to remove: ");
		int removeEvent = Integer.parseInt(reader.nextLine());
	
		for(Event e: events) {
			
			if (removeEvent == e.getID()) {
				events.remove(e);
			}
		}
	
		System.out.println("Event deleted! \n");
	}
	
	private void save() {
		if (recorder == null) {
			recorder = new EventRecorder(saveLocation);
		}
		
		recorder.save(events);
	}
	
	private Calendar convertData(String date, String time){
		String dateInText = date + " " + time;
		
		SimpleDateFormat converter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date convertedDateAndTime = null; 
		
		try {
			convertedDateAndTime = converter.parse(dateInText);
		}
		catch(ParseException exception) {
			exception.printStackTrace();
		}
		
		Calendar eventDateAndTime = Calendar.getInstance();
		eventDateAndTime.setTimeInMillis(convertedDateAndTime.getTime());
	
		return eventDateAndTime;
	}
	
	private String formatDate(Calendar c) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		String dateInText = formatter.format(c.getTime());
		
		return dateInText;
	}
}

package br.com.lfsantos.mydailyprog.intermediate.chl1;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventRecorder {
	
	String fileName;
	private BufferedWriter fileWriter;
	
	EventRecorder(String backup) {
		this.fileName = backup;  
	}
	
	public boolean save(List<Event> events) {
		
		try {
			fileWriter = new BufferedWriter(new FileWriter(new File(fileName)));
			
			for(Event event : events) {
				this.save(event);
			}
		
			fileWriter.flush();
			fileWriter.close();
			return true;
		}
		catch(IOException e) {
			
		}
	
		return false;
	}
	
	private boolean save(Event event) {
		String newLine = "\n";
		
		try {
			fileWriter.write("id: " + event.getID() + newLine);
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date d = event.getDate().getTime(); 
			String timeAndDate = formatter.format(d);
			fileWriter.write("Date: " + timeAndDate + newLine);
		
			fileWriter.write("Description: " + event.getDescription() + newLine + newLine);
		
			fileWriter.flush();
			
			return true;
		}
		catch(IOException e) {
			System.out.println("Error while trying to save event");
		}
	
		return false;
	}
}
 

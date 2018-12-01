package br.com.lfsantos.mydailyprog.intermediate.chl1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventLoader {
	private String fileName = null;

	EventLoader(String file) {
		fileName = file;
	}
	
	public List<Event> load() {
		List<Event> savedEvents = new LinkedList<Event>();
		String line = null;
			
		try(BufferedReader fileReader = new BufferedReader(new FileReader(new File(fileName)))) {
			
			String[] eventFields = new String[3];
			int fieldIndex = 0;
			
			while((line = fileReader.readLine()) != null) {
				
				if(line.isEmpty()) {
					createAndAddToList(eventFields, savedEvents);
					
					fieldIndex = 0;
					continue;
				}
				
				String[] value = line.split(": ");
				eventFields[fieldIndex] = value[1]; 
				fieldIndex++;
			}
		
			createAndAddToList(eventFields, savedEvents); //adds the last item
		}
		catch(FileNotFoundException notFound) {
			System.out.println("ERROR: " + notFound);
		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		return savedEvents;
	}

	private void createAndAddToList(String[] fields, List<Event> events) {
		int id = Integer.parseInt(fields[0]);
		String description = fields[2];
		Calendar eventDate = null;
		
		try {
			SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			Date d = parser.parse(fields[1]);
			eventDate = Calendar.getInstance();
			eventDate.setTimeInMillis(d.getTime());
		}
		catch(ParseException e){
			System.out.println("ERROR: ");
			System.out.println(e);
		}
		
		Event e = new Event(id, eventDate, description);
		events.add(e);
	}
}


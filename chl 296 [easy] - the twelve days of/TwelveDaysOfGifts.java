//reddit thread: https://www.reddit.com/r/dailyprogrammer/comments/5j6ggm/20161219_challenge_296_easy_the_twelve_days_of/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwelveDaysOfGifts {
	
	public static void main(String[] args) {
		String[] days = {"first", "second", "third", "forth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth"};
		// #Bonus1 use one, two, three, etc instead of 1, 2, 3...
		String[] cardinals = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve"};
		
		// #Bonus 2: Receive the gifts from input
		String[] gifts = new String[12];
		
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(TwelveDaysOfGifts.class.getResourceAsStream("list of gifts.txt")))) {
			
			String line = "";
			int giftNumber = 0;
			
			while ((line = reader.readLine()) != null) {
				gifts[giftNumber++] = line;	
			}
		}
		catch(IOException e) {
			
		}
		
		for (int day = 1; day <= 12; day++) {
			System.out.println("On the " + days[day - 1] + " day of Christmas");
			System.out.println("my true love sent me: ");
			
			for (int numberOfGifts = day; numberOfGifts != 0; numberOfGifts--) {
				
				if (day > 1 && numberOfGifts == 1) {
					System.out.print("and ");
				}
				
				System.out.println(cardinals[numberOfGifts - 1] + " " + gifts[numberOfGifts - 1]);
			}
			
			System.out.print('\n');
		}
	}
}

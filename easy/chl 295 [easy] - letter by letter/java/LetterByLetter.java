// reddit thread: https://www.reddit.com/r/dailyprogrammer/comments/5hy8sm/20161212_challenge_295_easy_letter_by_letter/

import java.util.Scanner;

public class LetterByLetter {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
	
		System.out.println("We'll change a word into another, letter by letter.");
		System.out.print("Type a word: ");
		String word1 = reader.nextLine();
		System.out.print("Enter the word you desire to change to: ");
		String word2 = reader.nextLine();
		
		char[] changingWord = word1.toCharArray();
		
		System.out.println(word1);
		
		for (int i = 0; i < word2.length(); i++) {
			
			if(changingWord[i] != word2.charAt(i)) {
				changingWord[i] = word2.charAt(i);
			
				//for(char c : changingWord) {
					//System.out.print(c);
				//}
				System.out.println(changingWord);
			}
			else {
				continue;
			}
		}
	}
}

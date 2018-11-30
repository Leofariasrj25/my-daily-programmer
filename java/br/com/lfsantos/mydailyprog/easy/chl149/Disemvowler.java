//reddit thread: https://www.reddit.com/r/dailyprogrammer/comments/1ystvb/022414_challenge_149_easy_disemvoweler/

package br.com.lfsantos.dailyprog.easy.chl149;
import java.util.Scanner;

public class Disemvowler {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		System.out.print("Type your victim: ");
		String text = reader.nextLine();

		reader.close();

		char[] chars = text.toLowerCase().toCharArray();
		char[] consonants = new char[chars.length];
		char[] vowels = new char[chars.length];

        // cIndex and vIndex are being used to populate the arrays using the least amount of space possible    
		for(int i = 0, cIndex = 0, vIndex = 0 ; i < chars.length; i++) {

			char c = chars[i];

			if(Character.isWhitespace(c)) {
				continue;
			}
			else if(c == 'a'|| c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				vowels[vIndex] = c;
                vIndex++;
			}
			else {
				consonants[cIndex] = c;
                cIndex++;
			}
		}

		String cStr = new String(consonants).trim();
		String vStr = new String(vowels).trim();

		System.out.println(cStr);
		System.out.println(vStr);


	}
}

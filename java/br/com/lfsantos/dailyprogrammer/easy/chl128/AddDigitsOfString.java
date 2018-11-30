// reddit thread: https://www.reddit.com/r/dailyprogrammer/comments/1fnutb/06413_challenge_128_easy_sumthedigits_part_ii/

/*
    Given a well-formed (non-empty, fully valid) string of digits, 
   let the integer N be the sum of digits. Then, given this integer N, 
   turn it into  a string of digits. Repeat this process until you only have one digit left.
*/


package br.com.lfsantos.dailyprogrammer.easy.chl128;

public class AddDigitsOfString {
    
    public static void main(String[] args) {
        
       String sumString = args[0];
           
       while(sumString.length() > 1) {    
           char[] digits = sumString.toCharArray();

           int sum = 0;

           for(int i = 0, j = digits.length - 1; i <= j; i++, j--) {
               
               if(i == j) {
                sum += Character.getNumericValue(digits[i]);
               }
               else {
                sum += Character.getNumericValue(digits[i]);
                sum += Character.getNumericValue(digits[j]);
               }          

            }

            System.out.println("The sum of the digits from " + sumString + " is: " + sum);
            sumString = Integer.toString(sum); 
        } 
    }
}

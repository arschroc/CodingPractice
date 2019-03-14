/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem16;

/**
 *
 * @author Aaron Schrock
 */
public class Problem16 {

    /*
    This problem was asked by Amazon.

    Run-length encoding is a fast and simple method of encoding strings. The basic idea is to 
    represent repeated successive characters as a single count and character. 
    For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".

    Implement run-length encoding and decoding. 
    You can assume the string to be encoded have no digits and consists solely of alphabetic characters. 
    You can assume the string to be decoded is valid.
     */
    public static String runLengthEncoding(String input) {
        if(input == null || input.length() == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char letter = input.charAt(0);
        
        if(input.length() == 1) {
            sb.append(Integer.toString(count));
            sb.append(letter);
        }
        
        for(int i = 1; i < input.length(); i++) {
            //Repeating character found
            while(i < input.length() && input.charAt(i) == letter) {
                count++;
                i++;
            }
            
            //Add to string builder
            sb.append(Integer.toString(count));
            sb.append(letter);
            count = 1;
            if(i < input.length()) {
                letter = input.charAt(i);
            }
        }
        
        String output = sb.toString();
        return output;
    }
    public static String runLengthDecoding(String input) {
        if(input == null || input.length() < 2) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        char letter;
        int count;
        for(int i = 0; i < input.length(); i = i + 2) {
            //Get the count of each letter
            count = Integer.parseInt("" + input.charAt(i));
            letter = input.charAt(i+1);
            
            //Append the correct amount of each char
            for(int j = 0; j < count; j++) {
                sb.append(letter);
            }
        }
        String output = sb.toString();
        return output;
    }
    public static void main(String[] args) {
        String input = "AAAABBBCCDAA";
        System.out.println(runLengthEncoding(input));
        input = "4A3B2C1D2A";
        System.out.println(runLengthDecoding(input));
    }
    
}

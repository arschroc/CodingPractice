/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

/**
 *
 * @author Aaron Schrock
 */
public class Problem4 {

    /*
    This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
    
    Examples:
    12 = 2
    1 2
    12
    
    126 = 3
    1 2 6
    12 6
    1 26
    
    
    1226 = 5
    1 2 2 6
    12 2 6
    1 22 6
    1 2 26
    12 26
    
    12226 = 8
    1 2 2 2 6
    12 2 2 6
    1 22 2 6
    1 2 22 6
    1 2 2 26
    12 22 6
    12 2 26
    1 22 26
   
   recursive formula: decode[n] = decode[n-1] + decode[n-2]
    base case:
    decode[0] = 1
    decode[1] = 1 or 2 depending on the following:
    
    decode[i] where i > 0 is valid if message[i] == 1 || (message[i] == 2 && message[i-1] <7)
    
    */
    public static void main(String[] args) {
        System.out.println(decode("12226"));
    }
    
    public static int decode(String message) {
        if(message == null || message.length() == 0) {
            return 0;
        }
        if(message.length() == 1) {
            return 1;
        }
        //DYNAMIC!!!! fun
        int[] decodings = new int[message.length()];
        decodings[0] = 1;
        if(validation((int)message.charAt(message.length()-2), (int)message.charAt(message.length()-1))) {
            decodings[1] = 2;
        } else {
            decodings[1] = 1;
        }
        
        //Loop through the rest
        for(int i = 2; i < message.length(); i++) {
            if(validation((int)message.charAt(message.length()-i-1), (int)message.charAt(message.length()-i))) {
                decodings[i] = decodings[i-1] + decodings[i-2];
            } else {
                decodings[i] = decodings[i-1];
            }
        }
        
        return decodings[decodings.length - 1];
    }
    
    public static boolean validation(int first, int second) {
        //convert ascii to decimal
        first -= 48;
        second -= 48;
        return first == 1 || (first==2 && second < 7);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem7;

/**
 *
 * @author Aaron Schrock
 */
public class Problem7 {

    /*
    This problem was asked by Amazon.

    Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

    For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
    
    
    Brute force: start at each index and keep track of its longest substring = O(n^2) we can do better
     
    What to keep track of:
    Where we last saw a character 
    The current number of distinct characters in the substring
    The max substring and the current substring length
    The start of the substring
    
    After every character check the max substring vs current substring
    
    When distinct character threshold is reached:
        Move the start pointer of the substring until we are no longer at the threshold
    
    This method is O(n)
    */
    public static void main(String[] args) {
        // TODO code application logic here
        String s = "abcba";
        int k = 2;
        System.out.println(LongestSubstring(s, k)); //3
        s = "aabbcc";
        k = 2;
        System.out.println(LongestSubstring(s, k)); //4
        s = "aabbcc";
        k = 3;
        System.out.println(LongestSubstring(s, k)); 
    }
    
    public static int LongestSubstring(String s, int k) {
        //Base and edge cases
        if(s == null || s.length() == 0 || k <= 0) {
            return 0;
        }
        if(s.length() == 1 || k == 1) {
            return 1;
        }
        int[] charIndex = new int[128];
        for(int i = 0; i < 128; i++) {
            charIndex[i] = -1;
        }
        
        int res = 0;
        int start = 0;
        int nextStart = start;
        int distinct = 0;
       
        //Loop through the string looking for substrings
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            //If it is distinct
            if(charIndex[c] < start) {
                distinct++;
                
                //If we have reached the threshold of distinct chars
                //Move the starting pointer to the right until we are at k-1 distinct chars
                if(distinct > k) {
                    //While we still have more than the threshold keep moving start pointer
                    while(distinct > k) {
                        if(charIndex[s.charAt(nextStart)] == nextStart) {
                            distinct--;
                        }
                        nextStart++;
                    }
                    //Set the new start
                    start = nextStart;
                }
            }
            
            //Save the index of the current char
            charIndex[c] = i;
            //Check if current substring is max
            res = Math.max(res, i - start + 1);
        }
        
        return res;
    }
    
}

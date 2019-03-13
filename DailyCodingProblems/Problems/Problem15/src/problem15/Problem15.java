/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Aaron Schrock
 */
public class Problem15 {

    /*
    This problem was asked by Palantir.

    Write an algorithm to justify text. Given a sequence of words and an integer line length k, 
    return a list of strings which represents each line, fully justified.

    More specifically, you should have as many words as possible in each line. 
    There should be at least one space between each word. Pad extra spaces when necessary so that each line has exactly length k. 
    Spaces should be distributed as equally as possible, with the extra spaces, if any, distributed starting from the left.

    If you can only fit one word on a line, then you should pad the right-hand side with spaces.

    Each word is guaranteed not to be longer than k.

    For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

    ["the  quick brown", # 1 extra space on the left
    "fox  jumps  over", # 2 extra spaces distributed evenly
    "the   lazy   dog"] # 4 extra spaces distributed evenly
     */
    
    public static List<String> justifyText(String[] words, int k) {
        List<String> list = new ArrayList<String>() {};
        StringBuilder str = new StringBuilder();
        
        //No elemnts in words
        if(words.length == 0) {
            return list;
        }
        //One element in words
        if(words.length == 1) {
            for(int i = 0; i < k - words[0].length(); i++) {
                str.append(" ");
            }
            list.add(str.toString());
        }
        
        int numWords = 1;
        int letterCount = words[0].length();
        int spaces = 0;
        int i = 1;
        
        for(; i < words.length; i++) {
            if(letterCount + words[i].length() + 1 > k) {
                spaces = k - letterCount;
                
                //Add first word
                str.append(words[i - numWords]);
                //Add spaces
                for(int l = 0; l < spaces / (numWords-1); l++) {
                    str.append(" ");
                }
                //if left over spaces begin adding them at left most
                if(spaces % (numWords-1) != 0) {
                    str.append(" ");
                    spaces--;
                }
                
                //Add the words and their spaces
                for(int j = i - numWords + 1; j < i; j++) {
                    //Add word
                    str.append(" ");
                    str.append(words[j]);
                    //Add spaces
                    for(int l = 0; l < spaces / (numWords-1); l++) {
                        str.append(" ");
                    }
                    //If remaining spaces add them at left most
                    if(spaces % (numWords-1) != 0) {
                        str.append(" ");
                        spaces--;
                    }
                }
                
                list.add(str.toString());
                str = new StringBuilder();
                
                numWords = 1;
                letterCount = words[0].length();
            }
            else {
                numWords++;
                letterCount += words[i].length() + 1;
            }
        }
        
        //Add remaining words
        spaces = k - letterCount;
                
        //Add first word
        str.append(words[i - numWords]);
        //Add spaces
        for(int l = 0; l < spaces / (numWords-1); l++) {
            str.append(" ");
        }
        //if left over spaces begin adding them at left most
        if(spaces % (numWords-1) != 0) {
            str.append(" ");
            spaces--;
        }

        //Add the words and their spaces
        for(int j = i - numWords + 1; j < i; j++) {
            //Add word
            str.append(" ");
            str.append(words[j]);
            //Add spaces
            for(int l = 0; l < spaces / (numWords-1); l++) {
                str.append(" ");
            }
            //If remaining spaces add them at left most
            if(spaces % (numWords-1) != 0) {
                str.append(" ");
                spaces--;
            }
        }

        list.add(str.toString());
        
        return list;
    }
    public static void main(String[] args) {
        String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
        int k = 16;
        
        System.out.println(Arrays.toString(justifyText(words, k).toArray()));
    }
    
}

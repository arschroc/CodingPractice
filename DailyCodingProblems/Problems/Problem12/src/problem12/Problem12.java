/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem12;

import java.util.*;

/**
 *
 * @author Aaron Schrock
 */
public class Problem12 {

    /*
    This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. 
    If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond",
    return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
     */
    
    static ArrayList<String> getSentence(HashSet<String> dictionary, String noSpaces) {
        ArrayList<String> res = new ArrayList<>();
        for(int i = 0; i < noSpaces.length(); i++) {
            for(int j = i+1; j <= noSpaces.length(); j++) {
                if(dictionary.contains(noSpaces.substring(i, j))) {
                    res.add(noSpaces.substring(i, j));
                    i = j-1;
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        HashSet<String> dictionary = new HashSet<>();
        dictionary.add("quick");
        dictionary.add("brown");
        dictionary.add("the");
        dictionary.add("fox");
        String noSpaces = "thequickbrownfox";
        ArrayList<String> res = getSentence(dictionary, noSpaces);
        System.out.println(Arrays.toString(res.toArray()));
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem1;

import java.util.HashSet;

public class Problem1 {

    /*
    Good morning! Here's your coding interview problem for today.

    This problem was recently asked by Google.

    Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

    For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
    */
    public static boolean AddToK(int[] addArray, int k) {
        HashSet<Integer> addCheck = new HashSet<Integer>();
        if(addArray.length > 0) {
            for(int i = 0; i < addArray.length; i++) {
                if(addCheck.contains(k - addArray[i])) {
                    return true;
                }
                addCheck.add(addArray[i]);
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
       int[] addArray = new int[]{10,15,3,7};
       int k = 17;
       
       System.out.println(AddToK(addArray, k));
    }
    
}

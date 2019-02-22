/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem5;

import java.util.Arrays;

/**
 *
 * @author Aaron Schrock
 */
public class Problem5 {

    /*
    This problem was asked by Airbnb.

    Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.

    For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.

    Follow-up: Can you do this in O(N) time and constant space?
    */
    
    /*
    Approach:
    Brute force: double for loop adding up all non adjacent starting at each index = O(n^)
    
    Optimize: Save the greatest value up to an index, compare adding onto that index vs not
    - Update in place
    */
    public static void main(String[] args) {
        int[] input = {2, 4, 6, 2, 5};
        System.out.println(SumNoAdjacent(input)); //13
        input = new int[]{5, 1, 1, 5};
        System.out.println(SumNoAdjacent(input)); //10
        input = new int[]{-2, 5, 6, 0}; 
        System.out.println(SumNoAdjacent(input)); //6
        input = new int[]{5, 2, -1, 3};
        System.out.println(SumNoAdjacent(input)); //8
        input = new int[]{-4, -3, 1, 3, 3};
        System.out.println(SumNoAdjacent(input)); //4
    }
    
    public static int SumNoAdjacent(int[] input) {
        if(input == null || input.length == 0) {
            return 0;
        }
        if(input.length == 1) {
            return input[0];
        }
        input[1] = Math.max(input[0], input[1]);
        
        //loop through modifying in place
        for(int i = 2; i < input.length; i++) {
            input[i] = maxThree(input[i], input[i-1], (input[i-2]+input[i]));
        }
        
        
        return Math.max(input[input.length-1], input.length-2);
    }
    
    private static int maxThree(int a, int b, int c) {
        int max = Math.max(a, b);
        return Math.max(max, c);
    }
    
}

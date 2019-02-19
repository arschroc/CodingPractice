/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Aaron Schrock
 */
public class Problem3 {

    /*
    Given an array of integers, find the first missing positive integer in linear time and constant space. 
    In other words, find the lowest positive integer that does not exist in the array. The array can contain 
    duplicates and negative numbers as well.
    
    For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
    
    You can modify the input array in-place.
    */
    
    //Cant use HashSet -> constant space
    //Must modify array in-place
    //All positive No duplicates -> put value in its index
    //All positive with duplicates -? put value in its index and ignore the duplicate
    //e.g {1,1,2,0} -> {0,1,2,1} missing 3
    //With negative -> do first pass moving all negative to the front
    //e.g. {3, 4, -1, 1} -> {-1, 4, 1, 3}
    
    //O(3n) -> O(n) time
    //O(1) space
    public static int FirstMissingPosInteger(int[] input) {
        if(input == null || input.length == 0) {
            return 1;
        }
        int firstMissing = 0;
        
        //First pass find negatives and move them
        int freeIndex = 0;
        int temp;
        for(int i = 0; i < input.length; i++) {
            if(input[i] < 0) {
                temp = input[freeIndex];
                input[freeIndex] = input[i];
                input[i] = temp;
                freeIndex++;
            }
        }

        //Second pass move positive integers to their index
        for(int i = freeIndex; i < input.length; i++) {
            temp = input[i];
            if(temp < input.length - freeIndex) {
                input[i] = input[temp + freeIndex];
                input[temp + freeIndex] = temp;
            }
        }
        
        //Third pass find first missing positive integer
        for(int i = freeIndex + 1; i < input.length; i++) {
            if(input[i] != i - freeIndex) {
                firstMissing = i - freeIndex;
                break;
            }
        }
        
        //Check for edge cases
        if(firstMissing == 0) {
            firstMissing = input.length - freeIndex;
            if(firstMissing == 0) {
                firstMissing = 1;
            }
        }

        return firstMissing;
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 0}; //3
        int[] input2 = {3, 4, -1, 1}; //2
        int[] input3 = {1, 1, 2, 0}; //3
        int[] input4 = {}; //1
        int[] input5 = null; //1
        int[] input6 = {-3, 1, 4, 2, -1, -2}; //3
        int[] input7 = {-1}; //1
        
        System.out.println(FirstMissingPosInteger(input));
        System.out.println(FirstMissingPosInteger(input2));
        System.out.println(FirstMissingPosInteger(input3));
        System.out.println(FirstMissingPosInteger(input4));
        System.out.println(FirstMissingPosInteger(input5));
        System.out.println(FirstMissingPosInteger(input6));
        System.out.println(FirstMissingPosInteger(input7));
    }
    
}

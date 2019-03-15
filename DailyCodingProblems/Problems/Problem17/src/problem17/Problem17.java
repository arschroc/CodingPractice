/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem17;

/**
 *
 * @author Aaron Schrock
 */
public class Problem17 {

    /*
    This problem was asked by Facebook.

    You are given an array of non-negative integers that represents a two-dimensional elevation map where each element 
    is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.

    Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

    For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

    Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index
    (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
    */
    
    /*
    O(n^2) time O(1) space
    We can brute force by finding the max left and max right of each index
    Find the minimum of the max left and max right of each index and
    Add that minus the height of the current index
    
    O(n) time O(n) space
    Get better time complexity with dynamic programming
    Keep left max and right max arrays at each index
    At each index Add the minimum of the two arrays mius the height of current index
    
    O(n) time O(1) space
    Use two pointers on right and left with the right max and left max thus far
    
    If the current value is a new max update the max and dont add anything to answer
    
    If the current value is not a new max then the water at that value is bound by the max
    of its respective side. Add the max minus the current height
    
    
    While (left < right):
        if(heght[left] <= height{right}:
            if(height[left] > left_max):
                left_max = height[left]
            else add left_max minus height[left] to answer 
            Add one to left
        else: 
            if(height[right] > right_max):
                right_max = height[right]
            else add right_max minus height[right] to answer 
            Subtract one to left
    
                
    */
    public static int waterTrapped(int[] height) {
       int res = 0; 
       int left_max = height[0];
       int right_max = height[height.length-1];
       int left = 0;
       int right = height.length - 1;
       
       while(left < right) {
           if(height[left] <= height[right]) {
               if(height[left] > left_max) {
                   left_max = height[left];
               }
               else {
                   res += left_max - height[left];
               }
               left++;
           }
           else {
               if(height[right] > right_max) {
                   right_max = height[right];
               }
               else {
                   res += right_max - height[right];
               }
               right--;
           }
       }
        
        return res;
    }
    public static void main(String[] args) {
        int[] height = {2, 1, 2};
        System.out.println(waterTrapped(height)); //1
        height = new int[]{3, 0, 1, 3, 0, 5};
        System.out.println(waterTrapped(height)); //8
        height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(waterTrapped(height)); //6
    }
    
}

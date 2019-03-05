/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem11;

import java.util.*;

/**
 *
 * @author Aaron Schrock
 */
public class Problem11 {

    /*
    This problem was asked by Google.

    Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.

    For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:

    10 = max(10, 5, 2)
    7 = max(5, 2, 7)
    8 = max(2, 7, 8)
    8 = max(7, 8, 7)
    Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. 
    You can simply print them out as you compute them.
    */
    
    /*
    Can be done in O(n^2) time find each sub array O(n^2), find each subarray of length k O(n^2), find the max of each k subarray O(k)
    (There are n* (n+1)/2 subarrays and 2^n - 1 subsequences -> we want subarrays though
    Subarray must be continuous
    
    Can do it in O(nk) we find max of last k -> for every step in n we search the last k for max
    
    Can be done with counting sort but we would need the input to be bounded e.g. 1 < i < 100
    
    Can be done with a doubly linked list dequeue
    1. Remove elements not in window -> to do this we need to add the index into the deque
    2. Remove elements smaller than currently added value
    3. Add the value to the back
    4. Print the value at the front
    
    O(n) because you do a max of 2 operations per element = 2n = n
    queue is always a size of k or smaller
    */
    public static void maxOfSubArrays(int[] arr, int k) {
        int i = 0;
        Deque<Integer> dq = new LinkedList<>();
        //Add first k elements
        for(;i< k; i++) {
            //remove values smaller
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            
            //add value
            dq.addLast(i);
        }
        //Print the largest value
        System.out.print(arr[dq.peekFirst()] + " ");
        
        //Iterate through the rest of the values
        for(; i < arr.length; i++) {
            //Remove elements not in window
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.removeFirst();
            }
            
            //remove values smaller
            while(!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) {
                dq.removeLast();
            }
            
            //Add value
            dq.addLast(i);
            
            //Print output
            System.out.print(arr[dq.peekFirst()] + " ");
        }
        System.out.print("\n");
    }
    public static void main(String[] args) {
        int k = 3;
        int[] arr = {10, 5, 2, 7, 8, 7};
        maxOfSubArrays(arr, k); //10 7 8 8 
        arr = new int[]{2, 1, 3, 2, 4, 3, 5};
        maxOfSubArrays(arr, k); //3 3 4 4 5 
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

/**
This problem was asked by Uber.

Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division?
 */
public class Problem2 {

    //With division O(n)
    public static int[] MultArray(int[] arr) {
        if(arr == null) {
            return arr;
        }
        
        int[] newArr = new int[arr.length];
        int total = 1;
        
        //create total
        for(int i = 0; i < arr.length; i++) {
            total *= arr[i];
        }
        
        //create new array
        for(int i = 0; i < arr.length; i++) {
            newArr[i] = total/arr[i];
        }
        
        return newArr;
    } 
    //Without division O(n)
    public static int[] MultArrayNoDivision(int[] arr) {
        if(arr == null) {
            return arr;
        }
        if(arr.length == 1) {
            return arr;
        }
        
        int[] newArr = new int[arr.length];
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];
        
        //Create left array
        leftArr[0] = 1;
        leftArr[1] = arr[0];
        
        for(int i = 2; i < arr.length; i++) {
            leftArr[i] = leftArr[i-1] * arr[i-1];
        }
        
        //Create right array
        rightArr[arr.length-1] = 1;
        rightArr[arr.length - 2] = arr[arr.length-1];
        for(int i = arr.length - 2; i >= 0; i--) {
            rightArr[i] = rightArr[i+1] * arr[i+1];
        }
        
        //Create new array
        for(int i = 0; i < arr.length; i++) {
            newArr[i] = leftArr[i] * rightArr[i];
        }
        
        
        return newArr;
    } 

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] newArr = MultArray(arr);
        System.out.println("DIVISION SOLUTION");
        if(newArr != null) {
            for(int i = 0; i < newArr.length; i++) {
                System.out.println(newArr[i]);
            }
        }
        else {
            System.out.println("null");
        }
        
        System.out.println("NO DIVISION SOLUTION");
        int[] newArr2 = MultArrayNoDivision(arr);
        if(newArr2 != null) {
            for(int i = 0; i < newArr2.length; i++) {
                System.out.println(newArr2[i]);
            }
        }
        else {
            System.out.println("null");
        }
        
    }
    
}

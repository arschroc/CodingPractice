/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem6;

/**
 *
 * @author Aaron Schrock
 */
public class Problem6 {

    /**
     
     This problem was asked by Amazon.

    There exists a staircase with N steps, and you can climb up either 1 or 2 steps at a time. 
    Given N, write a function that returns the number of unique ways you can climb the staircase. The order of the steps matters.

    For example, if N is 4, then there are 5 unique ways:

    1, 1, 1, 1
    2, 1, 1
    1, 2, 1
    1, 1, 2
    2, 2
    What if, instead of being able to climb 1 or 2 steps at a time, you could climb any number from 
    a set of positive integers X? For example, if X = {1, 3, 5}, you could climb 1, 3, or 5 steps at a time.
    * 
    * 
    * Examples:
    * 1 -> 1
    * 2 -> 2 (1, 1) and (2)
    * 3 -> 3 (1, 2) (1, 1, 1) and (2, 1)
    * 4 -> 5 (1, 1, 2) (2, 2) ( 1, 2, 1) (1, 1, 1, 1) (2, 1, 1)
    * 
    * Algorithm: 
    * Look back two steps and one step. You have to go (N-1) or (N-2) to be able to get to N
    * Add up how many ways you can get to (N-1) and (N-2) -> recursive or dynamic
    */
    public static void main(String[] args) {
        //Staircase with 1 or 2 steps at a time
        System.out.println(NumWays(4)); //5
        
        //staricase with any number from a set of positive integers X
        int[] X = {1, 2};
        System.out.println(NumWaysX(X, 4)); //5
        X = new int[]{1, 3, 5};
        System.out.println(NumWaysX(X, 5)); //5 -> (5) (1, 1, 1, 1, 1) (1, 1, 3) (1, 3, 1) (3, 1, 1)
        X = new int[]{1, 3, 5};
        System.out.println(NumWaysX(X, 6)); //9
    }
    
    //Runtime: O(2^N)
    //Make it dynamic -> O(N)
    public static int NumWays(int N) {
        if(N <= 0) {
            return 0;
        }
        int[] resArray = new int[N];
        resArray[0] = 1;
        resArray[1] = 2;
        
        for(int i = 2; i < N; i++) {
            resArray[i] = resArray[i-1] + resArray[i-2];
        }
        
        return resArray[N-1];
    }
    
    public static int NumWaysX(int[] X, int N) {
        if(N <= 0 || X == null || X.length == 0) {
            return 0;
        }
        
        //Create a result array and initialize it to 0
        int[] resArray = new int[N+1];
        for(int i = 0; i < N; i++) {
            resArray[i] = 0;
        }
        
        //Loop through the array using recursive formula
        for(int i = 1; i< N+1; i++) {
            resArray[i] = NumWaysXHelper(X, resArray, i);
        }
        
        return resArray[N];
    }

    private static int NumWaysXHelper(int[] X, int[] resArray, int index) {
        int res = 0, stepBack = 0;
        
        for(int k = 0; k < X.length; k++) {
            stepBack = index - X[k];
            if(stepBack > 0) {
                res += resArray[stepBack];
            }
            if(stepBack == 0) {
                res += 1;
            }
        }
        return res;
    }
    
}

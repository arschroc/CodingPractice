/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem9;

import java.util.Arrays;

/**
 *
 * Aaron Schrock
 */
public class Problem9 {

    /*
     This problem was asked by Facebook.

    A builder is looking to build a row of N houses that can be of K different colors. 
    He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

    Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, 
    return the minimum cost which achieves this goal.
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int k = 3;
        int[][] costs = {
            {0, 1, 2},
            {3, 4, 5},
            {5, 6, 7}
        };
        System.out.println(minCost(costs, k)); //9
        k = 4;
        int[][]costs2 = {
            {0, 1, 2, 3},
            {4, 5, 6, 7},
            {1, 3, 2, 8}
        };
        System.out.println(minCost(costs2, k)); //6
    }
        
    
    public static int minCost(int[][] costs, int k) {
        if(costs == null || costs.length == 0) {
            return 0;
        }
        
        //we are going to keep track of the previous min
        //Also keep track of the second previous min in case we cant use the prvious min
        //also keep track of the index of previous min
        int prevMin = Integer.MAX_VALUE;
        int prevSecondMin = Integer.MAX_VALUE;
        int prevIndex = -1;
        for(int i = 0; i < k; i++) {
            if(costs[0][i] <= prevMin) {
                prevSecondMin = prevMin;
                prevMin = costs[0][i];
                prevIndex = i;
            }
            else if(costs[0][i] < prevSecondMin) {
                prevSecondMin = costs[0][i];
            }
        }
        
        
        for(int i = 1; i < costs.length; i++) {
            //Reset next previous values
            int nextPrevMin = Integer.MAX_VALUE;
            int nextPrevSecondMin = Integer.MAX_VALUE;
            int nextPrevIndex = -1;
            for(int j = 0; j < k; j++) {
                //Calculate the cost thus forth
                if(j == prevIndex) {
                    costs[i][j] += prevSecondMin;
                }
                else {
                    costs[i][j] += prevMin;
                }
                
                //Calculate min values at this row
                if(costs[i][j] <= nextPrevMin) {
                    nextPrevSecondMin = nextPrevMin;
                    nextPrevMin = costs[i][j];
                    nextPrevIndex = j;
                }
                else if(costs[i][j] < nextPrevSecondMin) {
                    nextPrevSecondMin = costs[i][j];
                }
            }
            //Update previous values
            prevMin = nextPrevMin;
            prevSecondMin = nextPrevSecondMin;
            prevIndex = nextPrevIndex;
        }
        
        return prevMin;
    }
    
}

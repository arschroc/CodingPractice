/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem8;

import java.util.Arrays;

/**
 *
 * @author Aaron Schrock
 */

public class Problem8 {

    /*
    This problem was asked by Twitter.

You run an e-commerce website and want to record the last N order ids in a log. Implement a data structure to accomplish this, with the following API:

record(order_id): adds the order_id to the log
get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
    */
    
    
    
    public static void main(String[] args) {
        OrderRecord or = new OrderRecord(5);
        for(int i = 0; i < 5; i++) {
            or.record(i);
        }
        System.out.println(or.get_last(2)); //3
        or.record(5);
        System.out.println(or.get_last(2)); //4
        or.record(6);
        System.out.println(or.get_last(2)); //5
        or.record(7);
        System.out.println(or.get_last(2)); //6
        System.out.println(or.get_last(5)); //3
    }
    
}

class OrderRecord {
    private int maxSize;
    private int[] circularBuffer;
    private int currIndex;
        
    public OrderRecord() {
        this.maxSize = 10;
        this.currIndex = 0;
        circularBuffer = new int[this.maxSize];
    }

    public OrderRecord(int n) {
        this.maxSize = n;
        this.currIndex = 0;
        circularBuffer = new int[n];
    }

    //inserts order id
    public void record(int order_id) {
        circularBuffer[currIndex] = order_id;
        //set next index
        currIndex = (currIndex+1)%maxSize;
    }
    //Gets last ith element
    public int get_last(int i) {
        return circularBuffer[(currIndex-i+maxSize)%maxSize];
    }
}

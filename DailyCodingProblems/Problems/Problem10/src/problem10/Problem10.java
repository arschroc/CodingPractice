/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem10;

import problem10.Problem10.LinkedList.Node;

/**
 *
 * @author Aaron Schrock
 */
class Problem10 {

    /*
    This problem was asked by Google.

Given two singly linked lists that intersect at some point, find the intersecting node. The lists are non-cyclical.

For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10, return the node with value 8.

In this example, assume nodes with the same value are the exact same node objects.

Do this in O(M + N) time (where M and N are the lengths of the lists) and constant space.
     */
    
    static class LinkedList {
        Node head;
        
        static class Node { 
            int data; 
            Node next; 
            boolean seen;

            Node(int d) { 
                data = d; 
                next = null; 
                seen = false;
            } 
        }
    }
    
    public static Node intersection(LinkedList l1, LinkedList l2) {
        //Iterate through first list
        Node itr1 = l1.head;
        while(itr1 != null) {
            itr1.seen = true;
            itr1 = itr1.next;
        }
        //Iterate through second list
        Node itr2 = l2.head;
        while(itr2 != null) {
            if(itr2.seen) {
                return itr2;
            }
            itr2 = itr2.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList list = new LinkedList();
        list.head = new Node(3);
        list.head.next = new Node(7);
        list.head.next.next = new Node(8);
        list.head.next.next.next = new Node(10);
        LinkedList list2 = new LinkedList();
        list2.head = new Node(99);
        list2.head.next = new Node(1);
        list2.head.next.next = list.head.next.next;
        list2.head.next.next.next = list.head.next.next.next;
        Node output = intersection(list, list2);
        if(output == null) {
            System.out.println("null");
            return;
        }
        System.out.println(output.data); //8
    }
    
}

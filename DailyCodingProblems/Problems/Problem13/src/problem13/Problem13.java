/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem13;

import problem13.Problem13.LinkedList.Node;

/**
 *
 * @author Aaron Schrock
 */
public class Problem13 {

    /*
    This problem was asked by Google.

Given a singly linked list and an integer k, remove the kth last element from the list. k is guaranteed to be smaller than the length of the list.

The list is very long, so making more than one pass is prohibitively expensive.

Do this in constant space and in one pass.
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
        
        void printList() {
            Node node = head;
            while(node != null) {
                System.out.print(node.data + " ");
                node = node.next;
            }
            System.out.print("\n");
        }
    }
    
    public static void kLastElement(LinkedList list, int k) {
        Node fast = list.head;
        Node slow = list.head;
        
        for(int i = 0; i < k; i++) {
            fast = fast.next;
        }
        
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        System.out.println(slow.data);
    }
    
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        Node node = list.head;
        for(int i = 2; i < 9; i++) {
            node.next = new Node(i);
            node = node.next;
        } 
        list.printList();
        kLastElement(list, 2); //7
        kLastElement(list, 3); //6
        kLastElement(list, 4); //5
        kLastElement(list, 5); //4
        kLastElement(list, 8); //1
    }
    
}

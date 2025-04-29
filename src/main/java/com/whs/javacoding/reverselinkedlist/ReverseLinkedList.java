package com.whs.javacoding.reverselinkedlist;

class Node {
    int value;
    Node next;
    Node(int value) { this.value = value; }
}

public class ReverseLinkedList {
    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node reversed = reverse(head);
        while (reversed != null) {
            System.out.print(reversed.value + " ");
            reversed = reversed.next;
        }
    }
}

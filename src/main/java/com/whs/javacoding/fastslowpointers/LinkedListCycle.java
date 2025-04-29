package com.whs.javacoding.fastslowpointers;

class ListNode {
    int value;
    ListNode next;
    ListNode(int value) { this.value = value; }
}

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next; // cycle
        System.out.println(hasCycle(head)); // Output: true
    }
}

package com.game.ds.ll;

/**
 * https://leetcode.com/problems/rotate-list/submissions/
 */

//  Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class RotateLL {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode head = getRotatedLL(node1,3);
        ListNode ptr = head;
        while(ptr!=null){
            System.out.print(ptr.val+"\t");
            ptr=ptr.next;
        }
    }

    private static ListNode getRotatedLL(ListNode head, int k) {
        if(head==null )return null;
        ListNode ptr = head;
        ListNode prev = null;
        int len=0;

        while(ptr!=null){
            len++;
            ptr=ptr.next;
        }
        if(k>=len)k=k%len;
        if(head.next==null || k==0)return head;

        ptr=head;
        int i =0;
        while(i<len-1){
            if(i<len-k)
                prev=ptr;
            ptr=ptr.next;
            i++;
        }
        ptr.next = head;
        if(prev!=null){
            head = prev.next;
            prev.next = null;
        }
        return head;
    }
}

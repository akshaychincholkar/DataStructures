package com.game.ds.ll;


public class ReverseSublist {
    public static void main(String[] args) {
        NodeSLL head=NodeSLL.getDefaultSLL();
        int left = 2;
        int right = 4;
        head = getReversedSublist(head,left,right);
        NodeSLL.display(head);
    }

    public static NodeSLL getReversedSublist(NodeSLL head, int left, int right) {
        NodeSLL lptr = head;
        NodeSLL lprev = null;
        while(left>1&&lptr!=null){
            lprev=lptr;
            lptr=lptr.next;
            left--;
        }
        NodeSLL rptr = head;
        NodeSLL rprev = null;
        while(right>0&&rptr!=null){
            rprev=rptr;
            rptr=rptr.next;
            right--;
        }
        if(lprev!=null){
            lprev.next=rprev;
            rprev.next=null;
            ReverseSLL.reverseSLL(lptr);
        }
 else{
            head=ReverseSLL.reverseSLL(lptr);
        }
            lptr.next=rptr;
        return head;
    }
}

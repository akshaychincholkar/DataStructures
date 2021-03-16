package com.game.ds.ll;

public class NodeSLL {
    public int data;
    public NodeSLL next;
    static NodeSLL head = new NodeSLL(1);
    NodeSLL(int data){
        this.data = data;
    }
    public static NodeSLL getDefaultSLL(){
        NodeSLL n1 = new NodeSLL(2);
        NodeSLL n2 = new NodeSLL(3);
        NodeSLL n3 = new NodeSLL(4);
        NodeSLL n4 = new NodeSLL(5);
//        NodeSLL n5 = new NodeSLL(6);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        n4.next = n5;
        return  head;

    }
    public static void  displaySLL(){
        System.out.print(head.data);
        NodeSLL node = head.next;
        while(node!=null){
            System.out.print("-> "+node.data);
            node = node.next;
        }
        System.out.println();
    }
    public static NodeSLL getMiddleElement(){
        NodeSLL p1 = head.next;
        NodeSLL p2 = head;
        if(p1.next==null || p1.next.next == null) return null;
        while(p1!=null && p1.next!=null ){//&& p1.next.next != null){
            p1 = p1.next.next;
            if(p2 == null)p2 = head;
            else p2 = p2.next;
        }
        System.out.println("Middle element:"+p2.data);
        return p2;
    }
}

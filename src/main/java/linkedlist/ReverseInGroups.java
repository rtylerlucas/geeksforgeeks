package main.java.linkedlist;

import static main.java.linkedlist.ReverseInGroups.reverseList;

/**
 * Created by tyler on 1/8/17.
 */
public class ReverseInGroups {

    /*
     * 1 -> 2 -> 3-> 4 -> 5 -> 6 -> 7 -> 8 -> Null
     *  k = 3
     * 3 -> 2 -> 1-> 6 -> 5 -> 4 -> 8 -> 7 -> Null
     */
    public static LLNode reverseInGroups(LLNode head, int k)
    {
        int currGroupCount = 0;
        LLNode prev = null;
        LLNode curr = head;
        LLNode next = null;

        while(curr != null & currGroupCount != k)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            currGroupCount++;
        }
        if(next != null)
        {
            head.next = reverseInGroups(next, k);
        }
        return prev;
    }

    public static LLNode reverseList(LLNode head)
    {
        LLNode prev = null;
        LLNode curr = head;
        LLNode next;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args)
    {
        LLNode node = new LLNode(1);
        LLNode node2 = new LLNode(2);
        LLNode node3 = new LLNode(3);
        LLNode node4 = new LLNode(4);
        LLNode node5 = new LLNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LLNode n = reverseInGroups(node, 3);
//        LLNode n = node;
        while(n != null)
        {
            System.out.println(n.data);
            n = n.next;
        }
    }

}

package main.java.linkedlist;

/**
 * Created by tyler on 1/8/17.
 */
public class LinkedListUtil {

    public static LLNode getMiddle(LLNode start)
    {
        LLNode p1 = start;
        LLNode p2 = start;

        while(p2 != null && p2.next != null && p2.next.next != null)
        {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    public static LLNode mergeSort(LLNode head)
    {
        if(head == null || head.next ==null)
        {
            return head;
        }

        LLNode middle = getMiddle(head);
        LLNode rightOfMiddle = middle.next;
        middle.next = null;
        LLNode sortedLeft = mergeSort(head);
        LLNode sortedRight = mergeSort(rightOfMiddle);
        return combine(sortedLeft, sortedRight);
    }

    private static LLNode combine(LLNode n1, LLNode n2)
    {
        LLNode front = null;
        if(n1 == null)
        {
            front = n2;
        }
        else if(n2 == null)
        {
            front = n1;
        }
        else if(n1.data <= n2.data)
        {
            front = n1;
            n1.next =combine(n1.next, n2);

        }
        else
        {
            front = n2;
            front.next = combine(n1, n2.next);
        }
        return front;
    }

    public static void main(String[] args)
    {
        LLNode n = new LLNode(4);
        LLNode n2 = new LLNode(3);
        LLNode n3 = new LLNode(1);
        LLNode n4 = new LLNode(2);
        n.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(LinkedListUtil.getMiddle(n).data);

        LLNode t = mergeSort(n);
        while(t != null)
        {
            System.out.println(t.data);
            t = t.next;
        }


    }

}

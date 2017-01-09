package main.java.linkedlist;

/**
 * Created by tyler on 1/8/17.
 */
public class UnionIntersectionLL {

    public static String getIntersection(LLNode a, LLNode b)
    {
        LLNode sortedA = LinkedListUtil.mergeSort(a);
        LLNode sortedB = LinkedListUtil.mergeSort(b);
        StringBuilder res =  new StringBuilder();
        while(sortedA != null && sortedB != null)
        {
            if(sortedA.data == sortedB.data)
            {
                res.append(sortedA.data);
                sortedA = sortedA.next;
                sortedB = sortedB.next;
            }
            else if(sortedA.data < sortedB.data)
            {
                sortedA = sortedA.next;
            }
            else
            {
                sortedB = sortedB.next;
            }
        }
        return res.toString();
    }

    public String getUnion(LLNode a, LLNode b)
    {
        return null;
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

        LLNode j = new LLNode(4);
        LLNode j2 = new LLNode(3);
        LLNode j3 = new LLNode(1);
        LLNode j4 = new LLNode(6);
        j.next = j2;
        j2.next = j3;
        j3.next = j4;

        System.out.println(getIntersection(n, j));
    }
}

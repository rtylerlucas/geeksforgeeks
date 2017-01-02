package main.java.graph;

import main.java.graph.util.GraphNode;

import java.util.*;

/**
 * Created by tyler on 1/2/17.
 */
public class BFS
{
    public void search(GraphNode start)
    {
        if(start==null)
        {
            return;
        }

        Set<GraphNode> visited = new HashSet<>();
        Deque<GraphNode> buffer = new LinkedList<>();

        buffer.add(start);
        while(!buffer.isEmpty())
        {
            GraphNode visiting = buffer.poll();
            visited.add(visiting);
            for(GraphNode node : visiting.getChildren())
            {
                if(!visited.contains(node))
                {
                    buffer.add(node);
                    visited.add(node);
                }
            }
            System.out.println(visiting.getUniqueId());
        }

    }
    public static void main(String[] args)
    {
        GraphNode c = new GraphNode(3, new ArrayList<>());
        GraphNode d = new GraphNode(4, new ArrayList<>());

        GraphNode e = new GraphNode(5, new ArrayList<>());
        GraphNode g = new GraphNode(7, new ArrayList<>());

        List<GraphNode> aKids = new ArrayList<>();
        List<GraphNode> bKids = new ArrayList<>();
        List<GraphNode> fKids = new ArrayList<>();

        fKids.add(g);
        GraphNode f = new GraphNode(6, fKids);
        bKids.add(d);
        bKids.add(e);
        bKids.add(f);

        GraphNode b = new GraphNode(2, bKids);
        aKids.add(b);
        aKids.add(c);
        aKids.add(d);
        GraphNode a = new GraphNode(1, aKids);
        bKids.add(a);
        BFS bfs = new BFS();
        bfs.search(a);
    }
}



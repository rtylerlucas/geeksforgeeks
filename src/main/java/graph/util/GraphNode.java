package main.java.graph.util;

import java.util.List;

/**
 * Created by tyler on 1/2/17.
 */
public class GraphNode {

    private final int uniqueId;
    private List<GraphNode> children;

    public GraphNode(int uniqueId, List<GraphNode> children) {
        this.uniqueId = uniqueId;
        this.children = children;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public List<GraphNode> getChildren()
    {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GraphNode graphNode = (GraphNode) o;

        return uniqueId == graphNode.uniqueId;
    }

    @Override
    public int hashCode() {
        return uniqueId;
    }
}

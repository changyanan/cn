package com.example.itookdemodesign.hash;

import java.util.List;

/**
 * @author changyanan1
 */
public interface Cluster {

    void addNode(Node node);

    default void removeNode(Node node) {
        this.removeNode(node.getName());
    }

    void removeNode(String nodeName);

    Node get(String key);

    List<Node> getNodes();
}

package alogorithm.traversal;

import datastructure.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(|V| + |E|)
 * */
public class BreadthFirstSearch {

    public static Queue execute(Node root){
        Queue result = new LinkedList();

        Queue queue = new LinkedList();
        queue.add(root);

        while(queue.size() > 0){
            Node node = (Node) queue.poll();
            result.add(node);
            node.getAdjacentNodes().forEach((k, v) -> {
                queue.add(k);
            });
        }

        return result;
    }


}

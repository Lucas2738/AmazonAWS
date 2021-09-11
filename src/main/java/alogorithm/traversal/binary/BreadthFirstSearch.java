package alogorithm.traversal.binary;

import datastructure.BTreeNode;
import datastructure.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time Complexity: O(|V| + |E|)
 * */
public class BreadthFirstSearch {

    public static Queue execute(BTreeNode root){
        Queue result = new LinkedList();

        Queue<BTreeNode> queue = new LinkedList();
        queue.add(root);

        while(queue.size() > 0){
            BTreeNode node = queue.poll();
            result.add(node);
            if(node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if(node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
        return result;
    }


}

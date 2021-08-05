package alogorithm.traversal;

import alogorithm.traversal.model.Node;
import alogorithm.traversal.model.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static Queue execute(Tree tree){
        Queue result = new LinkedList();

        Queue queue = new LinkedList();
        queue.add(tree.getRoot());

        while(queue.size() > 0){
            Node node = (Node) queue.poll();
            result.add(node);
            node.getChilds().forEach(c -> {
                queue.add(c);
            });
        }

        return result;
    }


}

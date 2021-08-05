package alogorithm.traversal;

import alogorithm.traversal.model.Node;
import alogorithm.traversal.model.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeepFirstSearch {

    public static Queue execute(Tree tree){
        Queue result = new LinkedList();

        Stack<Node> stack = new Stack<>();
        stack.add(tree.getRoot());

        while(stack.size() > 0){
            Node node = stack.pop();
            result.add(node);
            node.getChilds().forEach(c -> {
                stack.add(c);
            });
        }
        return result;
    }

    public static Queue executeRecursive(Tree tree){
        Queue result = new LinkedList();
        traverse(tree.getRoot(), result);
        return result;
    }

    public static Node traverse(Node node, Queue queue){
        if(!node.isVisited()){
            queue.add(node);
            node.setVisited(true);
            LinkedList<Node> childs = node.getChilds();

            if(childs == null || childs.size() != 0){
                childs.forEach(n ->{
                    traverse(n, queue);
                });
            }else{
                return node.getParent();
            }
        }
        return node.getParent();
    }
}

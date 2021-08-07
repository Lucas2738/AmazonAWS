package alogorithm.traversal;

import datastructure.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DeepFirstSearch {

    public static Queue execute(Node root){
        Queue result = new LinkedList();

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while(stack.size() > 0){
            Node node = stack.pop();
            result.add(node);
            node.getAdjacentNodes().forEach((k, v) -> {
                stack.add(k);
            });
        }
        return result;
    }

    public static Queue executeRecursive(Node root){
        Queue result = new LinkedList();
        traverse(root, result);
        return result;
    }

    public static Node traverse(Node node, Queue queue){
        if(!node.isVisited()){
            queue.add(node);
            node.setVisited(true);
            Map<Node, Integer> childs = node.getAdjacentNodes();

            if(childs == null || childs.size() != 0){
                childs.forEach((k, v) ->{
                    traverse(k, queue);
                });
            }else{
                return node.getParent();
            }
        }
        return node.getParent();
    }
}

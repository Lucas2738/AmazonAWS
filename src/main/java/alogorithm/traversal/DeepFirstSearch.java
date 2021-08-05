package alogorithm.traversal;

import alogorithm.traversal.model.Node;
import alogorithm.traversal.model.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DeepFirstSearch {

    public static void main(String[] args){

        DeepFirstSearch DFS = new DeepFirstSearch();

        Tree tree = new Tree();

        Node root = new Node();
        root.setName("ROOT");

        Node a = new Node();
        a.setName("A");
        Node b = new Node();
        b.setName("B");
        Node c = new Node();
        c.setName("C");
        Node d = new Node();
        d.setName("D");
        Node e = new Node();
        e.setName("E");
        Node f = new Node();
        f.setName("F");
        Node g = new Node();
        g.setName("G");

        tree.setRoot(root);
            root.addChild(a);
            root.addChild(b);
            root.addChild(c);
                a.addChild(d);
                b.addChild(e);
                    e.addChild(f);
                    e.addChild(g);

        System.out.println(DFS.executeRecursive(tree));
    }

    public Queue execute(Tree tree){
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

    private Queue result = new LinkedList();
    public Queue executeRecursive(Tree tree){
        traverse(tree.getRoot());
        return result;
    }

    public Node traverse(Node node){
        if(!node.isVisited()){
            System.out.println(node.getName());
            node.setVisited(true);
            LinkedList<Node> childs = node.getChilds();

            if(childs == null || childs.size() != 0){
                childs.forEach(n ->{
                    traverse(n);
                });
            }else{
                return node.getParent();
            }
        }
        return node.getParent();
    }
}

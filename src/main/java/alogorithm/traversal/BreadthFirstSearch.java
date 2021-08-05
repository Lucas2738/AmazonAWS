package alogorithm.traversal;

import alogorithm.traversal.model.Node;
import alogorithm.traversal.model.Tree;

import java.util.LinkedList;

public class BreadthFirstSearch {

    public static void main(String[] args){
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

        execute(tree);
    }

    public static boolean execute(Tree tree){

        traverse(tree.getRoot());
        return true;
    }

    public static Node traverse(Node node){
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

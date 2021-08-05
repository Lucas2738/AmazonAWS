package alogorithm.traversal;

import alogorithm.traversal.model.Node;
import alogorithm.traversal.model.Tree;

import java.util.LinkedList;
import java.util.Queue;

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

        System.out.println(execute(tree));
    }



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

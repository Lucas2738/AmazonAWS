import alogorithm.traversal.BreadthFirstSearch;
import alogorithm.traversal.DeepFirstSearch;

import static org.junit.jupiter.api.Assertions.*;

import datastructure.Node;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Queue;

public class TreeTraversalTest {

    private static Node root;

    @BeforeAll
    public static void beforeClass(){
        root = Node.of("ROOT");
        Node a = Node.of("A");
        Node b = Node.of("B");
        Node c = Node.of("C");
        Node d = Node.of("D");
        Node e = Node.of("E");
        Node f = Node.of("F");
        Node g = Node.of("G");

        root.addChild(a);
        root.addChild(b);
        root.addChild(c);
        a.addChild(d);
        b.addChild(e);
        e.addChild(f);
        e.addChild(g);
    }


    @Test
    public void BFS(){
        Queue result = BreadthFirstSearch.execute(root);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void DFS(){
        Queue result = DeepFirstSearch.execute(root);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void DFSRecursive(){
        Queue result = DeepFirstSearch.executeRecursive(root);
        System.out.println(result);
        assertNotNull(result);
    }
}

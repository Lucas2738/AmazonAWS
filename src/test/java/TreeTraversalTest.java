import alogorithm.traversal.BreadthFirstSearch;
import alogorithm.traversal.DeepFirstSearch;
import alogorithm.traversal.model.Node;
import alogorithm.traversal.model.Tree;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Queue;

public class TreeTraversalTest {

    private static Tree tree;

    @BeforeAll
    public static void beforeClass(){
        tree = new Tree();
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
    }


    @Test
    public void BFS(){
        Queue result = BreadthFirstSearch.execute(tree);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void DFS(){
        Queue result = DeepFirstSearch.execute(tree);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void DFSRecursive(){
        Queue result = DeepFirstSearch.executeRecursive(tree);
        System.out.println(result);
        assertNotNull(result);
    }
}

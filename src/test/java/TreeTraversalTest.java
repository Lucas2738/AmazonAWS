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
        Node root = Node.of("ROOT");
        Node a = Node.of("A");
        Node b = Node.of("B");
        Node c = Node.of("C");
        Node d = Node.of("D");
        Node e = Node.of("E");
        Node f = Node.of("F");
        Node g = Node.of("G");

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

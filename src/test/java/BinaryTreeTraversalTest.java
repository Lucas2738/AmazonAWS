import alogorithm.traversal.binary.BreadthFirstSearch;
import alogorithm.traversal.binary.DeepFirstSearch;
import datastructure.BTreeNode;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class BinaryTreeTraversalTest {

    private static BTreeNode root;

    @BeforeAll
    public static void beforeClass(){
        root = BTreeNode.of("ROOT");
        BTreeNode a = BTreeNode.of("A");
        BTreeNode b = BTreeNode.of("B");
        BTreeNode c = BTreeNode.of("C");
        BTreeNode d = BTreeNode.of("D");
        BTreeNode e = BTreeNode.of("E");
        BTreeNode f = BTreeNode.of("F");

        root.setLeft(a);
        root.setRight(b);
        a.setLeft(c);
        b.setRight(d);
        d.setLeft(e);
        d.setRight(f);
    }


    @Test
    public void BFS(){
        System.out.println("BINARY TREE BFS TRAVERSAL");
        Queue result = BreadthFirstSearch.execute(root);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void DFSPreorder(){
        System.out.println("BINARY TREE DPS PREORDER TRAVERSAL");
        Queue result = DeepFirstSearch.execute(root, DeepFirstSearch.Type.PREORDER);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void DFSInorder(){
        System.out.println("BINARY TREE DPS INORDER TRAVERSAL");
        Queue result = DeepFirstSearch.execute(root, DeepFirstSearch.Type.INORDER);
        System.out.println(result);
        assertNotNull(result);
    }

    @Test
    public void DFSPostorder(){
        System.out.println("BINARY TREE DPS POSTORDER TRAVERSAL");
        Queue result = DeepFirstSearch.execute(root, DeepFirstSearch.Type.POSTORDER);
        System.out.println(result);
        assertNotNull(result);
    }

}

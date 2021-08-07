import alogorithm.shortestpath.Dijkstra;
import datastructure.Node;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DijskstraTest {

    @Test
    public void test(){
        Dijkstra dijskstra = new Dijkstra();
        Set<Node> shortestPath = dijskstra.execute(buildGraph());
        assertTrue(shortestPath.stream().filter(n -> n.getName().equals("I")).findFirst().get().getDistance() == 28);
    }

    public Set<Node> buildGraph(){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");

        //starting node
        a.setDistance(0);

        a.getAdjacentNodes().put(b, 10);
        a.getAdjacentNodes().put(c, 12);
        b.getAdjacentNodes().put(a, 10);
        c.getAdjacentNodes().put(a, 12);
        b.getAdjacentNodes().put(e, 8);
        b.getAdjacentNodes().put(c, 9);
        e.getAdjacentNodes().put(b, 8);
        c.getAdjacentNodes().put(b, 9);
        c.getAdjacentNodes().put(d, 3);
        c.getAdjacentNodes().put(f, 1);
        d.getAdjacentNodes().put(c, 3);
        f.getAdjacentNodes().put(c, 1);
        d.getAdjacentNodes().put(e, 7);
        d.getAdjacentNodes().put(f, 3);
        e.getAdjacentNodes().put(d, 7);
        f.getAdjacentNodes().put(d, 3);
        e.getAdjacentNodes().put(g, 8);
        e.getAdjacentNodes().put(h, 5);
        g.getAdjacentNodes().put(e, 8);
        h.getAdjacentNodes().put(e, 5);
        f.getAdjacentNodes().put(h, 6);
        h.getAdjacentNodes().put(f, 6);
        g.getAdjacentNodes().put(i, 2);
        g.getAdjacentNodes().put(h, 9);
        h.getAdjacentNodes().put(g, 9);
        i.getAdjacentNodes().put(g, 2);
        h.getAdjacentNodes().put(i, 11);
        i.getAdjacentNodes().put(h, 11);

        Set<Node> unVisited = new HashSet<>();
        unVisited.add(a);
        unVisited.add(b);
        unVisited.add(c);
        unVisited.add(d);
        unVisited.add(e);
        unVisited.add(f);
        unVisited.add(g);
        unVisited.add(h);
        unVisited.add(i);

        return unVisited;
    }
}

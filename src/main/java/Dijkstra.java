import java.util.*;

import static java.lang.System.*;

public class Dijkstra {

    private final HashMap<String, Node> visited = new HashMap<>();
    private Set<Node> unVisited = new HashSet<>();

    public static void main(String[] args){
        Dijkstra dijkstra =  new Dijkstra();
        dijkstra.init();
        dijkstra.run();

        out.println("END");
    }


    private void run(){

        while(unVisited.size() != 0){
            Node node = getLowestDistanceNode();
            unVisited.remove(node);

            for (Map.Entry<Node, Integer> adjacencyPair : node.getAdjacentNodes().entrySet()) {
                if((node.getDistance() + adjacencyPair.getValue() < adjacencyPair.getKey().getDistance())){
                    LinkedList<Node> shortestPath = new LinkedList<>(node.getShortestPath());
                    shortestPath.add(node);
                    adjacencyPair.getKey().setShortestPath(shortestPath);
                    adjacencyPair.getKey().setDistance(node.getDistance() + adjacencyPair.getValue());
                }
            }
            visited.put(node.getName(), node);
        }
    }



    private Node getLowestDistanceNode(){
        Node result = null;
        Integer dist = Integer.MAX_VALUE;

        for(Node n : unVisited){
            if(n.getDistance() < dist){
                dist = n.getDistance();
                result = n;
            }
        }
        return result;
    }

    private void init(){
        Node a = new Node("A");
        a.setDistance(0);
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");


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


        unVisited.add(a);
        unVisited.add(b);
        unVisited.add(c);
        unVisited.add(d);
        unVisited.add(e);
        unVisited.add(f);
        unVisited.add(g);
        unVisited.add(h);
        unVisited.add(i);

    }

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.*;

public class Dijkstra {

    private final List<Edge> edges =  new ArrayList<>();

    private static Node start;

    private final HashMap<Integer, Node> shortestPath = new HashMap<>();
    private final HashMap<Integer, Node> visited = new HashMap<>();

    public static void main(String[] args){
        Dijkstra dijkstra =  new Dijkstra();
        dijkstra.init();
        dijkstra.run(start);

        out.println("END");
    }


    private void run(final Node node){
        shortestPath.putIfAbsent(node.getKey(), node);

        List<Edge> neighs = edges.stream().filter(e -> e.getNodea().getKey() == node.getKey() || e.getNodeb().getKey() == node.getKey()).collect(Collectors.toList());
        neighs.forEach(n -> {
                    Node b = getOtherEdgeNode(n, node);

                    if(shortestPath.get(b.getKey()) != null){
                        b = shortestPath.get(b.getKey());
                    }

                    Node no = node;
                    if(shortestPath.get(node.getKey()) != null){
                        no = shortestPath.get(node.getKey());
                    }

                    if((no.getDistance() + n.getWeight() < b.getDistance())){
                        b.setPrevious(no);
                        b.setDistance(no.getDistance() + n.getWeight());
                    }

                    shortestPath.putIfAbsent(b.getKey(), b);
            }
        );

        visited.put(node.getKey(), node);

        neighs.stream()
                .filter(n -> visited.get(getOtherEdgeNode(n, node).getKey()) == null)
                .map(n -> getOtherEdgeNode(n, node))
                .forEach(this::run);
    }


    private Node getOtherEdgeNode(Edge edge, Node node){
        Node result;
        if(edge.getNodea().equals(node)){
            result = edge.getNodeb();
        }else{
            result = edge.getNodea();
        }
        return result;
    }

    private void init(){
        Node a = Node.builder().key(1).distance(0).build();
        Node b = Node.builder().key(2).distance(999).build();
        Node c = Node.builder().key(3).distance(999).build();
        Node d = Node.builder().key(4).distance(999).build();
        Node e = Node.builder().key(5).distance(999).build();
        Node f = Node.builder().key(6).distance(999).build();
        Node g = Node.builder().key(7).distance(999).build();
        Node h = Node.builder().key(8).distance(999).build();
        Node i = Node.builder().key(9).distance(999).build();

        start = a;

        edges.add(Edge.builder().weight(10).nodea(a).nodeb(b).build());
        edges.add(Edge.builder().weight(12).nodea(a).nodeb(c).build());
        edges.add(Edge.builder().weight(8).nodea(b).nodeb(e).build());
        edges.add(Edge.builder().weight(9).nodea(b).nodeb(c).build());
        edges.add(Edge.builder().weight(3).nodea(c).nodeb(d).build());
        edges.add(Edge.builder().weight(1).nodea(c).nodeb(f).build());
        edges.add(Edge.builder().weight(7).nodea(d).nodeb(e).build());
        edges.add(Edge.builder().weight(3).nodea(d).nodeb(f).build());
        edges.add(Edge.builder().weight(8).nodea(e).nodeb(g).build());
        edges.add(Edge.builder().weight(5).nodea(e).nodeb(h).build());
        edges.add(Edge.builder().weight(6).nodea(f).nodeb(h).build());
        edges.add(Edge.builder().weight(2).nodea(g).nodeb(i).build());
        edges.add(Edge.builder().weight(9).nodea(g).nodeb(h).build());
        edges.add(Edge.builder().weight(11).nodea(h).nodeb(i).build());

    }

}

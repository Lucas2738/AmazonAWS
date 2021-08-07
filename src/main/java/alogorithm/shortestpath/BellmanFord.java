package alogorithm.shortestpath;

import datastructure.Edge;
import datastructure.Node;

import java.util.*;

/**
 *  O(|V| * |E|)
 * */
public class BellmanFord {

    private final Set<Node> nodes = new HashSet<>();
    private final Set<Edge> edges = new HashSet<>();


    public Set<Node> execute() throws Exception {

        for(int i = 0; i < nodes.size() - 1; i++){
            for(Edge e : edges){
                if(e.getA().getDistance() != Integer.MAX_VALUE && e.getA().getDistance() + e.getWeight() < e.getB().getDistance()){
                    e.getB().setDistance(e.getA().getDistance() + e.getWeight());
                }
            }
        }
        for(Edge e : edges){
            if(e.getA().getDistance() != Integer.MAX_VALUE && e.getA().getDistance() + e.getWeight() < e.getB().getDistance()){
                throw new Exception("Negative cycle!");
            }
        }

        return nodes;
    }

    public void init(Set<Node> nodes){
        nodes.forEach(n -> {
            Map<Node, Integer> neigh = n.getAdjacentNodes();
            neigh.forEach((t,s) -> {
                Edge edge = Edge.builder()
                        .a(n)
                        .b(t)
                        .weight(s)
                        .build();
                edges.add(edge);
            });
        });
        this.nodes.addAll(nodes);
    }

}

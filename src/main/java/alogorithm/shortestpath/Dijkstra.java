package alogorithm.shortestpath;

import datastructure.Node;

import java.util.*;

/**
 *  O((|V| + |E|) log |V|)
 * */
public class Dijkstra {

    private final Set<Node> visited = new HashSet<>();

    public Set<Node> execute(Set<Node> unVisited){
        unVisited.addAll(unVisited);

        while(unVisited.size() != 0){
            Node node = getLowestDistanceNode(unVisited);
            unVisited.remove(node);

            for (Map.Entry<Node, Integer> adjacencyPair : node.getAdjacentNodes().entrySet()) {
                if((node.getDistance() + adjacencyPair.getValue() < adjacencyPair.getKey().getDistance())){
                    adjacencyPair.getKey().setParent(node);
                    adjacencyPair.getKey().setDistance(node.getDistance() + adjacencyPair.getValue());
                }
            }
            visited.add(node);
        }

        return visited;
    }

    private Node getLowestDistanceNode(Set<Node> unVisited){
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

}

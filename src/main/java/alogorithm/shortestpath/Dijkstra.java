package alogorithm.shortestpath;

import datastructure.Node;

import java.util.*;

public class Dijkstra {

    private final Set<Node> visited = new HashSet<>();
    private final Set<Node> unVisited = new HashSet<>();

    public Set<Node> execute(){

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
            visited.add(node);
        }

        return visited;
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

    public void init(Set<Node> unVisited){
        this.unVisited.addAll(unVisited);
    }

}

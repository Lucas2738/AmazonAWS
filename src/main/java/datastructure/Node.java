package datastructure;

import lombok.Data;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;

@Data
public class Node {
    private String name;
    private Node parent;
    private int distance = Integer.MAX_VALUE/2;
    private Map<Node, Integer> adjacentNodes =  new HashMap<>();
    private boolean visited;

    public Node(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return MessageFormat.format("{0}, Parent: {1}", name, parent);
    }

    public static Node of(String name){
        return new Node(name);
    }


    public void addChild(Node child){
        adjacentNodes.put(child, Integer.MAX_VALUE/2);
    }
}

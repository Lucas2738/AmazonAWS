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


    public Node(String name){
        this.name = name;
    }

    public boolean equals(Node n){
        return n.getName() == this.name;
    }

    @Override
    public String toString(){
        return MessageFormat.format("{0}, Parent: {1}", name, parent);
    }
}

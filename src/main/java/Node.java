import lombok.Data;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Data
public class Node {
    private String name;
    private LinkedList<Node> shortestPath =  new LinkedList<>();
    private int distance = Integer.MAX_VALUE;
    private Map<Node, Integer> adjacentNodes =  new HashMap<>();


    public Node(String name){
        this.name = name;
    }

    public boolean equals(Node n){
        return n.getName() == this.name;
    }

    @Override
    public String toString(){
        StringBuilder path = new StringBuilder();
        shortestPath.forEach(s -> path.append(s.getName() + " -> "));
        path.append(name);
        return MessageFormat.format("Node: {0}, shortestPath: {1}, distance: {2}", name, path , distance);
    }
}

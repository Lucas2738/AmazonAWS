package alogorithm.traversal.model;

import lombok.Data;

import java.util.LinkedList;

@Data
public class Node {

    private String name;
    private Node parent;
    private LinkedList<Node> childs =  new LinkedList<>();
    private boolean visited = false;

    public Node(String name) {
        this.name = name;
    }

    public void addChild(Node node){
        if(childs == null){
            childs = new LinkedList<>();
        }
        childs.add(node);
    }

    @Override
    public String toString(){
        return this.name;
    }

    public static Node of(String name){
        return new Node(name);
    }
}

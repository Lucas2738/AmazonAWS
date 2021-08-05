package alogorithm.traversal.model;

import java.util.LinkedList;

public class Node {

    private String name;
    private Node parent;
    private LinkedList<Node> childs =  new LinkedList<>();
    private boolean visited = false;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public LinkedList<Node> getChilds() {
        return childs;
    }

    public void setChilds(LinkedList<Node> childs) {
        this.childs = childs;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
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

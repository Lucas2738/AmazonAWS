package alogorithm.traversal.binary;

import datastructure.BTreeNode;
import datastructure.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DeepFirstSearch {


    public static Queue execute(BTreeNode root, Type type){
        Queue result = new LinkedList();
        traverse(root, result, type);
        return result;
    }

    public static Node traverse(BTreeNode node, Queue queue, Type type){
        if(node != null){
            switch (type){
                case PREORDER:
                    queue.add(node);
                    if(node.getLeft() != null){
                        traverse(node.getLeft(), queue, type);
                    }
                    if(node.getRight() != null){
                        traverse(node.getRight(), queue, type);
                    }
                    break;
                case INORDER:
                    if(node.getLeft() != null){
                        traverse(node.getLeft(), queue, type);
                    }
                    queue.add(node);
                    if(node.getRight() != null){
                        traverse(node.getRight(), queue, type);
                    }                    break;
                case POSTORDER:
                    if(node.getLeft() != null){
                        traverse(node.getLeft(), queue, type);
                    }
                    if(node.getRight() != null){
                        traverse(node.getRight(), queue, type);
                    }
                    queue.add(node);
                    break;
            }
        }
        return null;
    }


    public enum Type {
        PREORDER("root-left-right"),
        INORDER("left-root-right"),
        POSTORDER("left-right-root");

        private String desc;

        Type(String desc){
            this.desc=desc;
        }
    }
}

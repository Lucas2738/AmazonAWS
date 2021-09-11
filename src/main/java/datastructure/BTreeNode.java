package datastructure;

import lombok.Data;

import java.text.MessageFormat;

@Data
public class BTreeNode {
    BTreeNode left;
    String name;
    BTreeNode right;

    public BTreeNode(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return MessageFormat.format("{0}", name);
    }

    public static BTreeNode of(String name) {
        return new BTreeNode(name);
    }
}

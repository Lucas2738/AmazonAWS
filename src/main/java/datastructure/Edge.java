package datastructure;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Edge {
    private Node a;
    private Node b;
    private int weight;
}

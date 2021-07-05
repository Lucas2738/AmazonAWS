import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Node {
    int key;
    Node previous;
    int distance;

    public boolean equals(Node n){
        return n.getKey() == this.key;
    }
}

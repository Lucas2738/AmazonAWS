import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Edge {
    private int weight;
    private Node nodea;
    private Node nodeb;
}

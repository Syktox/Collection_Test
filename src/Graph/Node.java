package Graph;

import java.util.ArrayList;
import java.util.List;

public class Node {
    String value;
    List<Node> sons;
    List<Integer> weights;
    Integer minWeight;
    boolean marked;
    Node dad;

    Node(String value) {
        this.value = value;
        this.sons = new ArrayList<>();
        this.weights = new ArrayList<>();
        this.minWeight = Integer.MAX_VALUE;
        this.marked = false;
        this.dad = null;
    }

    public int getMinWeight() {
        return minWeight;
    }

    public void removeAllSons() {

    }
}

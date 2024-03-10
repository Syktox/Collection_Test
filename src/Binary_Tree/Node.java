package Binary_Tree;

public class Node {
    private Integer value;
    Node right;
    Node left;

    Node(Integer value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public Integer getValue() {
        return value;
    }
}

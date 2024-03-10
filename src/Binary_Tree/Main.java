package Binary_Tree;

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(50);
        tree.insert(20);
        tree.insert(80);

        tree.insert(10);
        tree.insert(30);

        tree.insert(70);
        tree.insert(90);

        tree.preorder();
        int length = tree.TreeToVine();
        
    }
}

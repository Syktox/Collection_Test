package Binary_Tree;

public class BinaryTree {
    private Node root;
    BinaryTree(int value) {
        this.root = new Node(value);
    }

    public void insert(Integer value) {
        insertRec(value, this.root);
    }

    private Node insertRec(Integer value, Node next) {
        if (next == null) {
            next = new Node(value);
            return next;
        }
        if (value <= next.getValue()) {
            next.left = insertRec(value, next.left);
        }
        else if (value > next.getValue()) {
            next.right = insertRec(value, next.right);
        }
        return next;
    }

    public void preorder() {
        preorder(this.root);
    }
    
    private void preorder(Node n) {
        if (n != null) {
            System.out.println(n.getValue());
            preorder(n.left);
            preorder(n.right);
        }   
    }

    public void postorder() {
        postorder(this.root);
    }
    
    private void postorder(Node n) {
        if (n != null) {
            postorder(n.left);
            postorder(n.right);
            System.out.println(n.getValue());
        }   
    }

    public void inorder() {
        inorder(this.root);
    }
    
    private void inorder(Node n) {
        if (n != null) {
            inorder(n.left);
            System.out.println(n.getValue());
            inorder(n.right);
        }   
    }

    public int TreeToVine() {
        int count = 0;
        Node vNode = new Node(null);
        vNode.right = this.root;

        Node tail = vNode;
        Node rest = vNode.right;

        while (rest != null) {
            if (rest.left == null) {
                tail = rest;
                rest = rest.right;
                count++;
            } else {
                Node temp = rest.left;
                rest.left = temp.right;
                temp.right = rest;
                rest = temp;
                tail.right = temp;                
            }
        }


        return count;
    }
}

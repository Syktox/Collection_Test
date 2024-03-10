package Graph;

import java.util.*;

public class Graph {
    List<Node> graphList = null;

    Graph() {
        graphList = new ArrayList<Node>();
    }

    public Node insert(String value) {
        Node node = new Node(value);
        graphList.add(node);
        return node;
    }

    public void connectNodes(Node start, Node end,int weight) {
        start.sons.add(end);
        end.sons.add(start);
        start.weights.add(weight);
        end.weights.add(weight);
    }

    public Node easyInsert(String value, Node father, int weight) {
        Node node = new Node(value);
        connectNodes(node, father, weight);
        return node;
    }

    private void resetMarked() {
        for (Node x : graphList) {
            x.marked = false;
        }
    }

    private void resetMinWeight() {
        for (Node x : graphList) {
            x.minWeight = Integer.MAX_VALUE;
        }
    }

    public void dfs(Node start) {
        start.marked = true;
        System.out.println("Value: " + start.value);
        for (Node x : start.sons) {
            if (!x.marked)
            dfs(x);
        }
    }

    public void bfs(Node start) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(start);
        start.marked = true;

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            System.out.println("Value: " + temp.value);
            temp.marked = true;
            for (Node x : temp.sons) {
                if (!x.marked) {
                    x.marked = true;
                    queue.add(x);
                }
            }
        }
    }

    public void MinimalSpanningTree(Node start) {
        resetMarked();
        resetMinWeight();
        Queue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getMinWeight));
        queue.add(start);

        while (!queue.isEmpty() && queue.peek() != null) {
            Node node = queue.poll();
            node.marked = true;

            List<Node> sons = node.sons;
            List<Integer> weights = node.weights;

            for (int i = 0; i < sons.size(); i++) {
                Node son = sons.get(i);
                Integer weight = weights.get(i);

                if (!son.marked) {
                    if (weight < son.getMinWeight()) {
                        son.minWeight = weight;
                        queue.add(son);
                        son.dad = node;
                    }
                }

            }


        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        Node a = graph.insert("a");
        Node b = graph.easyInsert("b", a, 40);
        Node c = graph.easyInsert("c", a, 3);
        Node d = graph.easyInsert("d", b, 2);
        Node e = graph.easyInsert("e", b, 1);
        Node f = graph.easyInsert("f", c, 2);
        Node g = graph.easyInsert("g", c, 3);
        Node h = graph.easyInsert("h", f, 2);
        graph.connectNodes(h, e, 4);
        graph.connectNodes(d, h, 6);
        graph.connectNodes(g, h, 1);

        graph.bfs(a);
    }
}

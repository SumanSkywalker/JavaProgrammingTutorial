import java.util.*;

public class MyGraph {
    List<GraphNode> network = new LinkedList<>();

    public void addNode(int data) {
        GraphNode node = new GraphNode(data);
        network.add(node);
    }

    public void linkNode(int node, int[] links) {
        int index = nodeIndex(node);
        if (index >= 0) {
            GraphNode Node = network.get(index);

            for (int j = 0; j < links.length; j++) {
                if (!Node.edges.contains(links[j])) {
                    Node.edges.add(links[j]);
                }
            }
        } else {
            System.out.println("Node not found in the network...");
            return;
        }
    }

    private int nodeIndex(int node) {
        int index = -1;
        for (int i = 0; i < network.size(); i++) {
            if (network.get(i).data == node) {
                return i;
            }
        }
        return index;
    }

    public void printGraph() {
        for (int i = 0; i < network.size(); i++) {
            System.out.print("Node: " + network.get(i).data + "\nlinks: ");
            for (int j = 0; j < network.get(i).edges.size(); j++) {
                System.out.print(network.get(i).edges.get(j) + " ");
            }
            System.out.println();
        }
    }
}

class GraphNode {
    int data;
    ArrayList<Integer> edges = new ArrayList<>();

    public GraphNode(int data) {
        this.data = data;
    }
}

class MyGraphMain {

    public static void main(String[] args) {
        MyGraph graph = new MyGraph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addNode(3);
        graph.addNode(4);
        graph.addNode(5);
        graph.linkNode(1, new int[]{2, 3, 4});
        graph.linkNode(2, new int[]{1, 3, 5});
        graph.linkNode(3, new int[]{1, 2, 4});
        graph.linkNode(4, new int[]{1, 3});
        graph.linkNode(5, new int[]{2});
        graph.printGraph();
    }
}

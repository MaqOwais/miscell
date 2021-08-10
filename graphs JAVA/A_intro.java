// package graphs JAVA;
import java.util.*;

public class A_intro {
 
    // class Graph {
        
        // A utility function to add an edge in an
        // undirected graph
        static void addEdge(ArrayList<ArrayList<Integer>> node,
                            int u, int v)
        {
            node.get(u).add(v);
            node.get(v).add(u);
        }
    
        // A utility function to print the nodeacency list
        // representation of graph
        static void printGraph(ArrayList<ArrayList<Integer>> node)
        {
            for (int i = 0; i < node.size(); i++) {
                System.out.println("\nnodeacency list of vertex " + i);
                System.out.print("head");
                for (int j = 0; j < node.get(i).size(); j++) {
                    System.out.print(" -> "+node.get(i).get(j));
                }
                System.out.println();
            }
            System.out.println(node);
        }
    
        // Driver Code
        public static void main(String[] args)
        {
            // Creating a graph with 5 vertices
            int V = 5;
            ArrayList<ArrayList<Integer> > node
                        = new ArrayList<ArrayList<Integer> >();
            
            for (int i = 0; i < V; i++)
                node.add(new ArrayList<Integer>());
    
            // Adding edges one by one
            addEdge(node, 0, 1);
            addEdge(node, 0, 4);
            addEdge(node, 1, 2);
            addEdge(node, 1, 3);
            addEdge(node, 1, 4);
            addEdge(node, 2, 3);
            addEdge(node, 3, 4);
            // addEdge(node, 2, 3);
            // addEdge(node, 2, 3);
            // addEdge(node, 2, 3);
            
            printGraph(node);
        }
    // }
}

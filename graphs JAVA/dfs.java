// package graphs JAVA;
import java.util.*;
 

public class dfs {
    
    static void addEdge(ArrayList<ArrayList<Integer>> node, int src, int dst){
        node.get(src).add(dst);
        node.get(dst).add(src);
    }


    


    public static void main(String[] args)
    {
        int V = 5;
        
        ArrayList<ArrayList<Integer>> node = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < V; i++) node.add(new ArrayList<Integer>());

        addEdge(node, 0, 1);
        addEdge(node, 0, 4);
        addEdge(node, 1, 2);
        addEdge(node, 1, 3);
        addEdge(node, 1, 4);
        addEdge(node, 2, 3);
        addEdge(node, 3, 4);
        System.out.println(node);

    }


}

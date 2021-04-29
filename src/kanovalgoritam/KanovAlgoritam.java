
package kanovalgoritam;
import java.util.*; 
  

class Graph { 
 
    int V; 

    List<Integer> adj[]; 
   
    public String stampaj(){
        return "Osma gimanazija";
    }
    
    public Graph(int vertices) 
    { 
        this.V = vertices; 
        adj = new ArrayList[V]; 
        for (int i = 0; i < V; i++) 
            adj[i] = new ArrayList<Integer>(); 
            
    } 
  
    // Function to add an edge to graph 
    public void addEdge(int u, int v) 
    { 
        adj[u].add(v); 
    } 
  
    public void topologicalSort() 
    { 
    
        int indegree[] = new int[V]; 
           System.out.println(Arrays.toString(indegree)); 
                
   
        for (int i = 0; i < V; i++) { 
            ArrayList<Integer> temp 
                = (ArrayList<Integer>)adj[i]; 
            System.out.println(temp);
            
            for (int node : temp) { 
                indegree[node]++; System.out.println(indegree[node]); 
            } 
             
                
        } 
  
        Queue<Integer> q 
            = new LinkedList<Integer>();  
        
        for (int i = 0; i < V; i++) { 
            if (indegree[i] == 0) 
                q.add(i); 
        } 
        System.out.println();
        System.out.println();
        System.out.println(q);
     
        int cnt = 0; 
  
        Vector<Integer> topOrder = new Vector<Integer>();  
        while (!q.isEmpty()) { 
        
            int u = q.poll(); 
            topOrder.add(u); 
  
       
            for (int node : adj[u]) { 
               
                if (--indegree[node] == 0) 
                    q.add(node); 
            } 
            
            cnt++; 
        } 
       
        if (cnt != V) { 
            System.out.println( 
                "There exists a cycle in the graph"); 
            return; 
        } 
   
        for (int i : topOrder) { 
            System.out.print(i + " "); 
        } 
    } 
} 

public class KanovAlgoritam {

   
    public static void main(String[] args) {
      
        Graph g = new Graph(6); 
        System.out.println(Arrays.toString(g.adj)); 
        
        g.addEdge(5, 2); 
        System.out.println(Arrays.toString(g.adj)); 
        
        g.addEdge(5, 0); 
        System.out.println(Arrays.toString(g.adj)); 
        g.addEdge(4, 0); 
        System.out.println(Arrays.toString(g.adj)); 
        
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        System.out.println(Arrays.toString(g.adj)); 
               
        
        System.out.println( 
            "Following is a Topological Sort"); 
        g.topologicalSort(); 
    }
    
}

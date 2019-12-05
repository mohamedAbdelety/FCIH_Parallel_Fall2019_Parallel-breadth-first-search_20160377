/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algo;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author Mohamed
 */
public class Graph {
    private int v;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Matrix 
  
   
    public Graph(int v) 
    { 
        this.v = v; 
        this.adj = new LinkedList[v]; 
        for (int i=0; i<v; i++) 
            adj[i] = new LinkedList(); 
    } 
  
    public void addEdge(int v,int dest_v) 
    { 
        adj[v].add(dest_v); 
    }
    
    
    
    public LinkedList<Integer> Serail_BFS(int source) 
    { 
        
        
        LinkedList<Integer> result = new LinkedList<Integer>();
        boolean visited[] = new boolean[this.v]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[source]=true; 
        queue.add(source); 
        
       
        while (queue.size() != 0) 
        { 
           
            int vertx = queue.poll(); 
            result.add(vertx); 
           
  
            Iterator<Integer> i = adj[vertx].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        }
        return result;
    } 
    
    
    
}

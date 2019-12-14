/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.el3atyanew;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohamed
 */
public class PBFS {

    private int v;   // No. of vertices 
    private LinkedList<Integer> adj[]; //Adjacency Matrix 
    private ThreadPoolExecutor executor;
    private int numThreads;

    public PBFS(int v) {
        this.numThreads = Runtime.getRuntime().availableProcessors();
        this.executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numThreads);

        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int dest_v) {

        adj[v].add(dest_v);
    }

    
    
    
    
    
    
    
    
    
    public int getSize(int source) {
        int size = 1;
        boolean visited2[] = new boolean[this.v];
        visited2[source] = true;
        ArrayList<Integer> Q = new ArrayList<Integer>();
        
        Q.add(source);

        while (Q.size() != 0) {
            int out = Q.get(0);
            Q.remove(0);

            for (Integer x : adj[out]) {
                if(!visited2[x]){
                    Q.add(x);
                    size++;
                    visited2[x] = true;
                }
              
            }

        }

        return size;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    public LinkedList<Integer>  parallel_BFS(int source) {
        int x = getSize(source);
        CountDownLatch endController = new CountDownLatch(x);

        LinkedList<Integer> result = new LinkedList<Integer>();
       
        boolean visited[] = new boolean[this.v];

        // Create a queue for BFS 
        int[] queue = new int[x];
        int indexQ = 1;
        for(int i = 0;i<x;i++){
            queue[i] = -1;
        }

        // Mark the current node as visited and enqueue it 
        visited[source] = true;
        int q = 0;
        queue[q] = source;
        
        for (int j = 0; j < x; j++) {
            
            boolean cheak = true;
            while (cheak) {
                
                if (queue[q] != -1) {
                    
                    int vertx = queue[q];
                    q++;
                    
                    result.add(vertx);
                   
                    Iterator<Integer> i = adj[vertx].listIterator();
                    
                    int zx = 0;
                    for (int cc = 0;cc < adj[vertx].size();cc++) { 
                        if (! visited[adj[vertx].get(cc)])
                        { zx +=1 ; } 
                    }
                    
                    
                    parallelTask task = new parallelTask(i, endController, visited, queue,indexQ);
                    executor.execute(task);
                    indexQ += zx;
                    cheak = false;
                }
            }

        }
        try {
            endController.await();
        } catch (InterruptedException ex) {
            Logger.getLogger(PBFS.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public void destroy() {
        executor.shutdown();
    }
}

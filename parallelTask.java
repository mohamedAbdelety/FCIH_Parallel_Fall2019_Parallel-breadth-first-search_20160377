/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PBFS;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.CountDownLatch;

/**
 *
 * @author Mohamed
 */
public class parallelTask implements Runnable{
   Iterator<Integer> i ;
    boolean visited[];
    private CountDownLatch endController;
    private  LinkedList<Integer> queue;
  
    
    public parallelTask(Iterator<Integer> i,CountDownLatch endController, boolean visited[], LinkedList<Integer> queue){
        this.i = i;
        this.endController = endController;
        this.visited = visited;
        this.queue = queue;
       
    }
    
    
    @Override
    public void run() {
        
        while (i.hasNext()) 
        { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n);
                }
                
        }
        
        endController.countDown();
      
    }
    
}

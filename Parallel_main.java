/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abd.el3atyanew;

import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Mohamed
 */
public class Parallel_main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        PBFS g = new PBFS(15); 
  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3);
        //g.addEdge(1, 0);
        g.addEdge(1, 4); 
        g.addEdge(2, 5); 
        g.addEdge(2, 6);
         
        
        g.addEdge(3, 7); 
        g.addEdge(3, 8); 
        g.addEdge(4, 9); 
        g.addEdge(4, 10);
       
        
        
        g.addEdge(5, 11); 
        g.addEdge(5, 12); 
        g.addEdge(6, 13); 
        g.addEdge(6, 14);
        
        
        
        int Source = 1;
        
        double currentTime = 0d;
        Date start, end;
        start = new Date();
        
        
        LinkedList<Integer> result = new LinkedList<Integer>();
        result = g.parallel_BFS(Source);
        
        
        end = new Date();
        currentTime = end.getTime() - start.getTime();
        
        for(int vert : result ){
            System.out.print(vert+" ");
        }
        System.out.println();
        System.out.println("=========================================");	
        System.out.println("Execution Time: " + (currentTime / 1000)
                        + " seconds.");
        System.out.println("=========================================");

        
        g.destroy();
    }
        

        
    }
    


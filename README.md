<h1 align="center"> Serail_Parallel <span style="color:#f00"> BFS </span>  </h1>
<br>


## About BFS

The breadth-first-search algorithm is a way to explore the vertexes of a graph layer by layer. It is a basic algorithm in graph theory which can be used as a part of other graph algorithms




## Serial breadth-first search

In the conventional sequential BFS algorithm, one data structures are created to store vertex is queue called fortiner contains the vertexes in order to visit.
we start from source vertex first step push source vertex to queue and make this vertex is visited then push neighbor of these vertexes will be checked, some of these neighbors which are not explored yet will be discovered and put into the queue.
after push neighbor of vertex we pop this vertex.
we reapet this steps with every vertex in queue until queue became empty.

<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs1.png" width="300px">   <img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs2.png" width="300px">

<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs3.png" width="300px">   <img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs4.png" width="300px">

<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs5.png" width="300px">   <img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs6.png" width="300px">


<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs7.png" width="300px">   <img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs8.png" width="300px">


<img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs9.png" width="300px">   <img src="https://media.geeksforgeeks.org/wp-content/cdn-uploads/bfs10.png" width="300px">



## Parallel breadth-first search
There is more than one way to implement Parallel breadth-first search 
- Parallel Random Access Machine (PRAM) 
- Parallel BFS with shared memory
- Parallel BFS with distributed memory
-- 1
-- 2







## Contributing

- محمد محمود عبدالعاطى 20160377
- مصطفي عمر محمد 20160426
- احمد رمضان احمد 20160017


## License

open-sourced software licensed under the [MIT license](https://opensource.org/licenses/MIT).

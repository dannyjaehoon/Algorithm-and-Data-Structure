A tree is a special kind of graph 
- a connected and acyclic graph
- contains n nodes and n - 1 edges

A graph may contain cycle
- nodes could be disconnected

### Graph Terminologies
A graph consists of vertices("nodes" in trees) and edges
- vertices are connected by edges
- two vertices connected by an edge are called neighbours and are adjacent
- Edges can be undirected or directed
- a tree is also an undirected graph
- a path is a sequence of vertices
- a cycle is a path that starts and ends at the same vertex

### Tree vs Graph Traversal

- We use an extra visited variable to keep track of vertices we have already visited to prevent re-visiting and getting into infinite loops
- visited can be any data structure that can answer existence queries quickly. For example, a hash set or an array where each element maps to a vertex in the graph can both do this in constant time.


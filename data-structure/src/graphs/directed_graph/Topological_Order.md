### What is a topological order?
- Topological sort or topological ordering of a directed graph is an ordering of nodes such that every node appears in the ordering before all the nodes it points to. Topological sort is not unique. 
- Graphs with Cycles Do Not Have Topological Ordering


Kahn's Algorithm
- For this algorithm, we systematically remove one node at a time, each time removing a node such that no other nodes point to that node (in-degree is 0). 
- If no such node exists, then there must be a cycle, and there is no way to order the nodes such that "every node appears in the ordering before all the nodes it points to" (no solution).
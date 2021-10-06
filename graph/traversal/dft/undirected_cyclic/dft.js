/***
 * 
 *  a
 * b c e
 * d f
 */

 let graph = {
    a: ['b', 'c'],
    b: ['d'],
    c: ['e'],
    d: ['f',],
    e: [],
    f: ['d'],
  };
  
  const depthFirstSearch = (graph, source, visited) => {
    if(visited.has(source)){
      return;
    }
    console.log(source);
    visited.add(source);
  
    for (const neighbor of graph[source]) {
      depthFirstSearch(graph, neighbor, visited)
    }
  }
  
  
  depthFirstSearch(graph, 'a', new Set())

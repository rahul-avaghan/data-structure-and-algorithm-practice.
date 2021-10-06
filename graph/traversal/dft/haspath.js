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


  const hasPath = (graph, src, dst, visited) => {
    if(visited.has(src)){
      return;
    }
    console.log(src);
    visited.add(src);
    if(dst === src){
        return true;
    }
  
    for (const neighbor of graph[src]) {
        hasPath(graph, neighbor, dst, visited)
    }
  }

  hasPath(graph, 'a', 'e');
  hasPath(graph, 'a', 'a');
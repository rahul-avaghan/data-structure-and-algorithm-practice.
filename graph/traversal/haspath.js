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
  
    visited.add(src);
    if(dst === src){
        return true;
    }
  
    for (const neighbor of graph[src]) {
        if(hasPath(graph, neighbor, dst, visited)){
          return true;
        }
    }
    return false;
  }

  console.log(hasPath(graph, 'f', 'e', new Set()));
  console.log(hasPath(graph, 'a', 'a', new Set()));

  ;
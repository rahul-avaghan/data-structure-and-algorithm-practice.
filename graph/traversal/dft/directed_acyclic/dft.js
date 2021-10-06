let graph = {
    a: ['b', 'c'],
    b: ['d'],
    c: ['e'],
    d: ['f',],
    e: [],
    f: [],
  }
  
  graph = {
    a: ['b', 'c'],
    b: [],
    c: ['e', 'd'],
    d: [],
    e: ['f'],
    f: [],
  }
  // non recursive
  // function depthFirstSearch(graph, source){
  
  //   const stack = [];
  //   stack.push(source)
  
  //   while( stack.length > 0 ){
  //     const present = stack.pop();
  //     console.log(present)
  
  //      for(const neighbour of graph[present]){
  //        stack.push(neighbour)
  //      }
  //   }
  
  // }
  
  function depthFirstSearch(graph, source) {
    console.log(source);
    for (const neighbour of graph[source]) {
  
      depthFirstSearch(graph, neighbour)
    }
  
  }
  
  depthFirstSearch(graph, 'a')
const graph = {
    1: ['2'],
    2: ['3','1'],
    3: ['2'],
    6: [],
    9: ['9'],
    9: ['12'],
    12: [],
  };
  
  function countConnectedGraghs(graph) {
    const visited = new Set();
  
    let count = 0;
    for (const node in graph) {
     if(discover(graph,node, visited, count) === true){
        count++;
     }
    }
    return count;
  }
  
  function discover(graph,node, visited, count) {
    if(visited.has(String(node))) return false;
  
    visited.add(String(node));
    for(const neighbor of graph[node]){
      discover(graph,neighbor,visited, count)
    }
    return true;
  }
  
  console.log(countConnectedGraghs(graph));

/***
 * 
 * 
 *  1 -> 
 * 
 * 
 * 
 * 
 */



 largestComponent = (graph) =>{
    const count = {value: 0}
    let largestNodes = 0;
    const visited = new Set();
  
    for(const current in graph){
       const size = explore(graph,current, visited)
      if(size > largestNodes){
        largestNodes = size;
      }
    }
    console.log(largestNodes)
  }
  
  
  explore = (graph,current, visited) => {
  
    if(visited.has(String(current))) return 0;
  
    visited.add(String(current));
    let size= 1;
    for(const neighbor of graph[current]){
      size += explore(graph,neighbor, visited);
    }
  
    return size;
  }
  
  largestComponent({
    0: [8, 1, 5],
    1: [0],
    5: [0, 8],
    8: [0, 5],
    2: [3, 4],
    3: [2, 4],
    4: [3, 2]
  }) 
  
  
  largestComponent({
    1: [2],
    2: [1,8],
    6: [7],
    9: [8],
    7: [6, 8],
    8: [9, 7, 2]
  })
  //  -> 6
  largestComponent({
    3: [],
    4: [6],
    6: [4, 5, 7, 8],
    8: [6],
    7: [6],
    5: [6],
    1: [2],
    2: [1]
  })//5
  
  largestComponent({
    0: [4,7],
    1: [],
    2: [],
    3: [6],
    4: [0],
    6: [3],
    7: [0],
    8: []
  })//3
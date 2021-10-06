

largestComponent = (graph) =>{
    const count = {value: 0}
    let largestNodes = 0;
    const visited = new Set();
  
    for(const current in graph){
       explore(graph,current, count, visited)
      if(count.value > largestNodes){
        largestNodes = count.value;
      }
      count.value = 0;
    }
    console.log(largestNodes)
  }
  
  
  explore = (graph,current, count, visited) => {
  
    if(visited.has(String(current))) return false;
  
    visited.add(String(current));
    for(const neighbor of graph[current]){
      explore(graph,neighbor, count, visited);
    }
  
    count.value +=1;
    
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
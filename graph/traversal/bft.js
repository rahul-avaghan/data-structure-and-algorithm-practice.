const bredthFirstSearch = (graph, source, visited) => {
    const queue = [source];
  
    while(queue.length > 0) {
      const current = queue.shift();
        if(visited.has(current)){
      return;
    }
  
      console.log(current);
      visited.add(current);
      for(const neighbor of graph[current]){
          queue.push(neighbor);
      }
    }
  
  }
  console.log('-----------------------------------');
  bredthFirstSearch(graph, 'a', new Set())
const grid = [
  ["W", "L", "W", "W", "W"],
  ["W", "L", "W", "W", "W"],
  ["W", "W", "W", "L", "W"],
  ["W", "W", "L", "L", "W"],
  ["L", "W", "W", "L", "L"],
  ["L", "L", "W", "W", "W"],
];

const islandCount = (grid) => {
  const visited = new Set();
  let smallIsland = grid.length * grid[0].length;
  for (let r = 0; r < grid.length; r++) {
    for (let c = 0; c < grid[0].length; c++) {
      const size = explore(grid, r, c, visited);
      if (size > 0 && size < smallIsland) {
        smallIsland = size;
      }
    }
  }

  return smallIsland;
};

const explore = (grid, r, c, visited) => {
  //console.log(r,c);
  const rowIsInBound = r >= 0 && r < grid.length;
  const columnIsInBound = c >= 0 && c < grid[0].length;

  if (!rowIsInBound || !columnIsInBound) return 0;
  const pos = r + "," + c;
  if (visited.has(pos)) return 0;

  visited.add(pos);

  if (grid[r][c] === "W") return 0;
  let size = 1;
  size += explore(grid, r - 1, c, visited);
  size += explore(grid, r + 1, c, visited);
  size += explore(grid, r, c - 1, visited);
  size += explore(grid, r, c + 1, visited);

  return size;
};

console.log(islandCount(grid)); // -> 3

console.log(
  islandCount([
    ["L", "L", "L"],
    ["L", "L", "L"],
    ["L", "L", "L"],
  ])
); // -> 9

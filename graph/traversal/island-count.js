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
  let count = 0;

  for (let r = 0; r < grid.length; r++) {
    for (let c = 0; c < grid[0].length; c++) {
      if (explore(grid, r, c, visited)) {
        count++;
      }
    }
  }

  return count;
};

const explore = (grid, r, c, visited) => {
  const rowIsInBound = r >= 0 && r < grid.length;
  const columnIsInBound = c >= 0 && c < grid[0].length;

  if (!rowIsInBound || !columnIsInBound) return false;
  const identifier = r + "," + c;
  if (visited.has(identifier)) return false;

  visited.add(identifier);

  if (grid[r][c] === "W") return false;

  explore(grid, r - 1, c, visited);
  explore(grid, r + 1, c, visited);
  explore(grid, r, c - 1, visited);
  explore(grid, r, c + 1, visited);

  return true;
};

console.log(islandCount(grid)); // -> 3

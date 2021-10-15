// cansum

const bestSum = (targetSum, numbers) => {
  const table = new Array(targetSum + 1).fill(null);
  table[0] = [];

  for (let i = 0; i < targetSum; i++) {
    if (table[i]) {
        for(let num of numbers){
            const combination = [ ...table[i], num ]
            if(!table[i + num] || combination.length < table[i + num].length){
                table[num + i] = combination;
            }
        }
    }
  }
  return table[targetSum]
};

//console.log(bestSum(7,[2,4,3,9]))
console.log(bestSum(7,[2,4,3,9,4,3,3]))
console.log(bestSum(8,[2,4,3,9,4,3,3]))
console.log(bestSum(80000,[2,4,3,9,4,3,3]))

const canConstruct = (target, wordBank) => {
  const table = new Array(target.length + 1).fill(false);

  table[0] = {
      val: true,
      char: "",
    };
    let conc = "";
  for (let i = 0; i <= target.length; i++) {
    if (table[i].val === true) {
        for(let word of wordBank){
            // console.log(target.slice(i, i + word.length), word);
            if(target.slice(i, i + word.length) === word){
                table[i + word.length ] = {val: true, char: word.slice(word[word.length-1])};
                conc+=word;
               // console.log(table[i + word.length ]);
            }
        }
    }
  }
 // console.log(table);
  console.log(conc);
  return table[target.length].val;
};

console.log(canConstruct("abcdef", ["ab", "abc", "cd", "cdef", "abcd"]));
// console.log(canConstruct("spiderman", ["man", "i", "sp", "der", "abcd"]));
// [ "",  ,  , ]
// a b c d e f g

// "" + a
// "" + a + b
// "" +

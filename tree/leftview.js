class Node {
    constructor(data) {
      this.data = data;
      this.left = this.right = null;
    }
  }
  
  class BinaryTree {
    constructor(root) {
      this.root = root;
    }
  
    leftView() {
      if (this.root === null) {
        return [];
      }
      let maxLevel = 0;
      const traverse = (node, level) => {
        if (!node || node.data == null) {
          return;
        }
        level += 1;
       
        if(level > maxLevel){
          maxLevel = level;
          console.log(node.data);
        }
        traverse(node.left, level);
        traverse(node.right, level);
      };
       traverse(this.root, 0);
  
      
    }
  }
  
  const binaryTree = new BinaryTree(new Node(2));
  binaryTree.root.left = new Node(3);
  binaryTree.root.right = new Node(4);
  binaryTree.root.left.left = new Node(6);
  binaryTree.root.left.right = new Node(7);
  binaryTree.root.left.right.left = new Node(100);
  binaryTree.root.right.right = new Node(9);
  binaryTree.root.right.left = new Node(8);
  binaryTree.leftView();
  
  /*
                 2
              3     4
          6    7  8   9
  
             100
  */
  
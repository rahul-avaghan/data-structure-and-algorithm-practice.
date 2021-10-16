class BinaryTree {

    constructor() {
      this.root = null;
    }
  
    inOrderTraversal() {
      const traverse = (root) => {
        if (root == null) {
          return null;
        }
        console.log(JSON.stringify(root.data));
        traverse(root.left);
        traverse(root.right);
  
      }
      traverse(this.root);
    }
  
    preOrderTraversal() {
      console.log(JSON.stringify(root.data));
      const traverse = (root) => {
        if (root == null) {
          return null;
        }
        traverse(root.left);
        console.log(JSON.stringify(root.data));
        traverse(root.right);
  
      }
      traverse(this.root);
    }
      postOrderTraversal() {
      console.log(JSON.stringify(root.data));
      const traverse = (root) => {
        if (root == null) {
          return null;
        }
        traverse(root.left);
        console.log(JSON.stringify(root.data));
        traverse(root.right);
  
      }
      traverse(this.root);
    }
  
    levelOrderTraversal(){
        console.log('levelOrderTraversal');
     if(this.root == null) return;
  
    const queue = [];
    queue.push(this.root);
  
     while((queue.length !== 0)){
      const visitedNode =  queue.shift();
      console.log(visitedNode.data);
      visitedNode.left && queue.push(visitedNode.left);
      visitedNode.right && queue.push(visitedNode.right);
     }
    }
  }
  
  class Node {
    constructor(data) {
      this.data = data;
  
    }
  }
  
  /*
  
              a
          b      e
       c    d   f   g  
  
  
  
  */
  const tree = ['a', 'b', 'e', 'c', 'd', 'f', 'g'];
  
  function createCompleteBinaryTreeFromArray(arr) {
    const binaryTree = new BinaryTree();
    const root = new Node(tree[0]);
    const length = arr.length;
    let i = 1;
    const traverseAndReplace = (root, i) => {
      if (i < length) {
        root = new Node(arr[i])
        root.left = traverseAndReplace(root.left, 2 * i + 1)
        root.right = traverseAndReplace(root.right, 2 * i + 2)
      }
      return root;
    }
    binaryTree.root = traverseAndReplace(root, 0);
    return binaryTree;
  
  }
   createCompleteBinaryTreeFromArray(tree).levelOrderTraversal()
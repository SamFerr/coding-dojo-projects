// Binary Search a Sorted Array
function binarySearch(arr, val){
    var left = 0;
    var right = arr.length-1;
    while (left <= right){
        var guessIdx = Math.floor((right+left) / 2);
        var guessVal = arr[guessIdx];
        if (guessVal == val){
            return true;
        }
        if (guessVal < val){
            left = guessIdx+1;
        }else{
            right = guessIdx-1;
        }
    }
    return false;
}

// Binary Search Tree
// Question: Write a function to determine if a Binary Tree is a Binary Search Tree.
// https://docs.google.com/file/d/0B7kEUUtxfkFKQ3F5ZWVmZGdtSms/edit
class Node 
    {
        int data;
        Node left;
        Node right;
    }
public boolean isBST(Node root, Integer min, Integer max)
    {
        if (root == null)
            return true;
        if (min != null && min > root.data)
            return false;
        if (max != null && max <= root.data)
            return false;
        return isBST(root.left, min, root.data) &&
            isBST(root.right, root.data, max);
    }


// Nth Smallest Element in a Binary Search Tree
// Question: Write a function to find the nth smallest element in a binary search tree
class Node {
    int i;
    Node left;
    Node right;
}
public static Node nthSmallestElement(Node root,
    int n)
{
    Stack < Node > stack = new Stack<Node>();
    Node node = root;
    int i = 0;
    while (!stack.isEmpty() || node != null) {
        if (node != null) {
            stack.push(node);
            node = node.left;
        }
        else {
            node = stack.pop();
            if (++i == n)
                return node;
            node = node.right;
        }
    }
    return null;
}

// BST to Array
// Question: Write a function to convert a sorted array to a BST of minimum height. Write a function to convert a BST to a sorted array
public static Node arrayToBST(int[] array, int
    start, int end)
{
    if (end < start)
        return null;
    int mid = (start + end) / 2;
    Node n = new Node(array[mid]);
    n.left = arrayToBST(array, start, mid - 1);
    n.right = arrayToBST(array, mid + 1, end);
    return n;
}
    public static Integer[] BSTtoArray(Node root)
{
    Stack < Node > stack = new Stack<Node>();
    Node node = root;
    ArrayList < Integer > list = new
        ArrayList<Integer>();
    while (!stack.isEmpty() || node != null) {
        if (node != null) {
            stack.push(node);
            node = node.left;
        }
        else {
            node = stack.pop();
            list.add(node.data);
            node = node.right;
        }
    }
    Integer[] array = new Integer
    [list.size()];
    list.toArray(array);
    return array;
}

// Binary Tree Mirror
// Question: Write a function to determine whether a binary tree's left and right side mirror each other.
// https://docs.google.com/file/d/0B7kEUUtxfkFKdkxOQ3B3Y2Zqcnc/edit

public static boolean isMirror(Node n1, Node n2)
{
    if (n1 == null && n2 == null)
        return true;
    if (n1 == null || n2 == null)
        return false;
    if (n1.data != n2.data)
        return false;
    return isMirror(n1.left, n2.right) &&
        isMirror(n1.right, n2.left);
}


// BST Coding Dojo Stuff:
function BST(){
    this.root = null;
}

function Node(val){
    this.value = val;
    this.left = null;
    this.right = null;
}

BST.prototype.add = function(val){
    var bstNode = new Node(val);
    if (!this.root){
        this.root = bstNode;
        return this;
    }
    var current = this.root;
    while (current){
        if (current.value > val){
            if (!current.left){
                current.left = bstNode;
                return this;
            }
            current = current.left;
        } else {
            if (!current.right){
                current.right = bstNode;
                return this;
            }
            current = current.right;
        }
    }
}

BST.prototype.isEmpty = function(){
    return (!this.root);
}

BST.prototype.min = function(){
    if (this.isEmpty()){return undefined;}
    var current = this.root;
    while (current.left){
        current = current.left;
    }
    return current.value;
}

BST.prototype.max = function(){
    if (this.isEmpty()){return undefined;}
    var current = this.root;
    while (current.right){
        current = current.right;
    }
    return current.value;
}

BST.prototype.contains = function(val){
    if (this.isEmpty()){return false;}
    var current = this.root;
    while (current){
        if (current.value == val){
            return true;
        }else if(current.value > val){
            current = current.left;
        }else{
            current = current.right;
        }
    }
    return false;
}

BST.prototype.size = function(node=this.root){
    if (!node){ 
        return 0; 
    }
    return 1 + this.size(node.right) + this.size(node.left);
}


BST.prototype.height = function(node=this.root){
    var left = this.size(node.left);
    var right = this.size(node.right);
    
    if(!node) {
        return 0;
    }
    else {
        return Math.max(left, right); 
    }

BST.prototype.isBalanced = function(node=this.root){
    if (!node){ return true; }
    var left = this.height(node.left);
    var right = this.height(node.right);
    if (Math.abs(left-right) > 1){ return false; }
    return (this.isBalanced(node.left) && this.isBalanced(node.right));
    }
}



var b = new BST();
console.log(b.isEmpty());
b.add(10).add(5).add(12).add(11).add(6).add(4);
// console.log(b);
// console.log(b.isEmpty());
// console.log(b.min());
// console.log(b.max());
// console.log(b.contains(8));
// console.log(b.contains(10));
// console.log(b.contains(6));
// console.log(b.size()); // 6
console.log(b.height());



// Zig-Zag Tree Traversal
// Question: Print out items of a Binary Tree in a zig-zag fashion
// https://docs.google.com/file/d/0B7kEUUtxfkFKdFdyLWxibnZMRjA/edit

public static void zigZag(Node root)
{
    Stack < Node > s1 = new Stack<Node>();
    Stack < Node > s2 = new Stack<Node>();
    s1.push(root);
    while (!s1.isEmpty() || !s2.isEmpty()) {
        while (!s1.isEmpty()) {
            Node n = s1.pop();
            System.out.println(n.data);
            if (n.right != null)
                s2.push(n.right);
            if (n.left != null)
                s2.push(n.left);
        }
        while (!s2.isEmpty()) {
            Node n = s2.pop();
            System.out.println(n.data);
            if (n.left != null)
                s1.push(n.left);
            if (n.right != null)
                s1.push(n.right);
        }
    }
}


// Sub-Trees
// Question: Write a algorithm to determine if a tree is a sub-tree of another tree.
// Sample Answer:
public class Node {
    Object data; Node left; Node right;
}
public boolean containsTree(Node t1, Node t2) {
    if (t2 == null)
        return true; return subTree(t1, t2);
}
private boolean subTree(Node t1, Node t2) {
    if (t1 == null)
        return false; if (t1.data == t2.data)
        if (matchTree(t1, t2))
            return true; return subTree(t1.left, t2) || subTree(t1.right, t2);
}
private boolean matchTree(Node t1, Node t2) {
    if (t1 == null && t2 == null)
        return true; if (t1 == null || t2 == null) return false; if (t1.data != t2.data)
        return false; return (matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right));
}

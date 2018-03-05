function SLL(){ //class definition of SLL
    this.head = null; //head property set to null initially
    //AddFront function that adds a value, therefore node to the front of the SLL
    this.AddFront = function(val){

        //create the node
        var node = new Node(val);
        // if the head of the SLL is empty, then we can simply set the head to the new node
        if (this.head == null){
            this.head = node;
        }
        // if the head is occupied, then create a temp to also point to the head so we can manipulate
        // the head to point elsewhere and not lose our previous head node
        // set the head to the new node, then set the new node's .next to the temp (previous head)
        else{
            var temp = this.head;
            this.head = node;
            node.next = temp;
        }
    }

    // Contains -- Search the SLL for a value, if found return true, if not return false
    this.Contains = function(val){ // incoming val to search for
        var current = this.head; // set a current variable to the head of the list
        while(current){ // while there's a node, let's keep moving...
            if (current.value == val){ //...unless we find what we're looking for in the node we're currently on
                return true; // return true
            }
            current = current.next;
        } // if we finish the while loop without finding our value, return false because it isn't there
        return false;
    }

    // RemoveFront -- Remove the front node of the list and return its value. Return null if the list is empty
    this.RemoveFront = function(){
        // determine if the list is empty or not
        if (this.head) { // if not empty
            var temp = this.head; // set a temp to the head node so we don't lose it after the next step
            this.head = this.head.next; // set the head to the head node's .next
            return temp.value; // return the temp's VALUE, not the entire node itself
        }
        return null; // if the list is empty, return null instead.
    }

    this.Front = function(){
        if (this.head){
            return this.head.value;
        }
        return null;
    }

    this.Length = function(){
        var count = 0;
        var current = this.head;
        while(current){
            count++;
            current = current.next;
        }
        return count;
    }

    this.Min = function(){
        var min = null;
        if (this.head){
            min = this.head.value;
            var current = this.head.next;
            while(current){
                if (current.value < min){
                    min = current.value;
                }
                current = current.next;
            }
        }
        return min;
    }

    this.Max = function(){
        var max = null;
        if (this.head){
            max = this.head.value;
            var current = this.head.next;
            while(current){
                if (current.value > max){
                    max = current.value;
                }
                current = current.next;
            }
        }
        return max;
    }

    this.Average = function(){
        var sum = 0;
        var count = 0;
        var current = this.head;
        while (current){
            count++;
            sum += current.value;
            current = current.next;
        }
        return sum/count;
    }

    this.Display = function(){
        var str_list = "";
        var current = this.head;
        while (current){
            str_list += current.value + " => ";
            current = current.next;
        }
        console.log(str_list + "null");
    }

    this.Prepend = function(val, before){
        var node = new Node(val);
        if (!this.head){
            this.head = node;
            return this;
        }
        if (this.head.value == before){
            this.AddFront(val);
            return this;
        }
        var current = this.head;
        while (current.next){
            if (current.next.value == before){
                var temp = current.next;
                current.next = node;
                node.next = temp;
                return this;
            }
        }
        current.next = node;
        return this;
    }

    this.removeVal = function (val) {
        if (this.head == null) {
            return this;
        }
        var current = this.head;
        var temp = 0;
        while (current) {
            if (current.value == val) {
                this.head = this.head.next
                current = current.next;
                return this;
            }
            if (current.value != val) {
                current = current.next.next;
                return this;
            }
            current = current.next;
            return this;
        }
    }
}

function Node(val){ // class definition for Node
    this.value = val; // value is a property and val is the incoming value we want to set this.value to
    this.next = null; // next pointer is null as we don't assume the node have a buddy yet
}

var mySLL = new SLL();
mySLL.AddFront(5);
mySLL.AddFront(4);
mySLL.AddFront(3);
mySLL.AddFront(2);
mySLL.AddFront(1);
mySLL.AddFront(-1);

// mySLL.Prepend(999, -1);
//mySLL.Prepend(999, -2);
//mySLL.Prepend(999, 2);
//mySLL.Prepend(999, 5);
mySLL.Display();
mySLL.removeVal(4);
mySLL.Display();



// iterating through for infinite loops

function SLL(){ //class definition of SLL
    this.head = null; //head property set to null initially
    //AddFront function that adds a value, therefore node to the front of the SLL
    this.AddFront = function(val){

        //create the node
        var node = new Node(val);
        // if the head of the SLL is empty, then we can simply set the head to the new node
        if (this.head == null){
            this.head = node;
        }
        // if the head is occupied, then create a temp to also point to the head so we can manipulate
        // the head to point elsewhere and not lose our previous head node
        // set the head to the new node, then set the new node's .next to the temp (previous head)
        else{
            var temp = this.head;
            this.head = node;
            node.next = temp;
        }
    }

    // Contains -- Search the SLL for a value, if found return true, if not return false
    this.Contains = function(val){ // incoming val to search for
        var current = this.head; // set a current variable to the head of the list
        while(current){ // while there's a node, let's keep moving...
            if (current.value == val){ //...unless we find what we're looking for in the node we're currently on
                return true; // return true
            }
            current = current.next;
        } // if we finish the while loop without finding our value, return false because it isn't there
        return false;
    }

    // RemoveFront -- Remove the front node of the list and return its value. Return null if the list is empty
    this.RemoveFront = function(){
        // determine if the list is empty or not
        if (this.head) { // if not empty
            var temp = this.head; // set a temp to the head node so we don't lose it after the next step
            this.head = this.head.next; // set the head to the head node's .next
            return temp.value; // return the temp's VALUE, not the entire node itself
        }
        return null; // if the list is empty, return null instead.
    }

    this.Front = function(){
        if (this.head){
            return this.head.value;
        }
        return null;
    }

    this.Length = function(){
        var count = 0;
        var current = this.head;
        while(current){
            count++;
            current = current.next;
        }
        return count;
    }

    this.Min = function(){
        var min = null;
        if (this.head){
            min = this.head.value;
            var current = this.head.next;
            while(current){
                if (current.value < min){
                    min = current.value;
                }
                current = current.next;
            }
        }
        return min;
    }

    this.Max = function(){
        var max = null;
        if (this.head){
            max = this.head.value;
            var current = this.head.next;
            while(current){
                if (current.value > max){
                    max = current.value;
                }
                current = current.next;
            }
        }
        return max;
    }

    this.Average = function(){
        var sum = 0;
        var count = 0;
        var current = this.head;
        while (current){
            count++;
            sum += current.value;
            current = current.next;
        }
        return sum/count;
    }

    this.Display = function(){
        var str_list = "";
        var current = this.head;
        while (current){
            str_list += current.value + " => ";
            current = current.next;
        }
        console.log(str_list + "null");
    }

    this.Prepend = function(val, before){
        var node = new Node(val);
        if (!this.head){
            this.head = node;
            return this;
        }
        if (this.head.value == before){
            this.AddFront(val);
            return this;
        }
        var current = this.head;
        while (current.next){
            if (current.next.value == before){
                var temp = current.next;
                current.next = node;
                node.next = temp;
                return this;
            }
        }
        current.next = node;
        return this; 
    }

    this.Remove = function(val){
        if (!this.head){
            return this;
        }
        if (this.head.value == val){
            this.head = this.head.next;
            return this;
        }
        var current = this.head;
        while (current.next){
            if (current.next.value == val){
                current.next = current.next.next;
                return this;
            }
            current = current.next;
        }
        return this;
    }

    this.HasLoop = function(){
        if (!this.head){ return false; }
        var runner = this.head.next;
        var walker = this.head;
        while (runner && runner.next) {
            if (runner == walker){
                return true;
            }
            runner = runner.next.next;
            walker = walker.next;
        }
        return false;
    }
}

function Node(val){ // class definition for Node
    this.value = val; // value is a property and val is the incoming value we want to set this.value to
    this.next = null; // next pointer is null as we don't assume the node have a buddy yet
}

var mySLL = new SLL();

var node1 = new Node(1);
var node2 = new Node(2);
var node3 = new Node(3);
var node4 = new Node(4);
var node5 = new Node(5);

mySLL.head = node1;
node1.next = node2;
node2.next = node3;
node3.next = node4;
node4.next = node5;
node5.next = node3; //loopage

console.log(mySLL.HasLoop()); // true
// mySLL.Display();



// Reverse Linked List
// Question: Write a function to reverse a singly-linked list.

private class Node {
    Object data;
    Node next;
}
private static Node reverseList(Node head)
{
    Node newHead = null;
    while (head != null) {
        Node temp = head.next;
        head.next = newHead;
        newHead = head;
        head = temp;
    }
    return newHead;
}




// // arrays 

// x = [0,1,2]

// // contigus memory - there is a limit to it


// // SLLs 

// functionSLL(){
//     this.head = null;
// }
// var mySLL = newSLL();
// console.log(mySLL);
// {head:null}

function SLL() {
    this.head = null;
    // AddFront
    this.AddFront = function (val) {
        var node = new Node(val);
        if (this.head == null) {
            this.head = node;
        }
        else {
            var temp = this.head;
            this.head = node;
            node.next = temp;
        }
    }

    this.Contain = function (val) {
        var current = this.head;
        while (current) {
            if (current.value == val) {
                return true;
            }
            current = current.next
        }
        return false;
    }

    this.removefront = function () {
        var current = this.head;
        if (current) {
            this.head = this.head.next;
            return current.val;
        }
        else {
            return null;
        }
    }

    this.Maximum = function (){
        var current = this.head;
        var max = this.head;
        while (current){
            if (current.next > current){
                max = current.next;
                current = current.next;
            }
            else{
                current = current.next;
            }
        }
        return max;
    }

    this.Minimum = function (){
        var current = this.head;
        var min = this.head;
        while (current){
            if (current.next < current){
                min = current.next;
                current = current.next;
            }
            else{
                current=current.next;
            }
        }
        return min;
    }

    this.Length = function (){
        var current = this.head;
        var counter = 1;
        while (current){
            current = current.next;
            counter +=1;
        }
        return counter;
    }

    this.Display = function(){
        var string = "";
        if (this.head == null){
            return null;
        }
        var current = this.head;
        while(current){
            string = current.value + " => ";
        }
        return string;
    }
}

function Node(val) {
    this.value = val;
    this.next = null;
}

var mySLL = new mySLL();
var NodeA = new Node(10);
var NodeB = new Node(234);
var NodeC = new Node(206);

NodeA.next = NodeB;
NodeB.next = NodeC;
mySLL.head = NodeA;

console.log(mySLL);
console.log(NodeA);
//AddFront


// recursive SLL
function rSLL(node){
    if(!node){
        return 0;
    }
    else{
        return 1 + rSLL(node.next);
    }
}

var mySLL = new SLL();
mySLL.rSLL(5);
mySLL.rSLL(4);
mySLL.rSLL(3);

console.log(rSLL(mySll.head));



// Converging Linked Lists
// Question: Write a function to determine whether two singly-linked lists converge. Write a function to find the intersection between two singly-linked lists.

public class Node {
    int value;
    Node next;
}
public static boolean listsConverge(Node head1,
    Node head2)
{
    if (head1 == null || head2 == null)
        return false;
    while (head1.next != null)
        head1 = head1.next;
    while (head2.next != null)
        head2 = head2.next;
    return head1.equals(head2);
}
public static Node listsIntersection(Node head1,
    Node head2)
{
    if (head1 == null || head2 == null)
        return null;
    int list1Length = 0;
    int list2Length = 0;
    Node n = head1;
    while (n != null) {
        list1Length++;
        n = n.next;
    }
    n = head2;
    while (n != null) {
        list2Length++;
        n = n.next;
    }
    while (list1Length > list2Length) {
        head1 = head1.next;
        list1Length - ;
    }
    while (list2Length > list1Length) {
        head2 = head2.next;
        list2Length - ;
    }
    while (head1 != null) {
        if (head1.equals(head2))
            return head1;
        head1 = head1.next;
        head2 = head2.next;
    }
    return null;
}


// FRONT - Retun the value at the head of the list. If Null return null

this.Front = function () {
    if (this.head != null) {
        return this.head;
    }
    else {
        return null;
    }
}

// Length. Make length and front function of the SLL class
this.Length = function () {
    var current = this.head;
    var counter = 1;
    while (current) {
        current = current.next;
        counter += 1;
    }
    return counter;
}

// Minimum

this.Minimum = function () {
    if (this.head == null) {
        return null;
    }
    var current = this.head;
    var min = this.head.value;
    while (current) {
        if (current.value < min) {
            min = current.value;
        }
        current = current.next;
    }
    return min;
}


// Max

this.Maximum = function () {
    if (this.head == null) {
        return null;
    }
    var current = this.head;
    var max = this.head.value;
    while (current) {
        if (current.value > max) {
            max = current.value;
            current = current.next;
        }
        current = current.next;
    }
    return max;
}


// Average 

this.Average = function () {
    var counter = 0;
    var sum = 0;
    var temp = this.head;
    while (temp != null){
        counter++;
        sum = sum + temp.value;
        temp = temp.next;
    }
    return sum / counter;
}

// Display()
// 5 -> 4 -> 3 -> 2 -> 1 
// then print this with those values and arrows
this.Display = function(){
    var string = "";
    if (this.head == null){
        return null;
    }
    var current = this.head;
    while(current){
        string = current.value + " => ";
    }
    return string;
}




// Prepend (0,3) 
this.Prepend = function(val, before){
    var node = new Node(val);
    if (!this.head){
        this.head = node;
        return this;
    }
    if (this.head.value == before){
        this.AddFront(val);
        return this;
    }
    var current = this.head;
    while (current.next){
        if (current.next.value == before){
            var temp = current.next;
            current.next = node;
            node.next = temp;
            return this;
        }
    }
    current.next = node;
    return this; 
}
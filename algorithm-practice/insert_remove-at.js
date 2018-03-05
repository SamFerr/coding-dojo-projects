var sam_array =[2,4,8]
// Insert At
InsertAt(sam_array, 1, 666)

function InsertAt(arr, idx, val){
    var x = idx +1;
    var y = arr.length;
    for(var i=y; i>idx; i--){
        arr[i] = arr[i-1];
    }
    arr[idx] = val;
}

console.log(sam_array)

// Remove At
function RemoveAt(arr,idx);{
    var; x = arr[idx]
    for(var i=x; i<arr.length-1; i++){
        arr[i]=arr[i+1];
    }
    arr.length = arr.length-1;
    return x
}

function removeAt(arr, idx){
    if (idx >= 0 && idx < arr.length){
        var temp = arr[idx];
        for(var i = idx; i < arr.length; i++){
            arr[i]=arr[i+1];
        }
        arr.length--;
        return temp;
    }
    return null;
}


// Missing Spaces
// Question: You are given a sentence with no spaces and dictionary containing thousands of words. Write an algorithm to reconstruct the sentence by inserting spaces in the appropriate positions.
// Example: input: "theskyisblue" output: "the sky is blue" input: "thegrassisgreen" output: "the grass is green"
// Sample Answer:
public static String makeSentence(String str, Set < String > dictionary)
{
    char[] array = str.toCharArray();
    StringBuilder prefix = new StringBuilder();
    for (int i = 0; i < array.length; i++) {
        prefix.append(array[i]);
        if (dictionary.contains(prefix.toString())) {
            if (prefix.length() == array.length)
                return prefix.toString();
            String suffix = makeSentence(new String(array, prefix.length(), array.length - prefix.length()), dictionary);
            if (suffix != null) {
                prefix.append(" ");
                prefix.append(suffix);
                return prefix.toString();
            }
        }
    }
    return null;
}
// If the candidate proposes a solution that doesn't backtrack, here's a simple test case that illustrates the need for backtracking. Imagine that the input string is "thesisparty", and the dictionary is exactly (in this order) {"party", "the", "thesis"}. A naive non-backtracking solution would find the word "the" in the dictionary, then would fail to find "sisparty" and give up. A backtracking solution would of course find "thesis party".


// Remove Blanks 
function RemoveBlanks(){
    myname ="Jayme"
    sayit=""
    for(var i=0; i<myname.length; i++){
        if(" " == myname[i]){
            sayit += myname[i];        }
    }
    return sayit;
}


// Remove Duplicates
arr = [1, 1, 5, 5, 7, 7];

function RemoveDupes(arr);
    for (i = 0; i < arr.length; i++) {
        if (arr[i] === arr[i + 1]) {
            arr.pop(i + 1);
        }
    }
console.log(arr)

function RemoveDupes(arr);
var minArr=[];
var idx = 0;

while(idx<arr.length){
    if(idx==0){ newArr.push(arr[0]);}
    if(arr[idx]!= newArr[newArr.length-1]){
        newArr.push(arr[idx]);
    }
    idx++;
}




 
 // Remove Value
this.removeVal = function (val) {
    if (this.head == null) {
        return this;
    }
    var current = this.head;
    var temp = 0;
    while (current) {
        if (current.value == val) {
            var temp = current;
            current = current.next;
            return this;
        }
        if (current.value != val) {
            var temp = current;
            current = current.next;
            return this;
        }
        current = current.next;            
        return this;
    }
}



// REMOVE FRONT: remove the head node and return the value of that node. access the value not the node. Return the value but preserve the list. List stays in tact
function removefront() {
    var current = this.head;
    if (current) {
        this.head = this.head.next;
        return current.val;
    }
    else {
        return null;
    }
}

var mySLL = new mySLL();
var NodeA = new Node(10);
var NodeB = new Node(9);
var NodeC = new Node(8);

NodeA.next = NodeB;
NodeB.next = NodeC;
mySLL.head = NodeA;

removefront()
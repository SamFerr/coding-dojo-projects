// Maximum Sub Array
// Question: Given an array with at least one positive integer, find the contiguous sub-array with the largest sum. For example, for the sequence of values −2, 1, −3, 4, −1, 2, 1, −5, 4; the contiguous sub- array with the largest sum is 4, −1, 2, 1, with sum 6.
// Sample Answer:
public static int[] maxSubArray(int[] array) {
    int starting_index = 0; int length = 0; int sum = 0;
    int t_starting_index = 0; int t_length = 0; int t_sum = 0;
    for (int i = 0; i < array.length; i++) {
        if (t_sum + array[i] > 0) {
            t_sum += array[i]; t_length++;
            if (t_sum > sum) {
                sum = t_sum; length = t_length; starting_index = t_starting_index;
            }
        } else {
            t_sum = 0; t_length = 0; t_starting_index = i + 1;
        }
    }
    int[] sub = new int[length];
    System.arraycopy(array, starting_index, sub, 0, length);
    return sub;
}
// Solution to find the max sum:
public static int maxSubArray(int[] array) {
    int max_ending_here = 0; int max_so_far = 0;
    for (int i: array) {
        max_ending_here = Math.max(0, max_ending_here + i);
        max_so_far = Math.max(max_so_far, max_ending_here);
    }
    return max_so_far;
}


// concat
function concat(arr1, arr2) {
    var newarr = [];
    for (var i = 0; i < arr1.length; i++) {
        newarr.push(arr1[i]);
    }
    for (var i = 0; i < arr2.length; i++) {
        newarr.push(arr2[i]);
    }
    return newarr;
}
var arr1 = [1, 2, 3, 4];
var arr2 = ["a", "b", "c"];
var superarray = concat(arr1, arr2);

console.log(superarray);

// reverse
function reverse(arr) {
    var newarr = []
    for (var i = arr.length - 1; i >= 0; i--) {
        newarr.push(arr[i]);
    }
    return newarr;
}
console.log(reverse([1,2,3,4]));


//*new arr putting the minimum to the front
function MinToFront(arr){
    for(var i = minidx; i>0; i--){
        arr[i]=arr
}


function fizzBuzz(){
    // iterate from 1 to 100
     for(var i = 1; i <= 100; i++){
         // both print "FizzBuzz"
         if (i % 3 === 0 && i % 5 === 0){
             console.log("FizzBuzz");
         }
         // if number is evenly divisible by 3, print "Fizz"
         else if (i % 3 === 0){
             console.log("Fizz");
         }
         // if number is evenly divisible by 5, print "Buzz"
         else if (i % 5 === 0){
             console.log("Buzz");
         }
         // if none print the number
         else {
             console.log(i);
         }
     }
 }
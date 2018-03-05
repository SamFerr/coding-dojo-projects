// CONTAINS: function takes in a value. see if value is in the list. if it is, return true as soon as you find it. otherwise return false
function Contain(val) {

    var current = this.head;

    while (current) {
        if (current.value == val) {
            return true;
        }
        current = current.next
    }
    return false;
}

// Missing Number
// Question: Find the missing number in an array of consecutive integers.
// Example: input:2,3,4,5,6,7,8,9,10,11,12,13,14,15 output: null input:2,3,5,6,7,8,9,10,11,12,13,14,15 output: 4 input:2,3,4,5,6,7,8,9,10,11,12,14,15 output: 13
// Sample Answer:
public static Integer missingNumber(int[] array) {
    int low = 0; int high = array.length - 1;
    int mid;
    while (low < high) {
        mid = (low + high) / 2;
        if (mid - low == array[mid] - array[low]) {
            if (mid + 1 < array.length && array[mid] + 1 != array[mid + 1])
                return array[mid] + 1;
            else
                low = mid + 1;
        } else {
            if (mid - 1 > -1 && array[mid] - 1 != array[mid - 1])
                return array[mid] - 1;
            else
                high = mid - 1;
        }
    }
    return null;
}


//Iterate through an array and print the values
//Example: given [-1,15,"Amazon",true], print the values -1 15 "Amazon" true
for (var i=0; i <arr.length; i++){
    console.log(arr[i]);
}

//Given an array, replace any negative values with the string "Amazon"
//Example: given [-1,0,2], alter the array to be ["Amazon", 0, 2]
for(var i=0; i < arr.length; i++){
    if(arr[i] <0){
        arr[i] = "Amazon"
    }
    console.log(arr)
}
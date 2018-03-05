//Bubble Sort
function bubbleSort(arr){
    var arrSize = arr.length;
    do {
        var swap = false;
        for (var i = 0; i < arrSize; i++){
            if (arr[i] > arr[i+1]){
                var temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
                swap = true;
            }
        }
        arrSize--;
    } while(swap);
}
var arr1 = [0,1,2,3,4,5];
var arr2 = [3,1,5,2,4,0];
bubbleSort(arr1);
bubbleSort(arr2);
console.log(arr1);
console.log(arr2);



//Insertion Sort
function insertionSort(arr){
    for (var i = 1; i < arr.length; i++){
        var num = arr[i];
        var runner = i;
        while (num < arr[runner-1] && runner > 0){
            arr[runner] = arr[runner-1];
            runner--;
        }
        arr[runner] = num;
        console.log(arr);
    }
}

var arr1 = [5,2,4,3,0,1];
insertionSort(arr1);
console.log(arr1);



//Merge Sort
function merge(arr1, arr2){
    var newArr = [];
    var idx1 = 0;
    var idx2 = 0;
    while (idx1 < arr1.length && idx2 < arr2.length) {
        if (arr1[idx1] < arr2[idx2]){
            newArr.push(arr1[idx1]);
            idx1++;
        } else {
            newArr.push(arr2[idx2]);
            idx2++;
        }
    }
    while (idx1 < arr1.length){
        newArr.push(arr1[idx1++]);
    }
    while (idx2 < arr2.length){
        newArr.push(arr2[idx2++]);
    }
    return newArr;
}

console.log(merge([2,5,6], [1,3,4,7]));
// [1,2,3,4,5,6,7];


// Merge Two Sorted Lists
// Question: Write a function, that given two sorted lists of integers as input, returns a single sorted list with items from both lists with no duplicate elements.
// Example:
// input: a = {1,2,3}; b = {4,5,6}; output: c = {1,2,3,4,5,6};
// input: a = {7,8,9}; b = {1,8,20,24}; output: c = {1,7,8,9,20,24};
// input: a = {3,3,4}; b = {4}; output: c = {3,4};
// input: a = {1,2,2,3,3,4,5,6,7}; b = {4,5,6,7,8,8,8}; output: c = {1,2,3,4,5,6,7,8};

public static List < Integer > merge(int[] a, int[]
    b)
{
    List < Integer > list = new
        ArrayList<Integer>();
    int a_index = 0;
    int b_index = 0;
    Integer i = null;
    while (a_index < a.length && b_index <
        b.length) {
        if (a[a_index] < b[b_index]) {
            if (i == null || i <
                a[a_index]) {
                i = a[a_index];
                list.add(i);
            }
            a_index++;
        }
        else {
            if (i == null || i <
                b[b_index]) {
                i = b[b_index];
                list.add(i);
            }
            b_index++;
        }
    }
    while (a_index < a.length) {
        if (i == null || i < a[a_index]) {
            i = a[a_index];
            list.add(i);
        }
        a_index++;
    }
    while (b_index < b.length) {
        if (i == null || i < b[b_index]) {
            i = b[b_index];
            list.add(i);
        }
        b_index++;
    }
    return list;
}
    

// QuickSort
function partition(arr, start, end)
    return i;

function rQuickSort(partition(arr), arr){
    start = 0
    end = arr.length - 1

    if(partition(arr)-1 <=1 && partition(arr) +1 <= arr.length - 1){
        return arr;
    }

    else if(arr[partition(arr) - 2] > 1)
        end = partition(arr) - 1
        return(rQuickSort(partition, start, end))

    else if(arr[partition(arr)+2 < arr.length-1]){
        return(rQuickSort(partition, start, end))
    }
}

// Todd's solution
//Quick Sort w/ Partition
function partition(arr, start, end){
    var partIdx = start;
    var num = arr[start];




//Selection Sort
function selectionSort(arr){
    for (var i = 0; i < arr.length; i++){
        var maxIdx = 0;
        for (var j = 1; j < arr.length-i; j++){
            if (arr[j] > arr[maxIdx]){
                maxIdx = j;
            }
        }
        var temp = arr[arr.length-i-1];
        arr[arr.length-i-1] = arr[maxIdx];
        arr[maxIdx] = temp;
    }
}
var arr1 = [5,3,1,6,2,0,4];
selectionSort(arr1);
console.log(arr1);



// Merging Lists
// Question: Write a function to merge n sorted lists into a single sorted list

public static List<Integer>
mergeLists(List<List<Integer>> lists)
{
if(lists.size() == 1)
return lists.get(0);
List<List<Integer>> list1 = new
ArrayList<List<Integer>>();
List<List<Integer>> list2 = new
ArrayList<List<Integer>>();
for(int i = 0; i < lists.size()/2; i++)
list1.add(lists.get(i));
for(int i = lists.size()/2; i <
lists.size(); i++)
list2.add(lists.get(i));
List<Integer> mergedList1 =
mergeLists(list1);
List<Integer> mergedList2 =
mergeLists(list2);
List<Integer> mergedOutput = new
ArrayList<Integer>();
int index1 = 0;
int index2 = 0;
while(index1 < mergedList1.size() &&
index2 < mergedList2.size())
if(mergedList1.get(index1)
<mergedList2.get(index2))
mergedOutput.add(mergedList1.get(index1++));
else
mergedOutput.add(mergedList2.get(index2++));
while(index1 < mergedList1.size())
mergedOutput.add(mergedList1.get(index1++));
while(index2 < mergedList2.size())
mergedOutput.add(mergedList2.get(index2++));
return mergedOutput;
}
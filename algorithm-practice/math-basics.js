//Print the values from 1 to 255... 1 2 3 4 5 6 ... 255
function ger_array(){
    for(var idx = 1; idx <256; idx++){
        console.log(idx);
}

//Print ODD values from 1 to 255... 1 3 5 7 9 11 ... 255
function get_array(){
    for(var idx = 1; idx <256; idx++){
        if(idx % 2 == 1)
        console.log(idx);

//Given an array, find the minimum and print it
var min = arr[0];
for(var i=1; i<arr.length; i++){
    if(min > arr[i]){
        min = arr[i]
    }
    console.log(min)
}

// Smallest k Integers
// Question: Write a function to find the smallest k integers in a list/stream.
// Sample Answer:
// comment (ujaved): This solution's time complexity is O(NlogN), where N is the number of elements in the streams. There's a solution with O(Nlogk) that uses a max heap priority queue of size K, representing the smallest k integers at any time. Whenever we have the max element greater than the integer i from the stream we replace it with i.
public static List < Integer > smallestKIntegers(Iterator < Integer > stream, int k)
            {
                List < Integer > list = new ArrayList<Integer>();
                Queue < Integer > minHeap = new PriorityQueue<Integer>();
                while (stream.hasNext()) {
                    minHeap.add(stream.next());
                }
                for (int i = 0; i < k; i++) {
                    if (minHeap.isEmpty()) {
                        break;
                    }
                    list.add(minHeap.poll());
                }
                return list;
            }


//Given an array, find the min, max, and average and print them
function maxMinAvg(arr) {
    
    var max = arr[0];
    var min = arr[0];
    var sum = arr[0];
        for (var i = 1; i < arr.length; i++){
            if (max < arr[i]){
                max = arr[i];
            }   
            if (min > arr[i]){
                min = arr[i];
            }
        sum = sum + arr[i];
        }
        
    var avg = sum / arr.length;
    var arrnew = [max, min, avg];
        return arrnew; 
    }



//Build and return an array of odd numbers from 1 to 255
for(var i=0; i<256; i++){
    if(i%2==0){
        console.log(arr[i])
    }
}


// Median Value
// Question: Write a function to find the median value from a stream of integers.

public static Double median(Iterator < Integer >
    iterator)
{
    Queue < Integer > minHeap = new
        PriorityQueue<Integer>();
    Queue < Integer > maxHeap = new
        PriorityQueue<Integer>(20, Collections.reverseOrder());
    int numOfElements = 0;
    while (iterator.hasNext()) {
        maxHeap.add(iterator.next());
        if (numOfElements % 2 == 0) {
            if (!minHeap.isEmpty() &&
                maxHeap.peek() > minHeap.peek()) {
                Integer
                maxHeapRoot = maxHeap.poll();
                Integer
                minHeapRoot = minHeap.poll();
                maxHeap.add(minHeapRoot);
                minHeap.add(maxHeapRoot);
            }
        }
        else {
            minHeap.add(maxHeap.poll());
        }
        numOfElements++;
    }
    if (numOfElements % 2 != 0)
        return
    maxHeap.peek().doubleValue();
    return (maxHeap.peek() + minHeap.peek())
        / 2.0;
}




// Square Roots
// Question: Write a function to find the square root of an integer.
// Sample Answer:
public static double sqrt(int a) {
    if (a < 0)
        throw new IllegalArgumentException();
    double max = a; double min = 0.0; Double result = null; Double estimate = null;
    while (estimate == null || Math.abs(estimate) > .001) {
        result = (max + min) / 2;
        estimate = result * result - a;
        if (estimate > 0)
            max = result; else
            min = result;
    }
    return result;
}
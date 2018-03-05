//Partition

function partition(arr){
    var partIdx = 0;
    var num = arr[0];
    for (var i = 0; i < arr.length; i++){
        if (arr[i] < num){
            partIdx++;
            var temp = arr[i];
            arr[i] = arr[partIdx];
            arr[partIdx] = temp;
        }
    }
    arr[0] = arr[partIdx];
    arr[partIdx] = num;
    return partIdx;
}
var arr1 = [5,2,6,7,1,3];
console.log(partition(arr1));
console.log(arr1);
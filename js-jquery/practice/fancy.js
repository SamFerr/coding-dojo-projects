var array = ["James", "Jill", "Jane", "Jack"];
function fancyPrint(arr){
  for (var i = 0; i < arr.length; i++) {
    console.log(`${i} -> ${arr[i]}`)
  }
}
fancyPrint(array, "-")
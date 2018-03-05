function time(HOUR, MINUTE, PERIOD){

var h = "";
var m = "";
var p = "";


if (period = "AM"){
    p = "in the morning"
}

else if (period = "PM"){
    p = "in the evening"
}

if (MINUTE > 30){
    console.log("It's almost", HOUR+1, p)
}

else if (MINUTE < 30){
    console.log("It's just after", HOUR, p)
}

}

time(8, 50, "AM")
var daysUntilMyBirthday = 135;

for (var x = daysUntilMyBirthday; x >= 0; x--){
    if (x==0){
        console.log("♪ღ♪*•.¸¸¸.•*¨¨*•.¸¸¸.•*•♪ღ♪¸.•*¨¨*•.¸¸¸.•*•♪ღ♪•* ♪ღ♪░H░A░P░P░Y░ B░I░R░T░H░D░A░Y░░♪ღ♪ *•♪ღ♪*•.¸¸¸.•*¨¨*•.¸¸¸.•*•♪¸.•*¨¨*•.¸¸¸.•*•♪ღ♪•«")
    }
    else if (x>30){
        console.log(x + " days until my birthday. This sucks!")
    }
    else if (x < 5){
        console.log(x + "days until my birthday. SO CLOSE!")
    }
    else if (x <= 30){
        console.log(x + " days until my bday. YEAH!")
    }
}
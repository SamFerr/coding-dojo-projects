function rfib(num){
    if(num == 0)
        return 0;
    else if(num == 1)
      return 1;
   else
      return rfib(num - 1) + rfib(num - 2);
}

console.log(rfib(3));


// Stairs
// Question: A man is walking up a set of stairs. He can either take 1 or 2 steps at a time. Given n number of steps, find out how many combinations of steps he can take to reach the top of the stairs.

public static int combinations(int stairs)
{
if(stairs == 0)
return 0;
int i = 0;
int j = 1;
for(int k = 0; k <= stairs; k++)
{
int temp = j;
j+= i;
i = temp;
}
return i;
}

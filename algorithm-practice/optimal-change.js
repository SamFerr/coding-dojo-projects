// Finding optimal change returned as object

function find(num){
    var coins = {Quarters: 0, Dimes: 0, Nickels: 0, Pennies: 0};

    coins.Quarters = Math.floor(num/25);
    temp = num % 25;
    coins.Dimes = Math.floor(temp/10);
    temp = temp % 10;
    coins.Nickels = Math.floor(temp/5);
    temp = temp % 5;
    coins.Pennies = temp;
    return coins;
}

console.log(find(117));



// Making Change
// Question: For US currency, there are six coins that are in use today: 1¢, 5¢, 10¢, 25¢, 50¢, 1$. Write a function that returns the number of possible combinations of change that can be made from n ¢. Example: input: 7 output: 2 (7p, 1n 2p) input: 10 output: 4 (1d, 10p, 2n, 1n 5p) input: 15 output: 6 (1d 1n, 1d 5p, 3n, 2n 5p, 1n 10p, 15p) Sample Answer:
public static int combinations(int n) {
    return combinations(n, 100);
}
public static int combinations(int n, int m) {
    if (n < 0)
        return 0;
    if (n == 0)
        return 1;
    int combinations = 0;
    if (m == 100)
        combinations += combinations(n - 100, 100);
    if (m >= 50)
        combinations += combinations(n - 50, 50);
    if (m >= 25)
        combinations += combinations(n - 25, 25);
    if (m >= 10)
        combinations += combinations(n - 10, 10);
    if (m >= 5)
        combinations += combinations(n - 5, 5);
    combinations += combinations(n - 1, 1);
    return combinations;
}

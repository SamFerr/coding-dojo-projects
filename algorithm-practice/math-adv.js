// Co-prime numbers (Number Theory)
// Question: In number theory, two integers a and b are said to be co-prime if the only positive integer that divides evenly between both of them is 1. Given two positive integers a and b, write a function to return true if a and b are coprime.
// Sample Answer:
public static boolean isCoprime(int a, int b) {
    while (b != 0) {
        int temp = b; b = a % b; a = temp;
    } return a == 1;
}


// Dice (Probability)
// Question: Given n number of dice rolls, find the probability of rolling a 6.
// Example: input: 0 output: 0 input: 1 output: 1/6 input: 2 output: 11/36 input: 3 output: 91/216
// Sample Answer:
public static double rollingASix(int n) {
    double probability = 1;
    for (int i = 0; i < n; i++) {
        probability *= 1.0 - (1.0 / 6.0);
    }
    return 1 - probability;
}



// Random Number Generator
// Question: Write a function to generate a random number between 1 and 9 with equal probability, given a method rand6() that generates a random number between 1 and 6.
// Sample Answer:
public static int rand9() {
    return (((rand6() - 1) * 6) + (rand6() - 1)) / 4 + 1;
}



// Power Function
// Question: Write a function to compute a^b efficiently. (A and B are both positive)
// Sample Answer:
public static int power(int a, int b) //a & b are both positive
{
    if (b == 0)
        return 1;
    if (b == 1)
        return a;
    int result = power(a, b / 2);
    if (b % 2 == 0)
        return result * result;
    return result * result * a;
}



// Birthday Problem (Probability)
// Question: Find the probability that, given n people, at least a pair of them will have the same birthday. (Based off the Birthday Paradox (http://en.wikipedia.org/wiki/Birthday_problem) )
// Sample Answer:
public static double sameBirthday(int n) {
    double np = 1;
    for (int i = 0; i < n; i++)
    np *= (365.0 - i) / 365.0;
    return 1 - np;
}


// Date Difference
// Question: Write a function to find the difference in days between two valid dates.
// Sample Answer:
public static final int[] daysInMonths = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
public static int differenceInDays(int day1, int month1, int year1, int day2, int month2, int year2)
{
    int differenceInDays1 = day1 + (365 * (year1));
    int differenceInDays2 = day2 + (365 * (year2));
    for (int i = 0; i < month1 - 1; i++) differenceInDays1 += daysInMonths[i];
    for (int i = 0; i < month2 - 1; i++) differenceInDays2 += daysInMonths[i];
    differenceInDays1 += ((year1 - 1) / 4) - ((year1 - 1) / 100) + ((year1 - 1) / 400);
    differenceInDays2 += ((year2 - 1) / 4) - ((year2 - 1) / 100) + ((year2 - 1) / 400);
    if (month1 > 2 && (year1 % 400 == 0 || (year1 % 100 != 0 && year1 % 4 == 0)))
        differenceInDays1++;
    if (month2 > 2 && (year2 % 400 == 0 || (year2 % 100 != 0 && year2 % 4 == 0)))
        differenceInDays2++;
    return Math.abs(differenceInDays1 - differenceInDays2);
}
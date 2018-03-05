public class BasicJavaTest {
    public static void main(String[] args){
        BasicJava basics = new BasicJava();

        basics.oneToTwoFiftyFive();
        basics.oneToTwoFiftyFiveOdd();
        basics.printSum();
        int[] myArray = {1, 3, 5, 7, 9, 13};
        basics.iterateArray(myArray);
        basics.findMax(myArray);
        basics.getAverage(myArray);
        basics.arrayOddNumber();
        basics.greaterThanY(myArray, 5);
        basics.squareValues(myArray);
        int[] myArray2 = {1, 5, 10, -2};
        basics.eliminateNegativeNumber(myArray2);
        basics.minMaxAverage(myArray2);
        int[] myArray3 = {1, 5, 10, 7, -2};
        basics.shiftValueArray(myArray3);
    }
}
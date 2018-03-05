// Skiing
// Question: Imagine you have a 2D array that represents a ski slope (see figure below). An index with a value of 1 represents a tree. The skier can only travel right and down along the array. Write an algorithm to determine whether a clear path exists for the skier to cross the finish line.
// https://docs.google.com/file/d/0B7kEUUtxfkFKZ0oyRFdRY3lEMzQ/edit
// Sample Answer:
public static void main(String[] args) {
    int[][] mountain = new int[][] {
        { 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 1, 0, 0, 0, 0 },
        { 0, 1, 0, 0, 0, 1, 1, 1 },
        { 0, 1, 1, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 1, 1, 0, 1 },
        { 0, 0, 1, 0, 1, 0, 0, 0 },
        { 0, 0, 0, 0, 1, 0, 0, 0 }
    };
    System.out.println(pathExists(mountain, 0, 0));
}
public static boolean pathExists(int[][] array, int x, int y)
{
    if (x == array.length || y == array[x].length || array[x][y] == 1)
        return false;
    if (x == array.length - 1 && y == array[x].length - 1)
        return true;
    return pathExists(array, x + 1, y) || pathExists(array, x, y + 1);
}



// Islands
// Question: You are given a 2d array filled with 1s and 0s. A 0 represents water and a 1 represents land (see figure below). Connected 1s represent a single island. Write a function to find the number of islands from a given 2d array.
// https://docs.google.com/file/d/0B7kEUUtxfkFKVDFfSG9aVlRSaTg/edit
// Sample Answer:
public static void main(String[] args) {
    int[][] map = new int[][] {
        { 0, 0, 0, 0, 0, 0, 1, 0 },
        { 0, 0, 1, 1, 0, 0, 1, 0 },
        { 0, 0, 0, 0, 0, 1, 1, 1 },
        { 1, 1, 1, 0, 0, 0, 0, 0 },
        { 0, 1, 1, 0, 1, 1, 0, 1 },
        { 0, 0, 0, 0, 1, 0, 0, 1 },
        { 0, 1, 0, 0, 1, 0, 0, 0 }
    };
    System.out.println(numberOfIslands(map));
}
public static int numberOfIslands(int[][] map) {
    int number = 0;
    for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[x].length; j++)
        {
            if (map[i][j] == 1) {
                number++; turnToZero(map, i, j);
            }
        }
    }
    return number;
}
public static void turnToZero(int[][] map, int x, int y)
{
    if (x >= map.length || x < 0 || y >= map[x].length || y < 0 || map[x][y] == 0)
        return;
    map[x][y] = 0; turnToZero(map, x + 1, y); turnToZero(map, x, y + 1); turnToZero(map, x - 1, y); turnToZero(map, x, y - 1);
}


// Chicken Tenders (Dynamic Programming)
// Question:A local fast food restaurant sells chicken tenders in packages of 6, 9 or 20. Thus, it is possible, for example, to buy exactly 15 pieces of chicken (with one package of 6 and a second package of 9), but it is not possible to buy exactly 16 , since no non- negative integer combination of 6's, 9's and 20's add up to 16. Write a function that takes one argument, n, and returns True if it is possible to buy a combination of 6, 9 and 20 pack units such that the total number of chicken tenders equals n, and otherwise returns False.
// Sample Answer:
public static boolean chicken(int n) {
    if (n < 0)
        return false;
    if (n % 6 == 0 || n % 9 == 0 || n % 20 == 0)
        return true;
    return chicken(n - 6) || chicken(n - 9) || chicken(n - 20);
}


// Clock Angle
// Question: Write a function to find the smaller angle between the hour and minute hand on an analog clock.
// Sample Answer:
public static double angle(int hour, int min) {
    double h = (hour % 12) * 30 + (min * .5); double m = min * 6;
    double angle = Math.abs(h - m); return Math.min(angle, 360 - angle);
}

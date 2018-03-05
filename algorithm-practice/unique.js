// Unique Characters
// Question: Implement an algorithm to determine if a string has all unique characters.
// Sample Answer:
public static boolean isUnique(String str) {
    boolean[] character_set = new boolean[256];
    for (int i = 0; i < str.length(); i++) {
        int val = str.charAt(i);
        if (character_set[val])
            return false;
        character_set[val] = true;
    }
    return true;
}
head = head.next;
if (n.value == minHead.value)
    minHead = minHead.next;
return n.value; }
public Integer min() {
    if (minHead == null)
        return null;
    return minHead.value;
} }



// Longest Unique Substring
// Question: Given a string, find the longest substring that only contains unique characters. Example: input: "0a123a45a6" output: "123a45"
// Sample Answer:
public static String findLongestSubstring(String str)
{
    Set < Character > set = new HashSet<Character>();
    int currentStart = 0;
    int length = 0; int start = 0;
    char[] array = str.toCharArray();
    for (int i = 0; i < array.length; i++) {
        if (!set.contains(array[i])) {
            set.add(array[i]);
            if (i - currentStart + 1 >= length) {
                length = i - currentStart + 1;
                start = currentStart;
            }
        } else {
            Character c = array[currentStart];
            while (c.charValue() != array[i]) {
                set.remove(array[currentStart]);
                currentStart++; c = array[currentStart];
            }
            currentStart++;
        }
    }
    return str.substring(start, start + length);
}



// Duplicates
// Question: Write a function that determines whether a String contains duplicate characters within k indices of each other.
// Sample Answer:
public static boolean containsDuplicates(String str, int k)
{
    char[] array = str.toCharArray();
    boolean[] set = new boolean[256];
    for (int i = 0; i < array.length; i++) {
        char c = array[i];
        if (set[c])
            return true;
        set[c] = true;
        if (i - k >= 0)
            set[array[i - k]] = false;
    }
    return false;
}



// Duplicates
// Question: Write a function that determines whether a two-dimensional integer array contains duplicate values within k indices of each other.
// Sample Answer:
class Point {
    public int x; public int y;
    public Point(int x, int y) {
        this.x = x; this.y = y;
    }
}
public static boolean containsDuplicates(int[][] array, int k)
{
    Map < Integer, List < Point >> map = new HashMap<Integer, List<Point>>();
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array[i].length; j++)
        {
            List < Point > list = map.get(array[i][j]);
            Point p = new Point(i, j);
            if (list == null) {
                list = new ArrayList<Point>();
                map.put(array[i][j], list);
            } else {
                for (Point point : list)
                if (Math.abs(point.x - i) <= k && Math.abs(point.y - j) <= k)
                    return true;
            }
            list.add(p);
        }
    }
    return false;
}

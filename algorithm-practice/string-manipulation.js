// Get digits
function GetDigits(str){
    final = "";
        for(var i=0; i < str.length; i++){
            if(typeof(str[i]) == "number"){
             final = final+str[i];
    }
    return final;
    }
    console.log(GetDigits("0s1a3y5w7h9a2t4?6!8>0"));

// Reverse the string
function Reverse(str) {
    var newstr = ""
    for (var i = str.length - 1; i >= 0; i--) {
        newstr += str[i];
    }
    return newstr;
}
var result = Reverse("ABCDEFGHIJKLMNOPQRSTUVWXYZ")
console.log(result);


// Anagrams
// Question: Write an algorithm to determine whether two strings are anagrams or not.
// Sample Answer:
public static boolean isAnagram(String str1, String str2)
{
    if (str1.length() != str2.length())
        return false;
    int[] character_set = new int[256];
    for (int i = 0; i < str1.length(); i++) {
        character_set[str1.charAt(i)]++; character_set[str2.charAt(i)]--;
    }
    for (int i = 0; i < str1.length(); i++)
    if (character_set[str1.charAt(i)] != 0)
        return false;
    return true;
}


// String Permutations
// Question: Find all permutations of a String.
// Example: input: abcd output: dcba, cdba, cbda, cbad, dbca, bdca, bcda, bcad, dbac, bdac, badc, bacd, dcab, cdab, cadb, cabd, dacb, adcb, acdb, acbd, dabc, adbc, abdc, abcd
// Sample Answer:
public static ArrayList < String > findPermutations(String str)
{
    ArrayList < String > permutations = new ArrayList<String>();
    permutations.add(new String());
    char[] strArray = str.toCharArray();
    for (char c : strArray) {
        ArrayList < String > tempList = new ArrayList<String>();
        for (String s: permutations) {
            for (int i = 0; i < s.length(); i++)
            tempList.add(new String(s.substring(0, i) + c + s.substring(i, s.length())));
            tempList.add(new String(s + c));
        }
        permutations = tempList;
    }
    return permutations;
}



// Password Suggestions
// Question: You are designing a New User sign-up form for a website. When a user enters text in the password field, you want to suggest possible 'stronger' passwords to the user by swapping in special characters, like turning an "a" into an "@". Given a password represented as a string and a character map that contains common characters and substitutions, create a list of all possible password combinations that can be created.
// Example:
// Input: Map:{{'i','!'},{'a','@'},{'s','$'},{'o','0'}, {'E','3'}} Password: password
// Output: p@ssword p@$sword pa$sword p@s$word p@$$word pa$$word pas$word p@ssw0rd p@$sw0rd pa$sw0rd p@s$w0rd p@$$w0rd pa$$w0rd pas$w0rd passw0rd
// Sample Answer:
public static List < String > getPasswords(String password, Map < Character, Character > map)
{
    List < String > passwords = new ArrayList<String>();
    char[] array = password.toCharArray();
    for (int i = 0; i < array.length; i++) {
        Character sub = map.get(array[i]);
        if (sub != null) {
            int length = passwords.size();
            for (int j = 0; j < length; j++)
            {
                String str = passwords.get(j);
                passwords.add(new String(str.substring(0, i) + sub + str.substring(i + 1)));
            }
            passwords.add(new String(password.substring(0, i) + sub + password.substring(i + 1)));
        }
    }
    return passwords;
}
Alternate answer
static Map < Character, Character > cMap;
public static void main(String[] args) throws java.lang.Exception
{
    cMap = new HashMap(); cMap.put('i', '!'); cMap.put('a', '@'); cMap.put('s', '$'); cMap.put('o', '0'); cMap.put('E', '3');
    String inputStr = new String("password"); printPasswords(inputStr, 0, new String());
}
public static void printPasswords(String inputStr, int position, String outputStr)
{
    if (position == inputStr.length()) {
        System.out.println(outputStr); return;
    }
    Character sub = cMap.get(inputStr.charAt(position));
    if (sub != null) {
        outputStr += sub; printPasswords(inputStr, position + 1, outputStr);
        outputStr = outputStr.substring(0, outputStr.length() - 1);
    } outputStr += inputStr.charAt(position);
    printPasswords(inputStr, position + 1, outputStr);
}



// Substrings
// Question: Find the longest common substring between two texts.
// Sample Answer:
private static String longestCommonSubstring(String s1, String s2)
{
    int start = 0; int length = 0;
    for (int i = 0; i < s1.length(); i++) {
        for (int j = 0; j < s2.length(); j++) {
            int x = 0;
            while (s1.charAt(i + x) == s2.charAt(j + x)) {
                x++; if (((i + x) >= s1.length()) || ((j + x) >= s2.length())) break;
            } if (x > length) {
                length = x; start = i;
            }
        }
    } return s1.substring(start, (start + length));
}



// String Rotations
// Question: In Java, the String class includes the function contains(CharSequence s) that returns true if the string contains the given sequence of values. Given two strings, write a function to determine if one string is a rotation of another string.
// Example:
// input: {"computerscience","tersciencecompu"} output: true
// Sample Answer:
public static boolean isRotation(String str1, String str2)
{
    if (str1 == null || str2 == null)
        return false;
    if (str1.length() != str2.length())
        return false;
    String s = str1 + str1;
    return s.contains(str2);
}



// Palindrome
// Question: Write a function to find out whether a string is a palindrome.
// Sample Answer:
public static boolean isPalindrome(String input) {
    int i = 0; int j = input.length() - 1;
    while (i < j) {
        if (input.charAt(i) != input.charAt(j)) {
            return false;
        } i++; j--;
    }
    return true;
}

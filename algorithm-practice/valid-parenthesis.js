// Is the parenthesis valid "()"
// Time complexity: O(n)
function isValidParentheses(str) {
    var i = 0, l = str.length, arr = [];
    if (!l) {
        return true;
    }

    if ((l % 2) !== 0) {
        return false;
    }

    while (i < l) {
        var s = str[i];
        if (s == "{") {
            arr.push(s);
        } else if (s == "}") {
            if (arr.length) {
                arr.pop();
            } else {
                return false;
            }
        }
        i++;
    }
    return true;
}

console.log(isValidParentheses("{{{}}}")); // true
isValidParentheses("{{}{}}"); // true
isValidParentheses("{}{{}}"); // true
console.log(isValidParentheses("}{}{")); // false



var ParensValid = function(str) {
    var stack = [];
    var open = { '{': '}', '[': ']', '(': ')' };
    var closed = { '}': true, ']': true, ')': true };
    
    for (var i = 0; i < str.length; i ++) {
      var x = str[i];
      if (open[x]) {
        stack.push(x);
      } else if (closed[x]) {
        if (open[stack.pop()] !== x) return false;
      }
    }
    
    return stack.length === 0;
  };

  console.log(ParensValid("{{}}{}")); //true
  console.log(ParensValid("}{{}{")); //false



// Curly Braces
// Question: Curly braces can be used in programming to provide scope-limit. Write a function to print all valid( properly opened and closed) combinations of n-pairs of curly braces.
// Example:
// input: 1 output: {}
// input: 2 output: {}{}, {{}}
// input: 3 output: {}{}{}, {}{{}}, {{}}{}, {{}{}}, {{{}}}
// input: 4 output: {}{}{}{}, {}{}{{}}, {}{{}}{}, {}{{}{}}, {}{{{}}}, {{}}{}{}, {{}}{{}}, {{}{}}{}, {{}{}{}}, {{}{{}}}, {{{}}}{}, {{{}}{}}, {{{}{}}}, {{{{}}}}

public static void printBraces(int n)
{
    printBraces(new String(), n, n);
}
public static void printBraces(String str, int
start, int end)
{
    if (start == 0 && end == 0) {
        System.out.println(str);
        return;
    }
    if (start > 0) {
        printBraces(str + "{", start - 1,
            end);
    }
    if (start < end) {
        printBraces(str + "}", start, end1);
    }
}

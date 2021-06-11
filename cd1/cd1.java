/*
https://www.codewars.com/kata/54b42f9314d9229fd6000d9c

Exercise
The goal of this exercise is to convert a string to a new string where each character in the new string is "(" 
if that character appears only once in the original string, or ")" if that character appears more than once in the original string. 
Ignore capitalization when determining if a character is a duplicate.

Examples:
"din"      =>  "((("
"recede"   =>  "()()()"
"Success"  =>  ")())())"
"(( @"     =>  "))((" 

Notes
Assertion messages may be unclear about what they display in some languages. If you read "...
It Should encode XXX", the "XXX" is the expected result, not the input!
*/

class cd1 {
    public static void main(String args[]) {
        System.out.println(DuplicateEncoder("Prespecialized"));
        //System.out.println(run("recede"));
        //System.out.println(run("Success"));
        //System.out.println(run("(( @"));
    }

    static String DuplicateEncoder(String word){
        String result = "";
        for(int i=0;i<word.length();i++) {
            if (howManyTimes(word.toLowerCase(), word.substring(i, i+1).toLowerCase())==1) {
                result = result + "(";
            } else {
                result = result + ")";
            }
        }
        return result;
    }

    static int howManyTimes(String sourceStr, String subStr) {
        int result=0;
        for(int i=0;i<sourceStr.length();i++) {
            if (sourceStr.substring(i,i+1).equals(subStr)) {
                result++;
            }
        }
        return result;
    }
}

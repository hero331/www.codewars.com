/*
https://www.codewars.com/kata/554b4ac871d6813a03000035
In this little assignment you are given a string of space separated numbers, and have to return the highest and lowest number.

Example:

highAndLow("1 2 3 4 5")  // return "5 1"
highAndLow("1 2 -3 4 5") // return "5 -3"
highAndLow("1 9 3 4 -5") // return "9 -5"
Notes:

All numbers are valid Int32, no need to validate them.
There will always be at least one number in the input string.
Output string must be two numbers separated by a single space, and highest number is first.
*/
public class cd13 {
    public static void main(String args[]){
        System.out.println(max_min("1 2 3 4 5"));
        System.out.println(max_min("1 2 -3 4 5"));
        System.out.println(max_min("1 9 3 4 -5"));
    }
    public static String max_min(String numbers){
        java.util.List<String> sList = java.util.Arrays.asList(numbers.split("\\s"));
        java.util.List<Integer> iList = sList.stream().map(Integer::parseInt).collect(java.util.stream.Collectors.toList());
        return java.util.Collections.max(iList)+" "+java.util.Collections.min(iList);
    }
}

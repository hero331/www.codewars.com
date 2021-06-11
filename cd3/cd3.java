/*
Problem
You are to write a function that takes an odd integer which is the difference between two consecutive perfect squares and find the squares

Input Format
num : Odd Integer 0<n<1000000

Output Format
Answer: String containing the bigger and smaller squares in one line like "Max-Min"

Examples
findSquares(9)  //returns '25-16'
findSquares(5)  // returns '9-4' 
*/
public class cd3 {
    public static void main(String args[]){
        System.out.println(GetSquares(5));
    }
    static String GetSquares(long n) {
        long min;
        long max;
        min = n / 2;
        max = min + 1;
        return Long.toString(max*max)+"-"+Long.toString(min*min);
    }
}

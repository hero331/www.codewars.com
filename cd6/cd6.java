/*
https://www.codewars.com/kata/51c8991dee245d7ddf00000e
Complete the solution so that it reverses all of the words within the string passed in.
Example:
"The greatest victory is that which requires no battle" --> "battle no requires which that is victory greatest The"
*/
public class cd6 {
    public static void main(String args[]){
        System.out.println(reverseWords("The greatest victory is that which requires no battle"));
    }
    public static String reverseWords(String str){
        //write your code here...
        String arr[];
        String result = "";
        arr = str.split(" ");
        for(int i=arr.length-1;i>=0;i--){
            result = result + " " +arr[i];
        }
        return result.trim();
    }
}

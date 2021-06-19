/*
https://www.codewars.com/kata/56bc28ad5bdaeb48760009b0

It's pretty straightforward. Your goal is to create a function that removes the first and last characters of a string. You're given one parameter, the original string. You don't have to worry with strings with less than two characters.
*/
public class cd19 {
    public static void main(String[] args){
        System.out.println(remove("It's pretty straightforward."));
    }

    public static String remove(String str) {
        return str.substring(1,str.length()-1);
    }
}

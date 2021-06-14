/*
https://www.codewars.com/kata/5ce9c1000bab0b001134f5af
Given a month as an integer from 1 to 12, return to which quarter of the year it belongs as an integer number.
For example: month 2 (February), is part of the first quarter; month 6 (June), is part of the second quarter; and month 11 (November), is part of the fourth quarter.
*/
public class cd5 {
    public static void main(String args[]) {
        System.out.println("1 - "+Integer.toString(GetQ(1)));
        System.out.println("2 - "+Integer.toString(GetQ(2)));
        System.out.println("3 - "+Integer.toString(GetQ(3)));
        System.out.println("4 - "+Integer.toString(GetQ(4)));
        System.out.println("5 - "+Integer.toString(GetQ(5)));
        System.out.println("6 - "+Integer.toString(GetQ(6)));
        System.out.println("7 - "+Integer.toString(GetQ(7)));
        System.out.println("8 - "+Integer.toString(GetQ(8)));
        System.out.println("9 - "+Integer.toString(GetQ(9)));
        System.out.println("10 - "+Integer.toString(GetQ(10)));
        System.out.println("11 - "+Integer.toString(GetQ(11)));
        System.out.println("12 - "+Integer.toString(GetQ(12)));
    }
    static int GetQ(int month) {
        return ((month+2) / 3);
    }
}

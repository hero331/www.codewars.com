/*
https://www.codewars.com/kata/563e320cee5dddcf77000158

It's the academic year's end, fateful moment of your school report. The averages must be calculated. All the students come to you and entreat you to calculate their average for them. Easy ! You just need to write a script.
Return the average of the given array rounded down to its nearest integer.
The array will never be empty.
*/
public class cd17 {
    public static void main(String[] args){
        System.out.println(getAverage(new int[] {1,2,3,4,5}));
    }

    public static int getAverage(int[] marks){
		return (int)Math.floor(java.util.stream.IntStream.of(marks).sum()/marks.length);
	}
}

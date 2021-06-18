import java.util.*;
/*
https://www.codewars.com/kata/5d68d05e7a60ba002b0053f6
John wants to give a total bonus of $851 to his three employees taking fairly as possible into account their number of days of absence during the period under consideration. Employee A was absent 18 days, B 15 days, and C 12 days.
The more absences, the lower the bonus ...
How much should each employee receive? John thinks A should receive $230, B $276, C $345 since 230 * 18 = 276 * 15 = 345 * 12 and 230 + 276 + 345 = 851.

Task:
Given an array arr (numbers of days of absence for each employee) and a number s (total bonus) the function bonus(arr, s) will follow John's way and return an array of the fair bonuses of all employees in the same order as their numbers of days of absences.
s and all elements of arr are positive integers.

Examples:
bonus([18, 15, 12], 851) -> [230, 276, 345]

bonus([30, 27, 8, 14, 7], 34067) -> [2772, 3080, 10395, 5940, 11880]
Notes
There are only integers in the kata so no need to use floats.
See Example Test Cases for more examples.
Please ask before translating.
In some tests the number of elements of arr can be big.
*/
public class cd16 {
    public static void main(String args[]){
        long[] arr=Bonus(new int[]{30, 27, 8, 14, 7}, 34067);
        System.out.println(doTest(arr, 34067));
        arr=Bonus(new int[]{27, 15, 19, 30, 19, 26, 22, 18, 29, 21, 24, 24, 22, 23, 30, 20, 12, 14, 29, 13, 22, 25}, 231535674714L);
        System.out.println(doTest(arr, 231535674714L));
    }

    public static long[] Bonus(int[] arr, long s){
            long[] lArr = new long[arr.length];
            for (int i=0;i<arr.length;i++){
                lArr[i] = arr[i];
            }
            long sum = java.util.stream.LongStream.of(lArr).sum();
            double[] absArr = new double[arr.length];
            for (int i=0;i<arr.length;i++){
                absArr[i] = (double)sum/arr[i];
            }
            double absSum = java.util.stream.DoubleStream.of(absArr).sum();
            long[] result = new long[arr.length];
            for (int i=0;i<arr.length;i++){
                double d = s*(((absArr[i])/(absSum/100))/100);
                result[i] = (d%1>=0.43) ? (long)Math.ceil(s*(((absArr[i])/(absSum/100))/100)) : (long)Math.floor(s*(((absArr[i])/(absSum/100))/100));            
            }
            return result;
    }

    public static boolean doTest(long[] al, long s){
        long l = 0;
        for(int i=0;i<al.length;i++){
            l += al[i];
        }
        System.out.println(l+"<>"+s);
        return l == s;
    }
}

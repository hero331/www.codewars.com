/*
https://www.codewars.com/kata/5a97387e5ee396e70a00016d

i is the imaginary unit, it is defined by i²=−1i² = -1i²=−1, therefore it is a solution to x²+1=0x² + 1 = 0x²+1=0.

Your Task
Complete the function pofi that returns iii to the power of a given non-negative integer in its simplest form, as a string (answer may contain iii).
*/
public class kata {
    public static void main(String[] args){
        System.out.println("0 "+pofi(0));
        System.out.println("1 "+pofi(1));
        System.out.println("2 "+pofi(2));
        System.out.println("3 "+pofi(3));
        System.out.println("4 "+pofi(4));
        System.out.println("5 "+pofi(5));
        System.out.println("6 "+pofi(6));
        System.out.println("7 "+pofi(7));
        System.out.println("8 "+pofi(8));
        System.out.println("9 "+pofi(9));
    }

    public static String pofi(int n) {
        if (n/4>0) n=n-(4*(n/4));
        return n==0?"1":n%4==0?"1":n%3==0?"-i":n%2==0?"-1":"i";
    }
}

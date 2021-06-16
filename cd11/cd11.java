/*
https://www.codewars.com/kata/5a6663e9fd56cb5ab800008b
I have a cat and a dog.
I got them at the same time as kitten/puppy. That was humanYears years ago.
Return their respective ages now as [humanYears,catYears,dogYears]

NOTES:
humanYears >= 1
humanYears are whole numbers only
Cat Years
15 cat years for first year
+9 cat years for second year
+4 cat years for each year after that
Dog Years
15 dog years for first year
+9 dog years for second year
+5 dog years for each year after that
*/
public class cd11 {
    public static void main(String args[]){
        int hy = 10;
        int[] y = humanYearsCatYearsDogYears(hy);
        int cy = y[1];
        int dy = y[2];
        System.out.println("human="+hy+" cat="+cy+" dog="+dy);
    }
    public static int[] humanYearsCatYearsDogYears(final int humanYears) {
        // Your code here!
        int catYears;
        int dogYears;
        if (humanYears==0){
            catYears=0;
            dogYears=0;
        } else if (humanYears==1){
            catYears=15;
            dogYears=15;
        } else if (humanYears==2){
            catYears=15+9;
            dogYears=15+9;
        } else {
            catYears=15+9+(4*(humanYears-2));
            dogYears=15+9+(5*(humanYears-2));
        }
        return new int[]{humanYears,catYears,dogYears};
    }
}

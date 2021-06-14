/*
Task
You will be given an array of numbers. You have to sort the odd numbers in ascending order while leaving the even numbers at their original positions.

Examples
[7, 1]  =>  [1, 7]
[5, 8, 6, 3, 4]  =>  [3, 8, 6, 5, 4]
[9, 8, 7, 6, 5, 4, 3, 2, 1, 0]  =>  [1, 8, 3, 6, 5, 4, 7, 2, 9, 0]
*/
public class cd2 {
    public static void main(String args[]){
        int b[] = sort(new int[]{5, 8, 6, 3, 4});
        for (int i=0;i<b.length;i++){
            System.out.println(Integer.toString(b[i]));
        }
    }
    static int[] sort(int array[]){
        int tmp;
        int[] result = array;
        for (int i=0;i<array.length-1;i++){
            if (array[i]%2!=0){
                for (int j=i+1;j<array.length;j++){
                    if (array[j]%2!=0){
                        if (array[i]>array[j]) {
                            tmp = array[i];
                            array[i] = array[j];
                            array[j] = tmp;
                        }
                    }
                }
            }
        }
        return result;
    }
}

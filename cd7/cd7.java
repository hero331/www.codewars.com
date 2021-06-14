/*
https://www.codewars.com/kata/5f70c883e10f9e0001c89673
If you've completed this kata already and want a bigger challenge, here's the 3D version
Bob is bored during his physics lessons so he's built himself a toy box to help pass the time. The box is special because it has the ability to change gravity.
There are some columns of toy cubes in the box arranged in a line. The i-th column contains a_i cubes. At first, the gravity in the box is pulling the cubes downwards. When Bob switches the gravity, it begins to pull all the cubes to a certain side of the box, d, which can be either 'L' or 'R' (left or right). Below is an example of what a box of cubes might look like before and after switching gravity.

+---+                                       +---+
|   |                                       |   |
+---+                                       +---+
+---++---+     +---+              +---++---++---+
|   ||   |     |   |   -->        |   ||   ||   |
+---++---+     +---+              +---++---++---+
+---++---++---++---+         +---++---++---++---+
|   ||   ||   ||   |         |   ||   ||   ||   |
+---++---++---++---+         +---++---++---++---+
Given the initial configuration of the cubes in the box, find out how many cubes are in each of the n columns after Bob switches the gravity.
Examples:
flip('R', { 3, 2, 1, 2 })     =>  { 1, 2, 2, 3 }
flip('L', { 1, 4, 5, 3, 5 })  =>  { 5, 5, 4, 3, 1 }
*/
public class cd7 {
    public static void main(String args[]){
        int arr[] = { 1, 4, 5, 3, 5 };
        int arrResult[] = move('R', arr);
        String result = "";
        for (int i=0;i<arr.length;i++){
            result = result + " " + Integer.toString(arrResult[i]);
        }
        System.out.print(result);
    }

    static int[] move(char dir, int arr[]){
        int tmp;
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if (((dir == 'R') && (arr[i]>arr[j])) || ((dir == 'L') && (arr[i]<arr[j]))) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
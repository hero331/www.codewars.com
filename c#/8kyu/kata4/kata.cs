/*
Given a 2D ( nested ) list ( array, vector, .. ) of size m * n, your task is to find the sum of the minimum values in each row.
For Example:
[ [ 1, 2, 3, 4, 5 ]        #  minimum value of row is 1
, [ 5, 6, 7, 8, 9 ]        #  minimum value of row is 5
, [ 20, 21, 34, 56, 100 ]  #  minimum value of row is 20
]
So the function should return 26 because the sum of the minimums is 1 + 5 + 20 = 26.
Note: You will always be given a non-empty list containing positive values.
ENJOY CODING :)
*/
using System;

class Kata
{
  public static int SumOfMinimums(int[,] numbers)
  {
    int[,] arr = new int[3,3];

    for (int i=0;i<3;i++){
      for (int j=0;j<3;j++){
        arr[i,j]=i*j;
      }
    }

    int sum=0;
    int min=0;
    for (int i=0;i<3;i++){
      for (int j=0;j<3;j++){
        if (j==0) {
          min=arr[i,j];
        } else {
          min=(min>arr[i,j] ? arr[i,j] : min);
        }
        sum += min;
      }
    }
    Console.WriteLine($"min = {min}");
    return 0;
  }
}
/*
https://www.codewars.com/kata/59bd84b8a0640e7c49002398

Task.
Calculate area of given triangle. Create a function t_area that will take a string which will represent triangle, find area of the triangle, one space will be equal to one length unit. The smallest triangle will have one length unit.

Hints
Ignore dots.

Example:

.
.      .  
.      .       .      ---> should return 2.0

.
.      .  
.      .       .     
.      .       .      .      ---> should return 4.5
*/
public class cd22 {
    public static void main(String args[]){
        System.out.println(tArea("\n.\n. .\n"));
        System.out.println(tArea("\n.\n. .\n. . .\n"));
        System.out.println(tArea("\n.\n. .\n. . .\n. . . .\n. . . . .\n. . . . . .\n. . . . . . .\n. . . . . . . .\n. . . . . . . . .\n"));
    }
    public static float tArea(String tStr) {
        return (float)Math.pow((tStr.replaceAll("\n", "!").replaceAll("[\\s\\.]", "").length()-2),2)/2;
    }
}

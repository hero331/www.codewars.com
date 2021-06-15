/*
https://www.codewars.com/kata/5d98b6b38b0f6c001a461198
Let us take a string composed of decimal digits: "10111213". We want to code this string as a string of 0 and 1 and after that be able to decode it.
To code we decompose the given string in its decimal digits (in the above example: 1 0 1 1 1 2 1 3) and we will code each digit.
Coding process to code a number n expressed in base 10:
For each digit d of n
a) Let k be the number of bits of d
b) Write k-1 times the digit 0 followed by the digit 1
c) Write digit d as a binary string, with the rightmost bit being the least significant
d) Concat the result of b) and c) to get the coding of d
At last concatenate all the results got for the digits of n.

An example
So we code 0 as 10, 1 as 11, 2 as 0110, 3 as 0111 ... etc...
With the given process, the initial string "10111213" becomes: "11101111110110110111" resulting of concatenation of 11 10 11 11 11 0110 11 0111.

Task:
Given strng a string of digits representing a decimal number the function code(strng) should return the coding of strng as explained above.
Given a string strng resulting from the previous coding, decode it to get the corresponding decimal string.

Examples:
code("77338855") --> "001111001111011101110001100000011000001101001101"
code("77338")  --> "0011110011110111011100011000"
code("0011121314") --> "1010111111011011011111001100"

decode("001111001111011101110001100000011000001101001101") -> "77338855"
decode("0011110011110111011100011000") -> "77338"
decode("1010111111011011011111001100") -> "0011121314"
Notes
SHELL: The only tested function is decode.
Please could you ask before translating.
*/
public class cd8 {
    public static void main(String args[]){
        String s = code("77338855");
        System.out.print(decode(s));
    }

    public static String code(String strng) {
        byte symByte;
        String symBin = "";
        String result = "";
        for (int i=0;i<strng.length();i++){
            symByte = Byte.parseByte(strng.substring(i,i+1));
            symBin = Integer.toBinaryString(symByte);
            for (int j=1;j<=symBin.length()-1;j++){
                result += "0";
            }
            symBin = "1" + symBin;
            result += symBin;// + " ";
        }
        return result;
    }

    public static String decode(String str){
        byte symByte;
        String symBin = "";
        int k = 0;
        String result = "";
        for (int i=0;i<str.length();i++){
            //001111 001111 0111 0111 00011000 00011000 001101 001101
            if (str.substring(i,i+1).equals("0")){
                k++;
            }
            if (str.substring(i,i+1).equals("1")) {
                symBin = str.substring(i+1, i+k+2);
                i = i+k+1;
                k = 0;
                symByte = Byte.parseByte(symBin, 2);
                result += symByte;
            }
        }
        return result;
    }
}

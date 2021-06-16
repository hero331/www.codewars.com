/*
https://www.codewars.com/kata/5dad6e5264e25a001918a1fc
Suppose we know the process by which a string s was encoded to a string r (see explanation below). The aim of the kata is to decode this string r to get back the original string s.

Explanation of the encoding process:
input: a string s composed of lowercase letters from "a" to "z", and a positive integer num
we know there is a correspondence between abcde...uvwxyzand 0, 1, 2 ..., 23, 24, 25 : 0 <-> a, 1 <-> b ...
if c is a character of s whose corresponding number is x, apply to x the function f: x-> f(x) = num * x % 26, then find ch the corresponding character of f(x)
Accumulate all these ch in a string r
concatenate num and r and return the result
For example:

encode("mer", 6015)  -->  "6015ekx"

m --> 12,   12 * 6015 % 26 = 4,    4  --> e
e --> 4,     4 * 6015 % 26 = 10,   10 --> k
r --> 17,   17 * 6015 % 26 = 23,   23 --> x

So we get "ekx", hence the output is "6015ekx"
Task
A string s was encoded to string r by the above process. complete the function to get back s whenever it is possible.

Indeed it can happen that the decoding is impossible for strings composed of whatever letters from "a" to "z" when positive integer num has not been correctly chosen. In that case return "Impossible to decode".

Examples
decode "6015ekx" -> "mer"
decode "5057aan" -> "Impossible to decode"
*/
public class cd12 {
    public static void main(String args[]){
        System.out.println(encode("abcdefghijk", 5057));
        System.out.println(decode("1273409kuqhkoynvvknsdwljantzkpnmfgf"));
        System.out.println(decode("1544749cdcizljymhdmvvypyjamowl"));
        System.out.println(decode("1877138eieaqgumigywmicwgcgg"));
        System.out.println(decode("1122305vvkhrrcsyfkvejxjfvafzwpsdqgp"));

    }
    public static String encode(String str, int code){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] charArr = str.toCharArray();
        String result = Integer.toString(code);
        int index = 0;
        for (int i=0;i<charArr.length;i++){
            index = java.util.Arrays.binarySearch(alphabet, charArr[i]);
            result += alphabet[index*code%26];
        }
        return result;
    }

    public static String decode(String r){
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] charArr;
        int code = 0;
        boolean isFound = false;
        String result = "";

        code = Integer.valueOf(r.replaceAll("\\D+", ""));
        charArr = r.replaceAll("\\d", "").toCharArray();

        for (int i=0;i<alphabet.length;i++){
            isFound = false;
            for (int j=0;j<alphabet.length;j++){
                if (i==j*code%26){
                    isFound = true;
                    break;
                }
            }
            if (!isFound){
                result = "Impossible to decode";
                break;
            }
        }

        if (isFound){
            for (int i=0;i<charArr.length;i++){
                for (int j=0;j<alphabet.length;j++){
                    if (java.util.Arrays.binarySearch(alphabet, charArr[i]) == j*code%26){
                        result += alphabet[j];
                        break;
                    }
                }
            }
        }
        return result;
    }
}

/*
https://www.codewars.com/kata/decode-the-morse-code-advanced

Part of Series 2/3
This kata is part of a series on the Morse code. Make sure you solve the previous part before you try this one. After you solve this kata, you may move to the next one.


In this kata you have to write a Morse code decoder for wired electrical telegraph.
Electric telegraph is operated on a 2-wire line with a key that, when pressed, connects the wires together, which can be detected on a remote station. The Morse code encodes every character being transmitted as a sequence of "dots" (short presses on the key) and "dashes" (long presses on the key).

When transmitting the Morse code, the international standard specifies that:

"Dot" – is 1 time unit long.
"Dash" – is 3 time units long.
Pause between dots and dashes in a character – is 1 time unit long.
Pause between characters inside a word – is 3 time units long.
Pause between words – is 7 time units long.
However, the standard does not specify how long that "time unit" is. And in fact different operators would transmit at different speed. An amateur person may need a few seconds to transmit a single character, a skilled professional can transmit 60 words per minute, and robotic transmitters may go way faster.

For this kata we assume the message receiving is performed automatically by the hardware that checks the line periodically, and if the line is connected (the key at the remote station is down), 1 is recorded, and if the line is not connected (remote key is up), 0 is recorded. After the message is fully received, it gets to you for decoding as a string containing only symbols 0 and 1.

For example, the message HEY JUDE, that is ···· · −·−−   ·−−− ··− −·· · may be received as follows:

1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011

As you may see, this transmission is perfectly accurate according to the standard, and the hardware sampled the line exactly two times per "dot".

That said, your task is to implement two functions:

Function decodeBits(bits), that should find out the transmission rate of the message, correctly decode the message to dots ., dashes - and spaces (one between characters, three between words) and return those as a string. Note that some extra 0's may naturally occur at the beginning and the end of a message, make sure to ignore them. Also if you have trouble discerning if the particular sequence of 1's is a dot or a dash, assume it's a dot.
2. Function decodeMorse(morseCode), that would take the output of the previous function and return a human-readable string.

NOTE: For coding purposes you have to use ASCII characters . and -, not Unicode characters.

The Morse code table is preloaded for you (see the solution setup, to get its identifier in your language).


Eg:
  morseCodes(".--") //to access the morse translation of ".--"
All the test strings would be valid to the point that they could be reliably decoded as described above, so you may skip checking for errors and exceptions, just do your best in figuring out what the message is!

Good luck!

After you master this kata, you may try to Decode the Morse code, for real.

···· · −·−−   ·−−− ··− −·· ·
1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011

11 00 11 00 11 00 11 000000 11 000000 111111 00 11 00 111111 001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011

*/
using System;
using System.Linq;
using System.Collections.Generic;
using System.Text.RegularExpressions;

public static class Kata
{
    public static void Main()
    {
        //Console.WriteLine(Decode("···· · −·−−   ·−−− ··− −·· ·"));
        //Console.WriteLine(DecodeBits("1111111"));
        string s = DecodeBits("1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011");
        Console.WriteLine(s);
        Console.WriteLine(DecodeMorse(s));

    }

    public static string DecodeBits(string bits) {
        //string s = bits.IndexOf("\n") > 0 ? bits.Substring(1, bits.IndexOf("\n")) : bits;
        string result = Regex.Replace(bits, @"^0{0,}", "");
        result = Regex.Replace(result, @"0{0,}$", "");
        int multiplier=0;
        string tu0="", tu1="";
        for (int i = 1; i < 100; i++)
        {
            tu0 += "0";
            tu1 += "1";
            if ((Regex.Matches(result, "^"+tu1+"0").Count + Regex.Matches(result, "0"+tu1+"$").Count + Regex.Matches(result, "0"+tu1+"0").Count > 0) || (Regex.Matches(result, "1" + tu0 + "1").Count) > 0) {
                multiplier = i;
                break;
            } 
        }

        if (multiplier == 0)
        {
            if (result.Replace("1", "").Equals("")) { return "."; } 
            else if (result.Replace("0", "").Equals("")) { return ""; }
        }
        
        result = Regex.Replace(result, @"1{" + (multiplier * 3) + 1 + ",}", ".");
        result = Regex.Replace(result, @"1{" + multiplier * 3 + "}", "-");
        result = Regex.Replace(result, @"1{" + multiplier + ",}", ".");
        result = Regex.Replace(result, @"0{" + multiplier * 7 + ",}", "   ");
        result = Regex.Replace(result, @"0{" + multiplier * 3 + ",}", " ");
        result = Regex.Replace(result, @"0{" + multiplier  + ",}", "");

        return result;
    }

    public static string DecodeMorse(string morseCode)
    {
        var chrs = morseCode
            .Trim()
            .Replace("   ", " X ")
            .Split(" ")
            .Select(x => x == "X" ? " " : MorseCode.Get(x));
        return string.Join("", chrs);
    }
}
/*
https://www.codewars.com/kata/554e4a2f232cdd87d9000038

Deoxyribonucleic acid (DNA) is a chemical found in the nucleus of cells and carries the "instructions" for the development and functioning of living organisms.
If you want to know more http://en.wikipedia.org/wiki/DNA
In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have function with one side of the DNA (string, except for Haskell); you need to get the other complementary side. DNA strand is never empty or there is no DNA at all (again, except for Haskell).
More similar exercise are found here http://rosalind.info/problems/list-view/ (source)

Example: (input: output)
DnaStrand.makeComplement("ATTGC") // return "TAACG"
DnaStrand.makeComplement("GTAT") // return "CATA"
*/
public class cd24 {
    public static void main(String args[]){
        System.out.println(makeComplement("ATTGC"));
        System.out.println(makeComplement("GTAT"));
    }

    public static String makeComplement(String dna){
        String result="";
        String subS="";
        for (int i=0;i<dna.length();i++){
            subS = dna.substring(i,i+1);
            if (subS.equals("T")) {
                result += "A";
            } else if (subS.equals("A")) {
                result += "T";
            } else if (subS.equals("G")) {
                result += "C";
            } else if (subS.equals("C")) {
                result += "G";
            }
        }
        return result;
    }
}

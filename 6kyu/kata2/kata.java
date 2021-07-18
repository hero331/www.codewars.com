/*
https://www.codewars.com/kata/56f1c6034d0c330e4a001059

Generate a valid randomly generated hexadecimal color string. Assume all of them always have 6 digits.

Valid Output
#ffffff
#FfFfFf
#25a403
#000001
Non-Valid Output
#fff
#aaa
#zzzzz
cafebabe
#a567567676576756A7
*/
public class kata {
    public static void main(String args[]){
        for (int i=0;i<10;i++) System.out.println(GetRandomHtmlColor());
    }

    public static String GetRandomHtmlColor(){
        java.util.Random random = new java.util.Random();
        String result="#";
        for (int i=0;i<6;i++) result+=Integer.toHexString(random.nextInt(0x10)+0x10).toString().substring(1);
        return result;
    }
}

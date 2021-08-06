/*
https://www.codewars.com/kata/5266876b8f4bf2da9b000362

You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items. We want to create the text that should be displayed next to such an item.

Implement the function likes which takes an array containing the names of people that like an item. It must return the display text as shown in the examples:

Kata.Likes(new string[0]) => "no one likes this"
Kata.Likes(new string[] {"Peter"}) => "Peter likes this"
Kata.Likes(new string[] {"Jacob", "Alex"}) => "Jacob and Alex like this"
Kata.Likes(new string[] {"Max", "John", "Mark"}) => "Max, John and Mark like this"
Kata.Likes(new string[] {"Alex", "Jacob", "Mark", "Max"}) => "Alex, Jacob and 2 others like this"
For 4 or more names, the number in and 2 others simply increases.
*/

public class kata1{
    public static void main(String[] args){
        System.out.println(whoLikesIt("John, Staisy"));
    }
    public static String whoLikesIt(String... names) {
        return 
          names.length==0?"no one likes this":
          names.length==1?names[0]+" likes this":
          names.length==2?names[0]+" and "+names[1]+" like this":
          names.length==3?names[0]+", "+names[1]+" and "+names[2]+" like this":
          names[0]+", "+names[1]+" and "+Integer.toString(names.length-2)+" others like this";
    }
}
/*
https://www.codewars.com/kata/57f6051c3ff02f3b7300008b
So you've found a meeting room - phew! You arrive there ready to present, and find that someone has taken one or more of the chairs!! You need to find some quick.... check all the other meeting rooms to see if all of the chairs are in use.
Your meeting room can take up to 8 chairs. need will tell you how many have been taken. You need to find that many.
Find the spare chairs from the array of meeting rooms. Each meeting room tuple will have the number of occupants as a string. Each occupant is represented by 'X'. The room tuple will also have an integer telling you how many chairs there are in the room.
You should return an array of integers that shows how many chairs you take from each room in order, up until you have the required amount.

example:

[['XXX', 3], ['XXXXX', 6], ['XXXXXX', 9], ['XXX',2]] when you need 4 chairs:
result -> [0, 1, 3] no chairs free in room 0, take 1 from room 1, take 3 from room 2. no need to consider room 3 as you have your 4 chairs already.
If you need no chairs, return "Game On". If there aren't enough spare chairs available, return "Not enough!".

More in this series:

The Office I - Outed
The Office II - Boredeom Score
The Office III - Broken Photocopier
The Office IV - Find a Meeting Room
*/
public class cd15 {
    public static void main(String args[]){
        Room[] rooms = new Room[] {
            new Room("XXX", 3),
            new Room("XXXXX", 6),
            new Room("XXXXXX", 9)
        };
        Object o = r(rooms, 4);
    }
    public static Object r(Room[] x, int need){
        int freeChairs;
        int needChairs = need;
        java.util.ArrayList<Integer> result = new java.util.ArrayList<Integer>();
        if (need < 1) {
            return "Game On";
        } else {
            for (int i=0;i<x.length;i++){
                freeChairs = x[i].chairs - x[i].occupants.length();
                if (needChairs > 0){
                    if (freeChairs > 0){
                        if (needChairs - freeChairs > 0) {
                            result.add(freeChairs);
                            needChairs -= freeChairs;
                        } else {
                            result.add(needChairs);
                            needChairs -= freeChairs;
                            break;
                        }
                    } else {
                        result.add(0);
                    }
                } else {
                    break;
                }
            }
            if (needChairs > 0) {
                return "Not enough!";
            } else {
                int[] arr = new int[result.size()];
                for (int i=0;i<arr.length;i++){
                    arr[i]=result.get(i);
                }
                return arr;
            }
        }
    }
}

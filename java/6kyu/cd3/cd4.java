/*
https://www.codewars.com/kata/5db19d503ec3790012690c11

An architect wants to construct a vaulted building supported by a family of arches Cn.
fn(x) = -nx - xlog(x) is the equation of the arch Cn where x is a positive real number (0 < x <= 1), log(x) is the natural logarithm (base e), n a non negative integer. Let fn(0) = 0.
Be An the point of Cn where the tangent to Cn is horizontal and Bn+1 the orthogonal projection of An on the x-axis (it means that An and Bn+1 have the same x -coordinate). Kn is the intersection of Cn with the x-axis.
The figure shows C0, A0, B1, K0 as C(0), A0, B1, K0.

alternative text

The architect wants to support each arch Cn with a wall of glass filling the curved surface An Bn+1 Kn under the curve Cn. On the drawing you can see the surface A0 B1 K0 in blue.
He asks if we could calculate the weight of the surface of glass he needs to support all arches C0...Cn where n is a positive integer knowing he can choose glass thickness hence glass weight per square unit of surface.
He gives us the absolute value of A0 B1 K0 area (in blue); call it i0 which is approximately 0.14849853757254047 in square units.

Task
Write the function weight with parameters n and w where n is the number of arches to consider (n >= 1) and w is the weight of a square unit of glass depending on the wall thickness.
This function should return the weight of n glass walls as described above.

Examples
weight(10, 700) -> 120.21882500408238
weight(8, 1108) -> 190.28922301858418
Hint:
There is no integral to calculate. You can plot C1 and try to see the relationship between the different Cn and then use i0.

Notes:
don't round or truncate your result
please ask before translating
*/
public class cd4 {
    public static void main(String args[]) {
        //System.out.println("Task is not done.");
        // double res=0;
        // double k = 1.862947434565763;//1.86294;
        // for (long i=0;i<100000000;i++){
        //     res = weight(10,700, k);
        //     if (res < 120.21882500408238){
        //         k -= 0.000000000000001;
        //     } else if (res > 120.21882500408238) {
        //         k += 0.000000000000001;
        //     } else {
        //         System.out.println("DONE!!!! k="+Double.toString(k));
        //         break;
        //     }
        //     //System.out.println("res="+Double.toString(res)+" k="+Double.toString(k));
        // }
        // System.out.println("k="+Double.toString(k));
        // System.out.println(Double.toString(res));
        // System.out.println("120.21882500408238");

        //double k = 1.8629474345656987;
        System.out.println(Double.toString(weight(10,700)));
        System.out.println("120.21882500408238");
        System.out.println(Double.toString(weight(8,1108)));
        System.out.println("190.28922301858418");
    }

    static double weight(long n, long w){
        double i0 = 0.14849853757254047;
        double s0 = i0 * w;
        double sn = s0;
        for(int i=1;i<n;i++){
            s0 /= Math.E * Math.E;
            sn += s0;
        }
        return sn;
    }
}

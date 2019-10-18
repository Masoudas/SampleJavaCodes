/**
 * The printf method in System.out provides us with a way of 
 * formatting the output.
 * 
 * System.out.printf(format, args) 
 * System.out.printf(l, format, args)

 * The first version writes args to standard output in the format specified by 
 * fmtString, using the default locale. The second lets you specify a locale
 */

package SampleJavaCodes.Basics;
class FormatOutPut{
    public static void main(String[] args) {
        System.out.printf("%05d \n", -3);   // Five digits before the integer.
        System.out.printf("%(d \n", -3);   // Five digits before the integer.
        System.out.printf("%f \n", -3f);   // Five digits before the integer.
        System.out.printf("%5.2f \n", -3f);   // Five digits before the integer.
        //System.out.printf(l, "%f", args)
    }
}
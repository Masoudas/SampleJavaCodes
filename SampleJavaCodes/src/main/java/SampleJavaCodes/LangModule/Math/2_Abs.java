package SampleJavaCodes.LangModule.Math;

class abs {
    public static void main(String[] args) {
        /**
         * Here's something cool about the abs method.
         * In the integer overload, the Integer.MIN_VALUE
         * returns what value? .... It returns Integer.MIN_VALUE.
         * why? .... Because in the two's complement, there's 
         * no counterpart for this value!!!
         */

        System.out.println(Math.abs(Integer.MIN_VALUE));

    }
    
}
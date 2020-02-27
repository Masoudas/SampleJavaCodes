package SampleJavaCodes.Interfaces;

/**
 * Of course as we know, when a class implements an interface, it is an instance of
 * that interface.
 */
interface Int1 {

    
}

/**
 * IsInstanceOf
 */
class ImplementInt1 implements Int1  {


    public static void main(String[] args) {
        ImplementInt1 int1 = new ImplementInt1();

        System.out.println(int1 instanceof Int1);
    }
}


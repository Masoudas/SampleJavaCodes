/**
 * The instanceof keyword checks whether an variable
 * is an instance of a particular class.
 * Of course not surprisingly, instanceof is a run-time operator.
 * 
 * This may come useful in several situations, one of which is casting.
 * 
 * What happens if a class is subclass of another one? The method returns 
 * true. Why? As we said we check this to be able to cast, and this property
 * of instanceof allows us to cast.
 * 
 */

package SampleJavaCodes.Classes;

class AA{

}

class BB{

}

class CC extends AA{

}

class DD extends AA{

}

class CheckInstance{
    public static void main(String[] args) {
        AA a = new AA();
        BB b = new BB();
        CC c = new CC();
        DD d = new DD();

        if (a instanceof AA) System.out.println("a instanceof AA");
        if (c instanceof AA) System.out.println("c instanceof AA");
        if (a instanceof CC) System.out.println("a instanceof CC");
    }
}
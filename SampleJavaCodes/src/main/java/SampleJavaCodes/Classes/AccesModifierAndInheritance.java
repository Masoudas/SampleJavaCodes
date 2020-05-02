package SampleJavaCodes.Classes;

/**
 * When inheriting classes, the access modifier can grow, and not shrink.
 * Hence, protected can become public. Obviously we can't shrink access 
 * modifier, due to Liskov Substitution principle.
 * 
 * Of course, we should never forget that we can access super class fields and methods
 * through the super method.
 * 
 * Note that the same principiles apply for static fields and methods, the difference being
 * we don't need to use override keyword (why?? Think carefully, then see OverrideMethod)!
 */
class BaseClass {
    private int private1 = 0;
    protected int protected1 = 0;

    private static int staticPrivate = 0;
    protected static int protectedStatic = 0;

    private void privateMethod(){

    }

    protected void protectedMethod(){

    }

    private static void privateStaticMethod() {
        
    }

    protected static void protectedStaticMethod() {
        
    }

}

class Inherited extends BaseClass{
    public int protected1 = 0; // Overriding and increasing access of upper class field.
    public static int protectedStatic = 0;  // Overriding upper class field

    public Inherited(){
        super.protected1 = 10;
    }
    /**
     * Overriding protected method, and changing it's access modifier to public
     */
    @Override
    public void protectedMethod() {
        super.protectedMethod();
    }

    public static void protectedStaticMethod() {
        protectedStaticMethod();
    }

}

class InheritInherited extends Inherited{
    /**
     * Can't do this!
     */
    // @Override
    // protected void protectedMethod() {
    //     super.protectedMethod();
    // }
}
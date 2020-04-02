package SampleJavaCodes.Classes;

/**
 * Constructors are not inherited by inheritance, because:
 * 1- A constructor is a special method, that returns the
 * same type as the class. Now suppose you inherit one, in the child class, it
 * will return the same type as the super class which is wrong. 
 * 2- Rheoretically, we have a constructor that does not have the same name as the
 * class (because if we are inheriting, we should be able to see the method name
 * appear in the derived class, which is physically impossible). 
 * 3- We violate encapsulation, because subclass can set the value of superclass private
 * fields (I don't understand this).
 * 
 */

 class ParentClass {
    public ParentClass(int x){
    }
}

/*
// class ChildClass extends ParentClass{
    public ParentClass(int x){  // This would not make sense, it is neither a constructor, nor a method, hence 
                    // if we uncomment it, we get a compile-time error!

    }  
// }
*/

/**
 * Suppose a class is defined with a non-default constructor, why Java forces us to invoke 
 * the superclass constructor in inheritance?
 * First, note that super class has no default constructor. Now that we use inhertance,
 * then we need to instantiate the super class at some point, But we need to pass values to superclass
 * because it does not have default constructor. Hence, Java forces us to override.
 */
class ParentNoDefaultConstructor {
    // Note that this class does not have default constructor.
    public ParentNoDefaultConstructor(int x){

    }
    
}

// You see that we are forced to override the parent implicit constructor.
class ChildOfNoDefault extends ParentNoDefaultConstructor{
    
}


/**
 * Why doesn't Java force us to override the other constructors for example in the Exception class?
 * For example the constructor with string?
 */
class ExtendedException extends Exception{

}
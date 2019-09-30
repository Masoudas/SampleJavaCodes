/*
It may happen that we want to restrict the types that can be assigned to a generic.
Like for example, in the following example, we want to return the mean of an array.
However, there's no explicit cast between generic and double, hence we get an error.

class AverageCalculator<T>{
    T[] t;
    
    public AverageCalculator(T[] t){
        this.t = t;
    }

    public double getAverage(){
        double average = 0;
        
        for (T var : t) {
            average = average + var;    // This is not acceptable
            average = average + (double)var;    // This is not acceptable either, because the compiler does 
                                                // not know what it is casting from.
        }

        return average / t.length;
    }
}

Now, when defining the generic types, we can bound the type, using the keyword extends.
We best define a superclass, which nicely bounds the types, and allows several subtypes to be used.
For example, in the following case, we use the Number class, which is the super class of Integer, Double 
and so forth.

Note that we cannot bound a generic from below, like we do a wild card. I have no idea why!
*/

package SampleJavaCodes.Generics;

class AverageCalculator<T extends Number>{
    T[] t;
    
    public AverageCalculator(T[] t){
        this.t = t;
    }

    public double getAverage(){
        double average = 0;
        
        for (T var : t) {
            average = average + var.doubleValue();    // Now this is acceptable.
            //average = average + (double)var;    // Or this.
        }

        return average / t.length;
    }

    public static void main(String[] args) {
        Integer[] arr = { 1, 2, 3, 4 };
        
        AverageCalculator<Integer> aCal = new AverageCalculator<Integer>(arr);

        System.out.println(aCal.getAverage());

        // AverageCalculator<String> aCal1; This is not acceptable.
    }
}


// It is also worth mentioning that we can extend interface types as generic types.
class ExtendingInterfaces<T extends Runnable> {
    
}

// We can also use what we call intersectioning, with ONE class and at least one interface.
// Naturally, I think we do this when the two types have something in common!
class IntersectingTypes<T extends Number & Runnable > {
    
}

//‌ Finally, note that interestingly enough, one generic can extend another! Ok cool!
class OtherGenericExtender<U, T extends U>{}


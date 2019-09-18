/*
Suppose we define an averageCalculator class, and we want to check whether two arrays
yield the same average.
Naturally, we think of an isSame() method. and the following implementation.

The problem however is that when we instantiate a class, naturally we assign a type.
Suppose that this type is float. Hence, when we try and pass an array of type Integer,
Very subtle problem.

class AverageCalculator<T extends Number>{
    T[] t;
    
    public AverageCalculator(T[] t){
        this.t = t;

    }

    public double getAverage(){
        return this.calcAvrg(this.t);
    }

    private double calcAvrg(T[] t) {
        double average = 0;

        for (T var : t) {
            average = average + var.doubleValue(); // Now this is acceptable.
            // average = average + (double)var; // Or this.
        }

        return average / t.length;
        
    }

    public boolean isSame(T[] t){
        return this.getAverage() == this.calcAvrg(t) ? true : false;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        Double[] arr1 = {1.0, 2.0, 3.0};

        AverageCalculator<Double> avrCal = new AverageCalculator<Double>(arr1);
        System.out.println(avrCal.isSame(arr)); // This assignment would be wrong, because the 
        template is Double.

    }

}

Also note that even the following implementation would not work for the same reason:
public boolean isSame(AverageCalculator<T> t){
    return this.getAverage() == t.getAverage() ? true : false;
}

To solve this problem, we use the wildtype argument. It allows the generic type to be as we desire,
and not follow the class argument.
Interestingly enough, we can bind the wildcards too. The notation is the same as binding a class.
Now, we may bind a wild card from above or below:

    1- If we use <? extends ClassType>, then we can use ClassType and its subclasses. This is called
       binding from above, or bounded above.
    
    2- If we use <? super ClassType>, then we can use ClassType and its superclasses. This is called
       binding from below, or bounded above.       
    
This is very natural, right.
Be careful about erasure of methods with generics though. If we overload with bounded above or bounded
below generics, we may get overlapping situations, which is problematic, and cause error, like the following
example:
public void isSame(AvCalculator<? extends Number>){}
public void isSame(AvCalculator<? super Number>){} // Erasure


*/

package SampleJavaCodes.Generics;

class AvCalculator<T extends Number>{
    T[] t;
    
    public AvCalculator(T[] t){
        this.t = t;

    }

    public double getAverage(){
        return this.calcAvrg(this.t);
    }

    private double calcAvrg(T[] t) {
        double average = 0;

        for (T var : t) {
            average = average + var.doubleValue(); // Now this is acceptable.
            // average = average + (double)var; // Or this.
        }

        return average / t.length;
        
    }

    public boolean isSame(AvCalculator<?> t){
        return this.getAverage() == t.getAverage() ? true : false;
    }

    public boolean isSame(AvCalculator<? extends Double> t, String str){
        // In this method, we bind from above.
        System.out.println(str);
        return this.getAverage() == t.getAverage() ? true : false;
    }

    public boolean isSame(AvCalculator<? super Float> t, int str){
        // In this method, we bind from below.
        return false;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3};
        Double[] arr1 = {1.0, 2.0, 3.0};

        AvCalculator<Integer> avrCal = new AvCalculator<Integer>(arr);
        AvCalculator<Double> avrCal1 = new AvCalculator<Double>(arr1);
        
        System.out.println(avrCal.isSame(avrCal1)); 
        System.out.println(avrCal.isSame(avrCal1, "Using the bounded wild card")); 

    }

}


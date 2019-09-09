package SampleJavaCodes.Classes;

// We may introduce methods with variable number of arguments. To do this we use three dots.
// As is the case, variable length argument must be the last parameter.
// The three dots tell the compiler to treat the variable like an array, hence it may even be even overridden.


// The ambiguity cases are very interesting, which cannot be resolved easily.

class VariableLengthMethods{
    public void variableityMethod(int ... vals){
        for (int var : vals) {
            System.out.println(var);   
        }

    }

    public void variableityMethod(String ... vals){
        for (String var : vals) {
            System.out.println(var);   
        }

    }


    public void variableityMethod(String str, String ... vals){
        for (String var : vals) {
            System.out.println(var);   
        }

    }

    public static void main(String[] args) {
        VariableLengthMethods vMethods = new VariableLengthMethods();
        vMethods.variableityMethod(1, 2, 4, 5);

        //vMethods.variableityMethod();   // This call will be ambiguous, because the compiler does not know whether to call the first or second method!
        //vMethods.variableityMethod("a");   // This call is also ambiguous, because the method does not know whether to call the second or third method.
    }
}
package SampleJavaCodes.Classes;

// For primitive types, the introduction of final keyword is equivalent to saying const.
// final primitive types of class are either initialized directly, or through constructor

class WithFinal{
    final int x = 10;
    final int y;

    public WithFinal() {
        y = 20;
    }

    public void methodWithFinal(final int x, final Helper helper) {
        // When the input to a method is final, its content cannot be changed.
        helper.x = 20;  // When a reference variable is final, its content can be changed, but not the reference value itself.
        //helper = new Helper();
    }

    final Helper returningFinal(){
        // This method is final This does not affect the return value, it means that this the last override of the method,
        // and it cannot be overridden anymore.
        return new Helper();
    }

}

class Helper{
    int x = 10;
}

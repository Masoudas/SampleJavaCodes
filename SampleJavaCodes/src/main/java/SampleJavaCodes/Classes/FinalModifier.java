package SampleJavaCodes.Classes;

// For primitive types, the introduction of final keyword is equivalent to saying const.
// final primitive types of class are either initialized directly, or through constructor

class WithFinal{
    final int x = 10;
    final int y;

    public WithFinal() {
        y = 20;
    }
}

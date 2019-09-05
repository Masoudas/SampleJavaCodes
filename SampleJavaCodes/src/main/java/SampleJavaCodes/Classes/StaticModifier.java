package SampleJavaCodes.Classes;

class StaticVars{
    static int x;
    // We can define a static block to initialize a static variable.
    static {
        if (true){
            x = 5;
        }
        else {
            x = 10;
        }
    }
}

/*
There's no such thing as static classes in java.
static class StaticClass{

}
*/
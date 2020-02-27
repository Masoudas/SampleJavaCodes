package SampleJavaCodes.Enumerations;


public interface EnumAndInterface {}

enum Set1 implements EnumAndInterface{
    Label1, Label2;
}

enum Set2 implements EnumAndInterface{
    Label3, Label4;
}

/**
 Goodness me, how does this work exactly?!
 */
class Test {
    public void print(EnumAndInterface iAndInterface) {
        System.out.println(iAndInterface);        
    }
    public static void main(String[] args) {
        new Test().print(Set1.Label1);
    }
    
}
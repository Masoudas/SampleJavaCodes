package EffectiveJava.GeneralProgramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class RulesForDecreasingLifeTimeOfTemps {
    /**
     * Local or temportary variables are those that last during the scope of a block.
     * We tend to declare them just before they're used, even though I older versions
     * of C, we had to define all local variables on top of the function. This was not
     * useful though, because when we move deeper into the function, we may forget
     * the local variable, it's type and so forth.
     * 
     * So the declaration of a local variable should be delayed as much as possible.
     */
    public void localVariables() {
        
    }

    /**
     * Nearly every local variable declaration should contain an initializer!
     * Exception happens when there's an exception (i.e., try catch). In this case, it
     * the variable is used only inside the try, then it should be defined there. Otherwise,
     * if it has to be defined outside the try, where it cannot be sensibly initialized.
     */
    public void initializeNearlyAllLocalVariables() {
        
    }

    /**
     * As we know, a for loop is defined as follows: for (initialization;
     * termination; increment) { statement(s) } In the initialization part, we can
     * define as many variables as we want to limit scope of variables. 
     *  
     * Like the example we see below. When I use the while to iterate, I have to define
     * a local variable outside, which remains there with no use. Now suppose I do a copy
     * and paste, then I get the subtle bug that the loop does not even start!
     * So use for loops, because they provide an initialization.
     */
    public void useForLoopsOverWhileLoops() {
        List<String> list = new ArrayList<>();

        Iterator<String> i1 = list.iterator();
        while (i1.hasNext()) {
            i1.next();
        }

        Iterator<String> i2 = list.iterator();
        while (i1.hasNext()) { // Subtle copy-paste bug.
            i2.next();
        }

        for (Iterator<String> i = list.iterator(); i.hasNext(); ) {
            i.next();
        }

        // This is a good way to iterate over.
        for (String string : list) {
            
        }
    }

    /**
     * One thing to remember is that we can always define the termination
     * condition inside the for initialization. One thing to remember is that
     * the type of all variables defined in the declaration must be the same!!!
     * So I can't define an string there!
     */
    public void forLoopTerminationCondition() {
        for (int i = 0, last = 10; i < last; i++) {
            
        }
    }

}

package EffectiveJava.Methods;

import org.junit.Test;

public class CheckArgumentsForValidityTest {

    @Test
    public void testAssertion() {
        CheckArgumentsForValidity.callAssertMethod(0, null);
        
    }
}
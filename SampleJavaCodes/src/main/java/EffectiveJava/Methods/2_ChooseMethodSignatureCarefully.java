import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * A method should not have excessive number of arguments. 
 * 
 * 
 * Avoid writing helper methods, unless you're sure they're often used.
 * For example, java List does not have a method to show the last index of a subset,
 * it creates a subview, and then uses the lastIndex method to show that.
 * 
 * Especially, avoid a long set of parameters with the same type, like int, int, int.
 * 
 * To avoid having long list of parameters, we can:
 * 1- Use helper classes.
 * 2- Use builder pattern, where a lot of set methods are there, and finally and execute method
 * to generate the class.
 * 3- Use function nesting, as discussed with the last index case of the java List inteface.
 * 
 * 
 * When there's opportunity to use interface or parameter, go for the interface.
 * For example, Use Map interface as function argument, instead of passing a HashMap.
 * 
 * Finally, favour enum over boolean. Like for example:
 * TemperatureScale = {Celcuis, Kelvin}, for:
 * temperature.ChangeScale(TemperatureScale.Celcius), which would be
 * nicer than temperature.ChangeScale(true). Also allows for extension to other 
 * scales.
 */

 class a{
     HashSet
 }
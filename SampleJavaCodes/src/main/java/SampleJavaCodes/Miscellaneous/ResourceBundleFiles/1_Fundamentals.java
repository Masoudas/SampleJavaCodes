package SampleJavaCodes.Miscellaneous.ResourceBundleFiles;

import java.util.Arrays;

/**
 * Resource bundle is a method of accessing several resources as a bundle.
 * These resources correspond to the compiled resources of course.
 * 
 * Usually this method is used for accessing classes that are the same, but
 * represent different variations. Like for example, texts in different languages.
 * 
 * The java.util package includes three classes that aid in the internationalization.
 * The first is the abstract class ResourceBundle. It defines
 * methods that enable you to manage a collection of locale-sensitive resources 
 * (locale here means region and language basically, and maybe servers!).
 * 
 * Resource bundles are identified by their family name (also called their base name).
 * To the family name can be added a two-character lowercase language 
 * code which specifies the language. In this case, if a requested locale matches 
 * the language code, then that version of the resource bundle is used.
 * Countries are also supported.
 * 
 * There are two subclasses of ResourceBundle. The first is 
 * PropertyResourceBundle, which manages resources by using property files.
 * PropertyResourceBundle adds no methods of its own. The second is the 
 * abstract class ListResourceBundle, which manages resources in an array of 
 * key/value pairs. ListResourceBundle adds the method getContents( ), which 
 * all subclasses must implement. It is shown here: 
 *      protected abstract Object[ ][ ] getContents( )
 * 
 * It returns a two-dimensional array that contains key/value pairs that represent 
 * resources. The keys must be strings. The values are typically strings, but can be
 * other types of objects.
 * 
 * 
 * 
 */

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.ListResourceBundle;

/**
 * The no label default is always English
 */
class TextResource extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[2][2];
        //key
        resources[0][0] = "Greetings";

        // value
        resources[0][1] = "Hey";

        resources[1][0] = "Parting";
        resources[1][1] = "Bye";

        return resources;
    }
}

class TextResource_fr extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] resources = new Object[2][2];
        //key
        resources[0][0] = "Greetings";

        // value
        resources[0][1] = "Bonjour";

        resources[1][0] = "Parting";
        resources[1][1] = "Au revoir";

        return resources;
    }
}

class Fundamentals {
    /**
     * Accessing the resources.
     * @param args
     */
    public static void main(String[] args) {
        // The first argument (base Name) is in fact the name of the package that contains the classes.
        ResourceBundle bundle = ResourceBundle.getBundle("TextResource", Locale.FRENCH);   

        Enumeration<String> keys = bundle.getKeys();

        while(keys.hasMoreElements()){
            String key = keys.nextElement();
            System.out.println(bundle.getObject(key));
        }
    }
}

/** We can also instead extend the ResourceBundle class to have more control over what is returned 
 *  with the methods of the Resource bundle.
 */

class AnotherResource extends ResourceBundle {

    @Override
    protected Object handleGetObject(String key) {
        if (key.equals("Greetings")) return "Hey";
        if (key.equals("Parting")) return "Bye";
        return null;
    }

    @Override
    public Enumeration<String> getKeys() {
        return Collections.enumeration(this.keySet());
    }

    @Override
    protected Set<String> handleKeySet() {
        return new HashSet<String>(Arrays.asList("Greetings", "Parting"));
    }
    
}

/**
 * Don't need to override the entire thing, just the methods that are needed.
 */
class AnotherResource_de extends AnotherResource{
    @Override
    protected Object handleGetObject(String key) {
        if (key.equals("Greetings")) return "Bonjour";
        if (key.equals("Parting")) return "Au revoir";
        return null;
    }
}


class AccessNewResources{
    public static void main(String[] args) {
        ResourceBundle bundle = ResourceBundle.getBundle("AnotherResource", Locale.FRENCH);
    }
}
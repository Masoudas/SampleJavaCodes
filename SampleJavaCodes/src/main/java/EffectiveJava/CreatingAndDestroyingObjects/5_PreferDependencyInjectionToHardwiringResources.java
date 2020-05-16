package EffectiveJava.CreatingAndDestroyingObjects;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Making classes (effectively) static, or singleton has down-side as well. One
 * is that they're nearly impossible to test (Recall the famous
 * FourPolarImagingSetup!)
 * 
 * With dependency injection, we provide the class resources for the class
 * (usually using constructors). This rids us of any hardwiring of resources
 * inside the class.
 * 
 * "Static utility classes and singletons are inappropriate for classes whose
 * behavior is parameterized by an underlying resource."
 * 
 * Consider the example below, where we try to check spell of a text, for which
 * we provide a dictionary. It can be hardwired either through a singleton, or
 * through the use of static methods for utility classes. However, we are
 * hardwired to a particular type of dictionary. Then why not use dependency
 * injection like the third implementation to actually provide the resource for
 * the class.
 * 
 * Dependency injection patterns re Dagger, Spring and Guice, which should be learned!
 * 
 * With dependency injection, we want to go a step further and provide a factory
 * for object, rather than the actual object. The Supplier<T> interface, introduced in Java 8, 
 * is perfect for representing factories. Then we ask for supplier instead of the actual 
 * resource, which like in the case of Tile can be even subclasses of tile.
 */


// Inappropriate use of static utility - inflexible & untestable!
class SpellCheckerUtility {
    private static final Lexicon dictionary = null;

    private SpellCheckerUtility() {
    } // Noninstantiable

    public static boolean isValid(String word) {
        return false;
    }

    public static List<String> suggestions(String typo) {
        return null;
    }
}

// Inappropriate use of singleton - inflexible & untestable!
class SpellCheckerSingleton {
    private final Lexicon dictionary = null;

    private SpellCheckerSingleton() {
    }

    public static SpellCheckerSingleton INSTANCE = new SpellCheckerSingleton();

    public boolean isValid(String word) {
        return false;
    }

    public List<String> suggestions(String typo) {
        return null;
    }
}

class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return false;
    }

    public List<String> suggestions(String typo) {
        return null;
    }
}

class Lexicon {

}

/**
 * -----------------------------------------------------
 */
class TileFactory<T extends Tile> implements Supplier<T>{

    @Override
    public T get() {
        return null;
    }
    
}

class MosaicFactory{
    public Mosiac create(Supplier<? extends Tile> tileFactory) {
        return null;
    }
}



class Tile{

}

class Mosiac{

}
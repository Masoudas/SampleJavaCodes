package EffectiveJava.Methods;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * One word, don't use overloading with the same number of parameters, unless
 * you are absolutely certain that the types are drastically different (Two
 * types are radically different if it is clearly impossible to cast any
 * non-null expression to both types, for example primitive types and reference
 * types are not radically different). In case of same number of parameters,
 * best to use different name methods.
 * 
 * As we know, overloaded methods are assigned at compile time, given that they
 * use variable type to determine the method.
 * 
 * As always, constructors can be an exception and should be viewed as such.
 * 
 * "Selection among overloaded methods is static, while selection among
 * overridden methods is dynamic".
 * 
 * So they can cause strange behavior sometimes, as shown in this example.
 */

class CollectionClassifier {
    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> lst) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        return "Unknown Collection";
    }

    /**
     * Because overloaded method is chosen at compile time through type, and we are
     * passing a Collection reference every time, we use the third method, and each
     * time we return an "Unknown type".
     * 
     * The solution to this problem is as "you guessed it", using the instanceof.
     */
    public static void main(String[] args) {
        Collection<?>[] collections = { new HashSet<String>(), new ArrayList<String>(),
                new HashMap<String, String>().values() };
        for (Collection<?> c : collections)
            System.out.println(classify(c));
    }
}

/**
 * If the typical user of an API does not know which of several method
 * overloadings will get invoked for a given set of parameters, use of the API
 * is likely to result in errors. So why cause this problem then?! Instead, it's
 * best to use methods with different names.
 * 
 * Only time we're allowed to overload methods with same number of parameters,
 * is when the types are radically difference. But for example primitives and
 * class implementations are not, hence, in the following example, we get the
 * weird behavior that instead of removing instances, we remove indexes in the
 * ArrayList, and hence cause confusion.
 */

class SetList {
    /**
     * First, the program adds the integers from −3 to 2, inclusive, to a sorted set
     * and a list. Then, it makes three identical calls to remove on the set and the
     * list. If you’re like most people, you’d expect the program to remove the
     * non-negative values (0, 1, and 2) from the set and the list and to print [-3,
     * -2, -1] [-3, -2, -1] . In fact, the program removes the non-negative values
     * from the set and the odd values from the list and prints [-3, -2, -1] [-2, 0,
     * 2] . It is an understatement to call this behavior confusing. We should've
     * used Integer.valueof instead of course!
     * 
     * @param args
     */
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = -3; i < 3; i++) {
            set.add(i);
            list.add(i);
        }
        for (int i = 0; i < 3; i++) {
            set.remove(i);
            list.remove(i);
        }
        System.out.println(set + " " + list);
    }
}

/**
 * Another ambiguous situation: A Class may for example implement interface A
 * and B. Now we have overriding for both interfaces, but then when we pass the
 * class, an ambiguity happens when choosing the overridden method, and the code
 * cannot be compiled!
 * 
 */

/**
 * Addition of Lambdas and function references has exacerbated this problem.
 * 
 * For example the following code is not compiled. Why? The surprising answer is
 * that the submit method has an overloading that takes a Callable<T> , while
 * the Thread constructor does not. You might think that this shouldn’t make any
 * difference because all overloadings of println return void , so the method
 * reference couldn’t possibly be a Callable . This makes perfect sense, but
 * it’s not the way the overload resolution algorithm works. Perhaps equally
 * surprising is that the submit method invocation would be legal if the println
 * method weren’t also overloaded. It is the combination of the overloading of
 * the referenced method ( println ) and the invoked method ( submit ) that
 * prevents the overload resolution algorithm from behaving as you’d expect.
 * 
 * Therefore, "DO NOT overload methods to take different functional interfaces in
 * the same argument position".
 * 
 * Read omitted parts from the book.
 */

class CodeNotCompiled {
    public static void main(String[] args) {
        new Thread(System.out::println).start();

        ExecutorService exec = Executors.newCachedThreadPool();
        // exec.submit(System.out::println); This line is not compiled.

    }
}

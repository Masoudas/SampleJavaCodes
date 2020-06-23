package SampleJavaCodes.Streams.Collectors;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Person1 {
    String name;
    int id;

    public Person1(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

/**
 * The simplest one is the to map, which asks for two Functions to map to key
 * and value from the elements of the stream. Note that if a duplicate key
 * exists, this map throws an exception.
 */
class SimplestToMap {
    public static void main(String[] args) {
        Person1[] persons = { new Person1("a", 1), new Person1("b", 2), new Person1("c", 3) };

        Map<String, Person1> mapToPerson = Stream.of(persons)
                .collect(Collectors.toMap(Person1::getName, Function.identity()));

        Map<String, Integer> MapToId = Stream.of(persons).collect(Collectors.toMap(p -> p.name, p -> p.id));

        System.out.println(MapToId);
    }
}

/**
 * What happens if there are duplicate keys inside the dictionary? Well the
 * merge function help us decide!
 * 
 * Like in the follwing example, only a1 and b3 will remain.
 */

class CreateMapAndResolveDuplicateKeys {
    public static void main(String[] args) {
        Person1[] persons = { new Person1("a", 1), new Person1("b", 2), new Person1("b", 3) };

        Map<String, Integer> MapToId = Stream.of(persons).collect(Collectors.toMap(p -> p.name, p -> p.id, (p1, p2) -> {
            if (p1 > p2) {
                return p1;
            }
            return p2;
        }));

        System.out.println(MapToId);
    }
}

/**
 * With the last implementation, we can supply the type of map to be created.
 */
class CreateMapWithMapSupplier {
    public static void main(String[] args) {
        Person1[] persons = { new Person1("a", 1), new Person1("b", 2), new Person1("b", 3) };

        HashMap<String, Integer> map = Stream.of(persons)
                .collect(Collectors.toMap(Person1::getName, Person1::getId, (p1, p2) -> {
                    if (p1 > p2) {
                        return p1;
                    }
                    return p2;
                }, HashMap::new));
        
        System.out.println(map);
    }
}
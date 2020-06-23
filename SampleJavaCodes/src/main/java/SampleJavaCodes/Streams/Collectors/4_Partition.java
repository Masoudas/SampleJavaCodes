package SampleJavaCodes.Streams.Collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Partition does nothing further than what groupby does */
class Person2 {
    String name;
    int id;

    public Person2(String name, int id) {
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
 * Partition allow us to separate an stream into two camps, one being true and
 * other being false, where an element is set into each camp based on the
 * predicate supplied.
 * 
 * We can imitate the same behavior with toMap method.
 */
class Partition {
    public static void main(String[] args) {
        Person2[] persons = { new Person2("a", 1), new Person2("b", 2), new Person2("b", 3) };

        Map<Boolean, List<Person2>> partition = Stream.of(persons)
                .collect(Collectors.partitioningBy(t -> t.getId() > 2 ? true : false));
        System.out.println(partition);

        // Repeating the same behavior with groupby
        Map<Boolean, List<Person2>> partitionByGrouping = Stream.of(persons)
                .collect(Collectors.groupingBy(p -> p.getId() > 2 ? true : false));

        System.out.println(partitionByGrouping);
    }
}
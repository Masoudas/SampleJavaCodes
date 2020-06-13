package SampleJavaCodes.Streams.Collectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * What are collectors? It is possible (indeed, common) to obtain a stream from
 * a collection. Sometimes it is desirable to obtain the opposite: to obtain a
 * collection from a stream. To perform such an action, the stream API provides
 * the collect( ) method.
 * 
 * As we know, we have two collect methods for streams, one is (Which is a
 * terminal operation) <R, A> R collect(Collector<? super T, A, R>
 * collectorFunc), where T is the element of the invoking stream, R specifies
 * the type of the result, and A specifies the internal accumulation type.
 * 
 * The collector interface is declared in java.utils as Collector<T,A,R> The
 * most famous two implementations are Collectors.toSet and Collectors.toList.
 * 
 * The second form of collect is <> R collect(Supplier<R> target, BiConsumer<R,
 * ? super T> accumulator, BiConsumer<R, R> combiner). To understand the
 * interfaces Supplier and BiConsumer, refer to functional interfaces package
 * first.
 * 
 * Ok, so now, the accumulator is the method responsible for adding objects to
 * this target, whose Type is indicated by R. Note that for biConsumer we have
 * void accept(C obj, D obj2), hence we accept obj2 (of type T) to put it the in
 * target obj (of type R).
 * 
 * The combiner is responsible for adding different objects of Type R here. What
 * is that used for? If each stream generates a new object of type R, we need to
 * append them together.
 * 
 * In collecter example, I try to put an stream of ints into a linked list.
 */
class Basics {
    public static void main(String[] args) {
        Collector<?, ?, ?> collector;
    }

}

class CollectToLinkedList {
    public static void main(String[] args) {
        // A special note on the add all. If it has duplicate elements, then it will
        // (same class reference), it will be eliminated!
        LinkedList<Integer> listOfInt = IntStream.range(1, 10).collect(() -> {
            return new LinkedList<>();
        }, (list, obj) -> list.add(obj), (list1, list2) -> {
            list1.addAll(list2);
        });

        // This is a more sophistaced version of the previous verbose thing
        LinkedList<Integer> list1OfInt = IntStream.range(1, 10).collect(LinkedList::new, LinkedList::add,
                LinkedList::addAll);

        // To add two lists together so that the duplicates are remaining, we need to
        // use the flatmap of the stream
        LinkedList<Integer> list2OfIntEnsuringDuplicates = IntStream.range(1, 10).collect(LinkedList::new,
                LinkedList::add, (listOne, listTwo) -> {
                    Stream.of(listOne, listTwo).flatMap(x -> x.stream()).collect(Collectors.toList());
                });

        // Standard method that returns a list interface
        // List<Integer> list1OfInt = IntStream.range(1,
        // 10).collect(Collectors.toList());

        System.out.println(listOfInt);
        System.out.println(list1OfInt);

    }

}
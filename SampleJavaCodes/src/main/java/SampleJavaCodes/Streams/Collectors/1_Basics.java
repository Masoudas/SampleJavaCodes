package SampleJavaCodes.Streams.Collectors;

import java.util.stream.Collector;

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
 * ? super T> accumulator, BiConsumer<R, R> combiner). To understand the interfaces
 * Supplier and BiConsumer, refer to functional interfaces package first.
 * 
 */
class Basics {
    public static void main(String[] args) {
        Collector<?, ?, ?> collector;
    }

}
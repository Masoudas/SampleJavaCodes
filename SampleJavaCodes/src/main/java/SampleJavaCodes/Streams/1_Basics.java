package SampleJavaCodes.Streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * When dealing with collections of data, we sometimes like to certain
 * operations on it, leveraging multi-core, and avoid writing large error-prone
 * code. Stream abstracts do that for us. They do what SQL like structures do
 * 
 * SELECT max(salary), employee_id, employee_name FROM Employee which returns
 * the row with employee of maximum salary.
 * 
 * Stream represents a sequence of objects from a source, which supports
 * aggregate operations. Following are the characteristics of a Stream −
 * 
 * 1- Sequence of elements − A stream provides a set of elements of specific
 * type in a sequential manner. A stream gets/computes elements on demand. It
 * never stores the elements.
 * 
 * 2- Source − Stream takes Collections, Arrays, or I/O resources as input
 * source.
 * 
 * 3- Aggregate operations − Stream supports aggregate operations like filter,
 * map, limit, reduce, find, match, and so on.
 * 
 * 4- Pipelining − Most of the stream operations return stream itself so that
 * their result can be pipelined. These operations are called intermediate
 * operations and their function is to take input, process them, and return
 * output to the target. collect() method is a terminal operation which is
 * normally present at the end of the pipelining operation to mark the end of
 * the stream.
 * 
 * 5- Automatic iterations − Stream operations do the iterations internally over
 * the source elements provided, in contrast to Collections where explicit
 * iteration is required (like when searching for the max of a collection).
 * 
 */

class ExampleImplementation {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        // Nice!
        filtered.stream().forEach(System.out::println);

        // Alternatively, we can use parallel streams!
        long count = strings.stream().parallel().filter(string -> !string.isEmpty()).count();

        // We can limit in terms of size for example! Jesus!
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        // We can perform statistics too.
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

        IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

        
    }

    public static void operationsOnAnArray() {
        // Calculating the cumulative multiplication using streams
        // Is it even feasible? Maybe not, because each element is in the hand of one
        // thread for example, so it's not. Perhaps unless I give the entire 
        // arr to the stream too! Which would be dumb! So I would 
        
        int[] arr1 = {1,2,3};

        IntStream.rangeClosed(1, arr1.length).mapToObj((i)-> arr1[i] = arr1[i-1]*arr1[i]);
    }
}

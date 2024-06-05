package Lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyStream {

    public static void main(String[] args) {
        

        /*
        Streams in Java, introduced in Java 8, are a powerful tool for processing sequences of elements in a functional style. 
        They enable operations such as filtering, mapping, and reducing, providing a way to perform complex data manipulations with concise and readable code 
        */

        //From Collections
        List<String> list = Arrays.asList("a","b","c");
        Stream<String> listsStream = list.stream();
        System.out.println(listsStream);

        //From Array
        String[] array = {"a", "b", "c"};
        Stream<String> streamArr = Arrays.stream(array);

        //From static
        Stream<String> streamST = Stream.of("a", "b", "c");


        //Stream Operations

        Predicate<String> startsWithA = (s) -> s.startsWith("a");
        //Predicate<String> startsWithA_ =  String::startsWith;

        Consumer<String> print_ = System.out::print;
        Consumer<Integer> printI = System.out::println;



        // Intermediate Operations

        //Filter ->Predicate

        String[] array_ = {"a", "ab", "c"};
        Stream<String> filtered = Arrays.stream(array_).filter(startsWithA);
        filtered.forEach(System.out::println);
        //filtered.forEach(print_);

        //Map -> Function

        Function<String,Integer> length_finder =  String::length;
        String[] array1 = {"123", "3434", "34343434"};
        Stream<Integer> lengthStream = Arrays.stream(array1).map(length_finder);
        lengthStream.forEach(printI);

        //FlatMap
        List<List<String>> list_ = Arrays.asList(
            Arrays.asList("a","b"),
            Arrays.asList("c","d","a")
        );
        Stream<String> flStream = list_.stream().flatMap(Collection::stream);
        flStream.forEach(System.out::print);

        System.out.println();


        //Distinct
        Stream<String> diStream = list_.stream().flatMap(Collection::stream).distinct();
        diStream.forEach(System.out::print);

        System.out.println();

        //Sorted
        Stream<String> soStream = list_.stream().flatMap(Collection::stream).sorted();
        soStream.forEach(print_);

        System.out.println();
        //Peek
        list_.stream().flatMap(Collection::stream).map( String::toUpperCase).peek(System.out::print).collect(Collectors.toList());
        

        System.out.println("\nTerminal operationss");
        Arrays.stream(array1).forEach(System.out::println);


        String[] arr = {"a", "ab", "c"};
        Stream<String> arrStrams = Arrays.stream(arr);

        //Converting Stream to List

        List<String> a1 = arrStrams.collect(Collectors.toList());

        //Reduce

        int[] numbers = {1,2,3,4,5};
        OptionalInt sum = Arrays.stream(numbers).reduce((i1,i2) -> i1+i2);
        System.out.println(sum.getAsInt());

        // Count Streams

        System.out.println(Arrays.stream(numbers).count());

        // Any Match
        String[] arr1 = {"abc","acde","efgi"};
        boolean anyMatch = Arrays.stream(arr1).anyMatch((s) -> s.length() == 4);
        System.out.println(anyMatch);

        //All Match
        boolean allmatch = Arrays.stream(arr1).allMatch((s) -> s.length() == 3);
        System.out.println(allmatch);

        //None Match
        boolean nonematch = Arrays.stream(arr1).noneMatch((s) -> s.length()>5);
        System.out.println(nonematch);

        //Find First

        Optional<String> optStr = Arrays.stream(arr1).filter((s) -> s.length() == 4).findFirst(); 
        System.out.println(optStr.get());
        
        //to List
        String[] setA = {"1","22","333","44","33"};
        List<String> a = Arrays.stream(setA).collect(Collectors.toList());
        a.forEach(print_);

        System.out.println();

        //to List
        Set<String> s = Arrays.stream(setA).collect(Collectors.toSet());
        s.forEach(print_);

        // to Map
        Map<String,Integer> map = Arrays.stream(setA).collect(
            Collectors.toMap(Function.identity(), String::length)
        );
        System.out.println(map);

        Map<Integer, List<String>> groupedByLength = Arrays.stream(setA).collect(
                Collectors.groupingBy(String::length));
        System.out.println(groupedByLength);


        Map<Boolean, List<String>> partitioned = Arrays.stream(arr1).collect
                        (
                            Collectors.partitioningBy(startsWithA));
    System.out.println(partitioned);


    List<Integer> l = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    long count = l.stream().filter((x) -> x>5).count();
    System.out.println(count);


    }
    
}

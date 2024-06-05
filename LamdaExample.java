package Lambda;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaExample {

    public static void main(String[] args) {
        
        //Predicate --> Represents a predicate(Boolean expression) of one argument
        Predicate<Integer> isEven = (n) -> n%2 == 0;
        System.out.println(isEven.test(3));

        //Function -> Represents a function that accepts one argument and produces the result
        Function<String,Integer> leng = (str) -> str.length();
        System.out.println(leng.apply("Hello Man"));

        //Consumer -> Represents a operation that accepts a single input argument and returns no result
        Consumer<String> str = (s) -> System.out.println(s);
        str.accept("Hey Man");

        //Supplier -> Represents a supplier of results
        Supplier<Double> random = () -> Math.random();
        System.out.println(random.get());


        //Bi Funcion: Represents a function that accepts two argument and produces the result

        BiFunction<Integer,Integer,Integer> add = (a,b) ->  a+b;
        System.out.println(add.apply(4, 3));

        // Advanced Concepts


        /** 1. Method References
        Method references provide a way to refer to methods without invoking them. 
        //They are compact and readable, often used as shorthand for lambda expressions that call an existing method. **/

        Function<Double,Double> sqrt = (x) -> Math.sqrt(x);
        Function<Double,Double> sq = Math::sqrt;

        System.out.println(sqrt.apply(9.0d));
        System.out.println(sq.apply(16.0d));


        /* 2. Instance Method of a perticular objects */
        Consumer<String> string = (s) -> System.out.println(s);
        //Lambda notation
        Consumer<String> stri = System.out::println;
        string.accept("Hey Hello");
        stri.accept("Hello Hey");

        // Constructors

        Supplier<ArrayList<String>> giveEmptyList = () -> new ArrayList<String>();

        Supplier<ArrayList<String>> giveList = ArrayList<String>::new;

        






    }
    
}

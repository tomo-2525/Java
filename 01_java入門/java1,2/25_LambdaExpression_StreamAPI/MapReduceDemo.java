import java.util.*;
import java.util.stream.*;

public class MapReduceDemo {
    public static void main(String args[]) {
        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        // demonstration of map method
        List<Integer> square = number.stream().map(x -> x * x).collect(Collectors.toList());
        System.out.println(square);
        System.out.println();

        // create a list of String
        List<String> names = Arrays.asList("Reflection", "A Collection", "Stream");
        // demonstration of filter method
        List<String> result = names.stream().filter(s -> s.startsWith("S")).collect(Collectors.toList());
        System.out.println(result);
        System.out.println();

        // demonstration of sorted method
        List<String> show = names.stream().sorted().collect(Collectors.toList());
        System.out.println(show);
        System.out.println();

        // create a list of integers
        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 2); // collect method returns a set
        Set<Integer> squareSet = numbers.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(squareSet);
        System.out.println();

        // demonstration of forEach method
        number.stream().map(x -> x * x).forEach(y -> System.out.println(y));
        System.out.println();

        // demonstration of reduce method
        int even = number.stream().filter(x -> x % 2 == 0).reduce(0, (ans, i) -> ans + i);
        System.out.println(even);
    }
}
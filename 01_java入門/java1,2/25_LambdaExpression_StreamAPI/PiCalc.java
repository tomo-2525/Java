import java.util.stream.*;

import javax.lang.model.element.Element;

import java.util.*;
import java.math.*;

public class PiCalc {
    public static void main(String[] args) {

        IntStream is = new IntStream.range(0, 99999999);

        // Parallel exec
        IntStream parallelStream = mylist.parallelStream();
        long start_1 = System.currentTimeMillis();

        long end_1 = System.currentTimeMillis();
        System.out.println("Running time by parallel exec. = " + (end_1 - start_1));
        parallelStream.forEach(p -> System.out.println("High Nums parallel=" + p));
        System.out.println(parallelStream + " delta-abs:");
        /*
        
        
        */
        // Sequential exec
        Stream<Double> sequentialStream = myList.stream();
        long start_2 = System.currentTimeMillis();
        sequentialStream = sequentialStream.mapToDouble((a) -> {
            return 4.0 * 1.0 / 99999999
                    * (Math.sqrt(Math.pow(r.random(1000) / 10000, 2) + Math.pow(r.random(1000) / 10000, 2)) <= 1 ? 1
                            : 0);
        });
        long end_2 = System.currentTimeMillis();
        sequentialStream.forEach(p -> System.out.println("High Nums parallel=" + p));
        System.out.println("Running time by sequential exec. = " + (end_2 - start_2));

        System.out.println(sequentialStream + " delta-abs:");
        System.out.println("Raito = " + ((end_2 - start_2) / (end_1 - start_1)));

    }
}
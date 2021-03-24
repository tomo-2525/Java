import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

import java.util.regex.*;

public class JavaStreamExercise {
    public static void main(String args[]) {
        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        // demonstration of map method
        List<Integer> multiply_2 = number.stream().map(x -> 2 * x).collect(Collectors.toList());
        System.out.println(multiply_2);

        // create a list of String
        List<String> stoplist = Arrays.asList("is", "was", "to", "have", "in", "on");
        List<String> teststr = Arrays.asList("The", "2019-20", "coronavirus", "pandemic", "was", "confirmed", "to",
                "have", "spread", "to", "Japan", "on", "16", "January", "2020", ".");
        teststr = teststr.stream().filter((elem) -> {
            int frag = 0;
            for (String str : stoplist) {
                if (elem.compareTo(str) == 0)
                    frag = 1;
            }

            if (frag == 1)
                return false;
            else
                return true;
        }).filter(elem -> {
            String regex_Alphabet = "^[A-Za-z]+$";
            Pattern p = Pattern.compile(regex_Alphabet);
            Matcher m = p.matcher(elem);
            return m.matches();
        }).collect(Collectors.toList());
        System.out.println(teststr);

        teststr = teststr.stream().collect(ArrayList::new, (l, e) -> l.add(0, e), (l, subl) -> l.addAll(0, subl));
        System.out.println(teststr);
    }
}

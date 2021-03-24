import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class WordCount {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("コマンドライン引数にファイル名を入力してください！");
            System.out.println("使い方　java WordCount ファイル名");
            System.exit(0);
        }

        try {
            List<String> table = new ArrayList<>();
            BufferedReader in = new BufferedReader(new FileReader(args[0]));
            while (true) {
                String line = in.readLine();
                if (line == null) {
                    break;
                }
                line = line.replace(".", "").replace(",", "").replaceAll("^[A-Za-z0-9]+$", " ");
                for (String s : line.split("\\s+")) {
                    if (!s.equals("")) {
                        table.add(s);
                    }
                }
            }
            in.close();

            Map<String, Integer> map = table.stream()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(s -> 1)));
            System.out.println(map);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

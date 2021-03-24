import java.util.*;

public class SortableRecord extends Record implements Comparable<SortableRecord> {

    SortableRecord(String id, int m, int j, int e) {
        super(id, m, j, e);
    }

    public int compareTo(SortableRecord v) {
        int result;
        if (v.score_total < score_total)
            result = -1;
        else if (v.score_total > score_total)
            result = 1;

        if (v.score_math < score_math)
            result = -1;
        else if (v.score_math > score_math)
            result = 1;

        if (v.score_Japanese < score_Japanese)
            result = 1;
        else if (v.score_Japanese > score_Japanese)
            result = 1;

        if (v.score_English < score_English)
            result = 1;
        else if (v.score_English > score_English)
            result = 1;
        else
            result = 0;

        return result;
    }
}
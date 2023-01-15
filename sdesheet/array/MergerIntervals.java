import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergerIntervals {

    public static void main(String[] args) {
        ArrayList<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(new Integer[] { 1, 3 }));
        arr.add(Arrays.asList(new Integer[] { 2, 4 }));
        arr.add(Arrays.asList(new Integer[] { 2, 6 }));
        arr.add(Arrays.asList(new Integer[] { 8, 9 }));
        arr.add(Arrays.asList(new Integer[] { 8, 10 }));
        arr.add(Arrays.asList(new Integer[] { 9, 11 }));
        arr.add(Arrays.asList(new Integer[] { 15, 18 }));
        arr.add(Arrays.asList(new Integer[] { 16, 17 }));

        var mergedArray = mergerIntervals(arr);

        System.out.println(mergedArray.toString());
    }

    private static ArrayList<List<Integer>> mergerIntervals(ArrayList<List<Integer>> arr) {

        if (arr.isEmpty()) {
            return arr;
        }

        Collections.sort(arr, (a, b) -> a.get(0) - b.get(0));
        ArrayList<List<Integer>> merged = new ArrayList<>();
        // [1,3] [2,6]
        for (int i = 0; i < arr.size(); i++) {

            if (merged.isEmpty() || merged.get(merged.size() - 1).get(1) < arr.get(i).get(0)) {

                var node = new ArrayList<Integer>();
                node.add(arr.get(i).get(0));
                node.add(arr.get(i).get(1));
                merged.add(node);

            } else {
                merged.get(merged.size() - 1).set(1,
                        Math.max(merged.get(merged.size() - 1).get(1),
                                arr.get(i).get(1)));
            }
        }

        return merged;

    }
}

import java.util.HashSet;

public class RemoveDuplicatesAndGiveTheSize {

    /***
     * 
     * Problem Statement: Given an integer array sorted in non-decreasing order,
     * remove the duplicates in place such that each unique element appears only
     * once. The relative order of the elements should be kept the same.
     * 
     * If there are k elements after removing the duplicates, then the first k
     * elements of the array should hold the final result. It does not matter what
     * you leave beyond the first k elements.
     * 
     * Note: Return k after placing the final result in the first k slots of the
     * array.
     * 
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {

    }

    /***
     * 
     * Load all the elemenst to a set
     * take the size of the set
     * put all the elements back to the array
     * 
     * @param input
     */
    public static int removeDuplicatesBruteForce(int[] input) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            set.add(input[i]);
        }

        int k = set.size();

        int j = 0;
        for (int val : set) {

            input[j++] = val;
        }
        return k;
    }

    // int arr[] = {1,1,2,2,2,3,3};
    public static int removeDuplicatesOptimised(int[] input) {

        int indexOfUniqueElement = 0;
        for (int index = 1; index < input.length; index++) {
            if (input[indexOfUniqueElement] != input[index]) {
                input[indexOfUniqueElement] = input[index];
                indexOfUniqueElement++;
            }
        }
        return indexOfUniqueElement + 1;
    }
}

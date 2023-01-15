public class Duplicate {
    public static void main(String[] args) {
        // find duplicates in n+1 numbers
        int[] input = { 1, 3, 4, 2, 3 };
        System.out.println(findDuplicate(input));
    }

    public static int findDuplicate(int[] nums) {

        // Find the intersection point of the two runners.
        int fast = nums[0];
        int slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        // Find the "entrance" to the cycle.
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return fast;
    }
}
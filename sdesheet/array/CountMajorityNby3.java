public class CountMajorityNby3 {
    public static void main(String[] args) {
        int input[] = { 2, 2, 2, 10, 3, 3, 3, 2 };
        majorityElement(input);
    }

    public static void majorityElement(int[] nums) {

        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 0;

        for (int n : nums) {
            if (candidate1 == n) {
                count1++;
            } else if (candidate2 == n) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = n;
                count1++;
            } else if (count2 == 0) {
                candidate2 = n;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int n : nums) {
            if (n == candidate1) {
                count1++;
            }
            if (n == candidate2) {
                count2++;
            }
        }

        System.out.println("Majority numbers are ");
        System.out.println(count1 > nums.length / 3 ? candidate1 : "");
        System.out.println(count2 > nums.length / 3 ? candidate2 : "");

    }
}

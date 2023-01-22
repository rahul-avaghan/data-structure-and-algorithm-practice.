public class TappingRainWater {

    /***
     * 
     * Given an array arr[] of N non-negative integers representing the height of
     * blocks. If width of each block is 1, compute
     * how much water can be trapped between the blocks during the rainy season.
     * 
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {
        // int[] input = { 3, 0, 0, 2, 0, 4 };
        // int[] input = { 4, 0, 0, 2, 0, 3 };
        int[] input = { 1, 0, 1, 2, 0, 3 };

        int l = 0;
        int r = input.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;
        while (l < r) {
            leftMax = (leftMax > input[l]) ? leftMax : input[l];
            rightMax = (rightMax > input[r]) ? rightMax : input[r];

            if (leftMax < rightMax) {
                totalWater += leftMax - input[l];
                l++;
            } else {
                totalWater += rightMax - input[r];
                r -= 1;
            }
        }

        System.out.print("Total Area : " + totalWater);

    }

}
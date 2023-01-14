
public class KadensAlgo {

    /***
     * 
     * o(n3)
     * 
     * for(i=0;i<n;i++){
     * for(j=i;j<n;j++){
     * for(k=i; k <j; k++){
     * curSum+= input[k];
     * }
     * maxSum = max(curSum,maxSum);
     * }
     * 
     * 
     * }
     * curSum
     * for(i=0;i<n;i++){
     * for(j=i;j<n;j++){
     * 
     * curSum+= input[k];
     * }
     * maxSum = max(curSum,maxSum);
     * }
     * 
     * 
     * }
     * 
     * 
     * 
     * 
     * 
     * 
     * @param args
     */

    public static void main(String[] args) {
        int[] input = { -1, 2, -3, 5, 6, -10, -5 };
        int sum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int i = 0; i < input.length; i++) {
            curSum += input[i];
            sum = Math.max(curSum, sum);
            curSum = Math.max(curSum, 0);
        }
        System.out.print(sum);
    }
}
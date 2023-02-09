import java.util.Arrays;

/***
 * 
 * 
 * Job Sequencing Problem
 * Problem Statement: You are given a set of N jobs where each job comes with a
 * deadline and profit. The profit can only be earned upon completing the job
 * within its deadline. Find the number of jobs done and the maximum profit that
 * can be obtained. Each job takes a single unit of time and only one job can be
 * performed at a time.
 * 
 * Input: N = 4, Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
 * 
 * Output: 2 60
 */

public class JobSquence {

    public static class Job {

        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

    }
    // {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}

    public static void main(String[] args) {
        Job[] jobs = new Job[] {
                new Job(1, 4, 20),
                new Job(2, 1, 10),
                new Job(3, 1, 40),
                new Job(4, 1, 30)
        };
        int profit = getMaxProfit(jobs);
        System.out.println("Total profit " + profit);

    }

    public static int getMaxProfit(Job[] jobs) {

        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxi = 0;
        int n = jobs.length;

        for (int i = 0; i < n; i++) {
            if (maxi < jobs[i].end) {
                maxi = jobs[i].end;
            }
        }

        int[] answers = new int[maxi + 1];

        for (int i = 0; i < maxi; i++) {
            answers[i] = -1;
        }

        int totalProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = jobs[i].end; j > 0; j--) {
                if (answers[i] == -1) {

                    totalProfit += jobs[i].profit;
                    answers[j] = i;
                    break;
                }
            }
        }

        return totalProfit;
    }

}

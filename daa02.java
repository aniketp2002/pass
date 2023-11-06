
// Implement job sequencing with deadlines using a greedy method


import java.util.Arrays;

class Job {
    char id;
    int deadline;
    int profit;

    public Job(char id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencing {
    public static void jobSequence(Job[] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs, (a, b) -> Integer.compare(b.profit, a.profit)); // Sort jobs by profit in descending order
        boolean[] slot = new boolean[n];
        char[] result = new char[n];
        int totalProfit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = Math.min(n, jobs[i].deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    result[j] = jobs[i].id;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        System.out.println("Job Sequence for Maximum Profit:");
        for (int i = 0; i < n; i++) {
            if (slot[i]) {
                System.out.print(result[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }

    public static void main(String[] args) {
        Job[] jobs = {
            new Job('a', 2, 100),
            new Job('b', 1, 19),
            new Job('c', 2, 27),
            new Job('d', 1, 25),
            new Job('e', 3, 15)
        };

        jobSequence(jobs);
    }
}


// Time Complexity:

// Sorting the jobs based on profit: O(n*log(n)), where 'n' is the number of jobs.
// The subsequent loop for job allocation: O(n)
// Overall, the time complexity is O(n*log(n)), dominated by the sorting step.


// Space Complexity:

// The space complexity is primarily determined by the data structures used to store the job sequence and other information.
// result array: O(n) where 'n' is the number of jobs. It stores the job sequence.
// slot array: O(n) where 'n' is the number of jobs. It tracks available slots.
// Other variables and input data structures: O(1)
// Overall, the space complexity is O(n) due to the arrays used for tracking job sequence and slot availability.
import java.util.Scanner;

public class FCFSMain {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of jobs");
		int numOfJobs = sc.nextInt();
		JobSchedular job = new JobSchedular(numOfJobs);
		job.getTurnAroundTime();
		job.getCompletionTime();
		job.getWaitingTime();
		int maximumWait = job.getMaximumWaiting();
		System.out.println("Maximum waiting time is: " + maximumWait);
		double average = job.getAverageWaitingTime();
		System.out.println("Average waiting time is: " + average);
		sc.close();
	}
}

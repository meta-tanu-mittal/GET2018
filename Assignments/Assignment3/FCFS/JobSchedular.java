import java.util.Scanner;

public class JobSchedular {
	int[][] jobArray;
	int numOfJobs;
	int[] complete;
	int[] wait;
	int[] turnAround;

	public JobSchedular(int jobs) {
		numOfJobs = jobs;
		Scanner sc = new Scanner(System.in);
		jobArray = new int[jobs][3];
		complete = new int[jobs];
		wait = new int[jobs];
		turnAround = new int[jobs];
		System.out.println("Enter arrival time and burst time");
		for (int count = 0; count < jobs; count++) {
			System.out.println("For process" + count);
			jobArray[count][0] = sc.nextInt();
			jobArray[count][1] = sc.nextInt();
			jobArray[count][2] = count;
		}
		sc.close();
		sortJobs();
		completionTime();
		waitingTime();
		turnAroundTime();
	}

	public void swap(int number1, int number2) {
		int swapVariable;
		for (int counter = 0; counter < 3; counter++) {
			swapVariable = jobArray[number1][counter];
			jobArray[number1][counter] = jobArray[number2][counter];
			jobArray[number2][counter] = swapVariable;
		}
	}

	public void sortJobs() {
		for (int count = 0; count < numOfJobs; count++) {
			for (int count2 = count + 1; count2 < numOfJobs; count2++) {
				if (jobArray[count][0

				] > jobArray[count2][0]) {
					swap(count, count2);

				}
			}
		}
	}

	public void turnAroundTime() {
		for (int count = 0; count < numOfJobs; count++) {
			turnAround[count] = complete[count] - jobArray[count][0];
		}

	}

	public void getTurnAroundTime() {
		System.out.println("Turn Around time of processes are: ");
		display(turnAround);
	}

	public void waitingTime() {
		for (int count = 0; count < numOfJobs; count++) {
			if (count == 0 || jobArray[count][0] > complete[count - 1]) {
				wait[count] = 0;
			} else {
				wait[count] = complete[count - 1] - jobArray[count][0];

			}
		}

	}

	public void getWaitingTime() {
		System.out.println("Waiting time of processes are: ");
		display(wait);
	}

	void display(int[] arrayDisplay) {
		System.out.println("Process id \t Time");
		for (int counter = 0; counter < numOfJobs; counter++) {
			System.out.println("" + jobArray[counter][2] + "\t\t"
					+ arrayDisplay[counter]);
		}
		System.out.println();
	}

	public void completionTime() {
		for (int count = 0; count < numOfJobs; count++) {
			if (count == 0 || jobArray[count][0] > complete[count - 1]) {
				complete[count] = jobArray[count][0] + jobArray[count][1];
				continue;
			} else {
				complete[count] = complete[count - 1] + jobArray[count][1];

			}
		}

	}

	public void getCompletionTime() {
		System.out.println("Completion time of processes are: ");
		display(complete);
	}

	public double getAverageWaitingTime() {
		int sum = 0;
		double average;
		for (int counter = 0; counter < numOfJobs; counter++) {
			sum = sum + wait[counter];
		}
		average = sum / numOfJobs;
		return average;
	}

	public int getMaximumWaiting() {
		int max = wait[0];
		for (int counter = 1; counter < numOfJobs; counter++) {
			if (wait[counter] > max) {
				max = wait[counter];
			}
		}
		return max;
	}
}

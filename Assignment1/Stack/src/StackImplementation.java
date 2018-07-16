import java.util.Scanner;

class UseStack {
	private static int max = 5;
	int stack[] = new int[max];
	static int top = -1;
	Scanner sc1 = new Scanner(System.in);

	public UseStack() {

		System.out.print("enter the max size of stack:");
		max = sc1.nextInt();
	}

	void push(int a) {
		// System.out.println(max);
		if (top == (max - 1))
			System.out.println("stack is full");
		else {// System.out.println(top);
			top++;
			stack[top] = a;
		}
	}

	int pop() {
		int n;
		if (top == -1) {
			System.out.println("stack is empty");
			return -1;
		} else {
			n = stack[top];
			top--;
			return n;
		}
	}

	void display() {
		int i;
		if (top == -1) {
			System.out.println("stack is empty");
		} else {
			for (i = 0; i <= top; i++) {
				System.out.print(stack[i] + "\t");
			}
		}
	}
}

public class StackImplementation {
	public static void main(String args[]) {
		int choice;
		Scanner sc = new Scanner(System.in);
		UseStack obj = new UseStack();
		while (true) {
			System.out
					.println("enter the following: \n1push \n2pop \n3display elements");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the no to be inserted:");
				obj.push(sc.nextInt());
				break;
			case 2:
				int a = obj.pop();
				if (a == -1) {
				} else
					System.out.println("element to be popped out:" + a);
				break;
			case 3:
				obj.display();
				break;
			default:
				System.out.println("enter your choice correctly");
			}

		}

	}

}

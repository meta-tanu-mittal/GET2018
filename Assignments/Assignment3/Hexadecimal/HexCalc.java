import java.util.ArrayList;
import java.util.Scanner;

public class HexCalc implements Calculator {
	private String number1, number2;
	Scanner sc = new Scanner(System.in);

	public void getNumbers() {
		System.out.println("enter first no in hexadecimal format:");
		number1 = (sc.next()).replaceAll("^0+(?!$)", "");
		System.out.println("enter second no in hexadecimal format:");
		number2 = (sc.next()).replaceAll("^0+(?!$)", "");
	}

	public int convertOtherToDecimal(String number1) {
		String num = number1.toUpperCase();
		int int_value = 0;
		int base = 1;

		for (int i = (num.length() - 1); i >= 0; i--) {
			int value = num.charAt(i);
			if (value >= '0' && num.charAt(i) <= '9') {
				int_value = int_value + ((value - 48) * base);
				base = base * 16;
			} else {
				int_value = int_value + ((value - 55) * base);
				base = base * 16;
			}
		}

		return int_value;
	}

	public String convertDecimalToOther(int num) {
		ArrayList<Character> lst = new ArrayList<Character>();
		int temp;
		while (num != 0) {
			temp = num % 16;
			if (temp < 10) {
				lst.add((char) (temp + 48));
			} else {
				lst.add((char) (temp + 55));
			}
			num = num / 16;
		}

		String str = "";
		for (int i = (lst.size()) - 1; i >= 0; i--) {
			str = str + lst.get(i);
		}
		return str;

	}

	public String add() {
		int result = convertOtherToDecimal(number1)
				+ convertOtherToDecimal(number2);
		return convertDecimalToOther(result);
	}

	public String subtract() {
		String result = "0";
		int n1 = convertOtherToDecimal(number1);
		int n2 = convertOtherToDecimal(number2);
		int n = Math.abs(n1 - n2);
		if (n1 > n2)
			result = convertDecimalToOther(n);
		else
			result = "-" + convertDecimalToOther(n);
		return result;
	}

	public String multiply() {
		int result = convertOtherToDecimal(number1)
				* convertOtherToDecimal(number2);
		return convertDecimalToOther(result);
	}

	public String divide() {
		int result = convertOtherToDecimal(number1)
				/ convertOtherToDecimal(number2);
		return convertDecimalToOther(result);
	}

	public boolean greaterThan() {
		boolean n = false;
		int l1 = number1.length();
		int l2 = number2.length();
		if (l1 > l2) {
			n = true;
		} else {
			if (l1 < l2) {
				n = false;
			} else {
				for (int i = 0; i < l1; i++) {
					if (number1.charAt(i) > number2.charAt(i)) {
						n = true;
						break;
					}
				}
			}
		}
		return n;

	}

	public boolean lessThan() {
		boolean n = false;
		int l1 = number1.length();
		int l2 = number2.length();
		if (l1 < l2) {
			n = true;
		} else {
			if (l1 == l2) {
				for (int i = 0; i < l1; i++) {
					if (number1.charAt(i) < number2.charAt(i)) {
						n = true;
						break;
					}
				}
			}

		}
		return n;
	}

	public boolean isEqual() {
		boolean n = false;
		int l1 = number1.length();
		int l2 = number2.length();
		if (l1 == l2) {
			for (int i = 0; i < l1; i++) {
				if (number1.charAt(i) == number2.charAt(i)) {
					n = true;
					break;
				}
			}
		}
		return n;
	}

}

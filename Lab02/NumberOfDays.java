package Tuan2;

import java.util.Scanner;

public class NumberOfDays {
	static int checkValid(String m) {
		String[] month = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };
		String[] abbr = { "Jan.", "Feb.", "Mar.", "Apr.", "May", "June", "July", "Aug.", "Sep.", "Oct.", "Nov.",
				"Dec." };
		String[] sht = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		String[] num = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };

		int j = -1;
		for (int i = 0; i < 12; i++) {
			if (m.equals(month[i]) || m.equals(abbr[i]) || m.equals(sht[i]) || m.equals(num[i])) {
				j = i;
				break;
			}
		}
		return (j);
	}

	public static void main(String args[]) {
		int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

		Scanner keyboard = new Scanner(System.in);

		int i, year;
		do {
			System.out.println("Enter month: ");
			String month = keyboard.nextLine();
			i = checkValid(month);
			if (i == -1) {
				System.out.println("Try again!");
			}
		} while (i == -1);

		do {
			System.out.println("Enter year: ");
			year = keyboard.nextInt();
		} while (year < 0);

		int leap;
		if (year % 4 == 0) {
			leap = 1;
		} else {
			leap = -1;
		}
		
		if (leap == 1 && i == 1) {
			System.out.println("Days of month: " + (day[i] + 1));
		}
		
		if (leap == -1) {
			System.out.println("Days of month: " + day[i]);
		}

		keyboard.close();
	}
}
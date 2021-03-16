import java.util.Scanner;

public class DateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		MyDate newDate = new MyDate();
		newDate.print(newDate);
		int i = 0;
		do {
			System.out.println("Please enter a date: ");
			String date = keyboard.nextLine();
			newDate.accept(date);
			i = newDate.checkValid(newDate);
			if (i == -1) {
				System.out.println("Invalid date! Please try again!");
			}
		} while (i != 1);
		newDate.print(newDate);
		keyboard.close();	
	}
}

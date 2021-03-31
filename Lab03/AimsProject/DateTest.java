import java.util.Scanner;

public class DateTest extends DateUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		MyDate newDate = new MyDate();
		System.out.print("Today: ");
		newDate.print();
		int i = 0;
		System.out.println("Date format: mm/dd/yyyy or mm dd yyyy");
		System.out.println("Example: March 27th 2020 \n\tor January 15 2020 \n\tor 03 15 2020 \n\tor Jan 15 2020");
		System.out.println("Please enter a date: ");
		do {
			String date = keyboard.nextLine();
			i = newDate.accept(date);
			if (i != 1) {
				System.out.println("Invalid date! Please try again!");
			}
		} while (i != 1);
		
		System.out.print("MyDate: ");
		newDate.print();
		
		
		System.out.println("---------------------------Lab04----------------------------");
		MyDate Date1 = new MyDate("thirtieth", "March", "twenty twenty-one");
		System.out.print("Date 1: ");
		Date1.print();
		System.out.println("-------------------------------------------------------");
		
		System.out.println("Enter Date 2\nEnter day in string (Example: twenty-second): ");
		String day = keyboard.nextLine();
		System.out.println("Enter month in string: ");
		String month = keyboard.nextLine();
		System.out.println("Enter year in string (Example: twenty-three forty-five): ");
		String year = keyboard.nextLine();
		MyDate Date2 = new MyDate(day, month, year);
		Date2.print();
		MyDate Date3 = new MyDate("thirtieth", "March", "twenty twenty-two");
		MyDate Date4 = new MyDate("twenty-seventh", "June", "twenty twenty-one");
	
		i = dateCmp(Date1, Date2);
		switch (i) {
		case 1:
			System.out.println("Date1 > Date2");
			break;
		case -1:
			System.out.println("Date1 < Date2");
			break;
		case 0:
			System.out.println("Date1 = Date2");
		}
		
		
		
		System.out.println("-------------------------------------------------------");
		System.out.println("Format\t\t|\tExample\n_____________________________________\nyyyy-mm-dd\t|\t1930-02-03\nd/m/yyyy\t|\t3/2/1930\ndd-mmm-yyyy"
				+ "\t|\t03-Feb-1930\nmmm d yyyy\t|\tFeb 3 1930\nmm-dd-yyyy\t|\t02-03-1930\n"
				+ "_____________________________________");
		System.out.print("Please select corresponding format (1 to 5): ");
		i = keyboard.nextInt();
		System.out.println("You've entered date: ");
		Date2.printFormat(i);
		
		System.out.println("\n-------------------------------------------------------");
		System.out.println("BEFORE SORT:");
		MyDate[] listDate = {Date1, Date2, Date3, Date4};
		for (i = 0; i < listDate.length; i++) {
			listDate[i].print();
		}
		System.out.println("---------------");
		System.out.println("AFTER SORT:");
		listDate = dateSort(listDate);
		for (i = 0; i < listDate.length; i++) {
			listDate[i].print();
		}
		
		keyboard.close();
	}

}

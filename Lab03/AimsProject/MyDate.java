import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class MyDate {
	private int day;
	private int month;
	private int year;
	private String stringDate;
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day >= 1 && day <= 31) {
			this.day = day;
		} else {
			System.out.println("Invalid day! Set to current day!");
			this.day = LocalDate.now().getDayOfMonth();
		}
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 12) {
			this.month = month;
		} else {
			System.out.println("Invalid month! Set to current month!");
			this.month = LocalDate.now().getMonthValue();
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year >= 0) {
			this.year = year;
		} else {
			System.out.println("Invalid year! Set to current year!");			
			this.year = LocalDate.now().getYear();
		}
	}

	public MyDate(){
		super();
        setDay(LocalDate.now().getDayOfMonth());
        setMonth(LocalDate.now().getMonthValue());
        setYear(LocalDate.now().getYear());
	}

	public MyDate(int day, int month, int year) {
		if (day >= 1 && day <= 31 || month >= 1 && month <= 12 || year >= 0) {
			setMonth(month);
			setDay(day);
			setYear(year);
		} else {
			if (day <= 1 && day >= 31) {
				System.out.print("Invalid day! ");
			}
			if (month <= 1 && month >= 12) {
				System.out.print("Invalid month! ");
			}
			if (year <= 0) {
				System.out.println("Invalid year!");
			}
		}
	}
	
	public MyDate(String date) {
		// Format:  month day year OR month/day/year
		// Example: March 27th 2000 or 03 27 2000 or 03/27/2000
		this.stringDate = date;
	}
	
	private void setDateByString(String input) {
		if (input.contains(" ")) {
			input = input.replaceAll(" ", "/");
		}
		input = input.replaceAll("th", "");
		input = input.replaceAll("nd", "");
		input = input.replaceAll("rd", "");
		input = input.replaceAll("1st", "1");
		
//		System.out.println(input);
		String[] split = input.split("/", 3);	
		
//		System.out.println(Arrays.toString(split));
		String strMon = split[0];
		String strDay = split[1];
		String strYea = split[2];
		
		setDay(Integer.parseInt(strDay));
		setYear(Integer.parseInt(strYea));
		
		switch (strMon.toLowerCase()) {
		case "1": case "01": case "january": case "jan.": case "jan":
			setMonth(1);
			break;
		case "2": case "02": case "february": case "feb.": case "feb":
			setMonth(2);
			break;
		case "3": case "03": case "march": case "mar.": case "mar":
			setMonth(3);
			break;
		case "4": case "04": case "april": case "apr.": case "apr":
			setMonth(4);
			break;
		case "5": case "05": case "may":
			setMonth(5);
			break;
		case "6": case "06": case "june": case "jun": case "jun.":
			setMonth(6);
			break;
		case "7": case "07": case "july": case "jul": case "jul.":
			setMonth(7);
			break;
		case "8": case "08": case "august": case "aug.": case "aug":
			setMonth(8);
			break;
		case "9": case "09": case "september": case "sep.": case "sep":
			setMonth(9);
			break;
		case "10": case "october": case "oct.": case "oct":
			setMonth(10);
			break;
		case "11": case "november": case "nov.": case "nov":
			setMonth(11);
			break;
		case "12": case "december": case "dec.": case "dec":
			setMonth(12);
			break;
		}
		
		
	}
	
	public int checkValid(MyDate date) {
		int reValue = 1;
		if (date.month == 2 && date.day > 29) {
			reValue = -1;
		}
		if (date.month == 2 && date.day > 28 && date.year % 4 != 0) {
			reValue = -1;
		}
		if (date.month == 4 || date.month == 6 || date.month == 9 || date.month == 11 && date.day == 31) {
			reValue = -1;
		}
		return reValue;
	}
	
	public void accept(String date) {
		this.stringDate = date;
		setDateByString(stringDate);
	}
	
	public void print(MyDate date) {
		System.out.println("MyDate: " + month + "/" + day + "/" + year);
	}
}

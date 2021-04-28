package soict.hedspi.aims.utils;

import java.time.LocalDate;

public class MyDate {
	private int day;
	private int month;
	private int year;
	private String stringDate;
	private String[] datePart = {null, null, null};
	private static final String[] monthArr = {
			"",
			"January",
	        "February",
	        "March",
	        "April",
	        "May",
	        "June",
	        "July",
	        "August",
	        "September",
	        "October",
	        "November",
	        "December"
		};
	private static final String[] numberArr = {
			"oh", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",	// 10
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen",	// 19
			"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "hundred"  // end 28
			};
	private static final String[] ordinalArr = {
			null, "first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",	// 10
			"eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", 	// 17
			"eighteenth", "nineteenth", "twentieth", "thirtieth"	// 18-19-20-21
			};
	
	public int getDay() {
		return day;
	}
	
	public int checkDay(int day) {
		if (day <= 0 || day > 31) 
			return -1;
		return 1;
	}
	
	public void setDay(int day) {
		int i = checkDay(day);
		if (i == 1)
			this.day = day;
		else {
			System.out.println("Invalid day! Set to current day!");
			this.day = LocalDate.now().getDayOfMonth();
		}
	}

	public int getMonth() {
		return month;
	}
	
	public String getstrMonth(int i) {
		return monthArr[i];
	}
	
	public int checkMonth(int month) {
		if (month <= 0 || month > 12) 
			return -1;
		return 1;
	}
	
	public void setMonth(int month) {
		int i = checkMonth(month);
		if (i == 1) {
			this.month = month;
		} else {
			System.out.println("Invalid month! Set to current month!");
			this.month = LocalDate.now().getMonthValue();
		}
	}

	public int getYear() {
		return year;
	}
	
	public int checkYear(int year) {
		if (year <= 0) 
			return -1;
		return 1;
	}
	
	public void setYear(int year) {
		int i = checkYear(year);
		if (i == 1) {
			this.year = year;
		} else {
			System.out.println("Invalid year! Set to current year!");			
			this.year = LocalDate.now().getYear();
		}
	}
	
	// Constructor
	public MyDate(){
		super();
        setDay(LocalDate.now().getDayOfMonth());
        setMonth(LocalDate.now().getMonthValue());
        setYear(LocalDate.now().getYear());
	}
	
	public MyDate(String date) {
		// Format:  month day year OR month/day/year
		// Example: March 27th 2000 or 03 27 2000 or 03/27/2000
		this.stringDate = date;
	}

	public MyDate(int day, int month, int year) {
		int i = checkDay(day);
		if (i == 1)
			setDay(day);
		i = checkMonth(month);
		if (i == 1)
			setMonth(month);
		i = checkYear(year);
		if (i == 1)
			setYear(year);
		
		MyDate temp = new MyDate();
		temp.day = day;
		temp.month = month;
		temp.year = year;
		i = checkValid(temp);	// Check if date is valid
		if (i == -1) {
			System.out.println("The date is not valid! Set to current date!");
			setDay(LocalDate.now().getDayOfMonth());
	        setMonth(LocalDate.now().getMonthValue());
	        setYear(LocalDate.now().getYear());
		}
	}
	
		public MyDate(String day, String month, String year) {
			datePart[0] = day;
			datePart[1] = month;
			datePart[2] = year;
			setDay(parseDay(datePart[0]));
			setMonth(parseMonth(datePart[1]));
			setYear(parseYear(datePart[2]));
		}
		
	// End of constructor
	
	private int setDateByString(String input) {
		if (input.contains(" ")) {
			input = input.replaceAll(" ", "/");
		}
		input = input.replaceAll("th", "");
		input = input.replaceAll("nd", "");
		input = input.replaceAll("rd", "");
		input = input.replaceAll("1st", "1");
		
//		System.out.println(input);
		String[] split = input.split("/");	
		
//		System.out.println(Arrays.toString(split));
		String strMon = split[0];
		String strDay = split[1];
		String strYea = split[2];
		
		if (strMon == null || strDay == null || strYea == null) {
			return -1;		// return -1 if input data is invalid
		}
		
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
		default:
			System.out.println("Invalid month!");
			return -1;
		}
			
		MyDate temp = new MyDate();
		temp.day = Integer.parseInt(strDay);
		temp.month = this.month;
		temp.year = Integer.parseInt(strYea);
		int i = checkValid(temp);	// Check if date is valid
		if (i == -1) {
	        return 0;		// return 0 if input date by string successfully but the date isn't valid
		}
		return 1;	// return 1 if input date by string successfully
		
	}
	
	public int checkValid(MyDate date) {	// -1 for invalid date and 1 for valid date
		if (date.month == 2) {		// Case month = 2
			if (date.year % 4 == 0)
				if (date.day > 29) 
					return -1;
			if (date.year % 4 != 0)
				if (date.day > 28)
					return -1;
			
		} else if (date.month == 4 || date.month == 6 || date.month == 9 || date.month == 11) {	// 30day-month: 4, 6, 9, 11
			if (date.day > 30) {
				return -1;
			}
		}
		return 1;
	}
	
	public int accept(String date) {
		this.stringDate = date;
		int i = setDateByString(stringDate);
		return i;
	}
	
	private String addSuffix(int day) {
		switch(day) {
		case 1:
		case 21:
		case 31:
			return String.valueOf(day) + "st";
		case 2:
		case 22:
			return String.valueOf(day) + "nd";
		case 3:
		case 23:
			return String.valueOf(day) + "rd";
		default:
			return String.valueOf(day) + "th";
		}
	}
	
	private int parseDay(String day) {
		day = day.toLowerCase();
		int returnDay = 0;
		String[] split = day.split("-");
		if (split.length == 1) {
			for (int i = 1; i < 21; i++) {
				if (split[0].equals(ordinalArr[i]))
					returnDay += i;
				else if (split[0].equals(ordinalArr[21]))
					return 30;
			}
		}
		if (split.length != 1) {
			if (split[0].equals(numberArr[20]))
				returnDay += 20;
			if (split[0].equals(numberArr[21])) {
				returnDay += 31;
				return returnDay;
			}	
			for (int i = 1; i < 10; i++) {
				if (split[1].equals(ordinalArr[i]))
					returnDay += i;
			}
		}
		return returnDay;
	}
	
	private int parseMonth(String month) {
		int i;
		for (i = 1; i <= 12; i++) {
			if (month.equals(monthArr[i]))
				return i;
		}
		return i;	
	}
	
	private int parseYear(String year) {		// Only accept year from 1000 to 9999
		year = year.toLowerCase();
		String[] yearPart = year.split(" ");
		int i, intYear = 0;
		String[] part1 = yearPart[0].split("-");
		String[] part2 = yearPart[1].split("-");
		if (part1.length == 1) {
			for (i = 10; i < 20; i++) {
				if (part1[0].equals(numberArr[i]))
					intYear += i * 100;
			}
			for (i = 20; i < 29; i++) {
				if (part1[0].equals(numberArr[i]))
					intYear += 100 * (20 + 10 * (i - 20));
			}
		}
		if (part1.length == 2) {
			for (i = 20; i < 29; i++) {
				if (part1[0].equals(numberArr[i]))
					intYear += 100 * (20 + 10 * (i - 20));
			}
			for (i = 1; i < 11; i++) {
				if (part1[1].equals(numberArr[i]))
					intYear += i * 100;
			}
		}
		if (part2.length == 1) {
			for (i = 10; i < 20; i++) {
				if (part2[0].equals(numberArr[i]))
					intYear += i;
			}
			for (i = 20; i < 29; i++) {
				if (part2[0].equals(numberArr[i]))
					intYear += 20 + 10 * (i - 20);
			}
		}
		if (part2.length == 2) {
			for (i = 20; i < 29; i++) {
				if (part2[0].equals(numberArr[i]))
					intYear += 20 + 10 * (i - 20);
			}
			for (i = 1; i < 11; i++) {
				if (part2[1].equals(numberArr[i]))
					intYear += i;
			}
		}
		return intYear;
	}
	
	public void print() {
		System.out.println(monthArr[month] + " " + addSuffix(day) + " " + year);
	}
	
	public void printFormat(int i) {
		switch (i) {
		case 1:
			System.out.println(year + "-" + month + "-" + day);
			break;
		case 2:
			System.out.println(day + "/" + month + "/" + year);
			break;
		case 3:
			System.out.printf("%d-%.3s-%d", day, getstrMonth(month), year);
			break;
		case 4:
			System.out.printf("%.3s %d %d", getstrMonth(month), day, year);
			break;
		case 5:
			System.out.println(month + "-" + day + "-" + year);
			break;
		default:
			System.out.println("Invalid format " + i);
		}
	
	}
}

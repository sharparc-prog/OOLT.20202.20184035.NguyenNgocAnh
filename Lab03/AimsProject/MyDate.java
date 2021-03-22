import java.time.LocalDate;

public class MyDate {
	private int day;
	private int month;
	private int year;
	private String stringDate;
	
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

	public int checkMonth(int month) {
		if (month <= 0 || month >= 12) 
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

	public MyDate(){
		super();
        setDay(LocalDate.now().getDayOfMonth());
        setMonth(LocalDate.now().getMonthValue());
        setYear(LocalDate.now().getYear());
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
	
	public MyDate(String date) {
		// Format:  month day year OR month/day/year
		// Example: March 27th 2000 or 03 27 2000 or 03/27/2000
		this.stringDate = date;
	}
	
	private int setDateByString(String input) {
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
	
	public void print(MyDate date) {
		System.out.println("MyDate: " + month + "/" + day + "/" + year);
	}
}

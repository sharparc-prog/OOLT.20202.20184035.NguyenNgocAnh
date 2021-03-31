
public class DateUtils {
	
	public static int dateCmp(MyDate date1, MyDate date2) {	
		if (date1.getYear() > date2.getYear())					
			return 1;
		if (date1.getYear() < date2.getYear())
			return -1;
		if (date1.getMonth() > date2.getMonth())
			return 1;
		if (date1.getMonth() < date2.getMonth())
			return -1;
		if (date1.getDay() > date2.getDay())
			return 1;
		if (date1.getDay() < date2.getDay())
			return -1;
		return 0;
	}
	
	public static MyDate[] dateSort(MyDate ...dateList) {
		int i, j;
		MyDate last;
		for (i = 1; i < dateList.length; i++) {
			last = dateList[i];
			j = i - 1;
			while (j >= 0 && dateCmp(dateList[j], last) == 1) {
				dateList[j+1] = dateList[j];
				j = j - 1;
			}
			dateList[j+1] = last;
		}
		
		return dateList;
	}
}

package soict.hedspi.aims.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoGarbage {
	public static void main(String[] args) {
		try {
			File myObj = new File("D:\\Th_OOP\\AimsProject\\hust\\soict\\hedspi\\aims\\garbage\\garbage.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				StringBuilder data = new StringBuilder();
				data.append(myReader.nextLine());
		        System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}

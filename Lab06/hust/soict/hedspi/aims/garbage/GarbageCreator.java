package soict.hedspi.aims.garbage;

import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class GarbageCreator {
	public static void main(String[] args) {
		try {
			File myObj = new File("D:\\Th_OOP\\AimsProject\\hust\\soict\\hedspi\\aims\\garbage\\garbage.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = null;
				data += myReader.nextLine();
		        System.out.println(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
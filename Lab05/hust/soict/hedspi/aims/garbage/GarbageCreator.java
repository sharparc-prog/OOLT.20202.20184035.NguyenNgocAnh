package soict.hedspi.aims.garbage;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class GarbageCreator {
	public static void main(String[] args) {
		try {
			File myObj = new File("garbagegarbage.txt");
			String s = null;
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				s = s + data;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
}

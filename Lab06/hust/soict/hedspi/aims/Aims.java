package soict.hedspi.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import soict.hedspi.aims.order.Order;
import soict.hedspi.aims.media.*;

public class Aims extends Media {
	private static Scanner sc = new Scanner(System.in);
	private static List<Order> orderList = new ArrayList<Order>();
	private static List<Media> mediaList = new ArrayList<Media>();
	private static Order orderBuffer = null;
	
	private static final boolean initialize() {
		while (orderList.size() + 1 < Order.MAX_LIMITED_ORDERS) {
			orderList.add(Order.addOrder());
			return true;
		}
		return false;
	}
	
	private static void clearBuffer() {
		orderBuffer = null;
	}
	
	private static void pressEnterToContinue() { 
		System.out.println("Press Enter key to continue...");
		try {
			System.in.read();
		}  
		catch(Exception e) {
		}  
	}
	
	private static void printMediaList() {
		if (mediaList.size() != 0) {
			for (int i = 0; i < mediaList.size(); i++) {
				System.out.println(i + 1 + ". " + mediaList.get(i).getTitle());
			}
		}
	}
	
	private static void showMenu() {
		while (true) {
			System.out.println("||   Order Management Application\t||");
			System.out.println("||======================================||");
			System.out.println("||1. Create new order\t\t\t||");
			System.out.println("||2. Add item to the order\t\t||");
			System.out.println("||3. Delete item by id\t\t\t||");
			System.out.println("||4. Display the items list of order\t||");
			System.out.println("||0. Exit\t\t\t\t||");
			System.out.println("||======================================||");
			System.out.println("||Please choose a number: 0-1-2-3-4\t||");
			int choice = 0;
			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.println("Invalid selection! Program will exit!");
			}
			switch (choice) {
			case 1:
				menu1();
				break;
			case 2:
				menu2();
				break;
			case 3:
				menu3();
				break;
			case 4:
				menu4();
				break;
			case 0:
				System.out.println("Bye bye");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid selection! Please try again!");
				break;
			}
		}
	}
	
	private static final void menu1() {
		if (initialize()) {
			System.out.println("->Success!");
		}
		else
			System.out.println("->You can't create more order!");
		pressEnterToContinue();
	}
	
	private static final void menu2() {
		if (orderList.size() == 0) {
			System.out.println("->Please create a order first!");
			pressEnterToContinue();
			return;
		}
		
		System.out.print("Select order id: ");
		for (int i = 0; i < orderList.size(); i++) {
			System.out.print((i + 1) + " ");
		}
		System.out.println();
		
		clearBuffer();
		int orderid = sc.nextInt();
		orderBuffer = orderList.get(orderid - 1);	// Temp
		
		int mediaid = 0;
		while (true) {
			System.out.println("-------------------------");
			System.out.println("->Selected order id: " + orderid);
			System.out.println("--1. Add an item by id");
			System.out.println("--2. Return main menu");
			System.out.println("Select option: 1-2");
			mediaid = sc.nextInt();
			switch (mediaid) {
			case 1:
				System.out.println("Current available media: ");
				printMediaList();
				System.out.println("Enter media id: ");
				mediaid = sc.nextInt();
				orderBuffer.addMedia(mediaList.get(mediaid - 1));
				System.out.println("'" + mediaList.get(mediaid - 1).getTitle() + "'" + " added!");
				orderList.set(orderid - 1, orderBuffer);
				break;
			case 2:
				orderList.set(orderid - 1, orderBuffer);
				return;
			default:
				throw new IllegalArgumentException("Invalid value: " + mediaid);
			}
		}
	}
	
	private static final void menu3() {
		if (orderList.size() == 0) {
			System.out.println("->Please create a order first!");
			pressEnterToContinue();
			return;
		}
		clearBuffer();
		System.out.print("Select order id: ");
		for (int i = 0; i < orderList.size(); i++) {
			System.out.print((i + 1) + " ");
		}
		System.out.println();
		
		int orderid = sc.nextInt();
		orderBuffer = orderList.get(orderid - 1);
		int mediaid = 0;
		while (true) {
			System.out.println("-------------------------");
			System.out.println("->Selected order id: " + orderid);
			System.out.println("--1. Remove an item by id");
			System.out.println("--2. Return main menu");
			System.out.println("Select option: 1-2");
			mediaid = sc.nextInt();
			switch (mediaid) {
			case 1:
				System.out.println("Current available media: ");
				printMediaList();
				System.out.println("Enter media id to remove: ");
				mediaid = sc.nextInt();
				if (orderBuffer.removeMedia(mediaList.get(mediaid - 1))) {
					System.out.println("Removed '" + mediaList.get(mediaid - 1).getTitle() + "' from the order id: " + orderid);
					orderList.set(orderid - 1, orderBuffer);
				}
				else
					System.out.println("Item doesn't exist!");
				break;
			case 2:
				orderList.set(orderid - 1, orderBuffer);
				return;
			default:
				throw new IllegalArgumentException("Invalid value: " + mediaid);
			}
		}
		
	}
	
	private static final void menu4() {
		if (orderList.size() == 0) {
			System.out.println("->Please create a order first!");
			pressEnterToContinue();
			return;
		}
		System.out.print("Select order id: ");
		for (int i = 0; i < orderList.size(); i++) {
			System.out.print((i + 1) + " ");
		}
		System.out.println();
		int orderid = sc.nextInt();		
		System.out.println("->Current items of order id: " + orderid);
		orderList.get(orderid - 1).printOrder();;
		pressEnterToContinue();
	}
	
	public static void main(String[] args) {
		Media media1 = new Media("The Lion King");
		media1.setCategory("Animation");
		media1.setCost(19.95f);		
		Media media2 = new Media("Star Wars");
		media2.setCategory("Science Fiction");
		media2.setCost(24.95f);		
		Media media3 = new Media("Alladin");
		media3.setCategory("Animation");
		media3.setCost(18.99f);
		mediaList.add(media1);
		mediaList.add(media2);
		mediaList.add(media3);
		
		showMenu();
		
	}

}
		
		


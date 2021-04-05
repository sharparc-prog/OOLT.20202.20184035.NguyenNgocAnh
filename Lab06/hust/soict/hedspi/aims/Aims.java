package soict.hedspi.aims;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import soict.hedspi.aims.order.Order;
import soict.hedspi.aims.media.*;

public class Aims {
	private static Scanner sc = new Scanner(System.in);
	private static List<Order> orderList = new ArrayList<Order>();
	private static List<Media> mediaList = new ArrayList<Media>();
	private static Order orderBuffer = Order.addOrder();
	
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
			int choice = sc.nextInt();
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
	
	private static void menu1() {
		if (orderList.size() < Order.MAX_LIMITED_ORDERS) {
			orderList.add(orderBuffer);
			System.out.println("->Success!");
		}
		else
			System.out.println("->You can't create more order!");
		pressEnterToContinue();
	}
	
	private static void menu2() {
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
		
		orderBuffer = null;
		int orderid = sc.nextInt();
		orderBuffer = orderList.get(orderid - 1);
		
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
				break;
			case 2:
				orderList.set(orderid - 1, orderBuffer);
				return;
			default:
				throw new IllegalArgumentException("Invalid value: " + mediaid);
			}
		}
	}
	
	private static void menu3() {
		if (orderList.size() == 0) {
			System.out.println("->Please create a order first!");
			pressEnterToContinue();
			return;
		}
		orderBuffer = null;
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
				if (orderBuffer.removeMedia(mediaList.get(mediaid - 1)))
					System.out.println("Removed '" + mediaList.get(mediaid - 1).getTitle() + "' from the order id: " + orderid);
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
	
	private static void menu4() {
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
		orderList.get(orderid - 1).printOrder();
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

//		// TODO Auto-generated method stub
//		Order anOrder = Order.addOrder();
//		// Create a new dvd object and set the fields
//		Media dvd1 = new Media("The Lion King");
//		dvd1.setCategory("Animation");
//		dvd1.setCost(19.95f);
//		dvd1.setDirector("Roger Allers");
//		dvd1.setLength(87);
//		
//		// Add the dvd to the order
//		anOrder.addMedia(dvd1);
//		
//		// Add another dvd
//		Media dvd2 = new Media("Star Wars");
//		dvd2.setCategory("Science Fiction");
//		dvd2.setCost(24.95f);
//		dvd2.setDirector("George Lucas");
//		dvd2.setLength(124);
//		// Add to order
//		anOrder.addMedia(dvd2);
//		
//		// Add another dvd
//		Media dvd3 = new Media("Alladin");
//		dvd3.setCategory("Animation");
//		dvd3.setCost(18.99f);
//		dvd3.setDirector("John Musker");
//		dvd3.setLength(90);
//		// Add to order
//		anOrder.addMedia(dvd3);
//		anOrder.removeMedia(dvd3);
//		int i = anOrder.removeMedia(dvd3);
//		assert (i == 0 || i == 1 || i == -1) : "Failed!"; 
//		i = anOrder.removeMedia(dvd3);
//		assert (i == 0 || i == 1 || i == -1) : "Failed!"; 
//		anOrder.addMedia(dvd3);
//		anOrder.addMedia(dvd3);
//		
//		anOrder.printOrder();
//		System.out.print("Total cost is: ");
//		System.out.println(anOrder.totalCost());
//		
//		Order anOrder2 = Order.addOrder();
//		anOrder2.addMedia(dvd3);
//		anOrder2.printOrder();
//		Order anOrder3 = Order.addOrder();
//		anOrder3.addMedia(dvd3);
//		Order anOrder4 = Order.addOrder();
//		anOrder4.addMedia(dvd3);
//		Order anOrder5 = Order.addOrder();
//		anOrder5.addMedia(dvd3);
//		System.out.println("------------------------------------------");
		
		


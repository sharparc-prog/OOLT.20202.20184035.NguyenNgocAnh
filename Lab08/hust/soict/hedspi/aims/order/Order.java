package soict.hedspi.aims.order;

import java.util.ArrayList;
import java.util.List;
import soict.hedspi.aims.media.*;
import soict.hedspi.aims.utils.MyDate;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 6;
	public static int numberOfOrder = 0;
	private List<Media> itemsOrdered = new ArrayList<Media>();
	private float totalCost = 0;
	private MyDate dateOrdered;
	
	// Constructor
	
	private Order() {		// Private constructor
		this.dateOrdered = new MyDate();
		numberOfOrder++;
	}
	
	public static Order addOrder() {		// Public method to return Order instance
		if (numberOfOrder < MAX_LIMITED_ORDERS) {
			return new Order();
		}
		System.out.println("Order limit reached! Can't create new order!");
		System.gc();
		return null;
	}
	
	public boolean addMedia(Media item) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED)
			return false;
		itemsOrdered.add((Media)item);
		return true;
	}
	
	public boolean removeMedia(Media item) {
		if (itemsOrdered.size() == 0)
			return false;
		if (itemsOrdered.contains((Media)item)) {
			itemsOrdered.remove((Media)item);
			return true;
		}
		return false;
	}

	public int countItemsOrdered() {
		return itemsOrdered.size();
	}

	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}
	
	public float totalCost(){
		totalCost = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			totalCost += itemsOrdered.get(i).getCost();
		}
		return totalCost;
	}
	
	public Media searchDiscByTitle(String title){
        for(int i = 0; i < itemsOrdered.size(); i++){
            if(itemsOrdered.get(i).getTitle().equals(title)){
               return itemsOrdered.get(i);
            }
        }
        return null;
    }
	
	public int getCountOfSearchTitle(String title){
        int count = 0;
        for(int i = 0 ; i < itemsOrdered.size() ; i++){
            if(itemsOrdered.get(i).getTitle().equals(title)){
                count++;
            }
        }
        return count;
    }
	
	public int clearQueue(Media[] queue) {
		if (itemsOrdered.size() == 0) {
			return -1;	// -1 if item list is empty	
		}
		for (int i = 0; i < itemsOrdered.size(); i++) {
			removeMedia(queue[i]);
		}
		return 1;	// 1 if delete at least 1 item
	}
	
	public int addMedia(Media ...dvdList) {	// Add by arbitrary number of items
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is already full!");
			return -1;		// -1 if order is already full
		}
		if (dvdList.length + itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {	// Check if queue is full
			System.out.println("Too many items! Can't add to order!");
			return -1;		// -1 if too many item
		}
		for (Media i : dvdList) {
			addMedia(i);		// Add each item in dvdList
		}
		return 1;		// return 1 if added successfully 
	}
	
	
	public int addMedia(Media dvd1, Media dvd2) {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is already full!");
			return -1;		// -1 if order is full
		} else if (itemsOrdered.size() + 1 == MAX_NUMBERS_ORDERED) {
			addMedia(dvd1);
			System.out.println(dvd2.getTitle() + " couldn't be added!");
			return 0;		// 0 if only add 1 item
		} else if (itemsOrdered.size() + 2 <= MAX_NUMBERS_ORDERED) {
			addMedia(dvd1);
			addMedia(dvd2);
		}
		return 1;		// 1 if successful added 2 items
	}
	
	public void printOrder() {
		System.out.println("************************Order************************");
		System.out.print("Date: ");
		dateOrdered.print();
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i) != null) {
				System.out.printf("%d. %-50s%-30s%4.2f$\n", i + 1, itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCategory(), itemsOrdered.get(i).getCost());
			}
		}
		System.out.println("Total cost: " + totalCost() + "$");
		System.out.println("*****************************************************");
	}	
	
	private int GenerateRandom(int min, int max) {	        
	      int random_int = (int)(Math.random() * (max - min + 1) + min);
	      return random_int;
	}
	
	public Media getALuckyItem(Media ...freeDisc) {
		int i = GenerateRandom(0, freeDisc.length - 1);
		return itemsOrdered.get(i);
	}
	
}

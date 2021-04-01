package soict.hedspi.aims.order;
import soict.hedspi.aims.media.DigitalVideoDisc;
import soict.hedspi.aims.utils.*;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITED_ORDERS = 5;
	
	private DigitalVideoDisc[] itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	private float totalCost = 0;
	private MyDate dateOrdered;
	private static int nbOrders = 0;
	
	// Constructor
	
	private Order() {		// Private constructor
		this.dateOrdered = new MyDate();
		nbOrders++;
		System.out.println("Order instance count: " + nbOrders);
	}
	
	public static Order addOrder() {		// Public method to return Order instance
		if (nbOrders < MAX_LIMITED_ORDERS) {
			return new Order();
		}
		System.out.println("Order limit reached! Can't create new order!");
		System.gc();
		return null;
	}

	// End of constructor
	
	
	public static int getNumOfInstances() {		// Get number of orders
        return nbOrders;
    }

	public MyDate getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(MyDate dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	private void addqtyOrdered(int qty){
		qtyOrdered += qty;
	}
	
	public int getqtyOrdered() {
		return qtyOrdered;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc){		// Add a disc to order
        if(qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.out.println("The order is already full!");
        }
        if(disc == null) {
        	System.out.println("Item doesn't exist!");
        } else {
            int i = qtyOrdered;
            itemOrdered[i] = disc; // Add item
            addqtyOrdered(1);
            System.out.println("This disc has been added successfully, you have ordered " + qtyOrdered + 
            			" disk(s)");
        }
    }
	
	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {	// Remove a disc from order
		if (qtyOrdered == 0) { // Check if array is empty
			System.out.println("There isn't anything to remove!");
			return -1;
		} else {
			for (int i = 0; i < qtyOrdered; i++) {
				if(itemOrdered[i].getTitle().equals(disc.getTitle())) { // Found item
					for (int j = i; j <= qtyOrdered; j++) {
						itemOrdered[j] = itemOrdered[j+1]; // Override the following item
					}
					addqtyOrdered(-1);
					System.out.println("Item removed successfully! You have ordered " + qtyOrdered + " disk(s).");
					return 1;		// return 1 if successfully remove 1 item
				}
			}
		}
		System.out.println("Item not found!");
		return 0;		// If can't found item
	}
	
	public float totalCost(){
		totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemOrdered[i].getCost();
		}
		return totalCost;
	}
	
	public DigitalVideoDisc searchDiscByTitle(String title){
        for(int i = 0; i < qtyOrdered; i++){
            if(itemOrdered[i].getTitle().equals(title)){
               return itemOrdered[i];
            }
        }
        return null;
    }
	
	public int getCountOfSearchTitle(String title){
        int count = 0;
        for(int i = 0 ; i < qtyOrdered ; i++){
            if(itemOrdered[i].getTitle().equals(title)){
                count++;
            }
        }
        return count;
    }
	
	public int clearQueue(DigitalVideoDisc[] queue) {
		if (qtyOrdered == 0) {
			return -1;	// -1 if item list is empty	
		}
		for (int i = 0; i < qtyOrdered; i++) {
			removeDigitalVideoDisc(queue[i]);
		}
		return 1;	// 1 if delete at least 1 item
	}
	
	// 	Lab04: Overloading
	// 	Có thể sử dụng 1 trong 2 method
	//	Method 1
/*
	public int addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {	// Add by a list (array) of items
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is already full!");
			return -1;		// -1 if order is already full
		}
		if (dvdList.length + qtyOrdered >= MAX_NUMBERS_ORDERED) {	// Check if queue is full
			System.out.println("Too many items! Can't add to order!");
			return -1;		// -1 if too many item
		}
		for (int i = 0; i < qtyOrdered; i++) {
			addDigitalVideoDisc(dvdList[i]);	// Add each item in dvdList
		}
		return 1;	// 1 if list was successfully added
	}
*/
	
	// Method 2
	public int addDigitalVideoDisc(DigitalVideoDisc ...dvdList) {	// Add by arbitrary number of items
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is already full!");
			return -1;		// -1 if order is already full
		}
		if (dvdList.length + qtyOrdered >= MAX_NUMBERS_ORDERED) {	// Check if queue is full
			System.out.println("Too many items! Can't add to order!");
			return -1;		// -1 if too many item
		}
		for (DigitalVideoDisc i : dvdList) {
			addDigitalVideoDisc(i);		// Add each item in dvdList
		}
		return 1;		// return 1 if added successfully 
	}
	
	
	public int addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered >= MAX_NUMBERS_ORDERED) {
			System.out.println("The order is already full!");
			return -1;		// -1 if order is full
		} else if (qtyOrdered + 1 == MAX_NUMBERS_ORDERED) {
			addDigitalVideoDisc(dvd1);
			System.out.println(dvd2.getTitle() + " couldn't be added!");
			return 0;		// 0 if only add 1 item
		} else if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
			addDigitalVideoDisc(dvd1);
			addDigitalVideoDisc(dvd2);
		}
		return 1;		// 1 if successful added 2 items
	}
	
	public void printOrder() {
		System.out.println("************************Order************************");
		System.out.print("Date: ");
		dateOrdered.print();
		for (int i = 0; i < itemOrdered.length; i++) {
			if (itemOrdered[i] != null) {
				System.out.println("DVD - " + itemOrdered[i].getTitle() + " - " + itemOrdered[i].getCategory() + 
						" - " + itemOrdered[i].getDirector() + " - " + itemOrdered[i].getLength() + 
						": " + itemOrdered[i].getCost() + "$"
						);
			}
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("*****************************************************");
	}	
	
	private int GenerateRandom(int min, int max) {	        
	      int random_int = (int)(Math.random() * (max - min + 1) + min);
	      return random_int;
	}
	
	public DigitalVideoDisc getALuckyItem(DigitalVideoDisc ...freeDisc) {
		int i = GenerateRandom(0, freeDisc.length - 1);
		System.out.println(i);
		return itemOrdered[i];
	}
	
}

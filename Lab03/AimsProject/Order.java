
public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	private float totalCost = 0;
	
	private void addqtyOrdered(int qty){
		qtyOrdered += qty;
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(qtyOrdered >= MAX_NUMBERS_ORDERED)
            System.out.println("The order is full!");
        else{
            int i = qtyOrdered;
            itemOrdered[i] = disc; // Add item
            addqtyOrdered(1);
            System.out.println("This disc has been added successfully, you have ordered " + qtyOrdered + 
            			" disk(s), you can order " + (MAX_NUMBERS_ORDERED - qtyOrdered) + " more disk(s).");
        }
    }
	
	public int removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int returnValue = 0;
		if (qtyOrdered == 0) { // Check if array is empty
			System.out.println("There isn't anything to remove!");
			returnValue = -1;
		} else {
			for (int i = 0; i < qtyOrdered; i++) {
				if(itemOrdered[i].getTitle().equals(disc.getTitle())) { // Found item
					for (int j = i; j <= qtyOrdered; j++) {
						itemOrdered[j] = itemOrdered[j+1]; // Override the following item
					}
					qtyOrdered--;
					System.out.println("Item removed successfully! You have ordered " + qtyOrdered + " disk(s).");
					returnValue = 1;
				} else {
					if (i == qtyOrdered - 1) System.out.println("Item not found!");
					returnValue = 0;
				}
			}
		}
		return returnValue;
	}
	
	public float totalCost(){
		for (int i = 0; i < qtyOrdered; i++) {
			totalCost += itemOrdered[i].getCost();
		}
		return totalCost;
	}
	
	public DigitalVideoDisc searchDiscByTitle(String title){
        for(int i = 0 ; i < qtyOrdered ; i++){
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
}

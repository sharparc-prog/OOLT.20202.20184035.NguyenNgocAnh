
public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order anOrder = Order.addOrder();
		// Create a new dvd object and set the fields
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		// Add the dvd to the order
		anOrder.addDigitalVideoDisc(dvd1);
		
		// Add another dvd
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		// Add to order
		anOrder.addDigitalVideoDisc(dvd2);
		
		// Add another dvd
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		// Add to order
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.removeDigitalVideoDisc(dvd3);
//		int i = anOrder.removeDigitalVideoDisc(dvd3);
//		assert (i == 0 || i == 1 || i == -1) : "Failed!"; 
//		i = anOrder.removeDigitalVideoDisc(dvd3);
//		assert (i == 0 || i == 1 || i == -1) : "Failed!"; 
		anOrder.addDigitalVideoDisc(dvd3);
		anOrder.addDigitalVideoDisc(dvd3);
		
		anOrder.printOrder();
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		Order anOrder2 = Order.addOrder();
		anOrder2.addDigitalVideoDisc(dvd3);
		anOrder2.printOrder();
		Order anOrder3 = Order.addOrder();
		anOrder3.addDigitalVideoDisc(dvd3);
		Order anOrder4 = Order.addOrder();
		anOrder4.addDigitalVideoDisc(dvd3);
		Order anOrder5 = Order.addOrder();
		anOrder5.addDigitalVideoDisc(dvd3);
		System.out.println("------------------------------------------");
		Order anOrder6 = Order.addOrder();
		
		
	}

}

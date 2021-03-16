
public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Order anOrder = new Order();
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
		int i = anOrder.removeDigitalVideoDisc(dvd3);
		assert (i == 0 || i == 1 || i == -1) : "Failed!"; 
		i = anOrder.removeDigitalVideoDisc(dvd3);
		assert (i == 0 || i == 1 || i == -1) : "Failed!"; 
		anOrder.addDigitalVideoDisc(dvd3);

		
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
	}

}

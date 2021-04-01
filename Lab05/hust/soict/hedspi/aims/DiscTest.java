package soict.hedspi.aims;

import soict.hedspi.aims.media.DigitalVideoDisc;
import soict.hedspi.aims.order.Order;

public class DiscTest {

	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Alladin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		Order anOrder = Order.addOrder();
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd3);
		System.out.println("You've got a free disc: " + anOrder.getALuckyItem(dvd1, dvd2, dvd3).getTitle());
		System.out.println("----");
		System.out.println(dvd1.search("Lion"));
		System.out.println(dvd1.search("Lion King"));
		System.out.println(dvd1.search("Tiger King"));
		
	}

}

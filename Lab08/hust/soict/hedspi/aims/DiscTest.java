package soict.hedspi.aims;

import soict.hedspi.aims.media.Media;
import soict.hedspi.aims.order.Order;

public class DiscTest{

	public static void main(String[] args) {
		Media dvd1 = new Media("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		
		Media dvd2 = new Media("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		
		Media dvd3 = new Media("Alladin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.99f);
		
		Order anOrder = Order.addOrder();
		anOrder.addMedia(dvd1);
		anOrder.addMedia(dvd2);
		anOrder.addMedia(dvd3);
		System.out.println("You've got a free disc: " + anOrder.getALuckyItem(dvd1, dvd2, dvd3).getTitle());
		System.out.println("----");
		System.out.println(dvd1.checkTitle("Lion"));
		System.out.println(dvd1.checkTitle("Lion King"));
		System.out.println(dvd1.checkTitle("Tiger King"));
		
	}

}

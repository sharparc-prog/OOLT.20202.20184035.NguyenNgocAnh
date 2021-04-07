package soict.hedspi.aims.media;

public class DigitalVideoDisc extends Media {
	
	private String director;
	private int length;
	
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getCategory() {
//		return category;
//	}
//	public void setCategory(String category) {
//		this.category = category;
//	}
//	public float getCost() {
//	return cost;
//	}
//	public void setCost(float cost) {
//	this.cost = cost;
//	}
	
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}

	
	// Constructor
		
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		
	}

	public boolean search(String title) {
		title = title.toLowerCase();
		String[] cut = title.split(" ");
		Boolean check = false;
		for (int i = 0; i < cut.length; i++) {
			if (this.title.toLowerCase().contains(cut[i]))
				check = true;
			else
				return false;
		}
		return check;
	}
	
}

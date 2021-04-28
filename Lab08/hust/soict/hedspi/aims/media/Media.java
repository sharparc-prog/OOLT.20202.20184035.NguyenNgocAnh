package soict.hedspi.aims.media;

public abstract class Media {
	protected String title;
	protected String category;
	protected float cost;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	// Constructor
	public Media() {
		
	}
	
	public Media(String title){
		this.title = title;
	}
	
	public Media(String title, String category){
		this(title);
		this.category = category;
	}

	//
	
	public boolean checkTitle(String title) {
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

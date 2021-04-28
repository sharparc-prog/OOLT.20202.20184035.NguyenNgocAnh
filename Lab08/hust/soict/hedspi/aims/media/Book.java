package soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public boolean addAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.contains(authorName))
				return false;
		}
		authors.add(authorName);
		return true;
	}
	
	public boolean removeAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.contains(authorName)) {
				authors.remove(i);
				return true;
			}
		}
		return false;
	}
	// Constructor
	
	public Book(String title) {
		super(title);
	}

	public Book(String title, String category) {
		super(title, category);
	}
	
	public Book(String title, String category, String authors) {
		super(title, category);
		this.authors.add(authors);
	} 
	
	public Book() {
		// TODO Auto-generated constructor stub
		
	}

}

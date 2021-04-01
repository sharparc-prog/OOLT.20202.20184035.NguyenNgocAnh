package soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	
	public boolean addAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName))
				return false;
		}
		authors.add(authorName);
		return true;
	}
	
	public boolean removeAuthor(String authorName) {
		for (int i = 0; i < authors.size(); i++) {
			if (authors.get(i).equals(authorName)) {
				authors.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public Book() {
		// TODO Auto-generated constructor stub
		
	}

}

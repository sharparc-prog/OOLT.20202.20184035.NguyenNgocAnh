package soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	
	public String getDirector() 
	{
		return director;
	}
	public void setDirector(String director) 
	{
		this.director = director;
	}
	public int getLength() 
	{
		return length;
	}
	public void setLength(int length) 
	{
		this.length = length;
	}
	
	// Constructor
	public DigitalVideoDisc() 
	{
		super();
	}
	
	public DigitalVideoDisc(String title) 
	{
		super(title);
	}
	// End constructor

	public boolean search(String title) 
	{
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
	@Override
	public void Play() 
	{
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length " + this.getLength());
	}
	
}

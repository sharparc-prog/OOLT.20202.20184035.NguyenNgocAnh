package soict.hedspi.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;
		
	public int getLength() 
	{
		return length;
	}

	public void setLength(int length)
	{
		this.length = length;
	}

	public String getDirector() 
	{
		return director;
	}

	public void setDirector(String director) 
	{
		this.director = director;
	}
	
	// Constructor	
	public Disc()
	{
		super();
	}
	
	public Disc(String title)
	{
		super(title);
	}
	
	public Disc(String title, String category)
	{
		super(title, category);
	}
	//

}
